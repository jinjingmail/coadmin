package com.gitee.app.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.PageUtil;
import com.gitee.app.domain.AppUser;
import com.gitee.app.service.AppUserService;
import com.gitee.app.service.dto.AppUserDTO;
import com.gitee.app.service.dto.AppUserQueryParam;
import com.gitee.app.service.mapper.AppUserMapper;
import com.gitee.app.service.converter.AppUserConverter;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
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
 * @since 2021-09-20
 */
@Service
@RequiredArgsConstructor
// @CacheConfig(cacheNames = AppUserService.CACHE_KEY)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AppUserServiceImpl implements AppUserService {

    // private final RedisUtils redisUtils;
    private final AppUserMapper appUserMapper;
    private final AppUserConverter appUserConverter;

    @Override
    public PageInfo<AppUserDTO> queryAll(AppUserQueryParam query, Pageable pageable) {
        IPage<AppUser> queryPage = PageUtil.toMybatisPage(pageable);
        IPage<AppUser> page = appUserMapper.selectPage(queryPage, QueryHelpMybatisPlus.getPredicate(query));
        return appUserConverter.convertPage(page);
    }

    @Override
    public List<AppUserDTO> queryAll(AppUserQueryParam query){
        return appUserConverter.toDto(appUserMapper.selectList(QueryHelpMybatisPlus.getPredicate(query)));
    }

    @Override
    public AppUser getEntityById(Long id) {
        return appUserMapper.selectById(id);
    }

    @Override
    // @Cacheable(key = "'id:' + #p0")
    public AppUserDTO getById(Long id) {
        return appUserConverter.toDto(getEntityById(id));
    }

    @Override
    public AppUserDTO getByOpenid(String openid) {
        if (StrUtil.isBlank(openid)) {
            return null;
        }
        QueryWrapper<AppUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(AppUser::getOpenid, openid);
        return appUserConverter.toDto(appUserMapper.selectOne(wrapper));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(AppUserDTO res) {
        AppUser entity = appUserConverter.toEntity(res);
        int ret = appUserMapper.insert(entity);
        res.setId(entity.getId());
        return ret;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(AppUserDTO res){
        AppUser entity = appUserConverter.toEntity(res);
        int ret = appUserMapper.updateById(entity);
        // delCaches(res.id);
        return ret;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByIds(Set<Long> ids){
        // delCaches(ids);
        return appUserMapper.deleteBatchIds(ids);
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
