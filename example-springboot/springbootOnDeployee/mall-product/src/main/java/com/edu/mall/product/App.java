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
 *  
 *  直接使用mnv打包
 *  mvn clean package dependency:copy-dependencies
 *  java -cp  Main
 *   
 *  appassembler（http://www.mojohaus.org/appassembler）插件的打包方式
 *  mvn clean package appassembler:assemble
 *  win 下面直接执行bat文件
 *  linux下需要先授予可执行权限（chmod +x product），再执行
 */
@SpringBootApplication
public class App {
    public static void main( String[] args ) throws Exception {
    	ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//    	context.close();
    }
}
