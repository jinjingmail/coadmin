package com.gitee.coadmin.base;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 浅析VO、DTO、DO、PO的概念、区别和用处
 * https://www.cnblogs.com/qixuejia/p/4390086.html
 *
 * Created by jinjin on 2020-09-22.
 */
@Getter
@Setter
public abstract class DataDto extends BaseDto {

    @ExcelProperty("创建人")
    @ColumnWidth(20)
    private String createBy;

    @ExcelProperty("更新人")
    @ColumnWidth(20)
    private String updateBy;

    @ExcelProperty("创建时间")
    @ColumnWidth(20)
    private Date createTime;

    @ExcelProperty("更新时间")
    @ColumnWidth(20)
    private Date updateTime;

}
