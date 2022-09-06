package com.ux168.platform.interfaces.facade.web.test;

import com.ux168.platform.application.dto.MoneyModel;
import com.ux168.platform.application.service.DemoService;
import com.ux168.platform.interfaces.dto.DemoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@RefreshScope
public class HelloApiController {

    //只支持redis五大类型中的字符串类型
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(HelloApiController.class);

    @Value("${name}")
    private String name;

    @Value("${name2}")
    private String name2;

    @Autowired
    private DemoService demoService;

    @PostMapping(value="/test")
    public DemoDTO hello() {
        ValueOperations<String, String> valueRedis = stringRedisTemplate.opsForValue();
        valueRedis.set("test","123");
        System.out.println(valueRedis.get("test"));
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
        MoneyModel moneyModel = demoService.getMoneyModel();
        return moneyModel.getName();
    }

    @PostMapping(value="/test3")
    public String hello3(@RequestParam("name") String name,@RequestParam("va")String va) {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName("hou");
        System.out.println(name);
        logger.info("test-log");
        return "hou@"+name+"@"+va;
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
