package com.gitee.coadmin.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Created by jinjin on 2020-10-13.
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class CoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer errorCode;
    private String message;

    public CoException() {
        super();
    }

    public CoException(String message) {
        super(message);
        this.message = message;
    }

    public CoException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public CoException(HttpStatus apiCode) {
        super(apiCode.getReasonPhrase());
        this.errorCode = apiCode.value();
        this.message = apiCode.getReasonPhrase();
    }

    public CoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoException(Throwable cause) {
        super(cause);
    }
}
