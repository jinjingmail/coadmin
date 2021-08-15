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

import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.system.service.dto.DictDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.modules.system.domain.Dict;
import com.gitee.coadmin.modules.system.service.DictService;
import com.gitee.coadmin.modules.system.service.dto.DictQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@Api(tags = "系统：字典管理")
@RequestMapping("/api/dict")
public class DictController {

    private final DictService dictService;
    private static final String ENTITY_NAME = "dict";

    @Log("导出字典数据")
    @ApiOperation("导出字典数据")
    @UnifiedAPI(enable = false)
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('dict:list')")
    public void download(HttpServletResponse response, DictQueryParam criteria) throws IOException {
        dictService.download(dictService.queryAll(criteria), response);
    }

    @Log("查询字典")
    @ApiOperation("查询字典")
    @GetMapping(value = "all")
    @PreAuthorize("@el.check('dict:list')")
    public List<DictDto> queryAll(){
        return dictService.queryAll(new DictQueryParam());
    }

    @Log("查询字典")
    @ApiOperation("查询字典")
    @GetMapping
    @PreAuthorize("@el.check('dict:list')")
    public PageInfo<DictDto> query(DictQueryParam query, Pageable pageable){
        return dictService.queryAll(query,pageable);
    }

    @Log("新增字典")
    @ApiOperation("新增字典")
    @PostMapping
    @PreAuthorize("@el.check('dict:add')")
    public Integer create(@Validated @RequestBody Dict resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return dictService.save(resources)?1:0;
    }

    @Log("修改字典")
    @ApiOperation("修改字典")
    @PutMapping
    @PreAuthorize("@el.check('dict:edit')")
    public Integer update(@RequestBody Dict resources){
        return dictService.updateById(resources)?1:0;
    }

    @Log("删除字典")
    @ApiOperation("删除字典")
    @DeleteMapping
    @PreAuthorize("@el.check('dict:del')")
    public Integer delete(@RequestBody Set<Long> ids){
        return dictService.removeByIds(ids)?1:0;
    }
}