package com.gitee.coadmin.modules.system.service.dto;

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
 * 系统参数
 * @author jinjin
 * @since 2021-09-19
 */
@Getter
@Setter
@NoArgsConstructor
public class SettingDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private Long id;

    @ApiModelProperty(value = "键")
    @NotBlank
    private String key;

    @ApiModelProperty(value = "值")
    @NotBlank
    private String value;

    @ApiModelProperty(value = "角色级别（role.level小于等于该值可修改或删除）")
    @NotNull
    private Integer roleLevel;

    @ApiModelProperty(value = "排序")
    @NotNull
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
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
      SettingDTO obj = (SettingDTO) o;
      return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(id);
    }
}
