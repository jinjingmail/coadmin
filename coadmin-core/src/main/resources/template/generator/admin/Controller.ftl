package ${package}.rest;

import com.gitee.coadmin.modules.logging.annotation.Log;
import ${package}.domain.${className};
import ${package}.service.${className}Service;
import ${package}.service.dto.${className}Dto;
import ${package}.service.dto.${className}QueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.util.Set;

/*  添加菜单的 SQL
<#if hasMenuPid>
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (${menuPid}, 4, 1, '${apiAlias}管理', '${apiAliasLetter}gl', '${className}', '${changeClassName}/index', 10, '${changeClassName}', 0, 1, 0, '${changeClassName}:list');
SELECT @lastId:=LAST_INSERT_ID();
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, permission)
    VALUES (@lastId, 0, 2, '${apiAlias}查看', 10, '${changeClassName}:view');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, permission)
    VALUES (@lastId, 0, 2, '${apiAlias}新增', 10, '${changeClassName}:add');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, permission)
    VALUES (@lastId, 0, 2, '${apiAlias}修改', 10, '${changeClassName}:edit');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, permission)
    VALUES (@lastId, 0, 2, '${apiAlias}删除', 10, '${changeClassName}:del');
<#else>
--- 没有设置上级菜单 ---
</#if>
*/

/**
* @author ${author}
* @date ${date}
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "${apiAlias}管理")
@RequestMapping("/api/${changeClassName}")
public class ${className}Controller {

    private final ${className}Service ${changeClassName}Service;

    @GetMapping
    @Log("查询${apiAlias}")
    @ApiOperation("查询${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:list', '${changeClassName}:view')")
    public ResponseEntity query(${className}QueryParam query, Pageable pageable){
        return new ResponseEntity<>(${changeClassName}Service.queryAll(query,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增${apiAlias}")
    @ApiOperation("新增${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:add')")
    public ResponseEntity create(@Validated @RequestBody ${className}Dto resources){
        return new ResponseEntity<>(${changeClassName}Service.insert(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改${apiAlias}")
    @ApiOperation("修改${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:edit')")
    public ResponseEntity update(@Validated @RequestBody ${className}Dto resources){
        ${changeClassName}Service.updateById(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除${apiAlias}")
    @ApiOperation("删除${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:del')")
    public ResponseEntity delete(@RequestBody Set<${pkColumnType}> ids) {
        ${changeClassName}Service.removeByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    @Log("导出${apiAlias}")
    @ApiOperation("导出${apiAlias}")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('${changeClassName}:list')")
    public void download(HttpServletResponse response, ${className}QueryParam query) throws IOException {
        ${changeClassName}Service.download(${changeClassName}Service.queryAll(query), response);
    }*/

}
