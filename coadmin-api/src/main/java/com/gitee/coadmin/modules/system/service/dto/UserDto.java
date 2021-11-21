package com.gitee.coadmin.modules.system.service.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.gitee.coadmin.excel.EnableDisableConverter;
import com.gitee.coadmin.excel.ExcelUserIdConverter;
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
@ExcelIgnoreUnannotated
public class UserDto extends DataDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * 演示converter的使用
     */
    @ExcelProperty(value = "用户名", converter = ExcelUserIdConverter.class)
    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private Long id;

    private Set<Long> roles;

    private Set<Long> jobs;

    private Set<Long> depts;

    //private DeptSmallDto dept;

    //private Long deptId;

    /*
     * 通过上面的 ExcelUserIdConverter.class 得到用户名
     */
    @ExcelIgnore
    private String username;

    private String usernameLetter;

    private String nickName;

    @ExcelProperty("性别")
    private String gender;

    @ExcelProperty("手机")
    private String phone;

    @ExcelProperty("邮箱")
    private String email;

    private String avatarName;

    private String avatarPath;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private Boolean isAdmin;

    @ExcelProperty(value = "状态", converter = EnableDisableConverter.class)
    private Boolean enabled;

    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("修改密码时间")
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
