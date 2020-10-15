package com.snail.cloud.zuuldemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableHystrix
public class ZuulDemoApplication {
//Zuul starter does not include a discovery client
    public static void main(String[] args) {
        SpringApplication.run(ZuulDemoApplication.class, args);
    }
    @HystrixCommand(defaultFallback = "",commandProperties = {
            @HystrixProperty(name = "",value = "")
    })
    public void test(){}
}
