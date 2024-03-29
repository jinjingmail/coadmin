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
package com.gitee.coadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

/**
 * WebMvcConfigurer
 *
 * @author Zheng Jie
 * @date 2018-11-30
 */
@Configuration
//@EnableWebMvc
public class WebConfigurer implements WebMvcConfigurer {

    /** 文件配置 */
    private final com.gitee.coadmin.config.FileProperties properties;

    public WebConfigurer(com.gitee.coadmin.config.FileProperties properties) {
        this.properties = properties;
    }

    /**
     * 提示：如果使用nginx做代理网关，建议关闭spring里的跨域，在nginx里面配置跨域。
     */
    @Bean
    public CorsFilter corsFilter() {
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
        com.gitee.coadmin.config.FileProperties.ElPath path = properties.getPath();
        String avatarUtl = "file:" + path.getAvatar().replace("\\","/");
        String pathUtl = "file:" + path.getPath().replace("\\","/");
        registry.addResourceHandler("/avatar/**").addResourceLocations(avatarUtl).setCachePeriod(0);
        registry.addResourceHandler("/file/**").addResourceLocations(pathUtl).setCachePeriod(0);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);

        /*
         * 第一个方法设置访问路径前缀，第二个方法设置资源路径
         * 将vue编译得到的文件，放到 resources/static 目录中，使用springboot的tomcat运行vue
         */
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
