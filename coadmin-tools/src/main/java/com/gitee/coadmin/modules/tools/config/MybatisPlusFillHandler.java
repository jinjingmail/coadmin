package com.gitee.coadmin.modules.tools.config;

import java.util.Date;

import com.gitee.coadmin.modules.tools.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * Created by jinjin on 2020-09-21.
 */
@Configuration
public class MybatisPlusFillHandler implements MetaObjectHandler{
    @Override
    public void insertFill(MetaObject metaObject) {
        Date currentTime = new Date();
        strictInsertFill(metaObject, "createTime", Date.class, currentTime);
        strictInsertFill(metaObject, "createBy", String.class, getUsername());
        strictUpdateFill(metaObject, "updateTime", Date.class, currentTime);
        strictUpdateFill(metaObject, "updateBy", String.class, getUsername());
        /*
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
        }*/
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date currentTime = new Date();
        strictUpdateFill(metaObject, "updateTime", Date.class, currentTime);
        strictUpdateFill(metaObject, "updateBy", String.class, getUsername());
        /*
        if (metaObject.hasSetter("updateTime")) {
            setFieldValByName("updateTime", currentTime, metaObject);
        }
        if (metaObject.hasSetter("updateBy")) {
            setFieldValByName("updateBy", getUsername(), metaObject);
        }*/
    }

    private String getUsername() {
        try {
            return SecurityUtils.getCurrentUsername();
        } catch (Exception e) {
            return "";
        }
    }

}
