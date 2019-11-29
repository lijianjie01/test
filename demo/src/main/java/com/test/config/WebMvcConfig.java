package com.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringBoot添加跨域设置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //需要跨域访问的Map路径
                .allowedHeaders("*") //允许跨域访问的Headers内容
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE") //允许跨域访问的方法，OPTIONS必须设置Shiro中用到
                .allowedOrigins("*") // 允许跨域访问的ip及端口
                .allowCredentials(true);
    }
}
