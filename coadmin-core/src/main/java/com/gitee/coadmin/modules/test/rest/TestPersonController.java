package com.gitee.coadmin.modules.test.rest;

import com.gitee.coadmin.base.API;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.test.service.TestPersonService;
import com.gitee.coadmin.modules.test.service.dto.TestPersonDto;
import com.gitee.coadmin.modules.test.service.dto.TestPersonQueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.util.Set;

/*  添加菜单的 SQL
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (121, 4, 1, '演示', 'ys', 'TestPerson', 'testPerson/index', 10, 'testPerson', 0, 0, 0, 'testPerson:list');
SELECT @lastId:=LAST_INSERT_ID();
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '查看演示', 10, 0, 0, 0, 'testPerson:list');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '新增演示', 2, 0, 0, 0, 'testPerson:add');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '修改演示', 30, 0, 0, 0, 'testPerson:edit');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, i_frame, `cache`, hidden, permission)
    VALUES (@lastId, 0, 2, '删除演示', 40, 0, 0, 0, 'testPerson:del');
*/

/**
 * @author jinjin
 * @date 2021-07-25
 **/
@RestController
@RequiredArgsConstructor
@Api(tags = "演示")
@RequestMapping("/api/test-person")
public class TestPersonController {

    private final TestPersonService testPersonService;

    @GetMapping
    @Log("查询演示")
    @ApiOperation("查询演示")
    @PreAuthorize("@el.check('testPerson:list')")
    public ResponseEntity<API<PageInfo<TestPersonDto>>> query(TestPersonQueryParam query, Pageable pageable){
        return API.ok(testPersonService.queryAll(query,pageable)).responseEntity();
    }

    @PostMapping
    @Log("新增演示")
    @ApiOperation("新增演示")
    @PreAuthorize("@el.check('testPerson:add')")
    public ResponseEntity<API<Integer>> create(@Validated @RequestBody TestPersonDto resources){
        return API.created(testPersonService.insert(resources)).responseEntity();
    }

    @PutMapping
    @Log("修改演示")
    @ApiOperation("修改演示")
    @PreAuthorize("@el.check('testPerson:edit')")
    public ResponseEntity<API<Integer>> update(@Validated @RequestBody TestPersonDto resources){
        return API.updated(testPersonService.updateById(resources)).responseEntity();
    }

    @DeleteMapping
    @Log("删除演示")
    @ApiOperation("删除演示")
    @PreAuthorize("@el.check('testPerson:del')")
    public ResponseEntity<API<Integer>> delete(@RequestBody Set<Long> ids) {
        return API.deleted(testPersonService.removeByIds(ids)).responseEntity();
    }
}
