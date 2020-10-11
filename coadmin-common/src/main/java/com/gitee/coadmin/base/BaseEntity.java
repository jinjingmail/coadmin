package com.gitee.coadmin.base;

import cn.hutool.json.JSONUtil;

import java.io.Serializable;

/**
 * Created by jinjin on 2020-10-06.
 */
public class BaseEntity implements Serializable {

    /* 分组校验 */
    public @interface Create {}

    /* 分组校验 */
    public @interface Update {
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
