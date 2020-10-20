package com.snail.cloud.zuuldemo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/20 21:21
 */
//@Component
public class CORSConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/ec1/**")
                .allowedOrigins("https://allowed-origin.com")
                .allowedMethods("GET","POST");
    }
}
