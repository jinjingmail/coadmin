package com.gitee.coadmin.modules.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.gitee.coadmin.utils.PinyinUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.EqualsAndHashCode;
import com.gitee.coadmin.base.DataEntity;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
* @author jinjin
* @date 2020-09-25
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class User extends DataEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type= IdType.ASSIGN_ID)
    @NotNull(groups = Update.class)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @NotBlank
    private String username;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String usernameLetter;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "手机号码")
    @NotBlank
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @NotBlank
    private String email;

    @ApiModelProperty(value = "头像地址")
    private String avatarName;

    @ApiModelProperty(value = "头像真实路径")
    private String avatarPath;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "是否为admin账号")
    private Boolean isAdmin;

    @ApiModelProperty(value = "状态：true启用、false禁用")
    private Boolean enabled;

    @ApiModelProperty(value = "修改密码的时间")
    private Date pwdResetTime;

    public <T> void copyFrom(T source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
