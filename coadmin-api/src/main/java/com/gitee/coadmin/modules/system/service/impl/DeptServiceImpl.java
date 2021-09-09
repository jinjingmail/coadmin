package com.gitee.coadmin.modules.system.service.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.security.service.UserCacheClean;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.impl.BaseServiceImpl;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.modules.system.domain.Dept;
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
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
 * 机构管理
* @author jinjin
* @date 2020-09-25
*/
@Slf4j
@Service
@AllArgsConstructor
// @CacheConfig(cacheNames = "dept")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    private final UserMapper userMapper;
    private final DeptMapper deptMapper;
    // private final RedisUtils redisUtils;
    private final RolesDeptsService rolesDeptsService;
    private final UsersDeptsService usersDeptsService;

    private final UserCacheClean userCacheClean;

    @Override
    public List<DeptDto> queryAll(DeptQueryParam criteria, Boolean query) {
        QueryWrapper<Dept> w = QueryHelpMybatisPlus.getPredicate(criteria);
        w.lambda().orderByAsc(Dept::getTreeSorts);
        return ConvertUtil.convertList(deptMapper.selectList(w), DeptDto.class);
    }

    // SELECT distinct id FROM sys_dept WHERE (tree_pids LIKE '%/8/%' OR tree_pids LIKE '%/35/%') AND enabled=1 ORDER BY tree_sorts asc
    @Override // TODO querySubDeptIdByPids.query=WHERE ( AND enabled = #{ew.paramNameValuePairs.MPGENVAL1}) ORDER BY tree_sorts ASC
    public List<Long> querySubDeptIdByPids(List<Long> pidList, Boolean enabled) {
        if (pidList.isEmpty()) {
            return new ArrayList<>();
        }
        LambdaQueryWrapper<Dept> query = new LambdaQueryWrapper<>();

        query.or(!pidList.isEmpty(), q -> pidList.forEach(pid -> q.or().like(Dept::getTreePids, "/" + pid + "/")));
        query.eq(enabled != null, Dept::getEnabled, enabled);
        query.orderByAsc(Dept::getTreeSorts);
        log.info("querySubDeptIdByPids.query={}", query.getCustomSqlSegment());
        return deptMapper.querySubDeptIdByPids(query);
    }

    @Override
    public List<Long> queryDeptIdAllByUserId(Long userId, Boolean enabled) {
        // 用户直接关联的机构
        List<Long> deptIdList = usersDeptsService.queryDeptIdByUserId(userId);
        // 所有子机构
        deptIdList.addAll(this.querySubDeptIdByPids(deptIdList, enabled));
        return deptIdList;
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
        Dept exist = getByName(resources.getName());
        if (exist != null) {
            throw new BadRequestException("已经存在：" + resources.getName());
        }

        Dept parent = getById(resources.getPid());
        resources.setTreeLeaf(true);
        updateSelfAndChildren(parent, resources);
        updateLeaf(parent, false);

        // redisUtils.del("dept::pid:" + resources.getPid());
        userCacheClean.cleanAll();
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
            if (self.getPid() == 0) {
                self.setTreePids("/");
            } else {
                self.setTreePids("/" + self.getPid() + "/");
            }
            self.setTreeNames("/" + self.getName());
            self.setTreeSorts("/" + NumberUtil.decimalFormat(FORMAT, self.getSort()));
        } else {
            self.setTreePids(parent.getTreePids() + self.getPid() + "/");
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
        if (size <= 0) {
            return 0;
        } else {
            return size;
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

        Dept exist = getByName(resources.getName());
        if (exist != null && !exist.getId().equals(resources.getId())) {
            throw new BadRequestException("已经存在：" + resources.getName());
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

        // 清理缓存
        delCaches(newTree.getId(), oldPid, newTree.getPid());
        return true;
    }

    private Dept getByName(String name) {
        LambdaQueryWrapper<Dept> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dept::getName, name);
        return deptMapper.selectOne(wrapper);
    }

    private long countOfChildren(Long pid) {
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
    public PageInfo<DeptCompactDto> buildTree(DeptQueryParam query, Long userId) {
        QueryWrapper<Dept> wrapper1 = QueryHelpMybatisPlus.getPredicate(query);
        final LambdaQueryWrapper<Dept> wrapper = wrapper1.lambda();
        wrapper.orderByAsc(Dept::getTreeSorts);

        List<DeptDto> tree = new ArrayList<>();
        if (query.getTreeId() == null) {
            List<Long> userTopLevelDeptIds = usersDeptsService.queryDeptIdByUserId(userId);
            for (Long id: userTopLevelDeptIds) {
                LambdaQueryWrapper<Dept> wr = wrapper.clone();
                wr.eq(Dept::getId, id);
                DeptDto dto = ConvertUtil.convert(deptMapper.selectOne(wr), DeptDto.class);
                if (dto!=null) {
                    if (!dto.getTreeLeaf()) {
                        dto.setChildren(getChildren(wrapper, dto.getId()));
                    }
                    tree.add(dto);
                }
            }
        } else {
            tree = getChildren(wrapper, query.getTreeId());
        }
        //Map<String, Object> map = new HashMap<>(2);
        return new PageInfo<>(tree.size(), ConvertUtil.convertList(tree, DeptCompactDto.class));
    }

    private List<DeptDto> getChildren(final LambdaQueryWrapper<Dept> wrapperOrigin, Long pid) {
        LambdaQueryWrapper<Dept> wrapper = wrapperOrigin.clone();
        if (pid != null) {
            wrapper.eq(Dept::getPid, pid);
        }
        List<DeptDto> depts = ConvertUtil.convertList(deptMapper.selectList(wrapper), DeptDto.class);
        if (!depts.isEmpty()) {
            for (DeptDto dept: depts) {
                if (!dept.getTreeLeaf()) {
                    dept.setChildren(getChildren(wrapperOrigin, dept.getId()));
                }
            }
        }
        return depts;
    }

    @Override
    public void download(List<DeptDto> all, HttpServletResponse response) throws IOException {
      List<Map<String, Object>> list = new ArrayList<>();
      for (DeptDto dept : all) {
        Map<String,Object> map = new LinkedHashMap<>();
              map.put("上级机构", dept.getPid());
              map.put("子机构数目", dept.getTreeLeaf()?0:1);
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
     */
    public void delCaches(Long deptId, Long pidOld, Long pidNew) {
        /*
        //List<User> users = userMapper.findByDeptRoleId(id);
        // 删除数据权限
        //redisUtils.delByKeys("data::user:", users.stream().map(User::getId).collect(Collectors.toSet()));
        List dataUserKeys = redisUtils.scan("data::user:*");
        log.info("delCaches.dataUserKeys.size={}", dataUserKeys.size());
        long count = redisUtils.del(dataUserKeys);
        log.info("delCaches.dataUserKeys delete count:{}", count);
        redisUtils.del("dept::id:" + deptId);
        redisUtils.del("dept::pid:" + (pidOld == null ? 0 : pidOld));
        redisUtils.del("dept::pid:" + (pidNew == null ? 0 : pidNew));
        userCacheClean.cleanAll();
        */
    }
}
