package com.snail.cloud.feignconsumer.feignclient;

import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.hystrix.HystrixFeign;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.loadbalancer.FeignBlockingLoadBalancerClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/24 23:11
 */
@Slf4j
public class StoreConfiguration {
//    @Bean
//    public Contract feignContract(){
//        log.info("feignContract");
//        return new Contract.Default();
//    }

//    @Bean
//    public Decoder feignDecoder(){
//        log.info("feignDecoder");
//        return new Decoder.Default();
//    }
//
//    @Bean
//    public Encoder feignEncoder(){
//        log.info("feignDecoder");
//        return new Encoder.Default();
//    }

    @Bean
    public Logger feignLogger(){
        log.info("feignDecoder");
        return new Slf4jLogger();
    }
    @Bean
    public Feign.Builder feignBuilder(){
        log.info("feignDecoder");
        return new HystrixFeign.Builder();
    }
//    @Bean
//    public Client feignClient(){
//        return new FeignBlockingLoadBalancerClient()
//    }

}
