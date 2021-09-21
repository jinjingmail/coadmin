/**
 * Copyright (C) 2018-2020
 * All rights reserved, Designed By www.yixiang.co
 * 注意：
 * 本软件为www.yixiang.co开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.gitee.app.common;

import com.gitee.app.domain.AppUser;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局user
 * @author hupeng
 * @date 2020-04-30
 */
public class LocalUser {
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void set(AppUser user, Integer level) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("level", level);
        LocalUser.threadLocal.set(map);
    }

    public static void clear() {
        LocalUser.threadLocal.remove();
    }

    public static AppUser getUser() {
        Map<String, Object> map = LocalUser.threadLocal.get();
        AppUser user = (AppUser)map.get("user");
        return user;
    }

    public static Integer getLevel() {
        Map<String, Object> map = LocalUser.threadLocal.get();
        Integer level = (Integer)map.get("level");
        return level;
    }
}
