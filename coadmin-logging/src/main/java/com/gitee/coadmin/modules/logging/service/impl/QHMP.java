package com.gitee.coadmin.modules.logging.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gitee.coadmin.annotation.Query;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by jinjin on 2020-10-13.
 */
@Slf4j
abstract class QHMP {

    public static <R, Q> QueryWrapper<R> getPredicate(Q query) {
        QueryWrapper<R> queryWrapper = new QueryWrapper<>();
        if (query == null) {
            return queryWrapper;
        }
        try {
            List<Field> fields = getAllFields(query.getClass(), new ArrayList<>());
            for (Field field : fields) {
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                Query q = field.getAnnotation(Query.class);
                if (q != null) {
                    String propName = q.propName();
                    String blurry = q.blurry();
                    String blurryEq = q.blurryEq();
                    String blurryLikeRight = q.blurryLikeRight();
                    String attributeName = StrUtil.isBlank(propName) ? field.getName() : propName;
                    attributeName = humpToUnderline(attributeName);
                    Class<?> fieldType = field.getType();
                    Object val = field.get(query);
                    if (ObjectUtil.isNull(val) || "".equals(val)) {
                        continue;
                    }
                    // 模糊多字段
                    if (ObjectUtil.isNotEmpty(blurry)) {
                        String[] blurrys = blurry.split(",");
                        queryWrapper.and(wrapper -> {
                            for (String blurry1 : blurrys) {
                                String column = humpToUnderline(blurry1);
                                wrapper.or();
                                wrapper.like(column, val.toString());
                            }
                        });
                        continue;
                    }
                    if (ObjectUtil.isNotEmpty(blurryEq)) {
                        String[] blurrys = blurryEq.split(",");
                        queryWrapper.and(wrapper -> {
                            for (String blurry1 : blurrys) {
                                String column = humpToUnderline(blurry1);
                                wrapper.or();
                                wrapper.eq(column, val.toString());
                            }
                        });
                        continue;
                    }
                    if (ObjectUtil.isNotEmpty(blurryLikeRight)) {
                        String[] blurrys = blurryLikeRight.split(",");
                        queryWrapper.and(wrapper -> {
                            for (String blurry1 : blurrys) {
                                String column = humpToUnderline(blurry1);
                                wrapper.or();
                                wrapper.likeRight(column, val.toString());
                            }
                        });
                        continue;
                    }
                    String finalAttributeName = attributeName;
                    switch (q.type()) {
                        case EQUAL:
                            queryWrapper.eq(attributeName, val);
                            break;
                        case GREATER_THAN:
                            queryWrapper.gt(finalAttributeName, val);
                            break;
                        case GREATER_THAN_EQ:
                            queryWrapper.ge(finalAttributeName, val);
                            break;
                        case LESS_THAN:
                            queryWrapper.lt(finalAttributeName, val);
                            break;
                        case LESS_THAN_EQ:
                            queryWrapper.le(finalAttributeName, val);
                            break;
                        case INNER_LIKE:
                            queryWrapper.like(finalAttributeName, val);
                            break;
                        case LEFT_LIKE:
                            queryWrapper.likeLeft(finalAttributeName, val);
                            break;
                        case RIGHT_LIKE:
                            queryWrapper.likeRight(finalAttributeName, val);
                            break;
                        case IN:
                            if (CollUtil.isNotEmpty((Collection<Long>) val)) {
                                queryWrapper.in(finalAttributeName, (Collection<Long>) val);
                            }
                            break;
                        case IN_SQL: {
                            String sql = q.sql();
                            sql = StrUtil.replace(sql, "?", val.toString());
                            queryWrapper.inSql(finalAttributeName, sql);
                        }
                        break;
                        case NOT_EQUAL:
                            queryWrapper.ne(finalAttributeName, val);
                            break;
                        case NOT_NULL:
                            queryWrapper.isNotNull(finalAttributeName);
                            break;
                        case IS_NULL:
                            queryWrapper.isNull(finalAttributeName);
                            break;
                        case BETWEEN:
                            List<Object> between = new ArrayList<>((List<Object>) val);
                            queryWrapper.between(finalAttributeName, between.get(0), between.get(1));
                            break;
                        default:
                            break;
                    }
                }
                field.setAccessible(accessible);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return queryWrapper;

    }

    public static List<Field> getAllFields(Class clazz, List<Field> fields) {
        if (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            getAllFields(clazz.getSuperclass(), fields);
        }
        return fields;
    }

    /***
     * 驼峰命名转为下划线命名
     *
     * @param para
     *        驼峰命名的字符串
     */

    public static String humpToUnderline(String para) {
        StringBuilder sb = new StringBuilder(para);
        int temp = 0;
        if (!para.contains("_")) {
            for (int i = 0; i < para.length(); i++) {
                if (Character.isUpperCase(para.charAt(i))) {
                    sb.insert(i + temp, "_");
                    temp += 1;
                }
            }
        }
        return sb.toString();
    }
}
