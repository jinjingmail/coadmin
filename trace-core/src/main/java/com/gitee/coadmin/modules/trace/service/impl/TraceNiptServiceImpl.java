package com.gitee.coadmin.modules.trace.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.modules.trace.service.TracePatientService;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.PageUtil;
import com.gitee.coadmin.modules.trace.domain.TraceNipt;
import com.gitee.coadmin.modules.trace.service.TraceNiptService;
import com.gitee.coadmin.modules.trace.service.dto.TraceNiptDTO;
import com.gitee.coadmin.modules.trace.service.dto.TraceNiptQueryParam;
import com.gitee.coadmin.modules.trace.service.mapper.TraceNiptMapper;
import com.gitee.coadmin.modules.trace.service.converter.TraceNiptConverter;
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
// @CacheConfig(cacheNames = TraceNiptService.CACHE_KEY)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TraceNiptServiceImpl implements TraceNiptService {

    // private final RedisUtils redisUtils;
    private final TraceNiptMapper traceNiptMapper;
    private final TraceNiptConverter traceNiptConverter;
    private final TracePatientService tracePatientService;

    @Override
    public PageInfo<TraceNiptDTO> queryAll(TraceNiptQueryParam query, Pageable pageable) {
        IPage<TraceNipt> queryPage = PageUtil.toMybatisPage(pageable);
        IPage<TraceNipt> page = traceNiptMapper.selectPage(queryPage, QueryHelpMybatisPlus.getPredicate(query));
        return traceNiptConverter.convertPage(page);
    }

    @Override
    public List<TraceNiptDTO> queryAll(TraceNiptQueryParam query){
        return traceNiptConverter.toDto(traceNiptMapper.selectList(QueryHelpMybatisPlus.getPredicate(query, "id", false)));
    }

    @Override
    public long queryCount(TraceNiptQueryParam query) {
        return traceNiptMapper.selectCount(QueryHelpMybatisPlus.getPredicate(query));
    }

    @Override
    // @Cacheable(key = "'id:' + #p0")
    public TraceNiptDTO getById(Long id) {
        if (id == null) {
            return null;
        }
        return traceNiptConverter.toDto(traceNiptMapper.selectById(id));
    }

    private TraceNiptDTO getByReportNo(String reportNo) {
        QueryWrapper<TraceNipt> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TraceNipt::getReportNo, reportNo);
        return traceNiptConverter.toDto(traceNiptMapper.selectOne(wrapper));
    }

    @Override
    @Transactional
    public void upload(TraceNiptDTO dto) {
        TraceNiptDTO old = getByReportNo(dto.getReportNo());
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

    @Override
    @Transactional
    public void updateTraceViewed(String patientNo) {
        UpdateWrapper<TraceNipt> update = new UpdateWrapper<>();
        update.lambda().eq(TraceNipt::getPatientNo, patientNo)
                .eq(TraceNipt::getViewed, false)
                .set(TraceNipt::getViewed, true);
        traceNiptMapper.update(null, update);
    }

    private void patient(TraceNiptDTO dto) {
        tracePatientService.insertOrUpdate(dto.getPatientNo(), dto.getPatientName(),
                dto.getPatientGender(), dto.getPatientAge(), dto.getPatientIdNo(), dto.getPatientHealthNo(),
                dto.getContactTel());
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int insert(TraceNiptDTO res) {
        TraceNipt entity = traceNiptConverter.toEntity(res);
        int ret = traceNiptMapper.insert(entity);
        res.setId(entity.getId());
        return ret;
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int updateById(TraceNiptDTO res){
        TraceNipt entity = traceNiptConverter.toEntity(res);
        int ret = traceNiptMapper.updateById(entity);
        // delCaches(res.id);
        return ret;
    }

    @Override
    // @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int removeByIds(Set<Long> ids){
        // delCaches(ids);
        return traceNiptMapper.deleteBatchIds(ids);
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
