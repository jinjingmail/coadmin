package com.gitee.coadmin.base;

import cn.hutool.json.JSONUtil;

import java.io.Serializable;

/**
 * Created by jinjin on 2020-10-06.
 */
public abstract class BaseDto implements Serializable {
    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
