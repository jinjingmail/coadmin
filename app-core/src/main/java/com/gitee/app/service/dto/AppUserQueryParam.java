package com.gitee.app.service.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;
import com.gitee.coadmin.annotation.Query;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author jinjin
 * @since 2021-09-20
 */
@Getter
@Setter
public class AppUserQueryParam{

    /** 精确 */
    
    @Query
    private Long id;

    /** 精确 */
    
    @Query
    private Boolean isEnabled;

    /** 精确 */
    
    @Query
    private Integer channel;

    /** 精确 */
    
    @Query
    private String openid;

    /** 精确 */
    
    @Query
    private String unionid;

    /** 精确 */
    
    @Query
    private String mobile;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String nickname;

    /** 精确 */
    
    @Query
    private Integer gender;


    /** BETWEEN */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> createTime;
}
