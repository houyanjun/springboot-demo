package com.ux168.platform.infrastructure.util;

import com.alibaba.nacos.common.utils.JacksonUtils;
import com.alibaba.nacos.common.utils.MapUtils;
import com.google.common.reflect.TypeResolver;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
public class TemplateNetWorkUtil {

    public static final String HTTP_PREFIX = "http://";
    public static final String SEPARATOR = "/";
    @Autowired
    private RestTemplate restTemplate;

    // 新增restTemplate对象注入方法，注意，此处LoadBalanced注解一定要加上，否则无法远程调用
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public <T> T executeGet(String serviceName,String api,Class<T> response) {
        String url = HTTP_PREFIX+serviceName+"/"+api;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> formEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<T> exchange = restTemplate.exchange(url, HttpMethod.GET, formEntity, response, new HashMap<>());
        T object = exchange.getBody();
        return object;
    }

    public <T> T executeGet(String serviceName,String api,Class<T> response, Map<String,String> uriValues) {
        String url = HTTP_PREFIX+serviceName+SEPARATOR+api + this.getUriValues(uriValues);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> formEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<T> exchange = restTemplate.exchange(url, HttpMethod.GET, formEntity, response, uriValues);
        T object = exchange.getBody();
        return object;
    }

    private String getUriValues(Map<String,String> uriValues) {
        StringBuilder stringBuilder = new StringBuilder();
        uriValues.forEach((key,value)->{
            stringBuilder.append(key).append("=").append("{").append(key).append("}").append("&");
        });
        String result = "?";
        if(stringBuilder.length()>0) {
            result +=  stringBuilder.substring(0,stringBuilder.length()-1);
        }
        return result;
    }

    public <T> T executePost(String serviceName,String api,Class<T> response,Map<String,String> uriValues) {
        String url = HTTP_PREFIX +serviceName+"/"+api;
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        uriValues.forEach((key,value)->{
            requestBody.add(key, value);
        });
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json; charset=utf-8");

        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(requestBody, requestHeaders);
        ResponseEntity<T> responseEntity = restTemplate.postForEntity(url, requestEntity, response);
        T object = responseEntity.getBody();
        return object;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }


}
