package com.gitee.coadmin.modules.trace.service.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.trace.domain.TraceNipt;
import com.gitee.coadmin.modules.trace.service.dto.TraceNiptDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author jinjin
 * @since 2022-01-04
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TraceNiptConverter {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    TraceNipt toEntity(TraceNiptDTO dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    TraceNiptDTO toDto(TraceNipt entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<TraceNipt> toEntity(List<TraceNiptDTO> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <TraceNiptDTO> toDto(List<TraceNipt> entityList);

    default PageInfo<TraceNiptDTO> convertPage(IPage<TraceNipt> page) {
        if (page == null) {
            return null;
        }
        PageInfo<TraceNiptDTO> pageInfo = new PageInfo<>();
        pageInfo.setTotalElements(page.getTotal());
        pageInfo.setContent(toDto(page.getRecords()));
        return pageInfo;
    }
}
