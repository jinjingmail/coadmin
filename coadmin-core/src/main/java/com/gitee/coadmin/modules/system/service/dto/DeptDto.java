package com.gitee.coadmin.modules.system.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import com.gitee.coadmin.base.DataDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
* @author jinjin
* @date 2020-09-25
*/
@Getter
@Setter
@NoArgsConstructor
public class DeptDto extends DataDto {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String deptCode;

    private String name;
    private String nameLetter;
    private Integer sort;

    private Long pid;
    private String treePids;
    private String treeNames;
    private String treeNamesLetter;
    private String treeSorts;
    private Integer treeLevel;
    private Boolean treeLeaf;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeptDto> children;

    private Boolean enabled;

    public Boolean getHasChildren() {
        return children != null && !children.isEmpty();
    }

    public String getLabel() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeptDto deptDto = (DeptDto) o;
        return Objects.equals(id, deptDto.id) &&
                Objects.equals(name, deptDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
