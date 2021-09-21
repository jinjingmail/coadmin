package com.gitee.app.service.dto;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;
import com.gitee.app.enums.AppUserChannelEnum;
import com.gitee.app.enums.AppUserGenderEnum;
import com.gitee.coadmin.utils.ValidationUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.*;
import com.gitee.coadmin.base.BaseDto;

/**
 * APP用户
 * @author jinjin
 * @since 2021-09-20
 */
@Getter
@Setter
@NoArgsConstructor
public class AppUserDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private Long id;

    @ApiModelProperty(value = "状态")
    @NotNull
    private Boolean isEnabled;

    @ApiModelProperty(value = "渠道(1=wxmp;2=wxliteapp;...)")
    @NotNull
    private AppUserChannelEnum channel;

    @ApiModelProperty(value = "openid")
    @NotBlank
    private String openid;

    @ApiModelProperty(value = "微信unionid")
    private String unionid;

    @ApiModelProperty(value = "手机号（已注册标识）")
    private String mobile;

    @ApiModelProperty(value = "昵称")
    @NotBlank
    private String nickname;

    @ApiModelProperty(value = "昵称首字母")
    @NotBlank
    private String nicknameLetter;

    @ApiModelProperty(value = "1男、2女、3未知")
    @NotNull
    private AppUserGenderEnum gender;

    @ApiModelProperty(value = "头像URL")
    private String headimgurl;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "国家地区语言版本")
    private String lang;

    @ApiModelProperty(value = "创建时间")
    @NotNull
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人")
    private String updateBy;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      AppUserDTO obj = (AppUserDTO) o;
      return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(id);
    }

    public Boolean checkIsRegistered() {
        return PhoneUtil.isMobile(getMobile());
    }
}
