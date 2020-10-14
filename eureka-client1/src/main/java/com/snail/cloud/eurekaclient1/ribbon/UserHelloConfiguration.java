package com.snail.cloud.eurekaclient1.ribbon;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date 2020/10/14 14:57
 */
//@Configuration(proxyBeanMethods = false)
public class UserHelloConfiguration {
    @Bean
    public ZonePreferenceServerListFilter serverListFilter(){
        ZonePreferenceServerListFilter filter=new ZonePreferenceServerListFilter();
        filter.setZone("myTestZone");
        return filter;
    }
    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

//    @Autowired
//    IClientConfig ribbonClientConfig;
//
//    @Bean
//    public IPing ribbonPing(IClientConfig config) {
//        return new PingUrl();
//    }
//
//    @Bean
//    public IRule ribbonRule(IClientConfig config) {
//        return new AvailabilityFilteringRule();
//    }

}
