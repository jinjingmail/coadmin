package com.gitee.coadmin.modules.system.service;

import com.gitee.coadmin.base.BaseService;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.system.domain.Dept;
import com.gitee.coadmin.modules.system.service.dto.DeptCompactDto;
import com.gitee.coadmin.modules.system.service.dto.DeptDto;
import com.gitee.coadmin.modules.system.service.dto.DeptQueryParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
* @author jinjin
* @date 2020-09-25
*/
public interface DeptService extends BaseService<Dept> {
    List<Dept> findByPid(long pid);

    /**
     * 构建树形数据
     * @return /
     */
    PageInfo<DeptCompactDto> buildTree(DeptQueryParam query, Long userId);

    Dept getById(Long id);
    DeptDto findById(Long id);

    /**
     * 插入一条新数据。
     */
    boolean save(Dept resources);
    boolean updateById(DeptCompactDto resources);
    boolean removeById(Long id);
    boolean removeByIds(Set<Long> ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<DeptDto> all, HttpServletResponse response) throws IOException;

    List<DeptDto> queryAll(DeptQueryParam criteria, Boolean query);

    /**
     * 父机构的所有递归子机构id
     * @param pidList
     * @return
     */
    List<Long> querySubDeptIdByPids(List<Long> pidList, Boolean enabled);

    /**
     * 查询用户对应的机构id（如果有权限的话，也包含所有递归子机构id）
     * TODO 用户的每个机构，可以设置只看本机构，还是包含子机构
     * @param userId
     * @return
     */
    List<Long> queryDeptIdAllByUserId(Long userId, Boolean enabled);
}
