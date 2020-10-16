package com.snail.cloud.zuuldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulDemoApplication {
//Zuul starter does not include a discovery client
//if you use @EnableZuulProxy with the Spring Boot Actuator, you enable two additional endpoints:
// routes、filters
// http://localhost:8888/actuator/routes/details
    public static void main(String[] args) {
        SpringApplication.run(ZuulDemoApplication.class, args);
    }

}
