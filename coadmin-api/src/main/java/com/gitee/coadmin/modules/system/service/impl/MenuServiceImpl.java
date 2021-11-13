package com.gitee.coadmin.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.system.domain.RolesMenus;
import com.gitee.coadmin.modules.system.service.dto.*;
import com.gitee.coadmin.modules.system.service.mapper.RolesMenusMapper;
import lombok.AllArgsConstructor;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.impl.BaseServiceImpl;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.exception.EntityExistException;
import com.gitee.coadmin.modules.system.domain.Menu;
import com.gitee.coadmin.modules.system.domain.User;
import com.gitee.coadmin.modules.system.service.MenuService;
import com.gitee.coadmin.modules.system.service.RoleService;
import com.gitee.coadmin.modules.system.service.RolesMenusService;
import com.gitee.coadmin.modules.system.domain.vo.MenuMetaVo;
import com.gitee.coadmin.modules.system.domain.vo.MenuVo;
import com.gitee.coadmin.modules.system.service.mapper.MenuMapper;
import com.gitee.coadmin.modules.system.service.mapper.UserMapper;
import com.gitee.coadmin.utils.ConvertUtil;
import com.gitee.coadmin.utils.FileUtil;
import com.gitee.coadmin.utils.RedisUtils;
import com.gitee.coadmin.utils.ValidationUtil;
import com.gitee.coadmin.utils.enums.MenuType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author jinjin
* @date 2020-09-25
*/
@Slf4j
@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "menu")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    private final RoleService roleService;
    private final UserMapper userMapper;
    private final MenuMapper menuMapper;
    private final RedisUtils redisUtils;
    private final RolesMenusService rolesMenusService;
    private final RolesMenusMapper rolesMenusMapper;

    @Override
    //@Cacheable
    public List<MenuDto> queryAll(MenuQueryParam query, boolean isQuery) {
        if (isQuery) {
            query.setPidIsNull(true);
        }
        boolean notEmpty = null != query.getPid() || StrUtil.isNotEmpty(query.getBlurry())
                || CollectionUtils.isNotEmpty(query.getCreateTime());
        if (isQuery && notEmpty) {
            query.setPidIsNull(null);
        }
        QueryWrapper<Menu> wrapper = QueryHelpMybatisPlus.getPredicate(query);
        LambdaQueryWrapper<Menu> lw = wrapper.lambda();
        lw.orderByAsc(Menu::getSort);
        return ConvertUtil.convertList(menuMapper.selectList(lw), MenuDto.class);
    }

    @Override
    //@Cacheable
    public List<MenuDto> queryAll(MenuQueryParam query){
        return queryAll(query, true);
    }

    @Override
    public Menu getById(Long id) {
        return menuMapper.selectById(id);
    }

    @Override
    @Cacheable(key = "'id:' + #p0")
    public MenuDto findById(Long id) {
        return ConvertUtil.convert(getById(id), MenuDto.class);
    }

    @Override
    public List<MenuDto> findByUser(Long currentUserId) {
        List<RoleSmallDto> roles = roleService.findByUsersId(currentUserId);
        Set<Long> roleIds = roles.stream().map(RoleSmallDto::getId).collect(Collectors.toSet());
        LinkedHashSet<Menu> menus = menuMapper.selectLinkRole(roleIds, 2L);
        return menus.stream().map(menu -> ConvertUtil.convert(menu, MenuDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Menu resources) {
        QueryWrapper<Menu> query = new QueryWrapper<Menu>();
        query.lambda().eq(Menu::getTitle, resources.getTitle());
        if (menuMapper.selectOne(query) != null) {
            throw new EntityExistException(Menu.class, "title", resources.getTitle());
        }
        if (StringUtils.isNotBlank(resources.getComponentName())) {
            QueryWrapper<Menu> query2 = new QueryWrapper<Menu>();
            query2.lambda().eq(Menu::getComponentName, resources.getComponentName());
            if (menuMapper.selectOne(query2) != null) {
                throw new EntityExistException(Menu.class, "组件名称", resources.getComponentName());
            }
        }
        if (resources.getIFrame()) {
            String http = "http://", https = "https://";
            if (!(resources.getPath().toLowerCase().startsWith(http)
                    || resources.getPath().toLowerCase().startsWith(https))) {
                throw new BadRequestException("外链必须以http://或者https://开头");
            }
        }
        /*if (resources.getPid() != null && resources.getPid() == 0) {
            resources.setPid(null);
        }*/
        resources.setSubCount(resources.getSubCount() == null ? 0 : resources.getSubCount());
        resources.setSort(resources.getSort() == null ? 999 : resources.getSort());
        int ret = menuMapper.insert(resources);

        // 计算子节点数目
        if (resources.getPid() != null) {
            // 清理缓存
            updateSubCnt(resources.getPid());
        }
        redisUtils.del("menu::pid:" + (resources.getPid() == null ? 0 : resources.getPid()));
        List<String> keys = redisUtils.scan("menu::user:*");
        keys.forEach(item -> redisUtils.del(item));
        return ret > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(Menu res){
        if (res.getId().equals(res.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }
        Menu menu = Optional.ofNullable(this.getById(res.getId())).orElseGet(Menu::new);
        // 记录旧的父节点ID
        Long pid = menu.getPid();
        ValidationUtil.isNull(menu.getId(), "Permission", "id", res.getId());

        if (res.getIFrame() != null && res.getIFrame()) {
            String http = "http://", https = "https://";
            if (!(res.getPath().toLowerCase().startsWith(http)
                    || res.getPath().toLowerCase().startsWith(https))) {
                throw new BadRequestException("外链必须以http://或者https://开头");
            }
        }
        QueryWrapper<Menu> query = new QueryWrapper<>();
        query.lambda().eq(Menu::getTitle, res.getTitle());
        Menu menu1 = menuMapper.selectOne(query);

        /*
        20211112 菜单名称可以重复
        if (menu1 != null && !menu1.getId().equals(menu.getId())) {
            throw new EntityExistException(Menu.class, "name", res.getTitle());
        }*/

        if (res.getPid() != null && res.getPid().equals(0L)) {
            res.setPid(null);
        }

        if (StringUtils.isNotBlank(res.getComponentName())) {
            QueryWrapper<Menu> query2 = new QueryWrapper<Menu>();
            query2.lambda().eq(Menu::getComponentName, res.getComponentName());
            menu1 = menuMapper.selectOne(query2);
            if (menu1 != null && !menu1.getId().equals(menu.getId())) {
                throw new EntityExistException(Menu.class, "componentName", res.getComponentName());
            }
        }

        // 记录的父节点ID
        Long oldPid = menu.getPid();
        Long newPid = res.getPid();

        // 类型从菜单或按钮变更为目录，清空路径和权限
        if (menu.getType() != MenuType.FOLDER.getValue() && res.getType() == MenuType.FOLDER.getValue()) {
            menu.setComponent(null);
            menu.setPermission(null);
            menu.setComponentName(null);
        } else {
            menu.setComponent(res.getComponent());
            menu.setPermission(res.getPermission());
            menu.setComponentName(res.getComponentName());
        }
        menu.setTitle(res.getTitle());
        menu.setPath(res.getPath());
        menu.setIcon(res.getIcon());
        menu.setIFrame(res.getIFrame());
        menu.setPid(res.getPid());
        menu.setSort(res.getSort());
        menu.setCache(res.getCache());
        menu.setHidden(res.getHidden());
        menu.setType(res.getType());
        int ret = menuMapper.updateById(menu);

        /*
         * 如果修改了菜单的父级，则将父级目录id添加到拥有当前菜单id的角色列表
         */
        if (res.getType() != MenuType.BUTTON.getValue()) {
            if (newPid != null) {
                if (ObjectUtil.notEqual(newPid, oldPid)) {
                    List<Long> roleIds = rolesMenusService.queryRoleIdByMenuId(res.getId());
                    UpdateWrapper<RolesMenus> wrapper = new UpdateWrapper<>();
                    wrapper.lambda()
                            .eq(RolesMenus::getMenuId, newPid)
                            .in(RolesMenus::getRoleId, roleIds);
                    rolesMenusMapper.delete(wrapper);
                    for (Long roleId: roleIds) {
                        RolesMenus entity = new RolesMenus();
                        entity.setMenuId(newPid);
                        entity.setRoleId(roleId);
                        rolesMenusMapper.insert(entity);
                    }
                }
            }
        }

        // 计算父级菜单节点数目
        updateSubCnt(oldPid);
        updateSubCnt(newPid);
        // 清理缓存
        delCaches(res.getId(), pid);
        return ret > 0;
    }

    @Override
    public Set<Menu> getDeleteMenus(List<Menu> menuList, Set<Menu> menuSet) {
        // 递归找出待删除的菜单
        for (Menu menu1 : menuList) {
            menuSet.add(menu1);
            QueryWrapper<Menu> query = new QueryWrapper<Menu>();
            query.lambda().eq(Menu::getPid, menu1.getId());
            List<Menu> menus = menuMapper.selectList(query);
            if (menus != null && menus.size() != 0) {
                getDeleteMenus(menus, menuSet);
            }
        }
        return menuSet;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Set<Long> ids){
        for (Long id: ids) {
            Menu menu = getById(id);
            rolesMenusService.removeByMenuId(id);
            if (menu.getPid() != null) {
                updateSubCnt(menu.getPid());
            }
            delCaches(menu.getId(), menu.getPid());
        }
        return menuMapper.deleteBatchIds(ids) > 0;
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(Long id){
        Set<Long> set = new HashSet<>(1);
        set.add(id);
        return this.removeByIds(set);
    }

    // @Override
    @Cacheable(key = "'tree'")
    public Object getMenuTree(Long pid) {
        Map<Long, List<Menu>> allMap = menuMapper.selectList(Wrappers.emptyWrapper()).stream().collect(Collectors.groupingBy(Menu::getPid));
        return buildMenuTree(allMap, pid);
    }

    private Object buildMenuTree(Map<Long, List<Menu>> allMap, Long pid) {
        List<Map<String, Object>> list = new LinkedList<>();
        allMap.get(pid).forEach(menu -> {
            if (menu != null) {
                List<Menu> menuList = allMap.get(menu.getId());
                Map<String, Object> map = new HashMap<>(16);
                map.put("id", menu.getId());
                map.put("label", menu.getTitle());
                if (menuList != null && menuList.size() != 0) {
                    map.put("children", getMenuTree(menu.getId()));
                }
                list.add(map);
            }
        });
        return list;
    }

    @Override
    @Cacheable(key = "'pid:' + #p0")
    public List<MenuDto> getMenus(Long pid) {
        List<Menu> menus;
        if (pid != null && !pid.equals(0L)) {
            QueryWrapper<Menu> query = new QueryWrapper<Menu>();
            query.lambda().eq(Menu::getPid, pid).orderByAsc(Menu::getSort);
            menus = menuMapper.selectList(query);
        } else {
            QueryWrapper<Menu> query = new QueryWrapper<Menu>();
            query.lambda().isNull(Menu::getPid).orderByAsc(Menu::getSort);
            menus = menuMapper.selectList(query);
        }
        return ConvertUtil.convertList(menus, MenuDto.class);
    }

    @Override
    public List<MenuDto> getSuperior(MenuDto menuDto, List<Menu> menus) {
        QueryWrapper<Menu> query = new QueryWrapper<Menu>();
        if (menuDto.getPid() == null) {
            query.lambda().isNull(Menu::getPid).orderByAsc(Menu::getSort);
            menus.addAll(menuMapper.selectList(query));
            return ConvertUtil.convertList(menus, MenuDto.class);
        }
        query.lambda().eq(Menu::getPid, menuDto.getPid()).orderByAsc(Menu::getSort);
        menus.addAll(menuMapper.selectList(query));
        return getSuperior(findById(menuDto.getPid()), menus);
    }

    @Override
    public PageInfo<MenuDto> buildTree(MenuQueryParam query) {

        List<MenuDto> tree = new ArrayList<>();
        if (query.getPid() == null) {
            QueryWrapper<Menu> wrapper1 = QueryHelpMybatisPlus.getPredicate(query);
            final LambdaQueryWrapper<Menu> wrapper = wrapper1.lambda();
            wrapper.orderByAsc(Menu::getSort);
            LambdaQueryWrapper<Menu> wrapper2 = wrapper.clone();
            wrapper2.isNull(Menu::getPid);
            List<MenuDto> depts = ConvertUtil.convertList(menuMapper.selectList(wrapper2), MenuDto.class);
            for (MenuDto dto: depts) {
                if (dto.getSubCount() > 0) {
                    dto.setChildren(getChildren(wrapper, dto.getId()));
                }
                tree.add(dto);
            }
        } else {
            Long pid = query.getPid();
            query.setPid(null);
            QueryWrapper<Menu> w = QueryHelpMybatisPlus.getPredicate(query);
            final LambdaQueryWrapper<Menu> wrapper = w.lambda();
            wrapper.orderByAsc(Menu::getSort);
            tree = getChildren(wrapper, pid);
        }
        //Map<String, Object> map = new HashMap<>(2);
        //map.put("totalElements", tree.size());
        //map.put("content", tree);
        return new PageInfo<MenuDto>(tree.size(), tree);
    }
    private List<MenuDto> getChildren(final LambdaQueryWrapper<Menu> wrapperOrigin, Long pid) {
        LambdaQueryWrapper<Menu> wrapper = wrapperOrigin.clone();
        if (pid != null) {
            wrapper.eq(Menu::getPid, pid);
        }
        List<MenuDto> dtos = ConvertUtil.convertList(menuMapper.selectList(wrapper), MenuDto.class);
        if (dtos != null) {
            for (MenuDto dto: dtos) {
                if (dto.getSubCount() > 0) {
                    dto.setChildren(getChildren(wrapperOrigin, dto.getId()));
                }
            }
        }
        return dtos;
    }

    @Override
    public List<MenuDto> buildTree(List<MenuDto> menuDtos) {
        List<MenuDto> trees = new ArrayList<>();
        Set<Long> ids = new HashSet<>();
        for (MenuDto menuDTO : menuDtos) {
            if (null == menuDTO.getPid()) {
                trees.add(menuDTO);
            }
            for (MenuDto it : menuDtos) {
                if (it.getPid() != null && it.getPid().equals(menuDTO.getId())) {
                    if (menuDTO.getChildren() == null) {
                        menuDTO.setChildren(new ArrayList<>());
                    }
                    menuDTO.getChildren().add(it);
                    ids.add(it.getId());
                }
            }
        }
        if (trees.size() == 0) {
            trees = menuDtos.stream().filter(s -> !ids.contains(s.getId())).collect(Collectors.toList());
        }
        return trees;
    }

    @Override
    public List<MenuVo> buildMenus(List<MenuDto> menuDtos) {
        List<MenuVo> list = new LinkedList<>();
        menuDtos.forEach(menuDTO -> {
            if (menuDTO != null) {
                List<MenuDto> menuDtoList = menuDTO.getChildren();
                MenuVo menuVo = new MenuVo();
                menuVo.setName(ObjectUtil.isNotEmpty(menuDTO.getComponentName()) ? menuDTO.getComponentName()
                        : menuDTO.getTitle());
                // 一级目录需要加斜杠，不然会报警告
                menuVo.setPath(menuDTO.getPid() == null ? "/" + menuDTO.getPath() : menuDTO.getPath());
                menuVo.setHidden(menuDTO.getHidden());
                // 如果不是外链
                if (!menuDTO.getIFrame()) {
                    if (menuDTO.getPid() == null) {
                        menuVo.setComponent(
                                StrUtil.isEmpty(menuDTO.getComponent()) ? "Layout" : menuDTO.getComponent());
                    } else if (!StrUtil.isEmpty(menuDTO.getComponent())) {
                        menuVo.setComponent(menuDTO.getComponent());
                    }
                }
                menuVo.setMeta(new MenuMetaVo(menuDTO.getTitle(), menuDTO.getIcon(), !menuDTO.getCache()));
                if (menuDtoList != null && menuDtoList.size() != 0) {
                    menuVo.setAlwaysShow(true);
                    menuVo.setRedirect("noredirect");
                    menuVo.setChildren(buildMenus(menuDtoList));
                    // 处理是一级菜单并且没有子菜单的情况
                } else if (menuDTO.getPid() == null) {
                    MenuVo menuVo1 = new MenuVo();
                    menuVo1.setMeta(menuVo.getMeta());
                    // 非外链
                    if (!menuDTO.getIFrame()) {
                        menuVo1.setPath("index");
                        menuVo1.setName(menuVo.getName());
                        menuVo1.setComponent(menuVo.getComponent());
                    } else {
                        menuVo1.setPath(menuDTO.getPath());
                    }
                    menuVo.setName(null);
                    menuVo.setMeta(null);
                    menuVo.setComponent("Layout");
                    List<MenuVo> list1 = new ArrayList<>();
                    list1.add(menuVo1);
                    menuVo.setChildren(list1);
                }
                list.add(menuVo);
            }
        });
        return list;
    }

    private void updateSubCnt(Long menuId) {
        if (menuId == null) {
            return;
        }
        QueryWrapper<Menu> query = new QueryWrapper<Menu>();
        query.lambda().eq(Menu::getPid, menuId);
        Long count = menuMapper.selectCount(query);

        UpdateWrapper<Menu> update = new UpdateWrapper<Menu>();
        update.lambda().eq(Menu::getId, menuId);
        Menu menu = new Menu();
        menu.setSubCount(count.intValue());
        menuMapper.update(menu, update);
    }

    /**
     * 清理缓存
     *
     * @param id  菜单ID
     * @param pid 菜单父级ID
     */
    public void delCaches(Long id, Long pid) {
        List<User> users = userMapper.findByMenuId(id);
        redisUtils.del("menu::id:" + id);
        redisUtils.delByKeys("menu::user:", users.stream().map(User::getId).collect(Collectors.toSet()));
        redisUtils.del("menu::pid:" + (pid == null ? 0 : pid));
    }
    
    @Override
    public void download(List<MenuDto> all, HttpServletResponse response) throws IOException {
      List<Map<String, Object>> list = new ArrayList<>();
      for (MenuDto menu : all) {
        Map<String,Object> map = new LinkedHashMap<>();
              map.put("上级菜单ID", menu.getPid());
              map.put("子菜单数目", menu.getSubCount());
              map.put("菜单类型", menu.getType());
              map.put("菜单标题", menu.getTitle());
              map.put("组件名称", menu.getComponentName());
              map.put("组件", menu.getComponent());
              map.put("排序", menu.getSort());
              map.put("图标", menu.getIcon());
              map.put("链接地址", menu.getPath());
              map.put("是否外链", menu.getIFrame());
              map.put("缓存", menu.getCache());
              map.put("隐藏", menu.getHidden());
              map.put("权限", menu.getPermission());
              map.put("创建者", menu.getCreateBy());
              map.put("更新者", menu.getUpdateBy());
              map.put("创建日期", menu.getCreateTime());
              map.put("更新时间", menu.getUpdateTime());
        list.add(map);
      }
      FileUtil.downloadExcel(list, response);
    }
}
