package com.gitee.coadmin.modules.system.service;

import com.gitee.coadmin.base.BaseService;
import com.gitee.coadmin.modules.system.domain.UsersJobs;

import java.util.List;

/**
* @author jinjin
* @date 2020-09-25
*/
public interface UsersJobsService extends BaseService<UsersJobs> {
    List<Long> queryUserIdByJobId(Long id);
    List<Long> queryJobIdByUserId(Long id);
    int removeByUserId(Long id);
    int removeByJobId(Long id);
}
