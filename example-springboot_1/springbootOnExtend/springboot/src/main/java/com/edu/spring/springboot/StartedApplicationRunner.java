package com.edu.spring.springboot;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartedApplicationRunner implements ApplicationRunner {
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("应用已经启动，参数为：" + Arrays.asList(args.getSourceArgs()));
	}
}
