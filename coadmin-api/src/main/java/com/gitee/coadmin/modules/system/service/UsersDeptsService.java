package com.gitee.coadmin.modules.system.service;

import com.gitee.coadmin.base.BaseService;
import com.gitee.coadmin.modules.system.domain.UsersDepts;

import java.util.List;

/**
* @author jinjin
* @date 2020-09-25
*/
public interface UsersDeptsService extends BaseService<UsersDepts> {
    List<Long> queryUserIdByDeptId(Long id);
    List<Long> queryDeptIdByUserId(Long id);
    int removeByDeptId(Long id);
    int removeByUserId(Long id);
}
