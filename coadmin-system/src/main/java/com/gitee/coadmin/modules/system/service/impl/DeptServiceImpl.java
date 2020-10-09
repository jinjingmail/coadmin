package com.gitee.coadmin.modules.system.service.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gitee.coadmin.base.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.impl.BaseServiceImpl;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.modules.system.domain.Dept;
import com.gitee.coadmin.modules.system.domain.User;
import com.gitee.coadmin.modules.system.service.DeptService;
import com.gitee.coadmin.modules.system.service.RolesDeptsService;
import com.gitee.coadmin.modules.system.service.UsersDeptsService;
import com.gitee.coadmin.modules.system.service.dto.DeptCompactDto;
import com.gitee.coadmin.modules.system.service.dto.DeptDto;
import com.gitee.coadmin.modules.system.service.dto.DeptQueryParam;
import com.gitee.coadmin.modules.system.service.mapper.DeptMapper;
import com.gitee.coadmin.modules.system.service.mapper.UserMapper;
import com.gitee.coadmin.utils.ConvertUtil;
import com.gitee.coadmin.utils.FileUtil;
import com.gitee.coadmin.utils.RedisUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
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
@CacheConfig(cacheNames = "dept")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    private final UserMapper userMapper;
    private final DeptMapper deptMapper;
    private final RedisUtils redisUtils;
    private final RolesDeptsService rolesDeptsService;
    private final UsersDeptsService usersDeptsService;

    @Override
    public List<DeptDto> queryAll(DeptQueryParam criteria, Boolean query) {
        QueryWrapper<Dept> w = QueryHelpMybatisPlus.getPredicate(criteria);
        w.lambda().orderByAsc(Dept::getTreeSorts);
        return ConvertUtil.convertList(deptMapper.selectList(w), DeptDto.class);
    }

    @Override
    public Dept getById(Long id) {
        return deptMapper.selectById(id);
    }
    @Override
    public DeptDto findById(Long id) {
        return ConvertUtil.convert(getById(id), DeptDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Dept resources) {
        if (resources.getSort() > 999) {
            throw new BadRequestException("sort large than 999");
        }
        if (resources.getPid() == null){
            resources.setPid(0L);
        }
        Dept parent = getById(resources.getPid());
        resources.setTreeLeaf(true);
        updateSelfAndChildren(parent, resources);
        //int ret = deptMapper.insert(resources);
        updateLeaf(parent, false);

        redisUtils.del("dept::pid:" + resources.getPid());
        //updateSubCnt(resources.getPid());
        return true;
    }

    private void updateLeaf(Dept tree, boolean isLeaf) {
        if (tree == null) {
            return;
        }
        if (tree.getTreeLeaf() != isLeaf) {
            tree.setTreeLeaf(isLeaf);
            deptMapper.updateById(tree);
        }
    }

    private static final String FORMAT = "00000";
    private void updateSelfAndChildren(Dept parent, Dept self) {
        if (parent == null) {
            self.setTreePids("/" + self.getPid());
            self.setTreeNames("/" + self.getName());
            self.setTreeSorts("/" + NumberUtil.decimalFormat(FORMAT, self.getSort()));
        } else {
            self.setTreePids(parent.getTreePids() + "/" + self.getPid());
            self.setTreeNames(parent.getTreeNames() + "/" + self.getName());
            self.setTreeSorts(parent.getTreeSorts() + "/" + NumberUtil.decimalFormat(FORMAT, self.getSort()));
        }
        self.setTreeLevel(calcTreeLevel(self));
        if (self.getId() == null) {
            deptMapper.insert(self);
        } else {
            deptMapper.updateById(self);
            if ( ! self.getTreeLeaf()) {
                QueryWrapper<Dept> query = new QueryWrapper<>();
                query.lambda().eq(Dept::getPid, self.getId());
                List<Dept> children = deptMapper.selectList(query);
                for (Dept child: children) {
                    updateSelfAndChildren(self, child);
                }
            }
        }
    }
    private int calcTreeLevel(Dept tree) {
        int size = StrUtil.splitTrim(tree.getTreePids(), '/').size();
        if (size <= 1) {
            return 0;
        } else {
            return size-1;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(DeptCompactDto resources){
        if (resources.getPid() == null) {
            resources.setPid(0L);
        }
        Dept newTree = getById(resources.getId());
        Long oldPid = newTree.getPid();
        ConvertUtil.copyIgnoreNull(resources, newTree);

        if (newTree.getSort() > 999) {
            throw new BadRequestException("sort large than 999");
        }
        if (newTree.getId().equals(newTree.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }
        Dept oldParent = getById(oldPid);
        Dept newParent = oldParent;
        log.info("oldPid={} newPid={}", oldPid, newTree.getPid());
        if ( ! oldPid.equals(newTree.getPid())) {
            newParent = getById(newTree.getPid());
            updateSelfAndChildren(newParent, newTree);

            updateLeaf(newParent, false);
            updateLeaf(oldParent, countOfChildren(oldParent==null? 0 : oldParent.getId()) == 0);
        } else {
            updateSelfAndChildren(newParent, newTree);
        }
        //int ret = deptMapper.updateById(newTree);

        //updateSubCnt(pidOld);
        //updateSubCnt(newTree.getPid());
        // 清理缓存
        delCaches(newTree.getId(), oldPid, newTree.getPid());

        return true;
    }

    private int countOfChildren(Long pid) {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Dept::getPid, pid);
        return deptMapper.selectCount(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Set<Long> ids){
        for (Long id: ids) {
            Dept dept = getById(id);
            // 清理缓存
            delCaches(id, dept.getPid(), null);
            rolesDeptsService.removeByDeptId(id);
            usersDeptsService.removeByDeptId(id);
            if (!dept.getTreeLeaf()) {
                removeChildren(dept.getId());
            }
            deptMapper.deleteById(dept.getId());

            Dept parent = getById(dept.getPid());
            if (parent != null) {
                updateLeaf(parent, countOfChildren(parent.getId()) == 0);
            }
        }
        return true;
    }

    private void removeChildren(Long pid) {
        QueryWrapper<Dept> query = new QueryWrapper<Dept>();
        query.lambda().eq(Dept::getPid, pid);
        List<Dept> children = deptMapper.selectList(query);
        for (Dept dept: children) {
            delCaches(dept.getId(), dept.getPid(), null);
            rolesDeptsService.removeByDeptId(dept.getId());
            usersDeptsService.removeByDeptId(dept.getId());
            if (!dept.getTreeLeaf()) {
                removeChildren(dept.getId());
            }
            deptMapper.deleteById(dept.getId());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(Long id){
        Set<Long> ids = new HashSet<>(1);
        ids.add(id);
        return removeByIds(ids);
    }

    // @Cacheable(key = "'pid:' + #p0")
    public List<Dept> findByPid(long pid) {
        QueryWrapper<Dept> query = new QueryWrapper<>();
        query.lambda().eq(Dept::getPid, pid);
        return deptMapper.selectList(query);
    }

    @Override
    public Map<String, Object> buildTree(LinkedHashSet<Long> deptIds) {
        log.info("buildTree:{}", JSONUtil.toJsonPrettyStr(deptIds));
        Set<DeptDto> trees = new LinkedHashSet<>();
        for (Long deptId : deptIds) {
            DeptDto dto = findById(deptId);
            if (dto==null) {
                continue;
            }
            /*if (!dto.getEnabled()) {
                continue;
            }*/
            if (!dto.getTreeLeaf()) {
                dto.setChildren(getChildren(dto.getId()));
            }
            trees.add(dto);
        }
        if (deptIds.isEmpty()) {
            List<DeptDto> children = getChildren(0L);
            Map<String, Object> map = new HashMap<>(2);
            map.put("totalElements", trees.size());
            map.put("content", ConvertUtil.convertList(children, DeptCompactDto.class));
            return map;

        } else {
            Map<String, Object> map = new HashMap<>(2);
            map.put("totalElements", trees.size());
            map.put("content", ConvertUtil.convertSet(trees, DeptCompactDto.class));
            return map;
        }
    }

    private List<DeptDto> getChildren(Long pid) {
        QueryWrapper<Dept> query = new QueryWrapper<Dept>();
        query.lambda().eq(Dept::getPid, pid).orderByAsc(Dept::getTreeSorts);
        List<DeptDto> depts = ConvertUtil.convertList(deptMapper.selectList(query), DeptDto.class);
        if (depts.isEmpty()) {
            return null;
        }
        for (DeptDto dept: depts) {
            if (!dept.getTreeLeaf()) {
                dept.setChildren(getChildren(dept.getId()));
            }
        }
        return depts;
    }

    @Override
    public void download(List<DeptDto> all, HttpServletResponse response) throws IOException {
      List<Map<String, Object>> list = new ArrayList<>();
      for (DeptDto dept : all) {
        Map<String,Object> map = new LinkedHashMap<>();
              map.put("上级部门", dept.getPid());
              map.put("子部门数目", dept.getTreeLeaf()?0:1);
              map.put("名称", dept.getName());
              map.put("排序", dept.getSort());
              map.put("状态", dept.getEnabled());
              map.put("创建者", dept.getCreateBy());
              map.put("更新者", dept.getUpdateBy());
              map.put("创建日期", dept.getCreateTime());
              map.put("更新时间", dept.getUpdateTime());
        list.add(map);
      }
      FileUtil.downloadExcel(list, response);
    }

    /**
     * 清理缓存
     *
     * @param id /
     */
    public void delCaches(Long id, Long pidOld, Long pidNew) {
        List<User> users = userMapper.findByDeptRoleId(id);
        // 删除数据权限
        redisUtils.delByKeys("data::user:", users.stream().map(User::getId).collect(Collectors.toSet()));
        redisUtils.del("dept::id:" + id);
        redisUtils.del("dept::pid:" + (pidOld == null ? 0 : pidOld));
        redisUtils.del("dept::pid:" + (pidNew == null ? 0 : pidNew));
    }

}
