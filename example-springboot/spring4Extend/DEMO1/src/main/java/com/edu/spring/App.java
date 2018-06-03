package com.edu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.edu.spring");
//		System.out.println(context.getBean(User.class));
		System.out.println(context.getBean("user"));
		context.getBean("user", User.class).show();
		context.getBean(Book.class).show();
		context.getBean(Bank.class).show();
		context.getBean(Dog.class).show();
		context.close();
	}
}
