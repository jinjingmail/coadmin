package com.gitee.coadmin.modules.system.service.dto;

import com.gitee.coadmin.annotation.DataPermission;
import lombok.Data;

import java.util.Date;
import java.util.List;
import com.gitee.coadmin.annotation.Query;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @author jinjin
* @date 2020-09-25
*/
@Getter
@Setter
@DataPermission(fieldName = "id")
public class DeptQueryParam{

    private Long treeId;

    @Query
    private Long id;

    @Query
    private Long pid;

    @Query(propName = "tree_pids", type = Query.Type.INNER_LIKE)
    private String pids;
    public String getPids() {
        return "/"+pids+"/";
    }

    @Query(blurry = "id,treeNames,treeNamesLetter")
    private String blurry;

    /** 精确 */
    @Query
    private Boolean enabled;
}
