package com.gitee.app.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppUserGenderEnum {
    MALE(1),
    FEMALE(2),
    UNKNOWN(3);

    @EnumValue
    @JsonValue    //标记响应json值
    private final Integer code;

    @JsonCreator
    public static AppUserGenderEnum create(Integer value) {
        for (AppUserGenderEnum v: values()) {
            if (v.code.equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("AppUserGenderEnum No element matches "+value);
    }
}
