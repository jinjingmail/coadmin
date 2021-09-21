package com.gitee.app.modules.auth.rest;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.StrUtil;
import com.gitee.app.domain.AppUser;
import com.gitee.app.modules.app.vo.BizAppUser;
import com.gitee.app.modules.app.vo.BizLoginResult;
import com.gitee.app.modules.auth.param.UsernamePasswordLoginParam;
import com.gitee.app.service.dto.AppUserDTO;
import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.exception.CoAuthException;
import com.gitee.coadmin.modules.logging.annotation.Log;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/auth")
public class AuthController {

    @Log("用户名密码登录")
    @UnifiedAPI
    @ApiOperation("用户名密码登录授权")
    @GetMapping(value = "/login_pwd")
    public BizLoginResult loginPwd(@Validated UsernamePasswordLoginParam loginDTO) {
        if ( ! (StrUtil.equals(loginDTO.getUsername(), "test") && StrUtil.equals(loginDTO.getPassword(), "123456")) ) {
            throw new CoAuthException("账号或者密码不正确");
        }

        AppUserDTO appUser = new AppUserDTO();
        appUser.setId(1L);
        appUser.setNickname(loginDTO.getUsername());
        appUser.setMobile("13800138000");
        appUser.setHeadimgurl("");

        StpUtil.login(appUser.getId());

        BizAppUser bizAppUser = getBizAppUser(appUser);

        BizLoginResult loginResult = new BizLoginResult();
        loginResult.setAppUser(bizAppUser);
        loginResult.setToken(StpUtil.getTokenValue());

        return loginResult;
    }

    private BizAppUser getBizAppUser(AppUserDTO appUser) {
        BizAppUser bizAppUser = new BizAppUser();
        bizAppUser.setNickname(appUser.getNickname());
        bizAppUser.setHeadimgurl(appUser.getHeadimgurl());
        bizAppUser.setMobile(DesensitizedUtil.mobilePhone(appUser.getMobile()));
        bizAppUser.setIsRegistered(appUser.checkIsRegistered());
        return bizAppUser;
    }
}
