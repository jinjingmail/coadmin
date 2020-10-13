package com.gitee.coadmin.app.service.impl;

import com.gitee.coadmin.app.domain.AppUser;
import com.gitee.coadmin.app.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jinjin on 2020-10-13.
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AppUserServiceImpl implements AppUserService{
    public AppUser getById(Long id) {
        AppUser user = new AppUser();
        user.setId(id);
        user.setName("noname");
        return user;
    }
}
