package com.snail.cloud.eurekaclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class EurekaClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient1Application.class, args);
    }

}
