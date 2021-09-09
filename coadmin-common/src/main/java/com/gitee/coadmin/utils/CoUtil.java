package com.gitee.coadmin.utils;

import javax.servlet.http.HttpServletRequest;

public class CoUtil {
    public static String getPath(HttpServletRequest request) {
        return request.getRequestURI();
    }
}
