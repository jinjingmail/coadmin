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
public class TraceCmaQueryParam{

    /** 精确 */
    
    @Query
    private Long id;


    /** 精确 */
    
    @Query
    private String reportStatus;


    /** 精确 */
    
    @Query
    private String reportNo;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE, blurry = "patientName, patientNameLetter")
    private String patientName;

    /** 精确 */
    
    @Query
    private String patientGender;

    /** 精确 */
    
    @Query(type = Query.Type.RIGHT_LIKE)
    private String patientAge;

    /** 精确 */
    
    @Query
    private String patientNo;

    /** 精确 */
    
    @Query
    private String specimanNo;

    /** 精确 */
    
    @Query
    private String specimanType;

    /** 精确 */
    
    @Query
    private String contactTel;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String departmentName;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String diagnosis;

    /** 精确 */
    
    @Query
    private String chipId;

    /** 精确 */
    
    @Query
    private String reportTip;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String chromosomeRegion;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String chromosomeRegion2;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String chromosomeRegion3;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String chromosomeRegion4;

    /** 精确 */
    
    @Query
    private String applyDoctor;



    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> receiptDate;
    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> reportDate;
    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> applyDate;
    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> createTime;
}
