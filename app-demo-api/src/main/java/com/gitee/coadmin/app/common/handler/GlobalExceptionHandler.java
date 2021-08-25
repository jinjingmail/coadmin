package com.gitee.coadmin.app.common.handler;

import com.gitee.coadmin.base.API;
import com.gitee.coadmin.exception.CoAuthException;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.exception.EntityExistException;
import com.gitee.coadmin.exception.EntityNotFoundException;
import com.gitee.coadmin.utils.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * GlobalExceptionHandler 未捕获的异常，返回如下的样式：
 * {"timestamp":1602485174975,"status":500,"error":"Internal Server Error","message":"","path":"/api/users"}
 *
 * GlobalExceptionHandler 捕获的异常，返回如下的样式：
 * {"status":400,"timestamp":"2020-10-12 14:45:06","message":"/ by zero"}
 * @author jinjin
 * @date 2020-10-13
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleException(Throwable e){
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return API.badRequest(e.getMessage()).responseEntity();
    }

    /**
     * BadCredentialsException
     */
    @ExceptionHandler(CoAuthException.class)
    public ResponseEntity<?> badCredentialsException(CoAuthException e){
        // 打印堆栈信息
        String message = "坏的凭证".equals(e.getMessage()) ? "用户名或密码不正确" : e.getMessage();
        log.error(message);
        return API.unauthorized(message).responseEntity();
    }

    /**
     * 处理自定义异常
     */
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<?> badRequestException(BadRequestException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return API.response(e.getStatus(), e.getMessage(), null).responseEntity();
	}

    /**
     * 处理 EntityExist
     */
    @ExceptionHandler(value = EntityExistException.class)
    public ResponseEntity<?> entityExistException(EntityExistException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return API.badRequest(e.getMessage()).responseEntity();
    }

    /**
     * 处理 EntityNotFound
     */
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFoundException(EntityNotFoundException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return API.notFound(e.getMessage()).responseEntity();
    }

    /**
     * 处理所有接口数据验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        String[] str = Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getCodes())[1].split("\\.");
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String msg = "不能为空";
        if(msg.equals(message)){
            message = str[1] + ":" + message;
        }
        return API.badRequest(message).responseEntity();
    }
}
