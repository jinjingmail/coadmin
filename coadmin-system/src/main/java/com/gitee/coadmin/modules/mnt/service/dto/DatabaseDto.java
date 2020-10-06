package com.gitee.coadmin.modules.mnt.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import com.gitee.coadmin.base.DataDto;

import java.io.Serializable;

/**
* @author jinjin
* @date 2020-09-27
*/
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DatabaseDto extends DataDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private String id;

    private String name;

    private String jdbcUrl;

    private String userName;

    private String pwd;
}
