package com.edu.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 *   自定义健康状态监测，实现HealthIndicator接口，并纳入到spring容器的管理之中
 *   
 *   CounterService  用来计数的服务，可以直接使用
 *   GaugeService  用来统计某个值，可以直接使用
 *   
 *   Metric不仅可以输出到页面，还可以输出到jmx，redis等地方
 *   通过向spring容器中装配一个MetricWriter来实现定向输出
 *   
 *   JDK的工具来查看监控数据
 *   jconsole, jmc, jvisualvm（需要单独安装插件）等等
 *
 */
@SpringBootApplication(exclude=WebSocketAutoConfiguration.class)
@PropertySource("classpath:my.properties")
public class App {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    	System.out.println(context);
    }
}
