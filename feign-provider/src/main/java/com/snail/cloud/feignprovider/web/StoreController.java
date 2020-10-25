package com.snail.cloud.feignprovider.web;

import com.snail.cloud.feignconsumer.feignclient.StoreClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 服务端
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/24 12:34
 */
@RestController
public class StoreController implements StoreClient {

    @Override
    public List<String> getStores(String name) {
        System.out.println(name);
        List<String>result= Arrays.asList("老刘","老张");
        return result;
    }
}
