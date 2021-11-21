package com.gitee.coadmin.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.gitee.coadmin.modules.system.service.UserService;
import com.gitee.coadmin.modules.system.service.dto.UserDto;
import com.gitee.coadmin.utils.SpringContextHolder;

import java.io.IOException;

public class EnableDisableConverter implements Converter<Boolean> {

    public Class<?> supportJavaTypeKey() {
        return Boolean.class;
    }

    public WriteCellData<?> convertToExcelData(Boolean value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        if (value != null) {
            return new WriteCellData<>(value ? "启用" : "禁用");
        } else {
            return null;
        }
    }

}
