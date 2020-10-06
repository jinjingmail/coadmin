package com.gitee.coadmin.modules.generator.service.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gitee.coadmin.base.CommonMapper;
import com.gitee.coadmin.modules.generator.domain.vo.TableInfo;
import com.gitee.coadmin.modules.generator.domain.ColumnInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author jinjin
* @date 2020-09-25
*/
@Repository
public interface ColumnInfoMapper extends CommonMapper<ColumnInfo> {

    List<TableInfo> getTables();

    int getTablesTotal();

    IPage<TableInfo> selectPageOfTables(IPage<?> page, @Param("name") String tableName);

    List<ColumnInfo> queryColumnInfo(String tableName);
}
