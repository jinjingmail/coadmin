/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.gitee.coadmin.modules.system.rest;

import cn.hutool.core.util.StrUtil;
import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.type.LogActionType;
import com.gitee.coadmin.modules.system.service.DictService;
import com.gitee.coadmin.modules.system.service.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.modules.system.service.DictDetailService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@Api(tags = "系统：字典详情管理")
@RequestMapping("/api/dictDetail")
public class DictDetailController {

    private final DictDetailService dictDetailService;
    private final DictService dictService;
    private static final String ENTITY_NAME = "dictDetail";

    @Log("查询字典详情")
    @ApiOperation("查询字典详情")
    @GetMapping
    public PageInfo<DictDetailDto> query(DictDetailQueryParam query,
                                                              @PageableDefault(sort = {"dictSort"}, direction = Sort.Direction.ASC) Pageable pageable){
        if (StrUtil.isBlank(query.getDictName())) {
            if (query.getDictId() == null) {
                throw new BadRequestException("请指定Dict.id");
            }
            return dictDetailService.queryAll(query, pageable);
        } else {
            if (query.getDictId() != null) {
                return dictDetailService.queryAll(query, pageable);
            }
            return dictDetailService.getDictByName(query.getDictName(), pageable);
        }
    }

    @Log("查询多个字典详情")
    @ApiOperation("查询多个字典详情")
    @GetMapping(value = "/map")
    public Map<String, List<DictDetailSmallDto>> getDictDetailMaps(@RequestParam String dictNames){
        String[] names = dictNames.split("[,，]");
        Map<String, List<DictDetailSmallDto>> dictMap = new HashMap<>(5);
        for (String name : names) {
            dictMap.put(name, dictDetailService.getDictByName(name));
        }
        return dictMap;
    }

    @Log("查询所有字典详情")
    @ApiOperation("查询所有字典详情")
    @GetMapping(value = "/map/all")
    public Map<String, List<DictDetailSmallDto>> getDictDetailMapsAll(){
        Map<String, List<DictDetailSmallDto>> dictMap = new HashMap<>(5);
        List<DictDto> dictAll = dictService.queryAll(new DictQueryParam());
        for (DictDto dict : dictAll) {
            dictMap.put(dict.getName(), dictDetailService.getDictByName(dict.getName()));
        }
        return dictMap;
    }

    @Log(value = "新增字典详情", type = LogActionType.ADD)
    @ApiOperation("新增字典详情")
    @PostMapping
    @PreAuthorize("@el.check('dict:add')")
    public Integer create(@Validated @RequestBody DictDetailDto resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        if (resources.getDictId() == null) {
            throw new BadRequestException("请指定Dict.id");
        }
        return dictDetailService.save(resources)?1:0;
    }

    @Log(value = "修改字典详情", type = LogActionType.UPDATE)
    @ApiOperation("修改字典详情")
    @PutMapping
    @PreAuthorize("@el.check('dict:edit')")
    public Integer update(@RequestBody DictDetailDto resources){
        return dictDetailService.updateById(resources)?1:0;
    }

    @Log(value = "删除字典详情", type = LogActionType.DELETE)
    @ApiOperation("删除字典详情")
    @DeleteMapping
    @PreAuthorize("@el.check('dict:del')")
    public Integer delete(@RequestBody Set<Long> ids){
        return dictDetailService.removeByIds(ids)?1:0;
    }
}