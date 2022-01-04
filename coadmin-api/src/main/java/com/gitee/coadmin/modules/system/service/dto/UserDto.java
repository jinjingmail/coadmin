package com.gitee.coadmin.modules.system.service.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
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

    @Excel(name = "用户名")
    private String username;

    private String usernameLetter;

    private String nickName;

    @Excel(name = "性别")
    private String gender;

    @Excel(name = "手机")
    private String phone;

    @Excel(name = "邮箱")
    private String email;

    private String avatarName;

    private String avatarPath;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private Boolean isAdmin;

    @Excel(name = "状态", replace = {"启用_true", "禁用_false"})
    private Boolean enabled;

    @Excel(name = "修改密码时间", format = "yyyy年MM月dd日")
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
