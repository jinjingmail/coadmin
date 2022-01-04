package com.gitee.coadmin.modules.trace.service.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.trace.domain.TracePatient;
import com.gitee.coadmin.modules.trace.service.dto.TracePatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author jinjin
 * @since 2022-01-04
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TracePatientConverter {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    TracePatient toEntity(TracePatientDTO dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    TracePatientDTO toDto(TracePatient entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<TracePatient> toEntity(List<TracePatientDTO> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <TracePatientDTO> toDto(List<TracePatient> entityList);

    default PageInfo<TracePatientDTO> convertPage(IPage<TracePatient> page) {
        if (page == null) {
            return null;
        }
        PageInfo<TracePatientDTO> pageInfo = new PageInfo<>();
        pageInfo.setTotalElements(page.getTotal());
        pageInfo.setContent(toDto(page.getRecords()));
        return pageInfo;
    }
}
