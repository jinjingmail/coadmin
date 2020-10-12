package com.gitee.coadmin.modules.system.service.dto;

import com.gitee.coadmin.annotation.DataPermission;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gitee.coadmin.annotation.Query;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @author jinjin
* @date 2020-09-25
*/
@Data
@DataPermission(fieldName = "id", inSql="SELECT DISTINCT user_id FROM sys_users_depts WHERE dept_id IN(?)")
public class UserQueryParam{

    /** 精确 */
    @Query
    private Long id;

    @Query(propName = "id", type = Query.Type.IN_SQL,
            sql="SELECT DISTINCT user_id FROM sys_users_depts WHERE dept_id=? OR dept_id IN(SELECT id FROM sys_dept WHERE tree_pids LIKE '%/?/%')")
    private Long deptId;

    @Query(blurry = "username,usernameLetter,phone,email")
    private String blurry;

    /** 精确 */
    @Query
    private Boolean enabled;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Query(type = Query.Type.BETWEEN)
    private List<Date> createTime;
}
