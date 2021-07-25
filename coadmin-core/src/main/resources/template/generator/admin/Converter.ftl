package ${package}.service.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.PageInfo;
import ${package}.domain.${className};
import ${package}.service.dto.${className}Dto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
* @author ${author}
* @date ${date}
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestPersonConverter {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    ${className} toEntity(${className}Dto dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    ${className}Dto toDto(${className} entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<${className}> toEntity(List<${className}Dto> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <${className}Dto> toDto(List<${className}> entityList);

    default PageInfo<${className}Dto> convertPage(IPage<${className}> page) {
        if (page == null) {
            return null;
        }
        PageInfo<${className}Dto> pageInfo = new PageInfo<>();
        pageInfo.setTotalElements(page.getTotal());
        pageInfo.setContent(toDto(page.getRecords()));
        return pageInfo;
    }
}
