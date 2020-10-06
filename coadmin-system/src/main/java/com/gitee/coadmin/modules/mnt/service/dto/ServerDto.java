package com.gitee.coadmin.modules.mnt.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.gitee.coadmin.base.DataDto;

import java.io.Serializable;
import java.util.Objects;

/**
* @author jinjin
* @date 2020-09-27
*/
@Getter
@Setter
@NoArgsConstructor
public class ServerDto extends DataDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private Long id;

    private String account;

    private String ip;

    private String name;

    private String password;

    private Integer port;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServerDto that = (ServerDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
