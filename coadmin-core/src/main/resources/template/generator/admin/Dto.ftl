package ${package}.service.dto;

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
import java.sql.Timestamp;
<#if !auto && pkColumnType == 'Long'>
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
</#if>
import com.gitee.coadmin.base.BaseDto;

/**
* @author ${author}
* @date ${date}
*/
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ${className}Dto extends BaseDto {
    private static final long serialVersionUID = 1L;
<#if columns??>
    <#list columns as column>

    <#if column.columnType = 'Long'>
    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    </#if>
    <#if column.changeColumnName != 'delFlag'>
    private ${column.columnType} ${column.changeColumnName};
    </#if>
    </#list>
</#if>
}
