package com.gitee.coadmin.modules.trace.service.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.trace.domain.TraceCma;
import com.gitee.coadmin.modules.trace.service.dto.TraceCmaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author jinjin
 * @since 2022-01-04
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TraceCmaConverter {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    TraceCma toEntity(TraceCmaDTO dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    TraceCmaDTO toDto(TraceCma entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<TraceCma> toEntity(List<TraceCmaDTO> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <TraceCmaDTO> toDto(List<TraceCma> entityList);

    default PageInfo<TraceCmaDTO> convertPage(IPage<TraceCma> page) {
        if (page == null) {
            return null;
        }
        PageInfo<TraceCmaDTO> pageInfo = new PageInfo<>();
        pageInfo.setTotalElements(page.getTotal());
        pageInfo.setContent(toDto(page.getRecords()));
        return pageInfo;
    }
}
