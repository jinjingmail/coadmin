/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.gitee.coadmin.exception.handler;

import com.gitee.coadmin.base.API;
import com.gitee.coadmin.exception.CoException;
import com.gitee.coadmin.utils.CoUtil;
import lombok.extern.slf4j.Slf4j;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.exception.EntityExistException;
import com.gitee.coadmin.exception.EntityNotFoundException;
import com.gitee.coadmin.utils.ThrowableUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * GlobalExceptionHandler 未捕获的异常，返回如下的样式：
 * {"timestamp":1602485174975,"status":500,"error":"Internal Server Error","message":"","path":"/api/users"}
 *
 * GlobalExceptionHandler 捕获的异常，返回如下的样式：
 * {"status":400,"timestamp":"2020-10-12 14:45:06","message":"/ by zero"}
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleException(Throwable e, HttpServletRequest request){
        log.error("handleException:{} path={}", e.getMessage(), CoUtil.getPath(request));
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return API.badRequest(e.getMessage()).responseEntity();
    }

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(CoException.class)
    public ResponseEntity<?> coException(CoException e, HttpServletRequest request){
        log.error("CoException:{} path={}", e.getMessage(), CoUtil.getPath(request));
        return API.badRequest(e.getMessage()).responseEntity();
    }

    /**
     * BadCredentialsException
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> badCredentialsException(Exception e, HttpServletRequest request){
        // 打印堆栈信息
        String message = "坏的凭证".equals(e.getMessage()) ? "用户名或密码不正确" : e.getMessage();
        log.error("badCredentialsException:{} path={}", message, CoUtil.getPath(request));
        return API.badRequest(message).responseEntity();
    }

    /**
     * 处理自定义异常
     */
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<?> badRequestException(BadRequestException e, HttpServletRequest request) {
        log.error("badRequestException:{} path={}", e.getMessage(), CoUtil.getPath(request));
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return API.response(e.getStatus(),e.getMessage(), null).responseEntity();
	}

    /**
     * 处理 EntityExist
     */
    @ExceptionHandler(value = EntityExistException.class)
    public ResponseEntity<?> entityExistException(EntityExistException e, HttpServletRequest request) {
        log.error("entityExistException:{} path={}", e.getMessage(), CoUtil.getPath(request));
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return API.badRequest(e.getMessage()).responseEntity();
    }

    /**
     * 处理 EntityNotFound
     */
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
        log.error("entityNotFoundException:{} path={}", e.getMessage(), CoUtil.getPath(request));
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return API.notFound(e.getMessage()).responseEntity();
    }

    /**
     * 处理所有接口数据验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        // 打印堆栈信息
        log.error("handleMethodArgumentNotValidException:{} path={}", e.getMessage(), CoUtil.getPath(request));
        String[] str = Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getCodes())[1].split("\\.");
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        if("不能为空".equals(message) || "不能为null".equals(message)){
            message = str[1] + ":" + message;
        }
        return API.badRequest(message).responseEntity();
    }
}
