package com.gitee.app.service.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.app.domain.AppUser;
import com.gitee.app.service.dto.AppUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author jinjin
 * @since 2021-09-20
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppUserConverter {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    AppUser toEntity(AppUserDTO dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    AppUserDTO toDto(AppUser entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<AppUser> toEntity(List<AppUserDTO> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <AppUserDTO> toDto(List<AppUser> entityList);

    default PageInfo<AppUserDTO> convertPage(IPage<AppUser> page) {
        if (page == null) {
            return null;
        }
        PageInfo<AppUserDTO> pageInfo = new PageInfo<>();
        pageInfo.setTotalElements(page.getTotal());
        pageInfo.setContent(toDto(page.getRecords()));
        return pageInfo;
    }
}
