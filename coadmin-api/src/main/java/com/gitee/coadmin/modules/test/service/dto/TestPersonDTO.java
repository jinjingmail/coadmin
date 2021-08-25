package com.gitee.coadmin.modules.test.service.dto;

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
 * @author jinjin
 * @since 2021-08-22
 */
@Getter
@Setter
@NoArgsConstructor
public class TestPersonDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private Long id;

    @ApiModelProperty(value = "姓名")
    @NotBlank
    private String name;

    @ApiModelProperty(value = "性别")
    @NotBlank
    private String gender;

    @ApiModelProperty(value = "出生日期")
    @NotNull
    private Date birthday;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人")
    private String updateBy;

    @ApiModelProperty(value = "备注")
    @Size(max = 60, message = "备注长度大于60")
    private String remarks;

    @ApiModelProperty(value = "测试enum")
    private Integer mysqlEngine;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      TestPersonDTO obj = (TestPersonDTO) o;
      return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(id);
    }
}
