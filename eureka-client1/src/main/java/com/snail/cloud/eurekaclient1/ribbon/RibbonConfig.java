package com.snail.cloud.eurekaclient1.ribbon;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date 2020/10/14 14:54
 */
//@Configuration
//@RibbonClient(name = "say-hello", configuration = {SayHelloConfiguration.class,UserHelloConfiguration.class})
public class RibbonConfig {

//    @LoadBalanced
//    @Bean(name = "restTemplate")
//    RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
}
