package ${package}.service;

import com.gitee.coadmin.base.PageInfo;
import ${package}.domain.${className};
import ${package}.service.dto.${className}Dto;
import ${package}.service.dto.${className}QueryParam;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
* @author ${author}
* @date ${date}
*/
public interface ${className}Service {

    static final String CACHE_KEY = "${changeClassName}";

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<${className}Dto>
    */
    PageInfo<${className}Dto> queryAll(${className}QueryParam query, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param query 条件参数
    * @return List<${className}Dto>
    */
    List<${className}Dto> queryAll(${className}QueryParam query);

    ${className} getEntityById(${pkColumnType} id);
    ${className}Dto getById(${pkColumnType} id);

    /**
     * 插入一条新数据。
     */
    int insert(${className}Dto resources);
    int updateById(${className}Dto resources);
    int removeById(${pkColumnType} id);
    int removeByIds(Set<${pkColumnType}> ids);
}
