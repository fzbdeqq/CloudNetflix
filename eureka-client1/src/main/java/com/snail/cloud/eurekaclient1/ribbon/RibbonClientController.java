package com.snail.cloud.eurekaclient1.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date 2020/10/14 14:53
 */
@RestController
public class RibbonClientController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="Artaban") String name) {
//        restTemplate
//        String greeting = this.restTemplate.getForObject("http://localhost:8090/greeting", String.class);

        String greeting = this.restTemplate.getForObject("http://say-hello/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }
    @GetMapping("/hi1")
    public String hi1(@RequestParam(value="name", defaultValue="Artaban") String name){
        ServiceInstance instance=loadBalancer.choose("say-hello");
//        URI hello=URI.create(String.format("http://%s:%s/greeting",instance.getPort()));
        URI hello=URI.create(String.format("http://say-hello:%s/greeting",instance.getPort()));
        String greeting = this.restTemplate.getForObject(hello, String.class);
        return String.format("%s, %s!", greeting, name);
    }

}
