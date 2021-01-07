package com.gitee.coadmin.modules.test.rest;

import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.test.domain.TestPerson;
import com.gitee.coadmin.modules.test.service.TestPersonService;
import com.gitee.coadmin.modules.test.service.dto.TestPersonDto;
import com.gitee.coadmin.modules.test.service.dto.TestPersonQueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.util.Set;

/*  添加菜单的 SQL
INSERT INTO sys_menu(pid, sub_count, `type`, title, title_letter, component_name, `component`, sort, `path`, i_frame, `cache`, hidden, permission)
    VALUES (121, 4, 1, '演示管理', 'ysgl', 'TestPerson', 'testPerson/index', 10, 'testPerson', 0, 1, 0, 'testPerson:list');
SELECT @lastId:=LAST_INSERT_ID();
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, permission)
    VALUES (@lastId, 0, 2, '演示查看', 10, 'testPerson:view');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, permission)
    VALUES (@lastId, 0, 2, '演示新增', 10, 'testPerson:add');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, permission)
    VALUES (@lastId, 0, 2, '演示修改', 10, 'testPerson:edit');
INSERT INTO sys_menu(pid, sub_count, `type`, title, sort, permission)
    VALUES (@lastId, 0, 2, '演示删除', 10, 'testPerson:del');
*/

/**
* @author jinjin
* @date 2021-01-07
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "演示管理")
@RequestMapping("/api/testPerson")
public class TestPersonController {

    private final TestPersonService testPersonService;

    @GetMapping
    @Log("查询演示")
    @ApiOperation("查询演示")
    @PreAuthorize("@el.check('testPerson:list', 'testPerson:view')")
    public ResponseEntity query(TestPersonQueryParam query, Pageable pageable){
        return new ResponseEntity<>(testPersonService.queryAll(query,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增演示")
    @ApiOperation("新增演示")
    @PreAuthorize("@el.check('testPerson:add')")
    public ResponseEntity create(@Validated @RequestBody TestPersonDto resources){
        return new ResponseEntity<>(testPersonService.insert(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改演示")
    @ApiOperation("修改演示")
    @PreAuthorize("@el.check('testPerson:edit')")
    public ResponseEntity update(@Validated @RequestBody TestPersonDto resources){
        testPersonService.updateById(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Log("删除演示")
    @ApiOperation("删除演示")
    @PreAuthorize("@el.check('testPerson:del')")
    public ResponseEntity delete(@RequestBody Set<Long> ids) {
        testPersonService.removeByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    @Log("导出演示")
    @ApiOperation("导出演示")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('testPerson:list')")
    public void download(HttpServletResponse response, TestPersonQueryParam query) throws IOException {
        testPersonService.download(testPersonService.queryAll(query), response);
    }*/

}
