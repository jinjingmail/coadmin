package com.gitee.coadmin.modules.system.service.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.system.domain.Setting;
import com.gitee.coadmin.modules.system.service.dto.SettingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author jinjin
 * @since 2021-09-19
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SettingConverter {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    Setting toEntity(SettingDTO dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    SettingDTO toDto(Setting entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<Setting> toEntity(List<SettingDTO> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <SettingDTO> toDto(List<Setting> entityList);

    default PageInfo<SettingDTO> convertPage(IPage<Setting> page) {
        if (page == null) {
            return null;
        }
        PageInfo<SettingDTO> pageInfo = new PageInfo<>();
        pageInfo.setTotalElements(page.getTotal());
        pageInfo.setContent(toDto(page.getRecords()));
        return pageInfo;
    }
}
