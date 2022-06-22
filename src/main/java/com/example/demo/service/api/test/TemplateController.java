package com.example.demo.service.api.test;

import com.example.demo.common.util.TemplateNetWorkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo/template")
public class TemplateController {

    @Autowired
    private TemplateNetWorkUtil templateNetWorkUtil;

    @GetMapping("/daemonGet")
    public String daemonGet() {
        Map<String,String> uriMap = new HashMap<>();
        uriMap.put("key","test");
        String forObject = templateNetWorkUtil.executeGet("springdemo", "hello/test4", String.class);
        String forObject2 = templateNetWorkUtil.executeGet("springdemo", "hello/test3", String.class,uriMap);
        return forObject+"@"+forObject2;
    }

    @PostMapping("/daemonPost")
    public String daemonPost() {
        Map<String,String> map = new HashMap<>();
        map.put("key","houTest");
        String forObject = templateNetWorkUtil.executePost("springdemo", "hello/test2", String.class,map);
        String forObject2 = templateNetWorkUtil.executePost("springdemo", "hello/test21", String.class,map);
        return forObject+"@"+forObject2;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }

}
