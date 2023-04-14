package com.gitee.coadmin.modules.trace.rest;

import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.exception.CoException;
import com.gitee.coadmin.utils.ExcelUtils;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.logging.annotation.type.LogActionType;
import com.gitee.coadmin.modules.trace.service.TraceCsService;
import com.gitee.coadmin.modules.trace.service.dto.TraceCsDTO;
import com.gitee.coadmin.modules.trace.service.dto.TraceCsQueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.springframework.web.multipart.MultipartFile;

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
@Api(tags = "染色体核型结果")
@RequestMapping("/api/trace/trace-cs")
public class TraceCsController {

    private final TraceCsService traceCsService;

    @GetMapping
    @Log("查询染色体核型结果")
    @ApiOperation("查询染色体核型结果")
    @PreAuthorize("@el.check('traceCs:list')")
    public PageInfo<TraceCsDTO> query(TraceCsQueryParam query, Pageable pageable){
        return traceCsService.queryAll(query,pageable);
    }

    @PostMapping
    @Log(value = "新增染色体核型结果", type = LogActionType.ADD)
    @ApiOperation("新增染色体核型结果")
    @PreAuthorize("@el.check('traceCs:add')")
    public Integer create(@Validated @RequestBody TraceCsDTO res){
        return traceCsService.insert(res);
    }

    @PutMapping
    @Log(value = "修改染色体核型结果", type = LogActionType.UPDATE)
    @ApiOperation("修改染色体核型结果")
    @PreAuthorize("@el.check('traceCs:edit')")
    public Integer update(@Validated @RequestBody TraceCsDTO res){
        return traceCsService.updateById(res);
    }

    @DeleteMapping
    @Log(value = "删除染色体核型结果", type = LogActionType.DELETE)
    @ApiOperation("删除染色体核型结果")
    @PreAuthorize("@el.check('traceCs:del')")
    public Integer delete(@RequestBody Set<Long> ids) {
        return traceCsService.removeByIds(ids);
    }

    @Log("导入染色体核型结果")
    @ApiOperation("导入染色体核型结果")
    @PostMapping(value = "/upload")
    @PreAuthorize("@el.check('traceCs:add')")
    public void upload(@RequestPart(value = "files") final MultipartFile[] uploadFiles) throws IOException {
        for (MultipartFile file: uploadFiles) {
            parseUploadFile(file);
        }
    }

    private void parseUploadFile(MultipartFile file) throws IOException {
        List<TraceCsDTO> dtos = ExcelUtils.importExcel(file, 0, 1, TraceCsDTO.class, 1,
                new String[] {"姓名", "登记号", "标本类型", "诊断", "染色体核型结果", "早筛报告时间"});
        for (TraceCsDTO dto: dtos) {
            traceCsService.upload(dto);
        }
    }

    @Log("导出染色体核型结果")
    @ApiOperation("导出染色体核型结果")
    @UnifiedAPI(enable = false)
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('traceCs:down')")
    public void download(TraceCsQueryParam criteria, HttpServletResponse response) {
        try {
            List<TraceCsDTO> dtos = traceCsService.queryAll(criteria);
            ExcelUtils.exportExcel(dtos, null, "导出染色体核型结果", TraceCsDTO.class, "", response);
        } catch (IOException e) {
            throw new CoException("导出失败");
        }
    }
}
