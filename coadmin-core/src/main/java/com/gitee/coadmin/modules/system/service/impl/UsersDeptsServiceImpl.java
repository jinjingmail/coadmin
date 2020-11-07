package com.gitee.coadmin.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.gitee.coadmin.base.impl.BaseServiceImpl;
import com.gitee.coadmin.modules.system.domain.UsersDepts;
import com.gitee.coadmin.modules.system.service.UsersDeptsService;
import com.gitee.coadmin.modules.system.service.mapper.DeptMapper;
import com.gitee.coadmin.modules.system.service.mapper.UsersDeptsMapper;
import lombok.AllArgsConstructor;
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
public class UsersDeptsServiceImpl extends BaseServiceImpl<UsersDepts> implements UsersDeptsService {

    private final UsersDeptsMapper usersDeptsMapper;
    private final DeptMapper deptMapper;

    @Override
    public List<Long> queryUserIdByDeptId(Long id) {
        LambdaQueryWrapper<UsersDepts> query = new LambdaQueryWrapper<>();
        query.eq(UsersDepts::getDeptId, id);
        return usersDeptsMapper.selectList(query).stream().map(UsersDepts::getUserId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> queryDeptIdByUserId(Long id) {
        if (id == 1) {
            // Admin 用户，可以查看所有机构
            return deptMapper.selectIdsByPid(0L);
        }
        LambdaQueryWrapper<UsersDepts> query = new LambdaQueryWrapper<>();
        query.eq(UsersDepts::getUserId, id);
        return usersDeptsMapper.selectList(query).stream().map(UsersDepts::getDeptId)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByDeptId(Long id) {
        LambdaUpdateWrapper<UsersDepts> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(UsersDepts::getDeptId, id);
        return usersDeptsMapper.delete(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByUserId(Long id) {
        LambdaUpdateWrapper<UsersDepts> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(UsersDepts::getUserId, id);
        return usersDeptsMapper.delete(wrapper);
    }
}
