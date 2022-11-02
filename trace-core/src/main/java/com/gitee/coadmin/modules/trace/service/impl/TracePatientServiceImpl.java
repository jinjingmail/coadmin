package com.gitee.coadmin.modules.trace.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.modules.trace.service.TraceCmaService;
import com.gitee.coadmin.modules.trace.service.TraceCsService;
import com.gitee.coadmin.modules.trace.service.TraceNiptService;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.PageUtil;
import com.gitee.coadmin.modules.trace.domain.TracePatient;
import com.gitee.coadmin.modules.trace.service.TracePatientService;
import com.gitee.coadmin.modules.trace.service.dto.TracePatientDTO;
import com.gitee.coadmin.modules.trace.service.dto.TracePatientQueryParam;
import com.gitee.coadmin.modules.trace.service.mapper.TracePatientMapper;
import com.gitee.coadmin.modules.trace.service.converter.TracePatientConverter;
import com.gitee.coadmin.utils.SpringContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.*;

/**
 * @author jinjin
 * @since 2022-01-04
 */
@Service
@RequiredArgsConstructor
// @CacheConfig(cacheNames = TracePatientService.CACHE_KEY)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TracePatientServiceImpl implements TracePatientService {

    // private final RedisUtils redisUtils;
    private final TracePatientMapper tracePatientMapper;
    private final TracePatientConverter tracePatientConverter;

    @Override
    public PageInfo<TracePatientDTO> queryAll(TracePatientQueryParam query, Pageable pageable) {
        IPage<TracePatient> queryPage = PageUtil.toMybatisPage(pageable);
        IPage<TracePatient> page = tracePatientMapper.selectPage(queryPage, QueryHelpMybatisPlus.getPredicate(query));
        PageInfo<TracePatientDTO> dtos = tracePatientConverter.convertPage(page);

        TraceNiptService niptService = SpringContextHolder.getBean(TraceNiptService.class);
        TraceCsService csService = SpringContextHolder.getBean(TraceCsService.class);
        TraceCmaService cmaService = SpringContextHolder.getBean(TraceCmaService.class);

        for (TracePatientDTO dto: dtos.getContent()) {
            if (StrUtil.isBlank(dto.getNo())) {
                continue;
            }
            dto.setNumCma(cmaService.numByPatientNo(dto.getNo()));
            dto.setNumCs(csService.numByPatientNo(dto.getNo()));
            dto.setNumNipt(niptService.numByPatientNo(dto.getNo()));
        }
        return dtos;
    }

    @Override
    public List<TracePatientDTO> queryAll(TracePatientQueryParam query){
        return tracePatientConverter.toDto(tracePatientMapper.selectList(QueryHelpMybatisPlus.getPredicate(query, "id", false)));
    }

    @Override
    public long queryCount(TracePatientQueryParam query) {
        return tracePatientMapper.selectCount(QueryHelpMybatisPlus.getPredicate(query));
    }

    @Override
    // @Cacheable(key = "'id:' + #p0")
    public TracePatientDTO getById(Long id) {
        if (id == null) {
            return null;
        }
        return tracePatientConverter.toDto(tracePatientMapper.selectById(id));
    }

    private TracePatientDTO getByNo(String no) {
        QueryWrapper<TracePatient> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TracePatient::getNo, no);
        return tracePatientConverter.toDto(tracePatientMapper.selectOne(wrapper));
    }

    @Override
    @Transactional
    public void updateTraceViewed(String patientNo) {
        TraceCmaService traceCmaService = SpringContextHolder.getBean(TraceCmaService.class);
        TraceCsService traceCsService = SpringContextHolder.getBean(TraceCsService.class);
        TraceNiptService traceNiptService = SpringContextHolder.getBean(TraceNiptService.class);

        traceCmaService.updateTraceViewed(patientNo);
        traceCsService.updateTraceViewed(patientNo);
        traceNiptService.updateTraceViewed(patientNo);
        updateViewed(patientNo);
    }

    private void updateViewed(String patientNo) {
        UpdateWrapper<TracePatient> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(TracePatient::getNo, patientNo)
                .eq(TracePatient::getViewed, false)
                .set(TracePatient::getViewed, true);
        tracePatientMapper.update(null, updateWrapper);
    }

    @Override
    @Transactional
    public void insertOrUpdate(String patientNo, String patientName, String patientGender, String patientAge,
                               String patientIdNo, String patientHealthNo, String contactTel) {
        boolean isNew = false;
        boolean isModified = false;
        TracePatientDTO old = getByNo(patientNo);
        if (old == null) {
            isNew = true;
            old = new TracePatientDTO();
        }
        if (!StrUtil.equals(patientNo, old.getNo())) {
            old.setNo(patientNo);
            isModified = true;
        }
        if (!StrUtil.equals(patientName, old.getName())) {
            old.setName(patientName);
            isModified = true;
        }
        if (!StrUtil.equals(patientGender, old.getGender())) {
            old.setGender(patientGender);
            isModified = true;
        }
        if (old.getBirthday() == null) {
            old.setBirthday(calcBirthYearByAge(patientAge));
            isModified = true;
        }
        if (StrUtil.isNotBlank(patientIdNo)) {
            old.setIdNo(patientIdNo);
            isModified = true;
        }
        if (StrUtil.isNotBlank(patientHealthNo)) {
            old.setHealthNo(patientHealthNo);
            isModified = true;
        }
        if (StrUtil.isNotBlank(contactTel)) {
            old.setContactNo(contactTel);
            isModified = true;
        }
        if (isNew) {
            insert(old);
        }
        else if (isModified) {
            updateById(old);
        }
    }

    private Date calcBirthYearByAge(String patientAge) {
        if (StrUtil.isBlank(patientAge)) {
            return null;
        }
        String ageStr = patientAge.replace("岁", "");
        if (StrUtil.isBlank(ageStr)) {
            return null;
        }
        Integer age = NumberUtil.parseInt(ageStr);
        return DateUtil.beginOfYear(DateUtil.offset(new Date(), DateField.YEAR, -age));
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int insert(TracePatientDTO res) {
        TracePatient entity = tracePatientConverter.toEntity(res);
        int ret = tracePatientMapper.insert(entity);
        res.setId(entity.getId());
        return ret;
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int updateById(TracePatientDTO res){
        TracePatient entity = tracePatientConverter.toEntity(res);
        int ret = tracePatientMapper.updateById(entity);
        // delCaches(res.id);
        return ret;
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int removeByIds(Set<Long> ids){
        // delCaches(ids);
        return tracePatientMapper.deleteBatchIds(ids);
    }
    
    /*
    private void delCaches(Long id) {
        redisUtils.del(CACHE_KEY + "::id:" + id);
    }

    private void delCaches(Set<Long> ids) {
        for (Long id: ids) {
            delCaches(id);
        }
    }*/
}
