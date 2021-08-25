package com.gitee.coadmin.modules.test.service.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.test.domain.TestPerson;
import com.gitee.coadmin.modules.test.service.dto.TestPersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author jinjin
 * @since 2021-08-22
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestPersonConverter {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    TestPerson toEntity(TestPersonDTO dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    TestPersonDTO toDto(TestPerson entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<TestPerson> toEntity(List<TestPersonDTO> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <TestPersonDTO> toDto(List<TestPerson> entityList);

    default PageInfo<TestPersonDTO> convertPage(IPage<TestPerson> page) {
        if (page == null) {
            return null;
        }
        PageInfo<TestPersonDTO> pageInfo = new PageInfo<>();
        pageInfo.setTotalElements(page.getTotal());
        pageInfo.setContent(toDto(page.getRecords()));
        return pageInfo;
    }
}
