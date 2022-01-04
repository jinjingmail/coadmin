package com.gitee.coadmin.modules.trace.service;

import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.trace.domain.TracePatient;
import com.gitee.coadmin.modules.trace.service.dto.TracePatientDTO;
import com.gitee.coadmin.modules.trace.service.dto.TracePatientQueryParam;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
 * 就诊人
 * @author jinjin
 * @since 2022-01-04
 */
public interface TracePatientService {

    String CACHE_KEY = "trace:trace-patient";

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<TracePatientDTO>
    */
    PageInfo<TracePatientDTO> queryAll(TracePatientQueryParam query, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param query 条件参数
    * @return List<TracePatientDTO>
    */
    List<TracePatientDTO> queryAll(TracePatientQueryParam query);

    long queryCount(TracePatientQueryParam query);

    TracePatientDTO getById(Long id);

    /**
     * 插入一条新数据。
     */
    int insert(TracePatientDTO res);
    int updateById(TracePatientDTO res);
    int removeByIds(Set<Long> ids);

    void insertOrUpdate(String patientNo, String patientName, String patientGender, String patientAge,
                        String patientIdNo, String patientHealthNo, String contactTel);
}
