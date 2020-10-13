package com.gitee.coadmin.app.modules.test.rest;

import com.gitee.coadmin.app.common.interceptor.AuthAccess;
import com.gitee.coadmin.app.common.util.R;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinjin on 2020-10-13.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {
    @AuthAccess
    @ApiOperation("测试登录（需授权）")
    @GetMapping(value = "/test_need_auth")
    public R test_need_auth() {
        return R.ok("success need_auth");
    }

    @AuthAccess(level = 0)
    @ApiOperation("测试登录（需授权，scope=0）")
    @GetMapping(value = "/test_need_auth_scope0")
    public R test_need_auth_scope9() {
        return R.ok("success need_auth scope0");
    }

    @ApiOperation("测试登录（无需授权）")
    @GetMapping(value = "/test_widthout_auth")
    public R test_widthout_auth() {
        return R.ok("success widthout_auth");
    }
}
