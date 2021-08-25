package com.gitee.coadmin.modules.system.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import com.gitee.coadmin.base.DataDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
* @author jinjin
* @date 2020-09-25
*/
@Getter
@Setter
public class UserDto extends DataDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private Long id;

    private Set<Long> roles;

    private Set<Long> jobs;

    private Set<Long> depts;

    //private DeptSmallDto dept;

    //private Long deptId;

    private String username;
    private String usernameLetter;

    private String nickName;

    private String gender;

    private String phone;

    private String email;

    private String avatarName;

    private String avatarPath;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private Boolean isAdmin;

    private Boolean enabled;

    private Date pwdResetTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto dto = (UserDto) o;
        return Objects.equals(id, dto.id) &&
                Objects.equals(username, dto.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

}
