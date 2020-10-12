package com.gitee.coadmin.modules.system.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* @author jinjin
* @date 2020-09-24
*/
@Data
public class DictDetailDto implements Serializable {

    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private Long id;

    private DictSmallDto dict;

    private String label;

    private String value;

    private Integer dictSort;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;
}
