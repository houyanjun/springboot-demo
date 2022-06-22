package com.example.demo.aop;

import com.example.demo.common.util.ResponseUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Aspect
@Component
public class OpenApiAop {

    @Autowired
    private HttpServletResponse response;

    @Pointcut("execution (* com.example.demo.service.api..*Controller.*(..))")
    public void apiPointAspect() {

    }

 /*   @Before(value = "apiPointAspect()")
    public void beforeAdvice() {
        System.out.println("beforeAdvice...");
    }

    @After(value = "apiPointAspect()")
    public void afterAdvice() {
        System.out.println("afterAdvice...");
    }*/

    @Around(value = "apiPointAspect()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("before");
        try {
            Signature signature = proceedingJoinPoint.getSignature();
            String name = signature.getName();
            Class declaringType = signature.getDeclaringType();
            String declaringTypeName = signature.getDeclaringTypeName();
            int modifiers = signature.getModifiers();
            Object[] args = proceedingJoinPoint.getArgs();
            Object proceed = proceedingJoinPoint.proceed(args);
            return proceed;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.out.println("after");
        return new HashMap<>();
    }
}
