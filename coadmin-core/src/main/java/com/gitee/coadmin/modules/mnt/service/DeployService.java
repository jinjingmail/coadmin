package com.gitee.coadmin.modules.mnt.service;

import com.gitee.coadmin.base.BaseService;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.mnt.domain.Deploy;
import com.gitee.coadmin.modules.mnt.domain.DeployHistory;
import com.gitee.coadmin.modules.mnt.service.dto.DeployDto;
import com.gitee.coadmin.modules.mnt.service.dto.DeployQueryParam;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;
import java.util.Set;

/**
* @author jinjin
* @date 2020-09-27
*/
public interface DeployService  extends BaseService<Deploy> {

    static final String CACHE_KEY = "deploy";

    /**
    * 查询数据分页
    * @param query 条件
    * @param pageable 分页参数
    * @return PageInfo<DeployDto>
    */
    PageInfo<DeployDto> queryAll(DeployQueryParam query, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param query 条件参数
    * @return List<DeployDto>
    */
    List<DeployDto> queryAll(DeployQueryParam query);

    Deploy getById(Long id);
    DeployDto findById(Long id);

    /**
     * 插入一条新数据。
     */
    boolean save(DeployDto resources);
    boolean updateById(DeployDto resources);
    boolean removeById(Long id);
    boolean removeByIds(Set<Long> ids);

    void deploy(String fileSavePath, Long id);
    String serverStatus(DeployDto resources);
    String startServer(DeployDto resources);
    String stopServer(DeployDto resources);
    String serverReduction(DeployHistory resources);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<DeployDto> all, HttpServletResponse response) throws IOException;
}
