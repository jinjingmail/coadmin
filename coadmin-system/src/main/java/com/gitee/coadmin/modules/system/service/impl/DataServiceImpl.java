/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.gitee.coadmin.modules.system.service.impl;

import com.gitee.coadmin.modules.system.service.UsersDeptsService;
import lombok.RequiredArgsConstructor;
import com.gitee.coadmin.modules.system.domain.Dept;
import com.gitee.coadmin.modules.system.service.DeptService;
import com.gitee.coadmin.modules.system.service.RoleService;
import com.gitee.coadmin.modules.system.service.dto.DeptDto;
import com.gitee.coadmin.modules.system.service.DataService;
import com.gitee.coadmin.modules.system.service.dto.RoleSmallDto;
import com.gitee.coadmin.modules.system.service.dto.UserDto;
import com.gitee.coadmin.utils.enums.DataScopeEnum;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @author Zheng Jie
 * @website https://el-admin.vip
 * @description 数据权限服务实现
 * @date 2020-05-07
 **/
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "data")
public class DataServiceImpl implements DataService {

    private final RoleService roleService;
    private final DeptService deptService;
    private final UsersDeptsService usersDeptsService;

    /**
     * 用户角色改变时需清理缓存
     * 用户所在机构，及其所有子机构的id列表
     * @param user /
     * @return /
     */
    @Override
    @Cacheable(key = "'user:' + #p0.id")
    public List<Long> getDeptIds(UserDto user) {
        Boolean enabled = true;
        if (user.getIsAdmin()) {
            enabled = null;
        }
        return deptService.queryDeptIdAllByUserId(user.getId(), enabled);
        /*
        // 用于存储机构id
        Set<Long> deptIds = new HashSet<>();
        // 查询用户角色
        List<RoleSmallDto> roleSet = roleService.findByUsersId(user.getId());
        // 获取对应的机构ID
        for (RoleSmallDto role : roleSet) {
            DataScopeEnum dataScopeEnum = DataScopeEnum.find(role.getDataScope());
            switch (Objects.requireNonNull(dataScopeEnum)) {
                case THIS_LEVEL:
                    // deptIds.add(user.getDept().getId());
                    break;
                case CUSTOMIZE:
                    deptIds.addAll(getCustomize(deptIds, role));
                    break;
                default:
                    return new ArrayList<>(deptIds);
            }
        }
        return new ArrayList<>(deptIds);*/
    }

    /**
     * 获取自定义的数据权限
     * @param deptIds 机构ID
     * @param role 角色
     * @return 数据权限ID
     */
    public Set<Long> getCustomize(Set<Long> deptIds, RoleSmallDto role){
        /*Set<DeptDto> depts = deptService.findByRoleId(role.getId());
        for (DeptDto dept : depts) {
            deptIds.add(dept.getId());
            List<Dept> deptChildren = deptService.findByPid(dept.getId());
            if (deptChildren != null && deptChildren.size() != 0) {
                deptIds.addAll(deptService.getDeptChildren(dept.getId(), deptChildren));
            }
        }*/
        return deptIds;
    }
}
