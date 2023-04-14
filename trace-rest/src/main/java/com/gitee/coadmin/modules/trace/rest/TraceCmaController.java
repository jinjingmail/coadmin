package com.gitee.coadmin.modules.trace.rest;

import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.exception.CoException;
import com.gitee.coadmin.utils.ExcelUtils;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.logging.annotation.type.LogActionType;
import com.gitee.coadmin.modules.trace.service.TraceCmaService;
import com.gitee.coadmin.modules.trace.service.dto.TraceCmaDTO;
import com.gitee.coadmin.modules.trace.service.dto.TraceCmaQueryParam;
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
@Api(tags = "染色体微整列分析")
@RequestMapping("/api/trace/trace-cma")
public class TraceCmaController {

    private final TraceCmaService traceCmaService;

    @GetMapping
    @Log("查询染色体微整列分析")
    @ApiOperation("查询染色体微整列分析")
    @PreAuthorize("@el.check('traceCma:list')")
    public PageInfo<TraceCmaDTO> query(TraceCmaQueryParam query, Pageable pageable){
        return traceCmaService.queryAll(query,pageable);
    }

    @PostMapping
    @Log(value = "新增染色体微整列分析", type = LogActionType.ADD)
    @ApiOperation("新增染色体微整列分析")
    @PreAuthorize("@el.check('traceCma:add')")
    public Integer create(@Validated @RequestBody TraceCmaDTO res){
        return traceCmaService.insert(res);
    }

    @PutMapping
    @Log(value = "修改染色体微整列分析", type = LogActionType.UPDATE)
    @ApiOperation("修改染色体微整列分析")
    @PreAuthorize("@el.check('traceCma:edit')")
    public Integer update(@Validated @RequestBody TraceCmaDTO res){
        return traceCmaService.updateById(res);
    }

    @DeleteMapping
    @Log(value = "删除染色体微整列分析", type = LogActionType.DELETE)
    @ApiOperation("删除染色体微整列分析")
    @PreAuthorize("@el.check('traceCma:del')")
    public Integer delete(@RequestBody Set<Long> ids) {
        return traceCmaService.removeByIds(ids);
    }

    @Log("导入染色体微整列分析")
    @ApiOperation("导入染色体微整列分析")
    @PostMapping(value = "/upload")
    @PreAuthorize("@el.check('traceCma:add')")
    public void upload(@RequestPart(value = "files") final MultipartFile[] uploadFiles) throws IOException {
        for (MultipartFile file: uploadFiles) {
            parseUploadFile(file);
        }
    }

    private void parseUploadFile(MultipartFile file) throws IOException {
        List<TraceCmaDTO> dtos = ExcelUtils.importExcel(file, 0, 1, TraceCmaDTO.class, 3,
                new String[] {"姓名", "登记号", "标本类型", "诊断", "芯片ID", "染色体区域"});
        for (TraceCmaDTO dto: dtos) {
            traceCmaService.upload(dto);
        }
    }

    @Log("导出染色体微整列分析")
    @ApiOperation("导出染色体微整列分析")
    @UnifiedAPI(enable = false)
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('traceCma:down')")
    public void download(TraceCmaQueryParam criteria, HttpServletResponse response) {
        try {
            List<TraceCmaDTO> dtos = traceCmaService.queryAll(criteria);
            ExcelUtils.exportExcel(dtos, null, "导出染色体微整列分析", TraceCmaDTO.class, "", response);
        } catch (IOException e) {
            throw new CoException("导出失败");
        }
    }
}
