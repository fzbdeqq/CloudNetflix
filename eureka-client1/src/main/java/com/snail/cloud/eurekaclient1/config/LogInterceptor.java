package com.snail.cloud.eurekaclient1.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/11 23:20
 */
@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    private final static String traceId="traceId";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uuid=UUID.randomUUID().toString();
        MDC.put(traceId, uuid);
        log.info("preHandle:{}",uuid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String uuid=MDC.get(traceId);
        log.info("postHandle:{}",uuid);
        MDC.remove(traceId);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
