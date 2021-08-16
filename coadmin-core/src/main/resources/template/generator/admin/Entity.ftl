package ${package}.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import java.util.Date;
<#if hasDateAnnotation>
</#if>
<#if hasTimestamp>
import java.sql.Timestamp;
</#if>
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>
import com.gitee.coadmin.base.BaseEntity;

/**
 * @author ${author}
 * @since ${date}
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("${tableName}")
public class ${className} extends BaseEntity {
    private static final long serialVersionUID = 1L;
<#if columns??>
    <#list columns as column>

    <#if column.remark != ''>
    @ApiModelProperty(value = "${column.remark}")
    </#if>
    <#if column.columnKey = 'PRI'>
      <#if auto>
    @TableId(type= IdType.AUTO)
      <#else>
    @TableId(type= IdType.ASSIGN_ID)
      </#if>
    </#if>
    <#if column.dateAnnotation??>
    <#if column.dateAnnotation = 'CreationTimestamp'>
    @TableField(fill= FieldFill.INSERT)
    <#elseif column.dateAnnotation = 'UpdateTimestamp'>
    @TableField(fill= FieldFill.UPDATE)
    <#else>
    @TableField(fill= FieldFill.INSERT_UPDATE)
    </#if>
    </#if>
    <#if column.changeColumnName = 'delFlag'>
    //@TableLogic
    //@TableField(fill=FieldFill.INSERT_UPDATE)
    private Boolean ${column.changeColumnName};
    <#else>
    private ${column.columnType} ${column.changeColumnName};
    </#if>
    </#list>
</#if>

    public void copyFrom(${className} source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
