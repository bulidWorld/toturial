package com.edu.spring.springboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *   ApplicationContextInitializer 接口是在spring容器执行refreshed之前的一个回调
 *   使用步骤：
 *   1：写一个类，实现ApplicationContextInitializer接口
 *   2：注册ApplicationContextInitializer
 *   
 *   注册方法：
 *   1：SpringApplication.addInitializers
 *   2：通过配置项 context.initializer.classes 指定，可以指定多个，多个用逗号隔开
 *   3：可以通过spring.factories机制（注册listener监听器也可以使用这种方式）
 *   
 *   
 *   
 *   CommandLineRunner、ApplicationRunner 接口是在容器启动成功后的最后一步回调（类似开机自启动）
 *   使用步骤：
 *   1：写一个类，实现CommandLineRunner接口
 *   2：把该类纳入到spring容器的管理之中
 *   注意：可以通过@Order注解或者Ordered接口来控制执行顺序。
 *   
 *  CommandLineRunner， ApplicationRunner 区别
 *  区别在于方法的参数不一样
 *  CommandLineRunner的参数是最原始的参数，没有做任何处理
 *  ApplicationRunner的参数是ApplicationArguments，是对原始参数做了进一步的封装
 *  
 *  ApplicationArguments是对参数（main方法）做了进一步的处理
 *  可以解析--name=value的，我们就可以通过name来获取value
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(App.class);
//    	app.addInitializers(new MyApplicationContextInitializer());
    	ConfigurableApplicationContext context = app.run(args);
    	ApplicationArguments arg = context.getBean(ApplicationArguments.class);
    	System.out.println(arg.getSourceArgs().length);
    	System.out.println(arg.getOptionNames());
    	System.out.println(arg.getOptionValues("myname"));
    	context.close();
    }
}
