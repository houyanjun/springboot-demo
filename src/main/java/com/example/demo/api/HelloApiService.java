package com.example.demo.api;

import com.example.demo.api.dto.DemoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hello")
@RefreshScope
public class HelloApiService {

    @Value("${name}")
    private String name;

    @Value("${name2}")
    private String name2;

    @Autowired
    private HttpServletRequest request;

    @PostMapping(value="/test")
    public DemoDTO hello() {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName("hou");
        demoDTO.setName(name2);
        System.out.println(name);
        return demoDTO;
    }

    @PostMapping(value="/test2")
    public String hello2(@RequestBody String key) {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName("hou");
        System.out.println(name);
        return "hou:"+key;
    }

    @PostMapping(value="/test21")
    public String test21() {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName("hou");
        System.out.println(name);
        return "hou:";
    }

    @GetMapping(value="/test3")
    public String hello3(@RequestParam(value = "key") String key) {

        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName("hou:"+key);
        System.out.println(name);
        return "hou:"+key;
    }

    @GetMapping(value="/test4")
    public String hello4() {

        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName("hou:");
        System.out.println(name);
        return "hou:";
    }
}
