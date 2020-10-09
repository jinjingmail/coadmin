package com.gitee.coadmin.base;

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

}
