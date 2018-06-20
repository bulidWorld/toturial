package com.edu.spring.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class EchoApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("=============EchoApplicationContextInitializer=============");
	}
}
