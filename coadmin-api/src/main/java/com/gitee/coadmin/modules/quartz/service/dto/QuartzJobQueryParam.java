package com.gitee.coadmin.modules.quartz.service.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;
import com.gitee.coadmin.annotation.Query;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @author jinjin
* @date 2020-09-27
*/
@Getter
@Setter
public class QuartzJobQueryParam{

    @Query(blurry = "id,jobName,beanName,methodName")
    private String blurry;

    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> createTime;
}
