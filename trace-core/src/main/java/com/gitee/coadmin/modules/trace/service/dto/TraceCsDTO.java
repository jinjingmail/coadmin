package com.gitee.coadmin.modules.trace.service.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.*;
import com.gitee.coadmin.base.BaseDto;

/**
 * 染色体核型结果
 * @author jinjin
 * @since 2022-01-04
 */
@Getter
@Setter
@NoArgsConstructor
public class TraceCsDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "报告时间")
    @Excel(name = "报告时间", format = "yyyy-MM-dd HH:mm")
    private Date reportTime;

    @ApiModelProperty(value = "流水号")
    @Excel(name = "流水号")
    private String reportNo;

    @ApiModelProperty(value = "登记号")
    @Excel(name = "登记号")
    private String patientNo;

    @ApiModelProperty(value = "姓名")
    @Excel(name = "姓名")
    private String patientName;

    @ApiModelProperty(value = "姓名首字母")
    private String patientNameLetter;

    @ApiModelProperty(value = "性别")
    @Excel(name = "性别")
    private String patientGender;

    @ApiModelProperty(value = "年龄")
    @Excel(name = "年龄")
    private String patientAge;

    @ApiModelProperty(value = "科室")
    @Excel(name = "科室")
    private String departmentName;

    @ApiModelProperty(value = "医嘱")
    @Excel(name = "医嘱")
    private String doctorAdvice;

    @ApiModelProperty(value = "标本类型")
    @Excel(name = "标本类型")
    private String specimanType;

    @ApiModelProperty(value = "诊断")
    @Excel(name = "诊断")
    private String diagnosis;

    @ApiModelProperty(value = "染色体核型结果")
    @Excel(name = "染色体核型结果")
    private String karyotypeResult;

    @ApiModelProperty(value = "早筛报告时间")
    @Excel(name = "早筛报告时间", format = "yyyy-MM-dd HH:mm")
    private Date firstPregencyReportTime;

    @ApiModelProperty(value = "PAPPMOM(早筛)")
    @Excel(name = "PAPPMOM(早筛)")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal firstPappmom;

    @ApiModelProperty(value = "FHCGMOM(早筛)")
    @Excel(name = "FHCGMOM(早筛)")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal firstFhcgmom;

    @ApiModelProperty(value = "T21风险值(早筛)")
    @Excel(name = "T21风险值(早筛)")
    private Integer firstT21Risk;

    @ApiModelProperty(value = "T18风险值(早筛)")
    @Excel(name = "T18风险值(早筛)")
    private Integer firstT18Risk;

    @ApiModelProperty(value = "中筛报告时间")
    @Excel(name = "中筛报告时间", format = "yyyy-MM-dd HH:mm")
    private Date secondPregencyReportTime;

    @ApiModelProperty(value = "AFPMOM(中筛)")
    @Excel(name = "AFPMOM(中筛)")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal secondAfpmom;

    @ApiModelProperty(value = "FHCGMOM(中筛)")
    @Excel(name = "FHCGMOM(中筛)")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal secondFhcgmom;

    @ApiModelProperty(value = "E3MOM(中筛)")
    @Excel(name = "E3MOM(中筛)")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal secondE3mom;

    @ApiModelProperty(value = "T21风险值(中筛)")
    @Excel(name = "T21风险值(中筛)")
    private Integer secondT21Risk;

    @ApiModelProperty(value = "T18风险值(中筛)")
    @Excel(name = "T18风险值(中筛)")
    private Integer secondT18Risk;

    @ApiModelProperty(value = "无创报告时间")
    @Excel(name = "无创报告时间", format = "yyyy-MM-dd HH:mm")
    private Date niptReportTime;

    @ApiModelProperty(value = "无创筛查")
    @Excel(name = "无创筛查")
    private String niptScreening;

    @ApiModelProperty(value = "无创补充报告时间")
    @Excel(name = "无创补充报告时间", format = "yyyy-MM-dd HH:mm")
    private Date niptReplenishReportTime;

    @ApiModelProperty(value = "无创筛查补充")
    @Excel(name = "无创筛查补充")
    private String niptScreeningReplenish;

    @ApiModelProperty(value = "备注")
    @Excel(name = "备注")
    @Size(max = 60, message = "备注长度不能大于60")
    private String remarks;

    @ApiModelProperty(value = "创建时间")
    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    @Excel(name = "创建人")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long createUser;

    @ApiModelProperty(value = "修改时间")
    @Excel(name = "修改时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "修改人")
    @Excel(name = "修改人")
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
      TraceCsDTO obj = (TraceCsDTO) o;
      return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(id);
    }
}
