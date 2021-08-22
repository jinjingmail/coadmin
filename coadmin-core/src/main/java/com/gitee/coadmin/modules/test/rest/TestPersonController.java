package com.gitee.coadmin.modules.test.rest;

import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.test.service.TestPersonService;
import com.gitee.coadmin.modules.test.service.dto.TestPersonDTO;
import com.gitee.coadmin.modules.test.service.dto.TestPersonQueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.util.Set;

/*  添加菜单的 SQL
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (121, 4, 1, '演示', 'ys', 'TestPerson', 'test/test-person/index', 10, 'test-person', 0, 0, 0, '');
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
 * @since 2021-08-22
 **/
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@Api(tags = "演示")
@RequestMapping("/api/test/test-person")
public class TestPersonController {

    private final TestPersonService testPersonService;

    @GetMapping
    @Log("查询演示")
    @ApiOperation("查询演示")
    @PreAuthorize("@el.check('testPerson:list')")
    public PageInfo<TestPersonDTO> query(TestPersonQueryParam query, Pageable pageable){
        return testPersonService.queryAll(query,pageable);
    }

    @PostMapping
    @Log("新增演示")
    @ApiOperation("新增演示")
    @PreAuthorize("@el.check('testPerson:add')")
    public Integer create(@Validated @RequestBody TestPersonDTO resources){
        return testPersonService.insert(resources);
    }

    @PutMapping
    @Log("修改演示")
    @ApiOperation("修改演示")
    @PreAuthorize("@el.check('testPerson:edit')")
    public Integer update(@Validated @RequestBody TestPersonDTO resources){
        return testPersonService.updateById(resources);
    }

    @DeleteMapping
    @Log("删除演示")
    @ApiOperation("删除演示")
    @PreAuthorize("@el.check('testPerson:del')")
    public Integer delete(@RequestBody Set<Long> ids) {
        return testPersonService.removeByIds(ids);
    }
}
