package com.gitee.coadmin.modules.system.service.mapper;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.gitee.coadmin.base.CommonMapper;
import com.gitee.coadmin.modules.system.domain.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
* @author jinjin
* @date 2020-09-25
*/
@Repository
public interface DeptMapper extends CommonMapper<Dept> {

    @Select("select d.* from sys_dept d where id = #{id}")
    Dept selectLink(Long id);

    @Select("SELECT d.* FROM sys_dept d LEFT OUTER JOIN sys_roles_depts rd ON d.id=rd.dept_id WHERE rd.role_id=#{roleId}")
    Set<Dept> selectByRoleId(Long roleId);

    List<Long> querySubDeptIdByPids(@Param(Constants.WRAPPER) AbstractWrapper query);

    List<Long> selectIdsByPid(Long pid);
}
