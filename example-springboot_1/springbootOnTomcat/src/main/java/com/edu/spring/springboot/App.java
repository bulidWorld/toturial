package com.edu.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  两种定制tomcat容器的方法
 *  1：实现EmbeddedServletContainerCustomizer接口，并把实现类纳入到spring容器中管理
 *  2：在spring容器中装配一个EmbeddedServletContainerCustomizer对象
 *  
 *  see EmbeddedServletContainerAutoConfiguration
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
    	SpringApplication.run(App.class, args);
    }
}
