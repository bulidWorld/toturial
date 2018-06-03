package com.edu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationClient2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationScan.class);
		System.out.println(context.getBean("&createRunnableFactoryBean"));
    	System.out.println(context.getBean(RunnableFactoryBean.class));
    	System.out.println(context.getBean(Car.class));
    	System.out.println(context.getBean(Cat.class));
    	System.out.println(context.getBean(UserController.class));
    	System.out.println(context.getBean(Animal.class));
		context.close();
	}

}
