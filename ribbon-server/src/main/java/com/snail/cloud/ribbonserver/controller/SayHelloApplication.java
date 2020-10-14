package com.snail.cloud.ribbonserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date 2020/10/14 14:39
 */
@RestController
public class SayHelloApplication {

    @GetMapping(value = "/greeting")
    public String greet(){
        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }

    @GetMapping(value = "/")
    public String home(){
        return "Hi!";
    }

}
