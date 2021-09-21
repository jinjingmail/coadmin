package com.gitee.app.modules.test.rest;

import com.gitee.coadmin.annotation.UnifiedAPI;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinjin on 2020-10-13.
 * 测试方法：
 * 平时访问 localhost:8003/test_need_auth，会提示没有权限（Unauthorized）。
 * 需要构造一个 POST 方法，发送用户名（test）密码（123456）到 localhost:8003/login_pwd，
 * 登录成功会受到一个token，把这个 token 放入 test_need_auth GET 请求的 Authorization 字段中，
 * 这时再访问 localhost:8003/test_need_auth 就会提示成功。
 */
@Slf4j
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class TestController {
    @ApiOperation("测试登录（需授权）")
    @GetMapping(value = "/test_need_auth")
    public String test_need_auth() {
        return "success need_auth";
    }

    @ApiOperation("测试登录（无需授权）")
    @GetMapping(value = "/test_widthout_auth")
    public String test_widthout_auth() {
        return "success widthout_auth";
    }
}
