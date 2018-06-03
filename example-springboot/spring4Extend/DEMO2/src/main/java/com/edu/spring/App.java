package com.edu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.edu.spring");
		context.getBeansOfType(Person.class).values().forEach(System.out::println);
		context.close();
	}
}
