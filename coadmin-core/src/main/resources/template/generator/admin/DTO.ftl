package ${package}.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
<#if hasTimestamp>
import java.sql.Timestamp;
</#if>
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>
import java.util.Date;
<#if !auto && pkColumnType == 'Long'>
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
</#if>
<#if isNotNullColumns??>
import javax.validation.constraints.*;
</#if>
import com.gitee.coadmin.base.BaseDto;

/**
 * @author ${author}
 * @since ${date}
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ${className}DTO extends BaseDto {
    private static final long serialVersionUID = 1L;
<#if columns??>
    <#list columns as column>

    <#if column.remark != ''>
    @ApiModelProperty(value = "${column.remark}")
    </#if>
    <#if column.istNotNull && column.columnKey != 'PRI'>
      <#if column.columnType = 'String'>
    @NotBlank
    <#else>
    @NotNull
      </#if>
    </#if>
    <#if column.changeColumnName = 'remarks'>
    @Size(max = 60, message = "备注长度大于60")
    </#if>
    <#if column.columnType = 'Long'>
    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    </#if>
    <#if column.changeColumnName != 'delFlag'>
    private ${column.columnType} ${column.changeColumnName};
    </#if>
    </#list>
</#if>
}
