package com.gitee.coadmin.base;

import cn.afterturn.easypoi.excel.annotation.Excel;
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

    @Excel(name = "创建人")
    private String createBy;

    @Excel(name = "更新人")
    private String updateBy;

    @Excel(name = "创建时间", format = "yyyy-MM-dd")
    private Date createTime;

    @Excel(name = "更新时间", format = "yyyy-MM-dd")
    private Date updateTime;

}
