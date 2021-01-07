package com.gitee.coadmin.modules.test.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.gitee.coadmin.modules.tools.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.ConvertUtil;
import com.gitee.coadmin.utils.PageUtil;
import com.gitee.coadmin.modules.test.domain.TestPerson;
import com.gitee.coadmin.modules.test.service.TestPersonService;
import com.gitee.coadmin.modules.test.service.dto.TestPersonDto;
import com.gitee.coadmin.modules.test.service.dto.TestPersonQueryParam;
import com.gitee.coadmin.modules.test.service.mapper.TestPersonMapper;
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
* @date 2021-01-07
*/
@Service
@AllArgsConstructor
// @CacheConfig(cacheNames = TestPersonService.CACHE_KEY)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TestPersonServiceImpl implements TestPersonService {

    // private final RedisUtils redisUtils;
    private final TestPersonMapper testPersonMapper;

    @Override
    public PageInfo<TestPersonDto> queryAll(TestPersonQueryParam query, Pageable pageable) {
        IPage<TestPerson> queryPage = PageUtil.toMybatisPage(pageable);
        IPage<TestPerson> page = testPersonMapper.selectPage(queryPage, QueryHelpMybatisPlus.getPredicate(query));
        return ConvertUtil.convertPage(page, TestPersonDto.class);
    }

    @Override
    public List<TestPersonDto> queryAll(TestPersonQueryParam query){
        return ConvertUtil.convertList(testPersonMapper.selectList(QueryHelpMybatisPlus.getPredicate(query)), TestPersonDto.class);
    }

    @Override
    public TestPerson getEntityById(Long id) {
        return testPersonMapper.selectById(id);
    }

    @Override
    // @Cacheable(key = "'id:' + #p0")
    public TestPersonDto getById(Long id) {
        return ConvertUtil.convert(getEntityById(id), TestPersonDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(TestPersonDto resources) {
        TestPerson entity = ConvertUtil.convert(resources, TestPerson.class);
        return testPersonMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(TestPersonDto resources){
        TestPerson entity = ConvertUtil.convert(resources, TestPerson.class);
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

    /*
    @Override
    public void download(List<TestPersonDto> all, HttpServletResponse response) throws IOException {
      List<Map<String, Object>> list = new ArrayList<>();
      for (TestPersonDto testPerson : all) {
        Map<String,Object> map = new LinkedHashMap<>();
              map.put("姓名", testPerson.getName());
              map.put("性别", testPerson.getGender());
              map.put("出生日期", testPerson.getBirthday());
              map.put("创建时间", testPerson.getCreateTime());
              map.put("创建人", testPerson.getCreateBy());
              map.put("修改时间", testPerson.getUpdateTime());
              map.put("修改人", testPerson.getUpdateBy());
              map.put("备注", testPerson.getRemarks());
        list.add(map);
      }
      FileUtil.downloadExcel(list, response);
    }*/
}
