package com.gitee.coadmin.modules.system.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* @author jinjin
* @date 20201007
*/
@Data
@NoArgsConstructor
public class DeptCompactDto implements Serializable {

    private Long id;
    private Long pid;
    private String name;
    private String nameLetter;
    private String deptCode;
    private Integer sort;
    private Boolean enabled;
    private Boolean treeLeaf;
    private String treeNames;
    private String treeNamesLetter;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeptCompactDto> children;
    private Date createTime;

    public String getLabel() {
        return name;
    }

    public Boolean getHasChildren() {
        return children != null && !children.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeptCompactDto deptDto = (DeptCompactDto) o;
        return Objects.equals(id, deptDto.id) &&
                Objects.equals(name, deptDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}