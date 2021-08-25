package com.gitee.coadmin.modules.system.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import com.gitee.coadmin.base.DataDto;

import java.io.Serializable;
import java.util.Objects;

/**
* @author jinjin
* @date 2020-09-25
*/
@Getter
@Setter
@NoArgsConstructor
public class JobDto extends DataDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Boolean enabled;

    private Integer sort;

    public JobDto(String name, Boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JobDto dto = (JobDto) o;
        return Objects.equals(id, dto.id) &&
                Objects.equals(name, dto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
