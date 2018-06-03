package com.edu.spring.springboot;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("bean count : " + applicationContext.getBeanDefinitionCount());
	}
}
