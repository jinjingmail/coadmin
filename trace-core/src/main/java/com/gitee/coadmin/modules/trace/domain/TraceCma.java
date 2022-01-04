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
import com.gitee.coadmin.base.BaseEntity;

/**
 * 染色体微整列分析
 * @author jinjin
 * @since 2022-01-04
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("trace_cma")
public class TraceCma extends BaseEntity {
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

    @ApiModelProperty(value = "性别")
    private String patientGender;

    @ApiModelProperty(value = "年龄")
    private String patientAge;

    @ApiModelProperty(value = "登记号")
    private String patientNo;

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

    @ApiModelProperty(value = "芯片ID")
    private String chipId;

    @ApiModelProperty(value = "报告提示")
    private String reportTip;

    @ApiModelProperty(value = "结果")
    private String result;

    @ApiModelProperty(value = "分析意见")
    private String reportAnalysisOpinion;

    @ApiModelProperty(value = "结论")
    private String conclusion;

    @ApiModelProperty(value = "提示")
    private String conclusionDetails;

    @ApiModelProperty(value = "建议")
    private String suggest;

    @ApiModelProperty(value = "染色体区域")
    private String chromosomeRegion;

    @ApiModelProperty(value = "DNA CHip")
    private String dnaChip;

    @ApiModelProperty(value = "结果2")
    private String result2;

    @ApiModelProperty(value = "染色体区域2")
    private String chromosomeRegion2;

    @ApiModelProperty(value = "结论2")
    private String conclusion2;

    @ApiModelProperty(value = "结果3")
    private String result3;

    @ApiModelProperty(value = "染色体区域3")
    private String chromosomeRegion3;

    @ApiModelProperty(value = "结论3")
    private String conclusion3;

    @ApiModelProperty(value = "结果4")
    private String result4;

    @ApiModelProperty(value = "染色体区域4")
    private String chromosomeRegion4;

    @ApiModelProperty(value = "结论4")
    private String conclusion4;

    @ApiModelProperty(value = "检验时间")
    private Date inspectionTime;

    @ApiModelProperty(value = "孕次")
    private Integer timesOfPregnancy;

    @ApiModelProperty(value = "产次")
    private Integer timesOfBirth;

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

    @ApiModelProperty(value = "姓名首字母")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private String patientNameLetter;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TraceCma obj = (TraceCma) o;
        return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void copyFrom(TraceCma source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
