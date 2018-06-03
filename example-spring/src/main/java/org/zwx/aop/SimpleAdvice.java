package org.zwx.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;
import org.zwx.entity.User;
import org.zwx.service.api.PrivilegeService;

import java.util.Arrays;

@Aspect
@Component
public class SimpleAdvice implements BeanFactoryAware {

//    @Before("execution(* org.zwx.aop.SimpleService.*(..))")
//    public void doBefore(JoinPoint joinPoint) {
//        System.out.println("..........................do before method.........................");
//    }

    private BeanFactory beanFactory;

    @Before("@annotation(log)")
    public void doLOG(LOG log) throws IllegalAccessException, InstantiationException {
        System.out.println(".....................do log.........................");
        PrivilegeService privilegeService = log.privilegeService().newInstance();
        privilegeService.hasPrivilege(new User("simple name"));
    }

    @Around("execution(* org.zwx.aop.SimpleService.*(..))")
    public void doBeforeChangeArgs(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        joinPoint.proceed();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
