package com.gitee.coadmin.modules.system.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.gitee.coadmin.base.DataDto;

import java.io.Serializable;

/**
* @author jinjin
* @date 2020-09-24
*/
@Getter
@Setter
@NoArgsConstructor
public class DictDto extends DataDto implements Serializable {

    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private Long id;

    //     private List<DictDetailDto> dictDetails;

    private String name;

    private String description;
}
