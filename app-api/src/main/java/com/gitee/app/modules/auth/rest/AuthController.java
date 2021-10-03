package com.gitee.app.modules.auth.rest;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.gitee.app.enums.AppUserChannelEnum;
import com.gitee.app.enums.AppUserGenderEnum;
import com.gitee.app.modules.app.vo.BizAppUser;
import com.gitee.app.modules.app.vo.BizLoginResult;
import com.gitee.app.modules.auth.param.UsernamePasswordLoginParam;
import com.gitee.app.service.AppUserService;
import com.gitee.app.service.dto.AppUserDTO;
import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.exception.CoException;
import com.gitee.coadmin.modules.logging.annotation.Log;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 鉴权
 * Created by jinjin on 2020-10-13.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final WxMpService wxMpService;
    private final WxMaService wxMaService;
    private final AppUserService appUserService;

    @Log("退出登录")
    @UnifiedAPI
    @ApiOperation("退出登录")
    @RequestMapping(value = "/logout")
    public void logout() {
        StpUtil.checkLogin();
    }

    @Log("用户信息")
    @UnifiedAPI
    @ApiOperation("用户信息")
    @RequestMapping(value = "/userinfo")
    public BizAppUser userinfo() {
        Long userId = StpUtil.getLoginIdAsLong();
        if (userId == 1L) {
            AppUserDTO appUser = new AppUserDTO();
            appUser.setId(1L);
            appUser.setNickname(TEST_USERNAME);
            appUser.setMobile("13800138000");
            appUser.setHeadimgurl("");

            return getBizAppUser(appUser);
        } else {
            AppUserDTO appUserDTO = appUserService.getById(userId);
            return getBizAppUser(appUserDTO);
        }
    }

    private final String TEST_USERNAME = "test";
    @Log("用户名密码登录")
    @UnifiedAPI
    @ApiOperation("用户名密码登录授权")
    @RequestMapping(value = "/login-pwd")
    public BizLoginResult loginPwd(@Validated @RequestBody UsernamePasswordLoginParam loginDTO) {
        if ( ! (StrUtil.equals(loginDTO.getUsername(), TEST_USERNAME) && StrUtil.equals(loginDTO.getPassword(), "123456")) ) {
            throw new CoException("账号或密码不正确");
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

    /**
     * 申请微信公众号测试账号的方法：
     * https://www.cnblogs.com/yimiyan/p/6594205.html
     * https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login
     */
    @Log("微信公众号登录")
    @UnifiedAPI
    @ApiOperation("微信公众号登录")
    @GetMapping(value = "/login-wxmp/{appId}")
    public BizLoginResult loginWxmp(@PathVariable String appId, @RequestParam String code, String state) {
        if (!this.wxMpService.switchover(appId)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的微信公众号配置，请核实！", appId));
        }

        WxOAuth2UserInfo wxUser = null;
        try {
            WxOAuth2AccessToken accessToken = wxMpService.getOAuth2Service().getAccessToken(code);
            wxUser = wxMpService.getOAuth2Service().getUserInfo(accessToken, "zh_CN");
            log.info("login_wxmp.user={}", JSONUtil.toJsonStr(wxUser));
        } catch (WxErrorException e) {
            log.error("WxErrorException", e);
            throw new CoException(e.getMessage());
        }

        AppUserDTO appUserDTO = appUserService.getByOpenid(wxUser.getOpenid());
        if (appUserDTO == null) {
            appUserDTO = newAppUserDTO(
                    AppUserChannelEnum.WXMP,
                    wxUser.getOpenid(), wxUser.getUnionId(), wxUser.getNickname(),
                    AppUserGenderEnum.create(wxUser.getSex()), wxUser.getHeadImgUrl(), wxUser.getCity(),
                    wxUser.getProvince(), wxUser.getCountry());
            appUserService.insert(appUserDTO);

        } else {
            if (!StrUtil.equals(appUserDTO.getNickname(), wxUser.getNickname())
                    || !StrUtil.equals(appUserDTO.getHeadimgurl(), wxUser.getHeadImgUrl())) {
                appUserDTO.setNickname(wxUser.getNickname());
                appUserDTO.setHeadimgurl(wxUser.getHeadImgUrl());
                appUserService.updateById(appUserDTO);
            }
        }

        if (!appUserDTO.getIsEnabled()) {
            throw new CoException("已被禁用");
        }

        StpUtil.login(appUserDTO.getId());

        BizAppUser bizAppUser = getBizAppUser(appUserDTO);

        BizLoginResult loginResult = new BizLoginResult();
        loginResult.setAppUser(bizAppUser);
        loginResult.setToken(StpUtil.getTokenValue());

        return loginResult;
    }
    /**
     * 微信小程序测试方法：
     * 1） 登录网页，创建测试号
     *     https://developers.weixin.qq.com/miniprogram/dev/devtools/sandbox.html
     *     https://mp.weixin.qq.com/wxamp/sandbox?doc=1
     * 2） 使用微信开发者工具，创建小程序，在“创建小程序”界面，选择“测试号”
     */
    @Log("微信小程序登录")
    @UnifiedAPI
    @ApiOperation("微信小程序登录")
    @PostMapping(value = "/login-wxma/{appId}")
    public BizLoginResult loginWxma(@PathVariable String appId, @RequestParam String code, String state) {
        if (!this.wxMaService.switchover(appId)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的微信小程序配置，请核实！", appId));
        }

        String sessionKey = null;
        String openId = null;
        String unionId = null;
        try {
            WxMaJscode2SessionResult maSession = wxMaService.getUserService().getSessionInfo(code);
            sessionKey = maSession.getSessionKey();
            openId = maSession.getOpenid();
            unionId = maSession.getUnionid();
            log.info("login_wxliteapp.openId={}", openId);
        } catch (WxErrorException e) {
            log.error("WxErrorException", e);
            throw new CoException(e.getMessage());
        }

        AppUserDTO appUserDTO = appUserService.getByOpenid(openId);
        if (appUserDTO == null) {
            appUserDTO = newAppUserDTO(
                    AppUserChannelEnum.WXMA,
                    openId, unionId, "",
                    null, null,
                    null, null, null);
            appUserService.insert(appUserDTO);

        }

        if (!appUserDTO.getIsEnabled()) {
            throw new CoException("已被禁用");
        }

        StpUtil.login(appUserDTO.getId());
        StpUtil.getSession().set("sessionKey", sessionKey);

        BizAppUser bizAppUser = getBizAppUser(appUserDTO);

        BizLoginResult loginResult = new BizLoginResult();
        loginResult.setAppUser(bizAppUser);
        loginResult.setToken(StpUtil.getTokenValue());

        return loginResult;
    }

    @Log("微信小程序用户信息")
    @UnifiedAPI
    @ApiOperation("微信小程序用户信息")
    @PostMapping(value = "/userinfo-wxma/{appId}")
    public BizAppUser loginWxma(@PathVariable String appId,
                                @RequestParam String signature,
                                @RequestParam String rawData,
                                @RequestParam String encryptedData,
                                @RequestParam String iv) {
        if (!this.wxMaService.switchover(appId)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的微信小程序配置，请核实！", appId));
        }

        String sessionKey = (String)StpUtil.getSession().get("sessionKey");
        if (!wxMaService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            throw new CoException("签名验证失败");
        }

        WxMaUserInfo userInfo = wxMaService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
        log.info("userinfo-wxma userInfo={}", JSONUtil.toJsonStr(userInfo));

        AppUserDTO userDTO = appUserService.getById(StpUtil.getLoginIdAsLong());
        userDTO.setNickname(userInfo.getNickName());
        userDTO.setGender(AppUserGenderEnum.create(Integer.valueOf(userInfo.getGender())));
        userDTO.setHeadimgurl(userInfo.getAvatarUrl());
        userDTO.setCity(userInfo.getCity());
        userDTO.setProvince(userInfo.getProvince());
        userDTO.setCountry(userInfo.getCountry());
        userDTO.setLang(userInfo.getLanguage());
        appUserService.updateById(userDTO);
        return getBizAppUser(userDTO);
    }

    private AppUserDTO newAppUserDTO(AppUserChannelEnum channelEnum,
                                     String openid, String unionid, String nickname, AppUserGenderEnum gender,
                                     String headimgUrl, String city, String province, String country) {
        AppUserDTO userDTO = new AppUserDTO();
        userDTO.setIsEnabled(true);
        userDTO.setChannel(channelEnum);
        userDTO.setOpenid(openid);
        userDTO.setUnionid(unionid);
        userDTO.setNickname(nickname);
        userDTO.setGender(gender);
        userDTO.setHeadimgurl(headimgUrl);
        userDTO.setCity(city);
        userDTO.setProvince(province);
        userDTO.setCountry(country);
        userDTO.setMobile(null);
        return userDTO;
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
