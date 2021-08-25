package com.gitee.coadmin.modules.quartz.service.dto;

import lombok.Getter;
import lombok.Setter;
import com.gitee.coadmin.annotation.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
* @author jinjin
* @date 2020-09-27
*/
@Getter
@Setter
public class QuartzLogQueryParam {

    @Query
    private Boolean isSuccess;

    @Query(blurry = "id,jobName,beanName,methodName")
    private String blurry;

    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> createTime;
}
