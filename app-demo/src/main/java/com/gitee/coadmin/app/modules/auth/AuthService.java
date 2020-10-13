package com.gitee.coadmin.app.modules.auth;

import com.gitee.coadmin.app.common.AppDemoConstants;
import com.gitee.coadmin.app.domain.AppUser;
import com.gitee.coadmin.utils.EncryptUtils;
import com.gitee.coadmin.utils.RedisUtils;
import com.gitee.coadmin.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by ThinkPad on 2020-10-13.
 */
@Service
public class AuthService {

    @Value("${jwt.token-validity-in-seconds}")
    private Integer expiredTimeIn;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 保存在线用户信息
     * @param user /
     * @param token /
     * @param request /
     */
    public void save(AppUser user, String token, HttpServletRequest request) {
        String job = "yshop开发工程师";
        String ip = StringUtils.getIp(request);
        String browser = StringUtils.getBrowser(request);
        String address = StringUtils.getCityInfo(ip);
        /*OnlineUser onlineUser = null;
        try {
            onlineUser = new OnlineUser(yxUser.getUsername(), yxUser.getNickname(), job, browser ,
                    ip, address, EncryptUtils.desEncrypt(token), new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        redisUtils.set(AppDemoConstants.APP_LOGIN_TOKEN + token, onlineUser, AuthService.expiredTimeIn);*/
        redisUtils.set(AppDemoConstants.APP_LOGIN_TOKEN + token, user, expiredTimeIn);
    }
}
