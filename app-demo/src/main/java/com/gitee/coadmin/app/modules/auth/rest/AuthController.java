package com.gitee.coadmin.app.modules.auth.rest;

import cn.hutool.core.util.StrUtil;
import com.gitee.coadmin.app.common.util.JwtUtil;
import com.gitee.coadmin.app.domain.AppUser;
import com.gitee.coadmin.app.modules.auth.AuthService;
import com.gitee.coadmin.app.modules.auth.param.UsernamePasswordLoginParam;
import com.gitee.coadmin.base.API;
import com.gitee.coadmin.exception.CoAuthException;
import com.gitee.coadmin.modules.logging.annotation.Log;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 鉴权
 * Created by jinjin on 2020-10-13.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    @Value("${single.login}")
    private Boolean singleLogin;

    private final AuthService authService;

    @Log("用户名密码登录")
    @ApiOperation("用户名密码登录授权")
    @PostMapping(value = "/login_pwd")
    public ResponseEntity<? extends API<?>> loginPwd(@Validated @RequestBody UsernamePasswordLoginParam loginDTO, HttpServletRequest request) {
        if ( ! (StrUtil.equals(loginDTO.getUsername(), "test") && StrUtil.equals(loginDTO.getPassword(), "123456")) ) {
            throw new CoAuthException("账号或者密码不正确");
        }

        AppUser appUser = new AppUser();
        appUser.setId(1L);
        appUser.setName(loginDTO.getUsername());

        String token =  JwtUtil.makeToken(appUser.getId());
        String expiresTimeStr = JwtUtil.getExpireTime(token);

        // 保存在线信息
        authService.save(appUser, token, request);
        // 返回 token
        Map<String, Object> map = new HashMap<String, Object>(2) {{
            put("token", token);
            put("expires_time", expiresTimeStr);
        }};

        if(singleLogin){
            //踢掉之前已经登录的token
            // TODO authService.checkLoginOnUser(loginDTO.getUsername(),token);
        }
        return API.ok("登陆成功", map).responseEntity();
    }
}
