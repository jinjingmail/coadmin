package com.gitee.coadmin.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by jinjin on 2020-10-13.
 */
public class UnAuthenticatedException extends CoException {
    public UnAuthenticatedException(String message) {
        super(message);
    }

    public UnAuthenticatedException(Integer errorCode, String message) {
        super(errorCode, message);
    }

    public UnAuthenticatedException(HttpStatus apiCode) {
        super(apiCode);
    }
}
