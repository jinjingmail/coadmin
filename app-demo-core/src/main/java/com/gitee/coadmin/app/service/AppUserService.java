package com.gitee.coadmin.app.service;

import com.gitee.coadmin.app.domain.AppUser;

/**
 * Created by ThinkPad on 2020-10-13.
 */
public interface AppUserService {
    AppUser getById(Long id);
}
