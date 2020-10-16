package com.snail.cloud.zuuldemo;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date 2020/10/15 17:28
 */
//@Configuration
public class ApplicationConfiguration {
//    @Bean
    public PatternServiceRouteMapper serviceRouteMapper(){
//       serviceId : myusers-v1 —— route:/v1/myusers/**
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }
}
