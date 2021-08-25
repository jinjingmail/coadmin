package com.gitee.coadmin.modules.system.service;

import com.gitee.coadmin.base.BaseService;
import com.gitee.coadmin.modules.system.domain.RolesDepts;

import java.util.List;

/**
* @author jinjin
* @date 2020-09-25
*/
public interface RolesDeptsService extends BaseService<RolesDepts> {

    List<Long> queryDeptIdByRoleId(Long id);
    List<Long> queryRoleIdByDeptId(Long id);
    int removeByRoleId(Long id);
    int removeByDeptId(Long id);
}
