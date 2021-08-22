package com.gitee.coadmin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MysqlEngineEnum {
    InnoDB(10),
    MyISAM(20),
    MEMORY(30);

    @EnumValue
    @JsonValue    //标记响应json值
    private final Integer code;
}
