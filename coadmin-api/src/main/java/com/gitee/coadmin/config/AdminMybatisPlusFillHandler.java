package com.gitee.coadmin.config;

import java.util.Date;

import com.gitee.coadmin.utils.SecurityUtils;
import com.gitee.coadmin.utils.PinyinUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * Created by jinjin on 2020-09-21.
 */
@Configuration
public class AdminMybatisPlusFillHandler implements MetaObjectHandler{

    private final String[] pinyinFields = new String[] {"name", "nickname", "label", "description", "treeNames", "title"};

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
        for (String field: pinyinFields) {
            if (metaObject.hasSetter(field + "Letter")) {
                Object o = metaObject.getValue(field);
                if (o != null) {
                    setFieldValByName(field + "Letter", PinyinUtil.getAllFirstPinyin(o.toString()), metaObject);
                }
            }
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
        for (String field: pinyinFields) {
            if (metaObject.hasSetter(field + "Letter")) {
                Object o = metaObject.getValue(field);
                if (o != null) {
                    setFieldValByName(field + "Letter", PinyinUtil.getAllFirstPinyin(o.toString()), metaObject);
                }
            }
        }
    }

    private String getUsername() {
        try {
            return SecurityUtils.getCurrentUsername();
        } catch (Exception e) {
            return "";
        }
    }

}
