/**
 * Copyright (C) 2018-2020
 * All rights reserved, Designed By www.yixiang.co
 * 注意：
 * 本软件为www.yixiang.co开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.gitee.coadmin.app.common.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller 返回结果
 * @author jinjin
 * @date 2020-10-13
 */
@Getter
@Setter
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "响应码")
    private int status;

    @ApiModelProperty(value = "响应消息")
    private String message;

    @ApiModelProperty(value = "响应数据")
    private T data;

    @ApiModelProperty(value = "响应时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date timestamp;

    public R() {
        timestamp  = new Date();
    }

    public static R<Boolean> result(boolean flag){
        if (flag){
            return ok();
        }
        return fail();
    }

    public static R<Boolean> result(HttpStatus apiCode){
        return result(apiCode,null);
    }

    public static <T> R<T> result(HttpStatus apiCode, T data){
        return result(apiCode,null,data);
    }

    public static <T> R<T> result(HttpStatus apiCode, String message, T data){
        if (StringUtils.isBlank(message)){
            message = apiCode.getReasonPhrase();
        }
        return R.<T>builder()
                .status(apiCode.value())
                .message(message)
                .data(data)
                .timestamp(new Date())
                .build();
    }

    public static R<Boolean> ok(){
        return ok(null);
    }

    public static <T> R<T> ok(T data){
        return result(HttpStatus.OK,data);
    }

    public static <T> R<T> ok(T data, String message){
        return result(HttpStatus.OK,message,data);
    }

    public static R<Map<String,Object>> okMap(String key, Object value){
        Map<String,Object> map = new HashMap<>(1);
        map.put(key,value);
        return ok(map);
    }

    public static R<Boolean> fail(HttpStatus apiCode){
        return result(apiCode,null);
    }

    public static R<String> fail(String message){
        return result(HttpStatus.INTERNAL_SERVER_ERROR, message,null);
    }

    public static <T> R<T> fail(HttpStatus apiCode, T data){
        if (HttpStatus.OK == apiCode){
            throw new RuntimeException("失败结果状态码不能为" + HttpStatus.OK.value());
        }
        return result(apiCode,data);
    }

    public static R<String> fail(Integer errorCode, String message){
        return new R<String>()
                .setStatus(errorCode)
                .setMessage(message);
    }

    public static R<Map<String,Object>> fail(String key, Object value){
        Map<String,Object> map = new HashMap<>(1);
        map.put(key,value);
        return result(HttpStatus.INTERNAL_SERVER_ERROR, map);
    }

    public static R<Boolean> fail() {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
