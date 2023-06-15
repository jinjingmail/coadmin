package ${package}.rest;

import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.exception.CoException;
import com.gitee.coadmin.utils.ExcelUtils;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.logging.annotation.type.LogActionType;
import ${package}.service.${className}Service;
import ${package}.service.dto.${className}DTO;
import ${package}.service.dto.${className}QueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/*  添加菜单的 SQL
<#if hasMenuPid>
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (${menuPid}, 4, 1, '${apiAlias}', '${apiAliasLetter}', '${className}', '${subModuleName}/${minusClassName}/index', 10, '${minusClassName}', 0, 0, 0, '${changeClassName}:list');
<#else>
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (null, 4, 1, '${apiAlias}', '${apiAliasLetter}', '${className}', '${subModuleName}/${minusClassName}/index', 10, '${minusClassName}', 0, 0, 0, '${changeClassName}:list');
</#if>
SELECT @lastId:=LAST_INSERT_ID();
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '查看${apiAlias}', 10, 0, 0, 0, '${changeClassName}:list');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '新增${apiAlias}', 20, 0, 0, 0, '${changeClassName}:add');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '修改${apiAlias}', 30, 0, 0, 0, '${changeClassName}:edit');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '删除${apiAlias}', 40, 0, 0, 0, '${changeClassName}:del');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '导出${apiAlias}', 40, 0, 0, 0, '${changeClassName}:down');
*/

/**
 * @author ${author}
 * @since ${date}
 **/
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@Api(tags = "${apiAlias}")
@RequestMapping("/api/${subModuleName}/${minusClassName}")
public class ${className}Controller {

    private final ${className}Service ${changeClassName}Service;

    @GetMapping
    @Log("查询${apiAlias}")
    @ApiOperation("查询${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:list')")
    public PageInfo<${className}DTO> query(${className}QueryParam query, Pageable pageable){
        return ${changeClassName}Service.pageByParam(query,pageable);
    }

    @PostMapping
    @Log(value = "新增${apiAlias}", type = LogActionType.ADD)
    @ApiOperation("新增${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:add')")
    public void create(@Validated @RequestBody ${className}DTO res){
        ${changeClassName}Service.insert(res);
    }

    @PutMapping
    @Log(value = "修改${apiAlias}", type = LogActionType.UPDATE)
    @ApiOperation("修改${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:edit')")
    public void update(@Validated @RequestBody ${className}DTO res){
        ${changeClassName}Service.updateById(res);
    }

    @DeleteMapping
    @Log(value = "删除${apiAlias}", type = LogActionType.DELETE)
    @ApiOperation("删除${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:del')")
    public void delete(@RequestBody Set<${pkColumnType}> ids) {
        ${changeClassName}Service.removeByIds(ids);
    }

    @Log("导出${apiAlias}")
    @ApiOperation("导出${apiAlias}")
    @UnifiedAPI(enable = false)
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('${changeClassName}:down')")
    public void download(${className}QueryParam criteria, HttpServletResponse response) {
        try {
            List<${className}DTO> dtos = ${changeClassName}Service.listByParam(criteria);
            ExcelUtils.exportExcel(dtos, null, "导出${apiAlias}", ${className}DTO.class, "", response);
        } catch (IOException e) {
            throw new CoException("导出失败");
        }
    }
}
