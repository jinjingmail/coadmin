package com.gitee.coadmin.modules.test.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.gitee.coadmin.base.BaseDto;

/**
* @author jinjin
* @date 2021-08-08
*/
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TestPersonDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private Long id;

    private String name;

    private String gender;

    private Date birthday;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String remarks;
}
