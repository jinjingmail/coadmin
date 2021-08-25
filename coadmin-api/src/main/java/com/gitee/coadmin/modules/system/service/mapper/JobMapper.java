package com.gitee.coadmin.modules.system.service.mapper;

import com.gitee.coadmin.base.CommonMapper;
import com.gitee.coadmin.modules.system.domain.Job;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
* @author jinjin
* @date 2020-09-25
*/
@Repository
public interface JobMapper extends CommonMapper<Job> {
    @Select("select j.* from sys_job where id = #{id}")
    Job selectLink(Long id);
}
