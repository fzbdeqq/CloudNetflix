package com.snail.cloud.zuuldemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/20 21:39
 */
@Slf4j
@Component
public class QueryParamPreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        log.info("QueryParamPreFilter");
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER-1 ;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx=  RequestContext.getCurrentContext();

        return !ctx.containsKey(FORWARD_TO_KEY)&& !ctx.containsKey(SERVICE_ID_KEY);
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=  RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        if(request.getParameter("sample")!=null){
            ctx.put(SERVICE_ID_KEY, request.getParameter("foo"));
        }
        return null;
    }
}
