package com.example.demo.api;

import com.example.demo.api.dto.DemoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RefreshScope
public class HelloApiService {

    @Value("${name}")
    private String name;

    @PostMapping(value="/test")
    public DemoDTO hello() {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName("hou");
        System.out.println(name);
        return demoDTO;
    }
}
