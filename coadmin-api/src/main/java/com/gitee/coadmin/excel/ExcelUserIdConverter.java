package com.gitee.coadmin.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.FileUtils;
import com.gitee.coadmin.modules.system.service.UserService;
import com.gitee.coadmin.modules.system.service.dto.UserDto;
import com.gitee.coadmin.utils.SpringContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

public class ExcelUserIdConverter implements Converter<Long> {

    public Class<?> supportJavaTypeKey() {
        return Long.class;
    }

    public WriteCellData<?> convertToExcelData(Long value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws IOException {
        UserDto userDto = SpringContextHolder.getBean(UserService.class).findById(value);
        if (userDto != null) {
            return new WriteCellData<>(userDto.getUsername());
        } else {
            return new WriteCellData<>(value+"");
        }
    }

}
