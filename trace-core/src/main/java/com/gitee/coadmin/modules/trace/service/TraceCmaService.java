package com.gitee.coadmin.modules.trace.service;

import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.trace.domain.TraceCma;
import com.gitee.coadmin.modules.trace.service.dto.TraceCmaDTO;
import com.gitee.coadmin.modules.trace.service.dto.TraceCmaQueryParam;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
 * 染色体微整列分析
 * @author jinjin
 * @since 2022-01-04
 */
public interface TraceCmaService {

    String CACHE_KEY = "trace:trace-cma";

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<TraceCmaDTO>
    */
    PageInfo<TraceCmaDTO> queryAll(TraceCmaQueryParam query, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param query 条件参数
    * @return List<TraceCmaDTO>
    */
    List<TraceCmaDTO> queryAll(TraceCmaQueryParam query);

    long queryCount(TraceCmaQueryParam query);

    TraceCmaDTO getById(Long id);

    void upload(TraceCmaDTO dto);

    /**
     * 插入一条新数据。
     */
    int insert(TraceCmaDTO res);
    int updateById(TraceCmaDTO res);
    int removeByIds(Set<Long> ids);

    void updateTraceViewed(String patientNo);
}
