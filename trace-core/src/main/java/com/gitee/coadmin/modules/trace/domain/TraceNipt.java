package com.gitee.coadmin.modules.trace.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import java.util.Date;
import java.util.Objects;
import java.math.BigDecimal;
import com.gitee.coadmin.base.BaseEntity;

/**
 * 无创产前筛查
 * @author jinjin
 * @since 2022-01-04
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("trace_nipt")
public class TraceNipt extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(type= IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "核收日期")
    private Date receiptDate;

    @ApiModelProperty(value = "报告状态")
    private String reportStatus;

    @ApiModelProperty(value = "报告日期")
    private Date reportDate;

    @ApiModelProperty(value = "流水号")
    private String reportNo;

    @ApiModelProperty(value = "姓名")
    private String patientName;

    @ApiModelProperty(value = "姓名首字母")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private String patientNameLetter;

    @ApiModelProperty(value = "性别")
    private String patientGender;

    @ApiModelProperty(value = "年龄")
    private String patientAge;

    @ApiModelProperty(value = "登记号")
    private String patientNo;

    @ApiModelProperty(value = "身份证")
    private String patientIdNo;

    @ApiModelProperty(value = "保健号")
    private String patientHealthNo;

    @ApiModelProperty(value = "病案号")
    private String caseNo;

    @ApiModelProperty(value = "标本号")
    private String specimanNo;

    @ApiModelProperty(value = "标本类型")
    private String specimanType;

    @ApiModelProperty(value = "联系电话")
    private String contactTel;

    @ApiModelProperty(value = "科室")
    private String departmentName;

    @ApiModelProperty(value = "诊断")
    private String diagnosis;

    @ApiModelProperty(value = "医嘱")
    private String doctorAdvice;

    @ApiModelProperty(value = "13-三体")
    private BigDecimal t13;

    @ApiModelProperty(value = "18-三体")
    private BigDecimal t18;

    @ApiModelProperty(value = "21-三体")
    private BigDecimal t21;

    @ApiModelProperty(value = "结果描述")
    private String reportDetails;

    @ApiModelProperty(value = "补充内容1")
    private String addition1;

    @ApiModelProperty(value = "补充内容1说明")
    private String addition1Remark;

    @ApiModelProperty(value = "补充内容2")
    private String addition2;

    @ApiModelProperty(value = "补充内容2说明")
    private String addition2Remark;

    @ApiModelProperty(value = "T13风险")
    private String t13Risk;

    @ApiModelProperty(value = "T18风险")
    private String t18Risk;

    @ApiModelProperty(value = "T21风险")
    private String t21Risk;

    @ApiModelProperty(value = "报告评价")
    private String reportEvaluation;

    @ApiModelProperty(value = "孕次")
    private Integer timesOfPregnancy;

    @ApiModelProperty(value = "产次")
    private Integer timesOfBirth;

    @ApiModelProperty(value = "体重(Kg)")
    private BigDecimal patientWeight;

    @ApiModelProperty(value = "身高(cm)")
    private BigDecimal patientHeight;

    @ApiModelProperty(value = "体重指数")
    private BigDecimal weightIndex;

    @ApiModelProperty(value = "末次月经")
    private Date lastMenstruation;

    @ApiModelProperty(value = "月经计算孕周")
    private String mcgw;

    @ApiModelProperty(value = "抽血当天孕周")
    private String bdgw;

    @ApiModelProperty(value = "自然受孕")
    private String natureConceived;

    @ApiModelProperty(value = "促排卵")
    private String ovulationInduction;

    @ApiModelProperty(value = "IUI")
    private String iui;

    @ApiModelProperty(value = "IVF")
    private String ivf;

    @ApiModelProperty(value = "异体输血")
    private String allogeneticTransfusion;

    @ApiModelProperty(value = "家族史")
    private String familyDiseases;

    @ApiModelProperty(value = "筛查模式")
    private String screeningModel;

    @ApiModelProperty(value = "超声NT测定孕周")
    private String ntGw;

    @ApiModelProperty(value = "NT测定值(mm)")
    private String ntMm;

    @ApiModelProperty(value = "母体血清筛查风险")
    private String mssr;

    @ApiModelProperty(value = "21三体综合征")
    private String t21Syndrome;

    @ApiModelProperty(value = "18三体综合征")
    private String t18Syndrome;

    @ApiModelProperty(value = "13三体综合征")
    private String t13Syndrome;

    @ApiModelProperty(value = "签署同意书")
    private Integer signConsent;

    @ApiModelProperty(value = "申请医生")
    private String applyDoctor;

    @ApiModelProperty(value = "申请日期")
    private Date applyDate;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill= FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    @TableField(fill= FieldFill.INSERT)
    private Long createUser;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill= FieldFill.UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "修改人")
    @TableField(fill= FieldFill.UPDATE)
    private Long updateUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TraceNipt obj = (TraceNipt) o;
        return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void copyFrom(TraceNipt source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
