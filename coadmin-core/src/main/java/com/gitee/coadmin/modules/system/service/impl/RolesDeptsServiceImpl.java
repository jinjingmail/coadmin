package com.gitee.coadmin.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import lombok.AllArgsConstructor;
import com.gitee.coadmin.base.impl.BaseServiceImpl;
import com.gitee.coadmin.modules.system.domain.RolesDepts;
import com.gitee.coadmin.modules.system.service.RolesDeptsService;
import com.gitee.coadmin.modules.system.service.mapper.RolesDeptsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jinjin on 2020-09-25.
 */
@AllArgsConstructor
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RolesDeptsServiceImpl extends BaseServiceImpl<RolesDepts> implements RolesDeptsService {
    private final RolesDeptsMapper rolesDeptsMapper;

    @Override
    public List<Long> queryDeptIdByRoleId(Long id) {
        LambdaQueryWrapper<RolesDepts> query = new LambdaQueryWrapper<>();
        query.eq(RolesDepts::getRoleId, id);
        return rolesDeptsMapper.selectList(query).stream().map(RolesDepts::getDeptId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> queryRoleIdByDeptId(Long id) {
        LambdaQueryWrapper<RolesDepts> query = new LambdaQueryWrapper<>();
        query.eq(RolesDepts::getDeptId, id);
        return rolesDeptsMapper.selectList(query).stream().map(RolesDepts::getRoleId)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByRoleId(Long id) {
        LambdaUpdateWrapper<RolesDepts> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(RolesDepts::getRoleId, id);
        return rolesDeptsMapper.delete(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByDeptId(Long id) {
        LambdaUpdateWrapper<RolesDepts> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(RolesDepts::getDeptId, id);
        return rolesDeptsMapper.delete(wrapper);
    }
}
