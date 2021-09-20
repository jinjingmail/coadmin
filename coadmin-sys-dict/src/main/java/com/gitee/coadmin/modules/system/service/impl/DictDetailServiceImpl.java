package com.gitee.coadmin.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.modules.system.service.dto.DictDetailSmallDto;
import lombok.AllArgsConstructor;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.impl.BaseServiceImpl;
import com.gitee.coadmin.modules.system.domain.Dict;
import com.gitee.coadmin.modules.system.service.mapper.DictMapper;
import com.gitee.coadmin.utils.ConvertUtil;
import com.gitee.coadmin.modules.system.domain.DictDetail;
import com.gitee.coadmin.modules.system.service.DictDetailService;
import com.gitee.coadmin.modules.system.service.dto.DictDetailDto;
import com.gitee.coadmin.modules.system.service.dto.DictDetailQueryParam;
import com.gitee.coadmin.modules.system.service.mapper.DictDetailMapper;
import com.gitee.coadmin.utils.PageUtil;
import com.gitee.coadmin.utils.RedisUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
* @author jinjin
* @date 2020-09-24
*/
@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "dictDetail")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictDetailServiceImpl extends BaseServiceImpl<DictDetail> implements DictDetailService {

    private final DictDetailMapper dictDetailMapper;
    private final DictMapper dictMapper;
    private final RedisUtils redisUtils;

    @Override
    //@Cacheable
    public PageInfo<DictDetailDto> queryAll(DictDetailQueryParam query, Pageable pageable) {
        IPage<DictDetail> page = PageUtil.toMybatisPage(pageable);
        IPage<DictDetail> pageList = dictDetailMapper.selectPage(page, QueryHelpMybatisPlus.getPredicate(query));
        return ConvertUtil.convertPage(pageList, DictDetailDto.class);
    }

    @Override
    //@Cacheable
    public List<DictDetailDto> queryAll(DictDetailQueryParam query){
        return ConvertUtil.convertList(dictDetailMapper.selectList(QueryHelpMybatisPlus.getPredicate(query)), DictDetailDto.class);
    }

    @Override
    public List<DictDetailSmallDto> getDictByName(String dictName) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Dict::getName, dictName);
        Dict dict = dictMapper.selectOne(wrapper);
        List<DictDetailSmallDto> ret = ConvertUtil.convertList(dictDetailMapper.getDictDetailsByDictName(dictName),
                DictDetailSmallDto.class);
        redisUtils.set("dictDetail::dictId:"+dict.getId(), ret);
        return ret;
    }

    @Override
    public PageInfo<DictDetailDto> getDictByName(String dictName, Pageable pageable) {
        IPage<DictDetailDto> page = PageUtil.toMybatisPage(pageable, true);
        return ConvertUtil.convertPage(dictDetailMapper.getDictDetailsByDictName(dictName, page), DictDetailDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(DictDetailDto resources) {
        DictDetail detail = ConvertUtil.convert(resources, DictDetail.class);
        boolean ret = dictDetailMapper.updateById(detail) > 0;
        // 清理缓存
        delCaches(detail.getDictId());
        return ret;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(DictDetailDto resources){
        DictDetail detail = ConvertUtil.convert(resources, DictDetail.class);
        boolean ret = dictDetailMapper.insert(detail) > 0;
        // 清理缓存
        delCaches(detail.getDictId());
        return ret;
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Set<Long> ids){
        boolean b = false;
        for (Long id : ids) {
            b = removeById(id);
        }
        return b;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(Long id) {
        DictDetail dictDetail = dictDetailMapper.selectById(id);
        boolean ret = dictDetailMapper.deleteById(id) > 0;
        // 清理缓存
        delCaches(dictDetail.getDictId());
        return ret;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByDictId(Long id) {
        UpdateWrapper<DictDetail> wrapper1 = new UpdateWrapper<>();
        wrapper1.lambda().eq(DictDetail::getDictId, id);
        boolean ret = dictDetailMapper.delete(wrapper1) > 0;
        delCaches(id);
        return ret;
    }

    private void delCaches(Long dictId){
        redisUtils.del("dictDetail::dictId:" + dictId);
    }
}
