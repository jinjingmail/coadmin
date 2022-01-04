package ${package}.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
<#if columns??>
    <#list columns as column>
        <#if column.columnKey = 'UNI'>
            <#if column_index = 1>
import com.gitee.coadmin.exception.EntityExistException;
            </#if>
        </#if>
    </#list>
</#if>
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.PageUtil;
import ${package}.domain.${className};
import ${package}.service.${className}Service;
import ${package}.service.dto.${className}DTO;
import ${package}.service.dto.${className}QueryParam;
import ${package}.service.mapper.${className}Mapper;
import ${package}.service.converter.${className}Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.*;

/**
 * @author ${author}
 * @since ${date}
 */
@Service
@RequiredArgsConstructor
// @CacheConfig(cacheNames = ${className}Service.CACHE_KEY)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ${className}ServiceImpl implements ${className}Service {

    // private final RedisUtils redisUtils;
    private final ${className}Mapper ${changeClassName}Mapper;
    private final ${className}Converter ${changeClassName}Converter;

    @Override
    public PageInfo<${className}DTO> queryAll(${className}QueryParam query, Pageable pageable) {
        IPage<${className}> queryPage = PageUtil.toMybatisPage(pageable);
        IPage<${className}> page = ${changeClassName}Mapper.selectPage(queryPage, QueryHelpMybatisPlus.getPredicate(query));
        return ${changeClassName}Converter.convertPage(page);
    }

    @Override
    public List<${className}DTO> queryAll(${className}QueryParam query){
        return ${changeClassName}Converter.toDto(${changeClassName}Mapper.selectList(QueryHelpMybatisPlus.getPredicate(query)));
    }

    @Override
    public long queryCount(${className}QueryParam query) {
        return ${changeClassName}Mapper.selectCount(QueryHelpMybatisPlus.getPredicate(query));
    }

    @Override
    // @Cacheable(key = "'id:' + #p0")
    public ${className}DTO getById(${pkColumnType} id) {
        if (id == null) {
            return null;
        }
        return ${changeClassName}Converter.toDto(${changeClassName}Mapper.selectById(id));
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int insert(${className}DTO res) {
        ${className} entity = ${changeClassName}Converter.toEntity(res);
        int ret = ${changeClassName}Mapper.insert(entity);
        res.setId(entity.getId());
        return ret;
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int updateById(${className}DTO res){
        ${className} entity = ${changeClassName}Converter.toEntity(res);
        int ret = ${changeClassName}Mapper.updateById(entity);
        // delCaches(res.id);
        return ret;
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int removeByIds(Set<${pkColumnType}> ids){
        // delCaches(ids);
        return ${changeClassName}Mapper.deleteBatchIds(ids);
    }
    
    /*
    private void delCaches(${pkColumnType} id) {
        redisUtils.del(CACHE_KEY + "::id:" + id);
    }

    private void delCaches(Set<${pkColumnType}> ids) {
        for (${pkColumnType} id: ids) {
            delCaches(id);
        }
    }*/
}
