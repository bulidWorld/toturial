package com.edu.spring.springboot;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Before("execution(* com.edu.spring.springboot.dao..*.*(..))")
	public void log() {
		System.out.println("before method log done ");
	}
	
	@After("execution(* com.edu.spring.springboot.dao..*.*(..))")
	public void logAfter(JoinPoint point){
		System.out.println("after method log done" + point.getTarget().getClass() + ",args=" + Arrays.asList(point.getArgs())+ ",method="+point.getSignature().getName());
	}
}
