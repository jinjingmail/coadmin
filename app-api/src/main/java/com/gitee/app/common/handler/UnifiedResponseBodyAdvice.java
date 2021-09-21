package com.gitee.app.common.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.base.API;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * 统一给api发送的消息，增加头部
 */
@RestControllerAdvice
public class UnifiedResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private boolean isResultUnite(MethodParameter methodParameter) {
        Method method = methodParameter.getMethod();
        if (method == null) {
            return false;
        }
        if (method.isAnnotationPresent(UnifiedAPI.class)) {
            return method.getAnnotation(UnifiedAPI.class).enable();
        }
        return method.getDeclaringClass().isAnnotationPresent(UnifiedAPI.class);
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return isResultUnite(methodParameter);
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof API || o instanceof ResponseEntity) {
            return o;
        }
        // String 类型需要特殊处理
        if (StringHttpMessageConverter.class.getName().equals(selectedConverterType.getName())) {
            return objectMapper.writeValueAsString(API.ok(o));
        }
        return API.ok(o);
    }
}
