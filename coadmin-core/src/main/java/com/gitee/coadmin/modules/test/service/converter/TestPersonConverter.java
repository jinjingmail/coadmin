package com.gitee.coadmin.modules.test.service.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.test.domain.TestPerson;
import com.gitee.coadmin.modules.test.service.dto.TestPersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
* @author jinjin
* @date 2021-07-25
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestPersonConverter {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    TestPerson toEntity(TestPersonDto dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    TestPersonDto toDto(TestPerson entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<TestPerson> toEntity(List<TestPersonDto> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <TestPersonDto> toDto(List<TestPerson> entityList);

    default PageInfo<TestPersonDto> convertPage(IPage<TestPerson> page) {
        if (page == null) {
            return null;
        }
        PageInfo<TestPersonDto> pageInfo = new PageInfo<>();
        pageInfo.setTotalElements(page.getTotal());
        pageInfo.setContent(toDto(page.getRecords()));
        return pageInfo;
    }
}
