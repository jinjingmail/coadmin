package com.gitee.app.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppUserChannelEnum {
    WXMP(1),
    WXLITEAPP(2);

    @EnumValue
    @JsonValue    //标记响应json值
    private final Integer code;

    @JsonCreator
    public static AppUserChannelEnum create(Integer value) {
        for (AppUserChannelEnum v: values()) {
            if (v.code.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("AppUserChannelEnum No element matches "+value);
    }
}
