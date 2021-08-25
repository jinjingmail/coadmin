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
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import java.util.Date;
import java.util.Objects;
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
 * ${apiAlias}
 * @author ${author}
 * @since ${date}
 */
@Getter
@Setter
@NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ${className} obj = (${className}) o;
        return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void copyFrom(${className} source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
