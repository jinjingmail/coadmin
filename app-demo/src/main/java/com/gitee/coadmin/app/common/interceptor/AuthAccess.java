package com.gitee.coadmin.app.common.interceptor;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义权限
 * @Author jinjin
 * @Date 2020-10-13
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthAccess {
    /**
     * 范围0-99，数字越小，权限级别越高。
     * 用户登录后会获得一个level，如果用户level小于等于 AuthAccess.level，则有权访问该资源。
     */
    int level() default 9;
}
