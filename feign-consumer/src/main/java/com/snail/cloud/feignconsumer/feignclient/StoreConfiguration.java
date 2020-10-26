package com.snail.cloud.feignconsumer.feignclient;

import feign.Contract;
import org.springframework.context.annotation.Bean;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/24 23:11
 */
public class StoreConfiguration {
    @Bean
    public Contract feignContract(){
        return new Contract.Default();
    }
}
