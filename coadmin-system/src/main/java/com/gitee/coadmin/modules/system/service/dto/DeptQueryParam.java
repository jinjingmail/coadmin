package com.gitee.coadmin.modules.system.service.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import com.gitee.coadmin.annotation.Query;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @author jinjin
* @date 2020-09-25
*/
@Data
public class DeptQueryParam{

    /** 精确 */
    @Query
    private Long pid;

    @Query(blurry = "treeNames")
    private String blurry;

    /** 精确 */
    @Query
    private Boolean enabled;
}
