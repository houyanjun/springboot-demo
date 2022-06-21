package com.example.demo.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value="springdemo")
public interface DemoClient {
    @PostMapping("/hello/test2")
    String test2();
}
