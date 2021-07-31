package com.gitee.coadmin.modules.test.service.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;
import com.gitee.coadmin.annotation.Query;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @author jinjin
* @date 2021-07-25
*/
@Getter
@Setter
public class TestPersonQueryParam{

    /** 精确 */
    @Query
    private Long id;

    /** 精确 */
    @Query
    private String gender;

    /** 精确 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Query
    private Date birthday;


    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> createTime;
}
