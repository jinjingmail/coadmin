package com.gitee.coadmin.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.PageUtil;
import com.gitee.coadmin.modules.system.domain.Setting;
import com.gitee.coadmin.modules.system.service.SettingService;
import com.gitee.coadmin.modules.system.service.dto.SettingDTO;
import com.gitee.coadmin.modules.system.service.dto.SettingQueryParam;
import com.gitee.coadmin.modules.system.service.mapper.SettingMapper;
import com.gitee.coadmin.modules.system.service.converter.SettingConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import java.util.*;

/**
 * @author jinjin
 * @since 2021-09-19
 */
@Service
@AllArgsConstructor
// @CacheConfig(cacheNames = SettingService.CACHE_KEY)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SettingServiceImpl implements SettingService {

    // private final RedisUtils redisUtils;
    private final SettingMapper settingMapper;
    private final SettingConverter settingConverter;

    @Override
    public PageInfo<SettingDTO> queryAll(SettingQueryParam query, Pageable pageable) {
        IPage<Setting> queryPage = PageUtil.toMybatisPage(pageable);
        IPage<Setting> page = settingMapper.selectPage(queryPage, QueryHelpMybatisPlus.getPredicate(query));
        return settingConverter.convertPage(page);
    }

    @Override
    public List<SettingDTO> queryAll(SettingQueryParam query){
        return settingConverter.toDto(settingMapper.selectList(QueryHelpMybatisPlus.getPredicate(query)));
    }

    @Override
    public Setting getEntityById(Long id) {
        return settingMapper.selectById(id);
    }

    @Override
    // @Cacheable(key = "'id:' + #p0")
    public SettingDTO getById(Long id) {
        return settingConverter.toDto(getEntityById(id));
    }

    @Override
    public SettingDTO getByKey(String keyName) {
        QueryWrapper<Setting> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Setting::getKey, keyName);
        return settingConverter.toDto(settingMapper.selectOne(wrapper));
    }

    @Override
    public String getValueByKey(String keyName) {
        QueryWrapper<Setting> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Setting::getKey, keyName);
        Setting setting = settingMapper.selectOne(wrapper);
        if (setting != null) {
            return setting.getValue();
        }
        return "";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(SettingDTO resources) {
        Setting entity = settingConverter.toEntity(resources);
        return settingMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(SettingDTO resources){
        Setting entity = settingConverter.toEntity(resources);
        int ret = settingMapper.updateById(entity);
        // delCaches(resources.id);
        return ret;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByIds(Set<Long> ids){
        // delCaches(ids);
        return settingMapper.deleteBatchIds(ids);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeById(Long id){
        Set<Long> set = new HashSet<>(1);
        set.add(id);
        return this.removeByIds(set);
    }

    /*
    private void delCaches(Long id) {
        redisUtils.delByKey(CACHE_KEY + "::id:", id);
    }

    private void delCaches(Set<Long> ids) {
        for (Long id: ids) {
            delCaches(id);
        }
    }*/
}
