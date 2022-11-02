package com.gitee.coadmin.modules.trace.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.modules.trace.service.TracePatientService;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.PageUtil;
import com.gitee.coadmin.modules.trace.domain.TraceCma;
import com.gitee.coadmin.modules.trace.service.TraceCmaService;
import com.gitee.coadmin.modules.trace.service.dto.TraceCmaDTO;
import com.gitee.coadmin.modules.trace.service.dto.TraceCmaQueryParam;
import com.gitee.coadmin.modules.trace.service.mapper.TraceCmaMapper;
import com.gitee.coadmin.modules.trace.service.converter.TraceCmaConverter;
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
// @CacheConfig(cacheNames = TraceCmaService.CACHE_KEY)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TraceCmaServiceImpl implements TraceCmaService {

    // private final RedisUtils redisUtils;
    private final TraceCmaMapper traceCmaMapper;
    private final TraceCmaConverter traceCmaConverter;
    private final TracePatientService tracePatientService;

    @Override
    public PageInfo<TraceCmaDTO> queryAll(TraceCmaQueryParam query, Pageable pageable) {
        IPage<TraceCma> queryPage = PageUtil.toMybatisPage(pageable);
        IPage<TraceCma> page = traceCmaMapper.selectPage(queryPage, QueryHelpMybatisPlus.getPredicate(query));
        return traceCmaConverter.convertPage(page);
    }

    @Override
    public List<TraceCmaDTO> queryAll(TraceCmaQueryParam query){
        return traceCmaConverter.toDto(traceCmaMapper.selectList(QueryHelpMybatisPlus.getPredicate(query, "id", false)));
    }

    @Override
    public long queryCount(TraceCmaQueryParam query) {
        return traceCmaMapper.selectCount(QueryHelpMybatisPlus.getPredicate(query));
    }

    @Override
    // @Cacheable(key = "'id:' + #p0")
    public TraceCmaDTO getById(Long id) {
        if (id == null) {
            return null;
        }
        return traceCmaConverter.toDto(traceCmaMapper.selectById(id));
    }

    @Override
    public Long numByPatientNo(String no) {
        QueryWrapper<TraceCma> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TraceCma::getPatientNo, no);
        return traceCmaMapper.selectCount(wrapper);
    }

    @Override
    @Transactional
    public void upload(TraceCmaDTO dto) {
        TraceCmaDTO old = getByReportNo(dto.getReportNo());
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

    private TraceCmaDTO getByReportNo(String reportNo) {
        QueryWrapper<TraceCma> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TraceCma::getReportNo, reportNo);
        return traceCmaConverter.toDto(traceCmaMapper.selectOne(wrapper));
    }

    private void patient(TraceCmaDTO dto) {
        tracePatientService.insertOrUpdate(dto.getPatientNo(), dto.getPatientName(),
                dto.getPatientGender(), dto.getPatientAge(), null, null,
                dto.getContactTel());
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int insert(TraceCmaDTO res) {
        TraceCma entity = traceCmaConverter.toEntity(res);
        int ret = traceCmaMapper.insert(entity);
        res.setId(entity.getId());
        return ret;
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int updateById(TraceCmaDTO res){
        TraceCma entity = traceCmaConverter.toEntity(res);
        int ret = traceCmaMapper.updateById(entity);
        // delCaches(res.id);
        return ret;
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int removeByIds(Set<Long> ids){
        // delCaches(ids);
        return traceCmaMapper.deleteBatchIds(ids);
    }

    @Override
    @Transactional
    public void updateTraceViewed(String patientNo) {
        UpdateWrapper<TraceCma> update = new UpdateWrapper<>();
        update.lambda().eq(TraceCma::getPatientNo, patientNo)
                .eq(TraceCma::getViewed, false)
                .set(TraceCma::getViewed, true);
        traceCmaMapper.update(null, update);
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
