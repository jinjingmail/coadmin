package ${package}.service.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.PageInfo;
import ${package}.domain.${className};
import ${package}.service.dto.${className}DTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author ${author}
 * @since ${date}
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestPersonConverter {
    /**
     * DTO转Entity
     * @param dto /
     * @return /
     */
    ${className} toEntity(${className}DTO dto);

    /**
     * Entity转DTO
     * @param entity /
     * @return /
     */
    ${className}DTO toDto(${className} entity);

    /**
     * DTO集合转Entity集合
     * @param dtoList /
     * @return /
     */
    List<${className}> toEntity(List<${className}DTO> dtoList);

    /**
     * Entity集合转DTO集合
     * @param entityList /
     * @return /
     */
    List <${className}DTO> toDto(List<${className}> entityList);

    default PageInfo<${className}DTO> convertPage(IPage<${className}> page) {
        if (page == null) {
            return null;
        }
        PageInfo<${className}DTO> pageInfo = new PageInfo<>();
        pageInfo.setTotalElements(page.getTotal());
        pageInfo.setContent(toDto(page.getRecords()));
        return pageInfo;
    }
}
