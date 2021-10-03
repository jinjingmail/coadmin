package com.gitee.app.service;

import com.gitee.coadmin.base.PageInfo;
import com.gitee.app.domain.AppUser;
import com.gitee.app.service.dto.AppUserDTO;
import com.gitee.app.service.dto.AppUserQueryParam;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
 * APP用户
 * @author jinjin
 * @since 2021-09-20
 */
public interface AppUserService {

    static final String CACHE_KEY = "app/app-user";

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<AppUserDTO>
    */
    PageInfo<AppUserDTO> queryAll(AppUserQueryParam query, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param query 条件参数
    * @return List<AppUserDTO>
    */
    List<AppUserDTO> queryAll(AppUserQueryParam query);

    AppUser getEntityById(Long id);
    AppUserDTO getById(Long id);

    /**
     * 插入一条新数据。
     */
    int insert(AppUserDTO resources);
    int updateById(AppUserDTO resources);
    int removeById(Long id);
    int removeByIds(Set<Long> ids);

    AppUserDTO getByOpenid(String openid);
}
