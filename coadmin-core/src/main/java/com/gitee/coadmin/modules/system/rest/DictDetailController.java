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
import com.gitee.coadmin.base.API;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.system.service.DictService;
import com.gitee.coadmin.modules.system.service.dto.DictDto;
import com.gitee.coadmin.modules.system.service.dto.DictQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.modules.system.service.DictDetailService;
import com.gitee.coadmin.modules.system.service.dto.DictDetailDto;
import com.gitee.coadmin.modules.system.service.dto.DictDetailQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<API<PageInfo<DictDetailDto>>> query(DictDetailQueryParam query,
                                                              @PageableDefault(sort = {"dictSort"}, direction = Sort.Direction.ASC) Pageable pageable){
        if (StrUtil.isBlank(query.getDictName())) {
            if (query.getDictId() == null) {
                throw new BadRequestException("请指定Dict.id");
            }
            return API.ok(dictDetailService.queryAll(query, pageable)).responseEntity();
        } else {
            if (query.getDictId() != null) {
                return API.ok(dictDetailService.queryAll(query, pageable)).responseEntity();
            }
            return API.ok(dictDetailService.getDictByName(query.getDictName(), pageable)).responseEntity();
        }
    }

    @Log("查询多个字典详情")
    @ApiOperation("查询多个字典详情")
    @GetMapping(value = "/map")
    public ResponseEntity<API<Map<String, List<DictDetailDto>>>> getDictDetailMaps(@RequestParam String dictNames){
        String[] names = dictNames.split("[,，]");
        Map<String, List<DictDetailDto>> dictMap = new HashMap<>(5);
        for (String name : names) {
            dictMap.put(name, dictDetailService.getDictByName(name));
        }
        return API.ok(dictMap).responseEntity();
    }

    @Log("查询所有字典详情")
    @ApiOperation("查询所有字典详情")
    @GetMapping(value = "/map/all")
    public ResponseEntity<API<Map<String, List<DictDetailDto>>>> getDictDetailMapsAll(){
        Map<String, List<DictDetailDto>> dictMap = new HashMap<>(5);
        List<DictDto> dictAll = dictService.queryAll(new DictQueryParam());
        for (DictDto dict : dictAll) {
            dictMap.put(dict.getName(), dictDetailService.getDictByName(dict.getName()));
        }
        return API.ok(dictMap).responseEntity();
    }

    @Log("新增字典详情")
    @ApiOperation("新增字典详情")
    @PostMapping
    @PreAuthorize("@el.check('dict:add')")
    public ResponseEntity<API<Integer>> create(@Validated @RequestBody DictDetailDto resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        if (resources.getDict() == null || resources.getDict().getId() == null) {
            throw new BadRequestException("请指定Dict.id");
        }
        return API.created(dictDetailService.save(resources)?1:0).responseEntity();
    }

    @Log("修改字典详情")
    @ApiOperation("修改字典详情")
    @PutMapping
    @PreAuthorize("@el.check('dict:edit')")
    public ResponseEntity<API<Integer>> update(@RequestBody DictDetailDto resources){
        return API.updated(dictDetailService.updateById(resources)?1:0).responseEntity();
    }

    @Log("删除字典详情")
    @ApiOperation("删除字典详情")
    @DeleteMapping
    @PreAuthorize("@el.check('dict:del')")
    public ResponseEntity<API<Integer>> delete(@RequestBody Set<Long> ids){
        return API.deleted(dictDetailService.removeByIds(ids)?1:0).responseEntity();
    }
}