package com.edu.spring.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(20)
@Component
public class ServerSuccessReport implements CommandLineRunner {
	public void run(String... args) throws Exception {
		System.out.println("===========应用已经成功的启动==========" + Arrays.asList(args));
	}
}
