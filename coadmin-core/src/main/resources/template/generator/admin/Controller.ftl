package ${package}.rest;

import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.Log;
import ${package}.service.${className}Service;
import ${package}.service.dto.${className}DTO;
import ${package}.service.dto.${className}QueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.util.Set;

/*  添加菜单的 SQL
<#if hasMenuPid>
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (${menuPid}, 4, 1, '${apiAlias}', '${apiAliasLetter}', '${className}', '${changeClassName}/index', 10, '${changeClassName}', 0, 0, 0, '');
SELECT @lastId:=LAST_INSERT_ID();
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '查看${apiAlias}', 10, 0, 0, 0, '${changeClassName}:list');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '新增${apiAlias}', 2, 0, 0, 0, '${changeClassName}:add');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '修改${apiAlias}', 30, 0, 0, 0, '${changeClassName}:edit');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '删除${apiAlias}', 40, 0, 0, 0, '${changeClassName}:del');
<#else>
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (null, 4, 1, '${apiAlias}', '${apiAliasLetter}', '${className}', '${minusClassName}/index', 10, '${minusClassName}', 0, 0, 0, '${changeClassName}:list');
SELECT @lastId:=LAST_INSERT_ID();
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '查看${apiAlias}', 10, 0, 0, 0, '${changeClassName}:list');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '新增${apiAlias}', 20, 0, 0, 0, '${changeClassName}:add');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '修改${apiAlias}', 30, 0, 0, 0, '${changeClassName}:edit');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '删除${apiAlias}', 40, 0, 0, 0, '${changeClassName}:del');
</#if>
*/

/**
 * @author ${author}
 * @date ${date}
 **/
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@Api(tags = "${apiAlias}")
@RequestMapping("/api/${minusClassName}")
public class ${className}Controller {

    private final ${className}Service ${changeClassName}Service;

    @GetMapping
    @Log("查询${apiAlias}")
    @ApiOperation("查询${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:list')")
    public PageInfo<${className}DTO> query(${className}QueryParam query, Pageable pageable){
        return ${changeClassName}Service.queryAll(query,pageable);
    }

    @PostMapping
    @Log("新增${apiAlias}")
    @ApiOperation("新增${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:add')")
    public Integer create(@Validated @RequestBody ${className}DTO resources){
        return ${changeClassName}Service.insert(resources);
    }

    @PutMapping
    @Log("修改${apiAlias}")
    @ApiOperation("修改${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:edit')")
    public Integer update(@Validated @RequestBody ${className}DTO resources){
        return ${changeClassName}Service.updateById(resources);
    }

    @DeleteMapping
    @Log("删除${apiAlias}")
    @ApiOperation("删除${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:del')")
    public Integer delete(@RequestBody Set<${pkColumnType}> ids) {
        return ${changeClassName}Service.removeByIds(ids);
    }
}
