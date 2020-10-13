package com.snail.cloud.eurekaclient1.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/10 23:26
 */
@RestController
@Slf4j
public class HomeController {

//THREAD(线程隔离）：使用该方式，HystrixCommand将会在单独的线程上执行，并发请求受线程池中线程数量的限制。
//SEMAPHORE（信号量隔离）：使用该方式，HystrixCommand将会在调用线程上执行，开销相对较小，并发请求受到信号量个数的限制。
    @GetMapping("/home")
    @HystrixCommand(fallbackMethod = "defaultStores",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE"),
//            @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public String home() throws InterruptedException {

//        HystrixCommandProperties
        int sleep=new Random().nextInt(1500);
        Thread.sleep(sleep);
        log.info("home");
        return "Hello world";
    }

    public String defaultStores(){
        log.info("defaultStores");
        return "熔断打开";
    }
}
