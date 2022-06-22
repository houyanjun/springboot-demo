package com.example.demo.service.api.test;

import com.example.demo.service.proxy.DemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RefreshScope
public class DemoFeignController {

    @Autowired
    private DemoClient demoClient;

    @PostMapping("/client")
    public String client(){
        String result = demoClient.test2();
        return "client is success: " + result;
    }

}
