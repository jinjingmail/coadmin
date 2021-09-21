package com.gitee.app.rest;

import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.logging.annotation.type.LogActionType;
import com.gitee.app.service.AppUserService;
import com.gitee.app.service.dto.AppUserDTO;
import com.gitee.app.service.dto.AppUserQueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.util.Set;

/*  添加菜单的 SQL
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (175, 4, 1, 'APP用户', 'APPyh', 'AppUser', 'app/app-user/index', 10, 'app-user', 0, 0, 0, '');
SELECT @lastId:=LAST_INSERT_ID();
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '查看APP用户', 10, 0, 0, 0, 'appUser:list');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '新增APP用户', 20, 0, 0, 0, 'appUser:add');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '修改APP用户', 30, 0, 0, 0, 'appUser:edit');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '删除APP用户', 40, 0, 0, 0, 'appUser:del');
*/

/**
 * @author jinjin
 * @since 2021-09-20
 **/
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@Api(tags = "APP用户")
@RequestMapping("/api/app/app-user")
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping
    @Log("查询APP用户")
    @ApiOperation("查询APP用户")
    @PreAuthorize("@el.check('appUser:list')")
    public PageInfo<AppUserDTO> query(AppUserQueryParam query, Pageable pageable){
        return appUserService.queryAll(query,pageable);
    }

    @PostMapping
    @Log(value = "新增APP用户", type = LogActionType.ADD)
    @ApiOperation("新增APP用户")
    @PreAuthorize("@el.check('appUser:add')")
    public Integer create(@Validated @RequestBody AppUserDTO resources){
        return appUserService.insert(resources);
    }

    @PutMapping
    @Log(value = "修改APP用户", type = LogActionType.UPDATE)
    @ApiOperation("修改APP用户")
    @PreAuthorize("@el.check('appUser:edit')")
    public Integer update(@Validated @RequestBody AppUserDTO resources){
        return appUserService.updateById(resources);
    }

    @DeleteMapping
    @Log(value = "删除APP用户", type = LogActionType.DELETE)
    @ApiOperation("删除APP用户")
    @PreAuthorize("@el.check('appUser:del')")
    public Integer delete(@RequestBody Set<Long> ids) {
        return appUserService.removeByIds(ids);
    }
}
