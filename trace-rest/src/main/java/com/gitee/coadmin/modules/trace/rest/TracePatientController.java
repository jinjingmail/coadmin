package com.gitee.coadmin.modules.trace.rest;

import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.exception.CoException;
import com.gitee.coadmin.utils.ExcelUtils;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.logging.annotation.type.LogActionType;
import com.gitee.coadmin.modules.trace.service.TracePatientService;
import com.gitee.coadmin.modules.trace.service.dto.TracePatientDTO;
import com.gitee.coadmin.modules.trace.service.dto.TracePatientQueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author jinjin
 * @since 2022-01-04
 **/
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@Api(tags = "就诊人")
@RequestMapping("/api/trace/trace-patient")
public class TracePatientController {

    private final TracePatientService tracePatientService;

    @GetMapping
    @Log("查询就诊人")
    @ApiOperation("查询就诊人")
    @PreAuthorize("@el.check('tracePatient:list')")
    public PageInfo<TracePatientDTO> query(TracePatientQueryParam query, Pageable pageable){
        return tracePatientService.queryAll(query,pageable);
    }

    @PostMapping
    @Log(value = "新增就诊人", type = LogActionType.ADD)
    @ApiOperation("新增就诊人")
    @PreAuthorize("@el.check('tracePatient:add')")
    public Integer create(@Validated @RequestBody TracePatientDTO res){
        return tracePatientService.insert(res);
    }

    @PutMapping
    @Log(value = "修改就诊人", type = LogActionType.UPDATE)
    @ApiOperation("修改就诊人")
    @PreAuthorize("@el.check('tracePatient:edit')")
    public Integer update(@Validated @RequestBody TracePatientDTO res){
        return tracePatientService.updateById(res);
    }

    @DeleteMapping
    @Log(value = "删除就诊人", type = LogActionType.DELETE)
    @ApiOperation("删除就诊人")
    @PreAuthorize("@el.check('tracePatient:del')")
    public Integer delete(@RequestBody Set<Long> ids) {
        return tracePatientService.removeByIds(ids);
    }

    @Log("导出就诊人")
    @ApiOperation("导出就诊人")
    @UnifiedAPI(enable = false)
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('tracePatient:down')")
    public void download(TracePatientQueryParam criteria, HttpServletResponse response) {
        try {
            List<TracePatientDTO> dtos = tracePatientService.queryAll(criteria);
            ExcelUtils.exportExcel(dtos, null, "导出就诊人", TracePatientDTO.class, "", response);
        } catch (IOException e) {
            throw new CoException("导出失败");
        }
    }
}
