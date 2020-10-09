package com.gitee.coadmin.modules.system.service;

import com.gitee.coadmin.base.BaseService;
import com.gitee.coadmin.modules.system.domain.Dept;
import com.gitee.coadmin.modules.system.service.dto.DeptCompactDto;
import com.gitee.coadmin.modules.system.service.dto.DeptDto;
import com.gitee.coadmin.modules.system.service.dto.DeptQueryParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
     * @param deptIds /
     * @return /
     */
    Object buildTree(LinkedHashSet<Long> deptIds);

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
}
