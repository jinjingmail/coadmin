package com.gitee.coadmin.modules.test.service;

import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.test.domain.TestPerson;
import com.gitee.coadmin.modules.test.service.dto.TestPersonDTO;
import com.gitee.coadmin.modules.test.service.dto.TestPersonQueryParam;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
 * @author jinjin
 * @since 2021-08-22
 */
public interface TestPersonService {

    static final String CACHE_KEY = "testPerson";

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<TestPersonDTO>
    */
    PageInfo<TestPersonDTO> queryAll(TestPersonQueryParam query, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param query 条件参数
    * @return List<TestPersonDTO>
    */
    List<TestPersonDTO> queryAll(TestPersonQueryParam query);

    TestPerson getEntityById(Long id);
    TestPersonDTO getById(Long id);

    /**
     * 插入一条新数据。
     */
    int insert(TestPersonDTO resources);
    int updateById(TestPersonDTO resources);
    int removeById(Long id);
    int removeByIds(Set<Long> ids);
}
