package com.gitee.coadmin.modules.system.service.mapper;

import com.gitee.coadmin.base.CommonMapper;
import com.gitee.coadmin.modules.system.domain.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.Set;

/**
* @author jinjin
* @date 2020-09-25
*/
@Repository
public interface MenuMapper extends CommonMapper<Menu> {

    @Select("SELECT distinct m.id FROM sys_roles_menus rm INNER JOIN sys_menu m ON rm.menu_id=m.id WHERE rm.role_id=#{roleId}")
    Set<Long> selectLink(Long roleId);

    @Select({"<script>SELECT m.* FROM sys_roles_menus rm INNER JOIN sys_menu m ON rm.menu_id=m.id WHERE rm.role_id IN"
            + "<foreach item='item' index='index' collection='roleIds' open='(' separator=',' close=')'> #{item} </foreach>"
            + "</script>"})
    Set<Menu> selectByRoleIds(@Param("roleIds") Set<Long> roleIds);

    @Select({"<script>SELECT m.* FROM sys_menu m LEFT OUTER JOIN sys_roles_menus rm ON m.id=rm.menu_id LEFT OUTER JOIN sys_role r ON rm.role_id=r.id WHERE r.id IN "
            + "<foreach item='item' index='index' collection='roleIds' open='(' separator=',' close=')'> #{item} </foreach>"
            + " AND m.type &lt;&gt; #{type} ORDER BY m.sort ASC</script>"})
    LinkedHashSet<Menu> selectLinkRole(@Param("roleIds") Set<Long> roleIds, @Param("type") Long type);

}
