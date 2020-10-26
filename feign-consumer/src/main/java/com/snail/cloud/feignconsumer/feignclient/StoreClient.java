package com.snail.cloud.feignconsumer.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 客户端
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/24 12:23
 */
@FeignClient(value = "feign-provider",
        url = "http://localhost:8002/",
        configuration =StoreConfiguration.class,
        primary = false
)
public interface StoreClient {

//    客户端：访问http://feign-provider/stores
//    @RequestMapping(method = RequestMethod.GET,value = "/stores")
    @GetMapping("/stores")
    List<String> getStores(@RequestParam(value = "name",defaultValue = "default") String name);
//    List<String> getStores(@SpringQueryMap String name);

}
