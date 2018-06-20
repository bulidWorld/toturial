package com.edu.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  更换web容器
 *  springboot web默认使用的是tomcat作为web容器
 *  可以更换成jetty
 *  步骤：
 *  1：排除
 *  <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-tomcat</artifactId>
	依赖
	2：加入jetty依赖
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-jetty</artifactId>
	</dependency>
 *
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
    	SpringApplication.run(App.class, args);
    }
}
