package com.gitee.coadmin.modules.system.rest;

import com.gitee.coadmin.annotation.AnonymousAccess;
import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.logging.annotation.type.LogActionType;
import com.gitee.coadmin.modules.system.service.SettingService;
import com.gitee.coadmin.modules.system.service.dto.SettingDTO;
import com.gitee.coadmin.modules.system.service.dto.SettingQueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.util.Set;


/**
 * @author jinjin
 * @since 2021-09-19
 **/
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@Api(tags = "系统参数")
@RequestMapping("/api/setting")
public class SettingController {

    private final SettingService settingService;

    @GetMapping
    @Log("查询系统参数")
    @ApiOperation("查询系统参数")
    @PreAuthorize("@el.check('setting:list')")
    public PageInfo<SettingDTO> query(SettingQueryParam query, Pageable pageable){
        return settingService.queryAll(query,pageable);
    }

    @GetMapping("/key-map/{keyName}")
    @PreAuthorize("@el.check('setting:list')")
    public SettingDTO getByKey(@PathVariable String keyName){
        return settingService.getByKey(keyName);
    }

    @GetMapping("/key-value/{keyName}")
    @PreAuthorize("@el.check('setting:list')")
    public String getValueByKey(@PathVariable String keyName){
        return settingService.getValueByKey(keyName);
    }

    @PostMapping
    @Log(value = "新增系统参数", type = LogActionType.ADD)
    @ApiOperation("新增系统参数")
    @PreAuthorize("@el.check('setting:add')")
    public Integer create(@Validated @RequestBody SettingDTO resources){
        return settingService.insert(resources);
    }

    @PutMapping
    @Log(value = "修改系统参数", type = LogActionType.UPDATE)
    @ApiOperation("修改系统参数")
    @PreAuthorize("@el.check('setting:edit')")
    public Integer update(@Validated @RequestBody SettingDTO resources){
        return settingService.updateById(resources);
    }

    @DeleteMapping
    @Log(value = "删除系统参数", type = LogActionType.DELETE)
    @ApiOperation("删除系统参数")
    @PreAuthorize("@el.check('setting:del')")
    public Integer delete(@RequestBody Set<Long> ids) {
        return settingService.removeByIds(ids);
    }
}
