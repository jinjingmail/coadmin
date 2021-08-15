package com.gitee.coadmin.base;

import cn.hutool.http.HttpStatus;
//import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.valueOf;

/**
 * REST Api 接口返回数据公共部分。
 * @author jinjin
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class API<T> {
    /*
    http://www.ruanyifeng.com/blog/2014/05/restful_api.html
    服务器向用户返回的状态码和提示信息，常见的有以下一些（方括号中是该状态码对应的HTTP动词）
    200 OK - [*]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
    400 INVALID REQUEST - [*]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
    401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
    403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
    404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
    406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
    410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
    422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
    500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。

    自定义状态码：从 10000 到 99999
    */
    @ApiModelProperty(value = "响应码")
    private Integer status;

    @ApiModelProperty(value = "响应时间")
    //@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime timestamp;

    @ApiModelProperty(value = "响应消息")
    private String message;

    @ApiModelProperty(value = "响应数据")
    private T data;

    private API() {
        timestamp = LocalDateTime.now();
    }

    /**
     * 创建成功
     */
    public static <E> API<E> created(E data) {
        API<E> api = new API<>();
        api.setStatus(HttpStatus.HTTP_OK);
        api.setData(data);
        return api;
    }
    /**
     * 更新成功
     */
    public static <E> API<E> updated(E data) {
        API<E> api = new API<>();
        api.setStatus(HttpStatus.HTTP_OK);
        api.setData(data);
        return api;
    }
    /**
     * 删除成功
     */
    public static <E> API<E> deleted(E data) {
        API<E> api = new API<>();
        api.setStatus(HttpStatus.HTTP_OK);
        api.setData(data);
        return api;
    }
    /**
     * 正确返回
     */
    public static API<?> ok(){
        API<?> api = new API<>();
        api.setStatus(HttpStatus.HTTP_OK);
        return api;
    }
    /**
     * 正确返回（带数据）
     */
    public static <E> API<E> ok(E data){
        API<E> api = new API<>();
        api.setStatus(HttpStatus.HTTP_OK);
        api.setData(data);
        return api;
    }
    /**
     * 正确返回（带数据和message）
     */
    public static <E> API<E> ok(String message, E data){
        API<E> api = new API<>();
        api.setStatus(HttpStatus.HTTP_OK);
        api.setData(data);
        api.setMessage(message);
        return api;
    }

    /**
     * 自定义返回类型
     */
    public static <E> API<E> response(Integer status, String message, E data) {
        API<E> api = new API<>();
        api.setStatus(status);
        api.setMessage(message);
        api.setData(data);
        return api;
    }

    /**
     * 用户发出的请求有错误，服务器没有进行新建或修改数据的操作
     */
    public static API<?> badRequest(String message){
        API<?> api = new API<>();
        api.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        api.setMessage(message);
        return api;
    }
    /**
     * 用户发出的请求针对的是不存在的记录，服务器没有进行操作
     */
    public static API<?> notFound(String message){
        API<?> api = new API<>();
        api.setStatus(HttpStatus.HTTP_NOT_FOUND);
        api.setMessage(message);
        return api;
    }
    /**
     * 表示用户没有权限（令牌、用户名、密码错误）
     */
    public static API<?> unauthorized(String message){
        API<?> api = new API<>();
        api.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
        api.setMessage(message);
        return api;
    }
    /**
     * 表示用户得到授权（与401错误相对），但是访问是被禁止的
     */
    public static API<?> forbidden(String message){
        API<?> api = new API<>();
        api.setStatus(HttpStatus.HTTP_FORBIDDEN);
        api.setMessage(message);
        return api;
    }

    /**
     * 统一返回
     */
    public ResponseEntity<API<T>> responseEntity() {
        return new ResponseEntity<>(this, valueOf(this.getStatus()));
    }
}


