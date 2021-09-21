package com.gitee.app.modules.auth.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 用户名密码登录
 * Created by jinjin on 2020-10-13.
 */
@Getter
@Setter
public class UsernamePasswordLoginParam {

    @NotBlank(message = "用户名必填")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank(message = "密码必填")
    @ApiModelProperty(value = "密码")
    private String password;

}
