package ${package}.service.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;
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
 * ${apiAlias}
 * @author ${author}
 * @since ${date}
 */
@Getter
@Setter
@NoArgsConstructor
public class ${className}DTO extends BaseDto {
    private static final long serialVersionUID = 1L;
<#if columns??>
    <#list columns as column>

    <#if column.remark != ''>
    @ApiModelProperty(value = "${column.remark}")
    @Excel(name = "${column.remark}")
    </#if>
    <#if column.istNotNull && column.columnKey != 'PRI'>
      <#if column.columnType = 'String'>
    @NotBlank
    <#else>
    @NotNull
      </#if>
    </#if>
    <#if column.changeColumnName = 'remarks'>
    @Size(max = 60, message = "备注长度不能大于60")
    </#if>
    <#if column.columnType = 'Long' || column.columnType = 'BigDecimal'>
    @JsonSerialize(using= ToStringSerializer.class)
    </#if>
    <#if column.changeColumnName != 'delFlag'>
    private ${column.columnType} ${column.changeColumnName};
    </#if>
    </#list>

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      ${className}DTO obj = (${className}DTO) o;
      return Objects.equals(id, obj.id);
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(id);
    }
</#if>
}
