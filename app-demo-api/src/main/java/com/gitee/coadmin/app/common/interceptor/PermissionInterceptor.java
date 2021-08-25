package com.gitee.coadmin.app.common.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.gitee.coadmin.app.common.AppDemoConstants;
import com.gitee.coadmin.app.common.LocalUser;
import com.gitee.coadmin.app.common.util.JwtUtil;
import com.gitee.coadmin.app.domain.AppUser;
import com.gitee.coadmin.app.service.AppUserService;
import com.gitee.coadmin.exception.UnAuthenticatedException;
import com.gitee.coadmin.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

/**
 * 权限拦截器
 * @author hupeng
 * @date 2020-04-30
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AppUserService userService;

    @Autowired
    private RedisUtils redisUtils;

    public PermissionInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<AuthAccess> authCheck = this.getAuthCheck(handler);
        if (!authCheck.isPresent()) {
            return true;
        }

        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.isEmpty(bearerToken)) {
            throw new UnAuthenticatedException(HttpStatus.UNAUTHORIZED);
        }

        if (!bearerToken.startsWith("Bearer")) {
            throw new UnAuthenticatedException(HttpStatus.UNAUTHORIZED);
        }
        String[] tokens = bearerToken.split(" ");
        if (!(tokens.length == 2)) {
            throw new UnAuthenticatedException(HttpStatus.UNAUTHORIZED);
        }
        String token = tokens[1];

        //检测用户是否被踢出
        if(redisUtils.get(AppDemoConstants.APP_LOGIN_TOKEN + token) == null){
            throw new UnAuthenticatedException(HttpStatus.UNAUTHORIZED);
        }

        Optional<Map<String, Claim>> optionalMap = JwtUtil.getClaims(token);
        Map<String, Claim> map = optionalMap
                .orElseThrow(() -> new UnAuthenticatedException(HttpStatus.UNAUTHORIZED));


        boolean valid = this.hasPermission(authCheck.get(), map);
        if(valid){
            this.setToThreadLocal(map);
        }
        return valid;
    }

    private void setToThreadLocal(Map<String,Claim> map) {
        Long uid = map.get("uid").asLong();
        Integer level = map.get("level").asInt();
        AppUser user = userService.getById(uid);
        if(user == null) {
            throw new UnAuthenticatedException(HttpStatus.FORBIDDEN);
        }
        LocalUser.set(user, level);
    }

    private boolean hasPermission(AuthAccess authCheck, Map<String, Claim> map) {
        Integer level = authCheck.level();
        Integer levelUser = map.get("level").asInt();
        if (levelUser > level) {
            throw new UnAuthenticatedException(HttpStatus.FORBIDDEN);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalUser.clear();
        super.afterCompletion(request, response, handler, ex);
    }

    private Optional<AuthAccess> getAuthCheck(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AuthAccess authCheck = handlerMethod.getMethod().getAnnotation(AuthAccess.class);
            if (authCheck == null) {
                return Optional.empty();
            }
            return Optional.of(authCheck);
        }
        return Optional.empty();
    }

}
