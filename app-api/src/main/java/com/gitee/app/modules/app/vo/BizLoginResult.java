package com.gitee.app.modules.app.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BizLoginResult {
    /**
     * 登录用户信息
     */
    private BizAppUser appUser;
    /**
     * 鉴权标识
     */
    private String token;
}
