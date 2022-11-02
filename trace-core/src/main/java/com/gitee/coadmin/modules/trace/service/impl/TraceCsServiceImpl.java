package com.gitee.coadmin.modules.trace.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.modules.trace.service.TracePatientService;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.PageUtil;
import com.gitee.coadmin.modules.trace.domain.TraceCs;
import com.gitee.coadmin.modules.trace.service.TraceCsService;
import com.gitee.coadmin.modules.trace.service.dto.TraceCsDTO;
import com.gitee.coadmin.modules.trace.service.dto.TraceCsQueryParam;
import com.gitee.coadmin.modules.trace.service.mapper.TraceCsMapper;
import com.gitee.coadmin.modules.trace.service.converter.TraceCsConverter;
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
// @CacheConfig(cacheNames = TraceCsService.CACHE_KEY)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TraceCsServiceImpl implements TraceCsService {

    // private final RedisUtils redisUtils;
    private final TraceCsMapper traceCsMapper;
    private final TraceCsConverter traceCsConverter;
    private final TracePatientService tracePatientService;

    @Override
    public PageInfo<TraceCsDTO> queryAll(TraceCsQueryParam query, Pageable pageable) {
        IPage<TraceCs> queryPage = PageUtil.toMybatisPage(pageable);
        IPage<TraceCs> page = traceCsMapper.selectPage(queryPage, QueryHelpMybatisPlus.getPredicate(query));
        return traceCsConverter.convertPage(page);
    }

    @Override
    public List<TraceCsDTO> queryAll(TraceCsQueryParam query){
        return traceCsConverter.toDto(traceCsMapper.selectList(QueryHelpMybatisPlus.getPredicate(query, "id", false)));
    }

    @Override
    public long queryCount(TraceCsQueryParam query) {
        return traceCsMapper.selectCount(QueryHelpMybatisPlus.getPredicate(query));
    }

    @Override
    // @Cacheable(key = "'id:' + #p0")
    public TraceCsDTO getById(Long id) {
        if (id == null) {
            return null;
        }
        return traceCsConverter.toDto(traceCsMapper.selectById(id));
    }

    @Override
    public Long numByPatientNo(String no) {
        QueryWrapper<TraceCs> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TraceCs::getPatientNo, no);
        return traceCsMapper.selectCount(wrapper);
    }

    @Override
    @Transactional
    public void upload(TraceCsDTO dto) {
        TraceCsDTO old = getByReportNo(dto.getReportNo());
        if (old != null) {
            BeanUtil.copyProperties(dto, old,  "id", "remarks",
                    "createTime", "createUser", "updateTime", "updateUser");
            updateById(old);
            patient(old);
        } else {
            insert(dto);
            patient(dto);
        }
    }

    private TraceCsDTO getByReportNo(String reportNo) {
        QueryWrapper<TraceCs> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TraceCs::getReportNo, reportNo);
        return traceCsConverter.toDto(traceCsMapper.selectOne(queryWrapper));
    }

    private void patient(TraceCsDTO dto) {
        tracePatientService.insertOrUpdate(dto.getPatientNo(), dto.getPatientName(),
                dto.getPatientGender(), dto.getPatientAge(), null, null,
                null);
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int insert(TraceCsDTO res) {
        TraceCs entity = traceCsConverter.toEntity(res);
        int ret = traceCsMapper.insert(entity);
        res.setId(entity.getId());
        return ret;
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int updateById(TraceCsDTO res){
        TraceCs entity = traceCsConverter.toEntity(res);
        int ret = traceCsMapper.updateById(entity);
        // delCaches(res.id);
        return ret;
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int removeByIds(Set<Long> ids){
        // delCaches(ids);
        return traceCsMapper.deleteBatchIds(ids);
    }

    @Override
    @Transactional
    public void updateTraceViewed(String patientNo) {
        UpdateWrapper<TraceCs> update = new UpdateWrapper<>();
        update.lambda().eq(TraceCs::getPatientNo, patientNo)
                .eq(TraceCs::getViewed, false)
                .set(TraceCs::getViewed, true);
        traceCsMapper.update(null, update);
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
