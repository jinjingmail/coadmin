package com.gitee.coadmin.modules.system.service;

import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.system.domain.Setting;
import com.gitee.coadmin.modules.system.service.dto.SettingDTO;
import com.gitee.coadmin.modules.system.service.dto.SettingQueryParam;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

/**
 * 系统参数
 * @author jinjin
 * @since 2021-09-19
 */
public interface SettingService {

    static final String CACHE_KEY = "system/setting";

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<SettingDTO>
    */
    PageInfo<SettingDTO> queryAll(SettingQueryParam query, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param query 条件参数
    * @return List<SettingDTO>
    */
    List<SettingDTO> queryAll(SettingQueryParam query);

    Setting getEntityById(Long id);
    SettingDTO getById(Long id);

    /**
     * 插入一条新数据。
     */
    int insert(SettingDTO resources);
    int updateById(SettingDTO resources);
    int removeById(Long id);
    int removeByIds(Set<Long> ids);

    SettingDTO getByKey(String keyName);
    String getValueByKey(String keyName);
}
