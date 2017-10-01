package org.zwx.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleAdvice {

    @Before("execution(* org.zwx.service.SimpleService.*(..))")
    public void doBefore() {
        System.out.println("..........................do before method.........................");
    }

    @Before("@annotation(LOG)")
    public void doLOG() {
        System.out.println(".....................do log.........................");
    }
}
