package com.ux168.platform.infrastructure.aop;

import com.ux168.platform.interfaces.dto.DemoDTO;
import com.ux168.platform.infrastructure.util.HttpApiInvokerHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api")
public class OpenApiInterceptor {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping("*/*")
    public void hello() {
        if(HttpApiInvokerHandler.isGetRequest(request)) {

        }
        if(HttpApiInvokerHandler.isPostRequest(request)) {

        }
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName("hou1");
        try {
            response.getOutputStream().write(new Gson().toJson(demoDTO).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * // 获取请求方式: GET
     * String getMethod()
     * // 获取虚拟目录(上下文目录)：虚拟路径通过在application配置当中可以配置
     * // 配置：server.servlet.context-path=/aaa
     * String getContextPath()
     * // 获取Servlet路径：就是获取的controller当中配置的路径
     * String getServletPath()
     * /// 获取请求参数： id=3
     * // http://localhost:8080/aaa/test?id=3
     * String getQueryString()
     * // 获取请求URI：/servletDemo/demo1
     * // 上下文路径+controller当中配置的路径
     * String getRequestURI()
     * // 获取完整请求路径：http://localhost:8080/aaa/test
     * String getRequestURL()
     * // 获取协议及版本：HTTP/1.1
     * String getProtocol()
     * // 获取客户机的IP地址：192.168.0.0
     * String getRemoteAddr()
     */
}
