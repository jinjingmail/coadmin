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
 * 无创产前筛查
 * @author jinjin
 * @since 2022-01-04
 */
@Getter
@Setter
@NoArgsConstructor
public class TraceNiptDTO extends BaseDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

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

    @ApiModelProperty(value = "身份证")
    @Excel(name = "身份证")
    private String patientIdNo;

    @ApiModelProperty(value = "保健号")
    @Excel(name = "保健号")
    private String patientHealthNo;

    @ApiModelProperty(value = "病案号")
    @Excel(name = "病案号")
    private String caseNo;

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

    @ApiModelProperty(value = "13-三体")
    @Excel(name = "13-三体")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal t13;

    @ApiModelProperty(value = "18-三体")
    @Excel(name = "18-三体")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal t18;

    @ApiModelProperty(value = "21-三体")
    @Excel(name = "21-三体")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal t21;

    @ApiModelProperty(value = "结果描述")
    @Excel(name = "结果描述")
    private String reportDetails;

    @ApiModelProperty(value = "补充内容1")
    @Excel(name = "补充内容1")
    private String addition1;

    @ApiModelProperty(value = "补充内容1说明")
    @Excel(name = "补充内容1说明")
    private String addition1Remark;

    @ApiModelProperty(value = "补充内容2")
    @Excel(name = "补充内容2")
    private String addition2;

    @ApiModelProperty(value = "补充内容2说明")
    @Excel(name = "补充内容2说明")
    private String addition2Remark;

    @ApiModelProperty(value = "T13风险")
    @Excel(name = "T13风险")
    private String t13Risk;

    @ApiModelProperty(value = "T18风险")
    @Excel(name = "T18风险")
    private String t18Risk;

    @ApiModelProperty(value = "T21风险")
    @Excel(name = "T21风险")
    private String t21Risk;

    @ApiModelProperty(value = "报告评价")
    @Excel(name = "报告评价")
    private String reportEvaluation;

    @ApiModelProperty(value = "孕次")
    @Excel(name = "孕次")
    private Integer timesOfPregnancy;

    @ApiModelProperty(value = "产次")
    @Excel(name = "产次")
    private Integer timesOfBirth;

    @ApiModelProperty(value = "体重(Kg)")
    @Excel(name = "体重(Kg)")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal patientWeight;

    @ApiModelProperty(value = "身高(cm)")
    @Excel(name = "身高(cm)")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal patientHeight;

    @ApiModelProperty(value = "体重指数")
    @Excel(name = "体重指数")
    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal weightIndex;

    @ApiModelProperty(value = "末次月经")
    @Excel(name = "末次月经", format = "yyyy-MM-dd")
    private Date lastMenstruation;

    @ApiModelProperty(value = "月经计算孕周")
    @Excel(name = "月经计算孕周")
    private String mcgw;

    @ApiModelProperty(value = "抽血当天孕周")
    @Excel(name = "抽血当天孕周")
    private String bdgw;

    @ApiModelProperty(value = "自然受孕")
    @Excel(name = "自然受孕")
    private String natureConceived;

    @ApiModelProperty(value = "促排卵")
    @Excel(name = "促排卵")
    private String ovulationInduction;

    @ApiModelProperty(value = "IUI")
    @Excel(name = "IUI")
    private String iui;

    @ApiModelProperty(value = "IVF")
    @Excel(name = "IVF")
    private String ivf;

    @ApiModelProperty(value = "异体输血")
    @Excel(name = "异体输血")
    private String allogeneticTransfusion;

    @ApiModelProperty(value = "家族史")
    @Excel(name = "家族史")
    private String familyDiseases;

    @ApiModelProperty(value = "筛查模式")
    @Excel(name = "筛查模式")
    private String screeningModel;

    @ApiModelProperty(value = "超声NT测定孕周")
    @Excel(name = "超声NT测定孕周")
    private String ntGw;

    @ApiModelProperty(value = "NT测定值(mm)")
    @Excel(name = "NT测定值(mm)")
    private String ntMm;

    @ApiModelProperty(value = "母体血清筛查风险")
    @Excel(name = "母体血清筛查风险")
    private String mssr;

    @ApiModelProperty(value = "21三体综合征")
    @Excel(name = "21三体综合征")
    private String t21Syndrome;

    @ApiModelProperty(value = "18三体综合征")
    @Excel(name = "18三体综合征")
    private String t18Syndrome;

    @ApiModelProperty(value = "13三体综合征")
    @Excel(name = "13三体综合征")
    private String t13Syndrome;

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
      TraceNiptDTO obj = (TraceNiptDTO) o;
      return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(id);
    }
}
