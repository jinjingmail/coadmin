package ${package}.service;

import com.gitee.coadmin.base.PageInfo;
import ${package}.domain.${className};
import ${package}.service.dto.${className}DTO;
import ${package}.service.dto.${className}QueryParam;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
 * ${apiAlias}
 * @author ${author}
 * @since ${date}
 */
public interface ${className}Service {

    String CACHE_KEY = "${subModuleName}:${minusClassName}";

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<${className}DTO>
    */
    PageInfo<${className}DTO> pageByParam(${className}QueryParam query, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param query 条件参数
    * @return List<${className}DTO>
    */
    List<${className}DTO> listByParam(${className}QueryParam query);

    long countByParam(${className}QueryParam query);

    ${className}DTO getById(${pkColumnType} id);

    /**
     * 插入一条新数据。
     */
    void insert(${className}DTO res);
    void updateById(${className}DTO res);
    void removeByIds(Set<${pkColumnType}> ids);
}
