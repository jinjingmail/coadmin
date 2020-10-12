package com.gitee.coadmin.modules.system.service.mapper;

import com.gitee.coadmin.base.CommonMapper;
import com.gitee.coadmin.modules.system.domain.Role;
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
public interface RoleMapper extends CommonMapper<Role> {
    @Select("SELECT r.* FROM sys_role r LEFT OUTER JOIN sys_users_roles ur ON r.id=ur.role_id LEFT OUTER JOIN sys_user u ON ur.user_id=u.id WHERE u.id=#{userId}")
    Set<Role> selectLink(Long userId);

    /**
     * 根据用户ID查询
     *
     * @param id 用户ID
     * @return /
     */
    @Select("SELECT r.* FROM sys_role r, sys_users_roles u WHERE " + "r.id = u.role_id AND u.user_id = #{id}")
    Set<Role> findByUserId(@Param("id") Long id);

    /**
     * 根据机构查询
     *
     * @param deptIds /
     * @return /
     */
    int countByDepts(@Param("deptIds") Set<Long> deptIds);

    /**
     * 根据菜单Id查询
     * @param menuIds /
     * @return /
     */
    List<Role> findInMenuId(@Param("menuIds") List<Long> menuIds);

}
