package com.snail.cloud.zuuldemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okhttp3.internal.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SIMPLE_HOST_ROUTING_FILTER_ORDER;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/10/20 21:52
 */
@Component
@Slf4j
public class OkHttpRoutingFilter extends ZuulFilter {
    @Autowired
    private ProxyRequestHelper helper;

    @Override
    public String filterType() {
        log.info("OkHttpRoutingFilter");
        return ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SIMPLE_HOST_ROUTING_FILTER_ORDER-1 ;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getRouteHost() != null
                && RequestContext.getCurrentContext().sendZuulResponse();
    }

    @SneakyThrows
    @Override
    public Object run() throws ZuulException {
        OkHttpClient httpClient=new OkHttpClient.Builder().build();
        RequestContext context=RequestContext.getCurrentContext();
        HttpServletRequest request=context.getRequest();

        String method=request.getMethod();

        String uri=this.helper.buildZuulRequestURI(request);

        Headers.Builder headers=new Headers.Builder();
        Enumeration<String> headerNames=request.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String name=headerNames.nextElement();
            Enumeration<String> values=request.getHeaders(name);

            while (values.hasMoreElements()){
                String value=values.nextElement();
                log.info("name:{},value:{}",name,value);
                headers.add(name,value);
            }
        }

        InputStream inputStream=request.getInputStream();

        RequestBody requestBody=null;
        if(inputStream!=null && HttpMethod.permitsRequestBody(method)){
            MediaType mediaType=null;
            if(headers.get("Content-Type")!=null){
                mediaType=MediaType.parse(headers.get("Content-Type"));
            }
            requestBody=RequestBody.create(mediaType, StreamUtils.copyToByteArray(inputStream));
        }

        Request.Builder builder=new Request.Builder().headers(headers.build())
                .url(uri).method(method, requestBody);

        Response response=httpClient.newCall(builder.build()).execute();
        LinkedMultiValueMap<String,String> responseHeaders=new LinkedMultiValueMap<>();

        for (Map.Entry<String, List<String>>entry:response.headers().toMultimap().entrySet()){
            responseHeaders.put(entry.getKey(),entry.getValue());
        }
        this.helper.setResponse(response.code(),response.body().byteStream(),responseHeaders);
        context.setRouteHost(null);
        return null;
    }
}
