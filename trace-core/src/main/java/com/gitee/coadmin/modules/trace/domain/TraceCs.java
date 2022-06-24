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
 * 染色体核型结果
 * @author jinjin
 * @since 2022-01-04
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("trace_cs")
public class TraceCs extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(type= IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "已查看")
    private Boolean viewed;

    @ApiModelProperty(value = "报告时间")
    private Date reportTime;

    @ApiModelProperty(value = "流水号")
    private String reportNo;

    @ApiModelProperty(value = "登记号")
    private String patientNo;

    @ApiModelProperty(value = "姓名")
    private String patientName;

    @ApiModelProperty(value = "性别")
    private String patientGender;

    @ApiModelProperty(value = "年龄")
    private String patientAge;

    @ApiModelProperty(value = "科室")
    private String departmentName;

    @ApiModelProperty(value = "医嘱")
    private String doctorAdvice;

    @ApiModelProperty(value = "标本类型")
    private String specimanType;

    @ApiModelProperty(value = "诊断")
    private String diagnosis;

    @ApiModelProperty(value = "染色体核型结果")
    private String karyotypeResult;

    @ApiModelProperty(value = "早筛报告时间")
    private Date firstPregencyReportTime;

    @ApiModelProperty(value = "PAPPMOM(早筛)")
    private BigDecimal firstPappmom;

    @ApiModelProperty(value = "FHCGMOM(早筛)")
    private BigDecimal firstFhcgmom;

    @ApiModelProperty(value = "T21风险值(早筛)")
    private Integer firstT21Risk;

    @ApiModelProperty(value = "T18风险值(早筛)")
    private Integer firstT18Risk;

    @ApiModelProperty(value = "中筛报告时间")
    private Date secondPregencyReportTime;

    @ApiModelProperty(value = "AFPMOM(中筛)")
    private BigDecimal secondAfpmom;

    @ApiModelProperty(value = "FHCGMOM(中筛)")
    private BigDecimal secondFhcgmom;

    @ApiModelProperty(value = "E3MOM(中筛)")
    private BigDecimal secondE3mom;

    @ApiModelProperty(value = "T21风险值(中筛)")
    private Integer secondT21Risk;

    @ApiModelProperty(value = "T18风险值(中筛)")
    private Integer secondT18Risk;

    @ApiModelProperty(value = "无创报告时间")
    private Date niptReportTime;

    @ApiModelProperty(value = "无创筛查")
    private String niptScreening;

    @ApiModelProperty(value = "无创补充报告时间")
    private Date niptReplenishReportTime;

    @ApiModelProperty(value = "无创筛查补充")
    private String niptScreeningReplenish;

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
        TraceCs obj = (TraceCs) o;
        return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void copyFrom(TraceCs source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
