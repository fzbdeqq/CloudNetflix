package com.snail.cloud.eurekaserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/11 12:58
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/eureka/**").permitAll()
                .and()
                .csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
