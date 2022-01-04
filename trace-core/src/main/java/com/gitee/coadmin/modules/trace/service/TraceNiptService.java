package com.gitee.coadmin.modules.trace.service;

import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.trace.domain.TraceNipt;
import com.gitee.coadmin.modules.trace.service.dto.TraceNiptDTO;
import com.gitee.coadmin.modules.trace.service.dto.TraceNiptQueryParam;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
 * 无创产前筛查
 * @author jinjin
 * @since 2022-01-04
 */
public interface TraceNiptService {

    String CACHE_KEY = "trace:trace-nipt";

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<TraceNiptDTO>
    */
    PageInfo<TraceNiptDTO> queryAll(TraceNiptQueryParam query, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param query 条件参数
    * @return List<TraceNiptDTO>
    */
    List<TraceNiptDTO> queryAll(TraceNiptQueryParam query);

    long queryCount(TraceNiptQueryParam query);

    TraceNiptDTO getById(Long id);

    /**
     * 插入一条新数据。
     */
    int insert(TraceNiptDTO res);
    int updateById(TraceNiptDTO res);
    int removeByIds(Set<Long> ids);

    void upload(TraceNiptDTO dto);
}
