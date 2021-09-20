package com.gitee.coadmin.modules.system.service.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;
import com.gitee.coadmin.annotation.Query;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author jinjin
 * @since 2021-09-19
 */
@Getter
@Setter
public class SettingQueryParam{

    /** 精确 */
    
    @Query
    private Long id;

}
