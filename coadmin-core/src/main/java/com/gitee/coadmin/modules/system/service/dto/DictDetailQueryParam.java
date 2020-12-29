package com.gitee.coadmin.modules.system.service.dto;

import lombok.Data;
import com.gitee.coadmin.annotation.Query;

/**
* @author jinjin
* @date 2020-09-24
*/
@Data
public class DictDetailQueryParam{

    @Query(blurry = "id,label,value")
    private String blurry;

    private String dictName;

    /** 精确 */
    @Query
    private Long detailId;

    /** 精确 */
    @Query
    private Long dictId;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String label;
}
