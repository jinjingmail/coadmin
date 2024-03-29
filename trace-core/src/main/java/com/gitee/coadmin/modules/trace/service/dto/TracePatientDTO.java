package com.gitee.coadmin.modules.trace.service.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.hutool.core.util.StrUtil;
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
 * 就诊人
 * @author jinjin
 * @since 2022-01-04
 */
@Getter
@Setter
@NoArgsConstructor
public class TracePatientDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    //@Excel(name = "ID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "true=已阅")
    //@Excel(name = "已阅")
    private Boolean viewed;

    @ApiModelProperty(value = "登记号")
    @Excel(name = "登记号")
    @NotBlank
    private String no;

    @ApiModelProperty(value = "姓名")
    @Excel(name = "姓名")
    @NotBlank
    private String name;

    @Excel(name = "CMA数量")
    private Integer cmaQuantity;
    @Excel(name = "CS数量")
    private Integer csQuantity;
    @Excel(name = "NIPT数量")
    private Integer niptQuantity;

    @ApiModelProperty(value = "备注")
    @Excel(name = "备注", width = 30.0)
    @Size(max = 260, message = "备注长度不能大于260")
    private String remarks;

    /*** 单独统计 begin */
    private String csSummary;
    private String cmaSummary;
    private String niptSummary;
    /** end */

    @Excel(name = "摘要", width = 30.0, isWrap = true)
    private String summary;
    public String getSummary() {
        return "CMA：" + StrUtil.trimToEmpty(cmaSummary) +
                "\nCS：" + StrUtil.trimToEmpty(csSummary) +
                "\nNIPT：" + StrUtil.trimToEmpty(niptSummary);
    }

    @ApiModelProperty(value = "姓名首字母")
    private String nameLetter;

    @ApiModelProperty(value = "性别")
    @Excel(name = "性别")
    private String gender;

    @ApiModelProperty(value = "出生日期")
    @Excel(name = "出生日期", format = "yyyy-MM-dd")
    private Date birthday;

    @ApiModelProperty(value = "身份证号")
    @Excel(name = "身份证号")
    private String idNo;

    @ApiModelProperty(value = "保健号")
    @Excel(name = "保健号")
    private String healthNo;

    @ApiModelProperty(value = "联系方式")
    @Excel(name = "联系方式")
    private String contactNo;

    @ApiModelProperty(value = "创建时间")
    //@Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    //@Excel(name = "创建人")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long createUser;

    @ApiModelProperty(value = "更新时间")
    //@Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    //@Excel(name = "更新人")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long updateUser;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      TracePatientDTO obj = (TracePatientDTO) o;
      return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(id);
    }
}
