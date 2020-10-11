package com.snail.cloud.eurekaclient1.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/10 23:26
 */
@RestController
public class HomeController {
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient discoveryClient;


    @GetMapping("/home")
    public String home(){
//        InstanceInfo instanceInfo=discoveryClient.getNextServerFromEureka("STORES",false);
//        System.out.println(instanceInfo.getHomePageUrl());
        return "Hello world";
    }
}
