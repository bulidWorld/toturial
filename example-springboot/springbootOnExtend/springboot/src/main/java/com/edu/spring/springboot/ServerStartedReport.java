package com.edu.spring.springboot;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class ServerStartedReport implements CommandLineRunner {
	public void run(String... args) throws Exception {
		System.out.println("===========应用启动后的时间是：" + LocalDateTime.now().toString());
	}
}
