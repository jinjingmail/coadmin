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
public class TracePatientQueryParam{

    /** 精确 */
    
    @Query
    private Long id;

    @Query
    private Boolean viewed;

    @Query(type = Query.Type.GREATER_THAN_EQ)
    private Integer csQuantity;
    @Query(type = Query.Type.GREATER_THAN_EQ)
    private Integer cmaQuantity;
    @Query(type = Query.Type.GREATER_THAN_EQ)
    Integer niptQuantity;

    @Query(propName = "csQuantity")
    private Integer csQuantityEq;
    @Query(propName = "cmaQuantity")
    private Integer cmaQuantityEq;
    @Query(propName = "niptQuantity")
    Integer niptQuantityEq;

    /** 精确 */
    @Query
    private String no;

    /** 模糊 */
    @Query( blurry = "name, nameLetter", type = Query.Type.RIGHT_LIKE)
    private String name;

    /** 模糊 */
    @Query( type = Query.Type.INNER_LIKE)
    private String remarks;

    /** 精确 */
    
    @Query
    private String gender;

    /** 精确 */
    
    @Query
    private String idNo;

    /** 精确 */
    
    @Query
    private String healthNo;

    /** 精确 */
    
    @Query
    private String contactNo;


    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> createTime;
}
