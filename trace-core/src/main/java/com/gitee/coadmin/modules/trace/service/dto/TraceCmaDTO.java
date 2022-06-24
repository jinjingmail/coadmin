package com.gitee.coadmin.modules.trace.service.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
 * 染色体微整列分析
 * @author jinjin
 * @since 2022-01-04
 */
@Getter
@Setter
@NoArgsConstructor
public class TraceCmaDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "已查看")
    @Excel(name = "已查看")
    private Boolean viewed;

    @ApiModelProperty(value = "核收日期")
    @Excel(name = "核收日期", format = "yyyy-MM-dd")
    private Date receiptDate;

    @ApiModelProperty(value = "报告状态")
    @Excel(name = "报告状态")
    private String reportStatus;

    @ApiModelProperty(value = "报告日期")
    @Excel(name = "报告日期", format = "yyyy-MM-dd")
    private Date reportDate;

    @ApiModelProperty(value = "流水号")
    @Excel(name = "流水号")
    private String reportNo;

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

    @ApiModelProperty(value = "登记号")
    @Excel(name = "登记号")
    private String patientNo;

    @ApiModelProperty(value = "标本号")
    @Excel(name = "标本号")
    private String specimanNo;

    @ApiModelProperty(value = "标本类型")
    @Excel(name = "标本类型")
    private String specimanType;

    @ApiModelProperty(value = "联系电话")
    @Excel(name = "联系电话")
    private String contactTel;

    @ApiModelProperty(value = "科室")
    @Excel(name = "科室")
    private String departmentName;

    @ApiModelProperty(value = "诊断")
    @Excel(name = "诊断")
    private String diagnosis;

    @ApiModelProperty(value = "医嘱")
    @Excel(name = "医嘱")
    private String doctorAdvice;

    @ApiModelProperty(value = "芯片ID")
    @Excel(name = "芯片ID")
    private String chipId;

    @ApiModelProperty(value = "报告提示")
    @Excel(name = "报告提示")
    private String reportTip;

    @ApiModelProperty(value = "结果")
    @Excel(name = "结果")
    private String result;

    @ApiModelProperty(value = "分析意见")
    @Excel(name = "分析意见")
    private String reportAnalysisOpinion;

    @ApiModelProperty(value = "结论")
    @Excel(name = "结论")
    private String conclusion;

    @ApiModelProperty(value = "提示")
    @Excel(name = "提示")
    private String conclusionDetails;

    @ApiModelProperty(value = "建议")
    @Excel(name = "建议")
    private String suggest;

    @ApiModelProperty(value = "染色体区域")
    @Excel(name = "染色体区域")
    private String chromosomeRegion;

    @ApiModelProperty(value = "DNA CHip")
    @Excel(name = "DNA CHip")
    private String dnaChip;

    @ApiModelProperty(value = "结果2")
    @Excel(name = "结果2")
    private String result2;

    @ApiModelProperty(value = "染色体区域2")
    @Excel(name = "染色体区域2")
    private String chromosomeRegion2;

    @ApiModelProperty(value = "结论2")
    @Excel(name = "结论2")
    private String conclusion2;

    @ApiModelProperty(value = "结果3")
    @Excel(name = "结果3")
    private String result3;

    @ApiModelProperty(value = "染色体区域3")
    @Excel(name = "染色体区域3")
    private String chromosomeRegion3;

    @ApiModelProperty(value = "结论3")
    @Excel(name = "结论3")
    private String conclusion3;

    @ApiModelProperty(value = "结果4")
    @Excel(name = "结果4")
    private String result4;

    @ApiModelProperty(value = "染色体区域4")
    @Excel(name = "染色体区域4")
    private String chromosomeRegion4;

    @ApiModelProperty(value = "结论4")
    @Excel(name = "结论4")
    private String conclusion4;

    @ApiModelProperty(value = "检验时间")
    @Excel(name = "检验时间", format = "yyyy-MM-dd HH:mm")
    private Date inspectionTime;

    @ApiModelProperty(value = "孕次")
    @Excel(name = "孕次")
    private Integer timesOfPregnancy;

    @ApiModelProperty(value = "产次")
    @Excel(name = "产次")
    private Integer timesOfBirth;

    @ApiModelProperty(value = "签署同意书")
    @Excel(name = "签署同意书")
    private Integer signConsent;

    @ApiModelProperty(value = "申请医生")
    @Excel(name = "申请医生")
    private String applyDoctor;

    @ApiModelProperty(value = "申请日期")
    @Excel(name = "申请日期", format = "yyyy-MM-dd")
    private Date applyDate;

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
      TraceCmaDTO obj = (TraceCmaDTO) o;
      return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(id);
    }
}
