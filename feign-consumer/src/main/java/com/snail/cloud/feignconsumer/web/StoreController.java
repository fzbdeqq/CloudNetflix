package com.snail.cloud.feignconsumer.web;

import com.snail.cloud.feignconsumer.feignclient.StoreClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/24 12:34
 */
@RestController
public class StoreController {
    @Resource
    private StoreClient storeClient;

    @GetMapping("/hello")
    public String hello(String name){
        List<String>result=storeClient.getStores(name);
        result.stream().forEach(x->{
            System.out.println(x);
        });
        return "hello";
    }
}
