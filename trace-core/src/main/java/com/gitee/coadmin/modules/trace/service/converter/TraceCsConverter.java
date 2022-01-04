package com.gitee.coadmin.modules.trace.service.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.trace.domain.TraceCs;
import com.gitee.coadmin.modules.trace.service.dto.TraceCsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author jinjin
 * @since 2022-01-04
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TraceCsConverter {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    TraceCs toEntity(TraceCsDTO dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    TraceCsDTO toDto(TraceCs entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<TraceCs> toEntity(List<TraceCsDTO> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <TraceCsDTO> toDto(List<TraceCs> entityList);

    default PageInfo<TraceCsDTO> convertPage(IPage<TraceCs> page) {
        if (page == null) {
            return null;
        }
        PageInfo<TraceCsDTO> pageInfo = new PageInfo<>();
        pageInfo.setTotalElements(page.getTotal());
        pageInfo.setContent(toDto(page.getRecords()));
        return pageInfo;
    }
}
