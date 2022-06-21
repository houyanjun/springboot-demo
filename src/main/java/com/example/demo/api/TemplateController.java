package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo/template")
public class TemplateController {
    @Autowired
    private RestTemplate restTemplate;

    // 新增restTemplate对象注入方法，注意，此处LoadBalanced注解一定要加上，否则无法远程调用
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/load")
    public String load() {
        String forObject = restTemplate.getForObject("http://springdemo/hello/test3", String.class);
        return forObject;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }

}
