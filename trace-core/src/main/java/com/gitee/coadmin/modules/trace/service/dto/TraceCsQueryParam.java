package com.gitee.coadmin.modules.trace.service.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;
import com.gitee.coadmin.annotation.Query;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author jinjin
 * @since 2022-01-04
 */
@Getter
@Setter
public class TraceCsQueryParam{

    /** 精确 */
    
    @Query
    private Long id;


    /** 精确 */
    
    @Query
    private String reportNo;

    /** 精确 */
    
    @Query
    private String patientNo;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE, blurry = "patientName, patientNameLetter")
    private String patientName;

    /** 精确 */
    
    @Query
    private String patientGender;

    /** 精确 */

    @Query(type = Query.Type.RIGHT_LIKE)
    private String patientAge;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String departmentName;

    /** 精确 */
    
    @Query
    private String specimanType;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String diagnosis;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String karyotypeResult;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String niptScreening;


    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> reportTime;
    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> createTime;
}
