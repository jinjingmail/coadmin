/**
 * Copyright (C) 2018-2020
 * All rights reserved, Designed By www.yixiang.co
 * 注意：
 * 本软件为www.yixiang.co开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.gitee.coadmin.app.config;

import com.gitee.coadmin.app.common.interceptor.PermissionInterceptor;
import com.gitee.coadmin.config.FileProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

/**
 * @ClassName 拦截器配置
 * @Author hupeng <610796224@qq.com>
 * @Date 2020/4/30
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /*
    @Value("${file.path}")
    private String path;

    @Value("${file.avatar}")
    private String avatar;*/

    @Autowired
    private FileProperties properties;

    @Bean
    public HandlerInterceptor getPermissionInterceptor() {
        return new PermissionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.getPermissionInterceptor());
    }

    @Bean
    public CorsFilter corsFilter()  {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //config.addAllowedOrigin("*");
        //config.addAllowedHeader("*");
        //config.addAllowedMethod("*");
        //1,允许任何来源
        config.setAllowedOriginPatterns(Collections.singletonList("*"));
        //2,允许任何请求头
        config.addAllowedHeader(CorsConfiguration.ALL);
        //3,允许任何方法
        config.addAllowedMethod(CorsConfiguration.ALL);
        //4,允许凭证
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String avatarUtl = "file:" + properties.getPath().getAvatar().replace("\\","/");
        String pathUtl = "file:" + properties.getPath().getPath().replace("\\","/");
        registry.addResourceHandler("/avatar/**").addResourceLocations(avatarUtl).setCachePeriod(0);
        registry.addResourceHandler("/file/**").addResourceLocations(pathUtl).setCachePeriod(0);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
    }
}
