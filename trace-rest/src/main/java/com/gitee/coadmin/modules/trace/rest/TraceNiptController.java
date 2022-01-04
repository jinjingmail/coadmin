package com.gitee.coadmin.modules.trace.rest;

import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.exception.CoException;
import com.gitee.coadmin.utils.ExcelUtils;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.logging.annotation.type.LogActionType;
import com.gitee.coadmin.modules.trace.service.TraceNiptService;
import com.gitee.coadmin.modules.trace.service.dto.TraceNiptDTO;
import com.gitee.coadmin.modules.trace.service.dto.TraceNiptQueryParam;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;

/**
 * @author jinjin
 * @since 2022-01-04
 **/
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@Api(tags = "无创产前筛查")
@RequestMapping("/api/trace/trace-nipt")
public class TraceNiptController {

    private final TraceNiptService traceNiptService;

    @GetMapping
    @Log("查询无创产前筛查")
    @ApiOperation("查询无创产前筛查")
    @PreAuthorize("@el.check('traceNipt:list')")
    public PageInfo<TraceNiptDTO> query(TraceNiptQueryParam query, Pageable pageable){
        return traceNiptService.queryAll(query,pageable);
    }

    @PostMapping
    @Log(value = "新增无创产前筛查", type = LogActionType.ADD)
    @ApiOperation("新增无创产前筛查")
    @PreAuthorize("@el.check('traceNipt:add')")
    public Integer create(@Validated @RequestBody TraceNiptDTO res){
        return traceNiptService.insert(res);
    }

    @PutMapping
    @Log(value = "修改无创产前筛查", type = LogActionType.UPDATE)
    @ApiOperation("修改无创产前筛查")
    @PreAuthorize("@el.check('traceNipt:edit')")
    public Integer update(@Validated @RequestBody TraceNiptDTO res){
        return traceNiptService.updateById(res);
    }

    @DeleteMapping
    @Log(value = "删除无创产前筛查", type = LogActionType.DELETE)
    @ApiOperation("删除无创产前筛查")
    @PreAuthorize("@el.check('traceNipt:del')")
    public Integer delete(@RequestBody Set<Long> ids) {
        return traceNiptService.removeByIds(ids);
    }

    @Log("导入无创产前筛查")
    @ApiOperation("导入无创产前筛查")
    @PostMapping(value = "/upload")
    @PreAuthorize("@el.check('traceNipt:add')")
    public void upload(@RequestPart(value = "files") final MultipartFile[] uploadFiles) throws IOException {
        for (MultipartFile file: uploadFiles) {
            parseUploadFile(file);
        }
    }

    private void parseUploadFile(MultipartFile file) throws IOException {
        List<TraceNiptDTO> dtos = ExcelUtils.importExcel(file, TraceNiptDTO.class);
        for (TraceNiptDTO dto: dtos) {
            traceNiptService.upload(dto);
        }
    }

    @Log("导出无创产前筛查")
    @ApiOperation("导出无创产前筛查")
    @UnifiedAPI(enable = false)
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('traceNipt:down')")
    public void download(TraceNiptQueryParam criteria, HttpServletResponse response) {
        try {
            List<TraceNiptDTO> dtos = traceNiptService.queryAll(criteria);
            ExcelUtils.exportExcel(dtos, null, "导出无创产前筛查", TraceNiptDTO.class, "", response);
        } catch (IOException e) {
            throw new CoException("导出失败");
        }
    }
}
