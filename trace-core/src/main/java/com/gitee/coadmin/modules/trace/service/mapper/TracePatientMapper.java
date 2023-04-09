package com.gitee.coadmin.modules.trace.service.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gitee.coadmin.base.CommonMapper;
import com.gitee.coadmin.modules.trace.domain.TracePatient;
import com.gitee.coadmin.modules.trace.service.dto.TracePatientDTO;
import com.gitee.coadmin.modules.trace.service.dto.TracePatientQueryParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 就诊人
 * @author jinjin
 * @since 2022-01-04
 */
@Repository
public interface TracePatientMapper extends CommonMapper<TracePatient> {

    List<TracePatientDTO> queryList(@Param(Constants.WRAPPER) QueryWrapper wrapper);

    long queryCount(@Param(Constants.WRAPPER) QueryWrapper wrapper);
}
