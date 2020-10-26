package com.snail.cloud.feignconsumer.web;

import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/26 22:11
 */
@Import(FeignClientsConfiguration.class)
public class FooController {

}
