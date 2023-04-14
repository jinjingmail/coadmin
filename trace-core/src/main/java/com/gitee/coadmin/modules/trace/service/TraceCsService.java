package com.gitee.coadmin.modules.trace.service;

import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.trace.domain.TraceCs;
import com.gitee.coadmin.modules.trace.service.dto.TraceCsDTO;
import com.gitee.coadmin.modules.trace.service.dto.TraceCsQueryParam;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
 * 染色体核型结果
 * @author jinjin
 * @since 2022-01-04
 */
public interface TraceCsService {

    String CACHE_KEY = "trace:trace-cs";

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<TraceCsDTO>
    */
    PageInfo<TraceCsDTO> queryAll(TraceCsQueryParam query, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param query 条件参数
    * @return List<TraceCsDTO>
    */
    List<TraceCsDTO> queryAll(TraceCsQueryParam query);

    long queryCount(TraceCsQueryParam query);

    TraceCsDTO getById(Long id);

    Long numByPatientNo(String no);
    String calcSummary(String patientNo);

    void upload(TraceCsDTO dto);
    /**
     * 插入一条新数据。
     */
    int insert(TraceCsDTO res);
    int updateById(TraceCsDTO res);
    int removeByIds(Set<Long> ids);

    void updateTraceViewed(String patientNo);

}
