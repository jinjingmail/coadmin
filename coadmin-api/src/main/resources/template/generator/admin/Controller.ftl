package ${package}.rest;

import com.gitee.coadmin.annotation.UnifiedAPI;
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
import java.util.Set;

/*  添加菜单的 SQL
<#if hasMenuPid>
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (${menuPid}, 4, 1, '${apiAlias}', '${apiAliasLetter}', '${className}', '${subModuleName}/${minusClassName}/index', 10, '${minusClassName}', 0, 0, 0, '');
SELECT @lastId:=LAST_INSERT_ID();
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '查看${apiAlias}', 10, 0, 0, 0, '${changeClassName}:list');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '新增${apiAlias}', 20, 0, 0, 0, '${changeClassName}:add');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '修改${apiAlias}', 30, 0, 0, 0, '${changeClassName}:edit');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '删除${apiAlias}', 40, 0, 0, 0, '${changeClassName}:del');
<#else>
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (null, 4, 1, '${apiAlias}', '${apiAliasLetter}', '${className}', '${subModuleName}/${minusClassName}/index', 10, '${minusClassName}', 0, 0, 0, '${changeClassName}:list');
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
        return ${changeClassName}Service.queryAll(query,pageable);
    }

    @PostMapping
    @Log(value = "新增${apiAlias}", type = LogActionType.ADD)
    @ApiOperation("新增${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:add')")
    public Integer create(@Validated @RequestBody ${className}DTO res){
        return ${changeClassName}Service.insert(res);
    }

    @PutMapping
    @Log(value = "修改${apiAlias}", type = LogActionType.UPDATE)
    @ApiOperation("修改${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:edit')")
    public Integer update(@Validated @RequestBody ${className}DTO res){
        return ${changeClassName}Service.updateById(res);
    }

    @DeleteMapping
    @Log(value = "删除${apiAlias}", type = LogActionType.DELETE)
    @ApiOperation("删除${apiAlias}")
    @PreAuthorize("@el.check('${changeClassName}:del')")
    public Integer delete(@RequestBody Set<${pkColumnType}> ids) {
        return ${changeClassName}Service.removeByIds(ids);
    }

    @Log("导出${apiAlias}")
    @ApiOperation("导出${apiAlias}")
    @UnifiedAPI(enable = false)
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('${changeClassName}:list')")
    public void download(HttpServletResponse response, UserQueryParam criteria) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("导出${apiAlias}", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ${className}DTO.class)
            .sheet("${apiAlias}")
            .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
            .doWrite(${className}Service.queryAll(criteria));
    }
}
