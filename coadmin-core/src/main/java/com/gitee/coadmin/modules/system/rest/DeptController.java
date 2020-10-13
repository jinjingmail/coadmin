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

import com.gitee.coadmin.annotation.AnonymousAccess;
import com.gitee.coadmin.modules.system.service.DeptService;
import com.gitee.coadmin.modules.system.service.dto.DeptCompactDto;
import com.gitee.coadmin.modules.tools.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.modules.system.domain.Dept;
import com.gitee.coadmin.modules.system.service.dto.DeptQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "系统：机构管理")
@RequestMapping("/api/dept")
public class DeptController {

    private final DeptService deptService;
    private static final String ENTITY_NAME = "dept";

    @Log("导出机构数据")
    @ApiOperation("导出机构数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('dept:list')")
    public void download(HttpServletResponse response, DeptQueryParam criteria) throws Exception {
        deptService.download(deptService.queryAll(criteria, false), response);
    }

    @Log("查询机构")
    @ApiOperation("查询机构")
    @GetMapping
    @PreAuthorize("@el.check('user:list','dept:list')")
    public ResponseEntity<Object> query(DeptQueryParam query) throws Exception {
        return new ResponseEntity<>(deptService.buildTree(query, SecurityUtils.getCurrentUserId()),HttpStatus.OK);
    }

    @Log("查询机构")
    @ApiOperation("查询机构:根据ID获取同级与上级数据")
    @PostMapping("/superior")
    @PreAuthorize("@el.check('user:list','dept:list')")
    public ResponseEntity<Object> getSuperior(@RequestBody LinkedHashSet<Long> ids) {
        return new ResponseEntity<>(deptService.buildTree(new DeptQueryParam(), SecurityUtils.getCurrentUserId()),HttpStatus.OK);
    }

    /**
     * 根据机构id列表，构建树
     * @param ids
     * @return
     */
    @GetMapping("/tree")
    //@PreAuthorize("@el.check('user:list','dept:list')")
    @AnonymousAccess
    public ResponseEntity<Object> tree(@RequestParam LinkedHashSet<Long> ids) {
        log.info("tree:{}", ids);
        return new ResponseEntity<>(deptService.buildTree(new DeptQueryParam(), SecurityUtils.getCurrentUserId()),HttpStatus.OK);
    }

    @Log("新增机构")
    @ApiOperation("新增机构")
    @PostMapping
    @PreAuthorize("@el.check('dept:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Dept resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        deptService.save(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改机构")
    @ApiOperation("修改机构")
    @PutMapping
    @PreAuthorize("@el.check('dept:edit')")
    public ResponseEntity<Object> update(@Validated(Dept.Update.class) @RequestBody DeptCompactDto resources){
        deptService.updateById(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除机构")
    @ApiOperation("删除机构")
    @DeleteMapping
    @PreAuthorize("@el.check('dept:del')")
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids){
        deptService.removeByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}