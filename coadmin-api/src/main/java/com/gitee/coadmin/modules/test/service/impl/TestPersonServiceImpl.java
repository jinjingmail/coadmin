package com.gitee.coadmin.modules.test.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.PageUtil;
import com.gitee.coadmin.modules.test.domain.TestPerson;
import com.gitee.coadmin.modules.test.service.TestPersonService;
import com.gitee.coadmin.modules.test.service.dto.TestPersonDTO;
import com.gitee.coadmin.modules.test.service.dto.TestPersonQueryParam;
import com.gitee.coadmin.modules.test.service.mapper.TestPersonMapper;
import com.gitee.coadmin.modules.test.service.converter.TestPersonConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import java.util.*;

/**
 * @author jinjin
 * @since 2021-08-22
 */
@Service
@AllArgsConstructor
// @CacheConfig(cacheNames = TestPersonService.CACHE_KEY)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TestPersonServiceImpl implements TestPersonService {

    // private final RedisUtils redisUtils;
    private final TestPersonMapper testPersonMapper;
    private final TestPersonConverter testPersonConverter;

    @Override
    public PageInfo<TestPersonDTO> queryAll(TestPersonQueryParam query, Pageable pageable) {
        IPage<TestPerson> queryPage = PageUtil.toMybatisPage(pageable);
        IPage<TestPerson> page = testPersonMapper.selectPage(queryPage, QueryHelpMybatisPlus.getPredicate(query));
        return testPersonConverter.convertPage(page);
    }

    @Override
    public List<TestPersonDTO> queryAll(TestPersonQueryParam query){
        return testPersonConverter.toDto(testPersonMapper.selectList(QueryHelpMybatisPlus.getPredicate(query)));
    }

    @Override
    public TestPerson getEntityById(Long id) {
        return testPersonMapper.selectById(id);
    }

    @Override
    // @Cacheable(key = "'id:' + #p0")
    public TestPersonDTO getById(Long id) {
        return testPersonConverter.toDto(getEntityById(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(TestPersonDTO resources) {
        TestPerson entity = testPersonConverter.toEntity(resources);
        return testPersonMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(TestPersonDTO resources){
        TestPerson entity = testPersonConverter.toEntity(resources);
        int ret = testPersonMapper.updateById(entity);
        // delCaches(resources.id);
        return ret;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByIds(Set<Long> ids){
        // delCaches(ids);
        return testPersonMapper.deleteBatchIds(ids);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeById(Long id){
        Set<Long> set = new HashSet<>(1);
        set.add(id);
        return this.removeByIds(set);
    }

    /*
    private void delCaches(Long id) {
        redisUtils.delByKey(CACHE_KEY + "::id:", id);
    }

    private void delCaches(Set<Long> ids) {
        for (Long id: ids) {
            delCaches(id);
        }
    }*/
}
