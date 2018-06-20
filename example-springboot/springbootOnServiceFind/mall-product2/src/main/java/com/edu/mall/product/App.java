package com.edu.mall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 微服务
 * 把原先的一个大的系统，拆分成小的系统
 * 每个小系统分别开发，测试，维护
 *
 *  常见的注册中心：zookeeper, consul, etcd, redis
 * 
 *  服务器提供方，需要在服务启动的时候，把服务的信息（ip，port）注册到注册中心（zookeeper）
 */
@SpringBootApplication
public class App {
    public static void main( String[] args ) throws Exception {
    	ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//    	context.close();
    }
}
