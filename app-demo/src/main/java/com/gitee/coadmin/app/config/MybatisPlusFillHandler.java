package com.gitee.coadmin.app.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.gitee.coadmin.app.common.util.JwtUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * Created by jinjin on 2020-09-21.
 */
@Configuration
public class MybatisPlusFillHandler implements MetaObjectHandler{
    @Override
    public void insertFill(MetaObject metaObject) {
        Date currentTime = new Date();
        if (metaObject.hasSetter("createTime")) {
            setFieldValByName("createTime", currentTime, metaObject);
        }
        if (metaObject.hasSetter("createBy")) {
            setFieldValByName("createBy", getUsername(), metaObject);
        }
        if (metaObject.hasSetter("updateTime")) {
            setFieldValByName("updateTime", currentTime, metaObject);
        }
        if (metaObject.hasSetter("updateBy")) {
            setFieldValByName("updateBy", getUsername(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date currentTime = new Date();
        if (metaObject.hasSetter("updateTime")) {
            setFieldValByName("updateTime", currentTime, metaObject);
        }
        if (metaObject.hasSetter("updateBy")) {
            setFieldValByName("updateBy", getUsername(), metaObject);
        }
    }

    private String getUsername() {
        try {
            // TODO JwtUtil.
            //return SecurityUtils.getCurrentUsername();
            return "";
        } catch (Exception e) {
            return "";
        }
    }

}
