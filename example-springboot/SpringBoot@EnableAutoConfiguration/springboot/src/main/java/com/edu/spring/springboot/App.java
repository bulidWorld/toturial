package com.edu.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.edu.core.bean.Role;
import com.edu.core.bean.User;
import com.google.gson.Gson;

/**
 *  @EnableAutoConfiguration 作用：从classpath中搜索所有META-INF/spring.factories配置文件
 *  然后，将其中org.springframework.boot.autoconfigure.EnableAutoConfiguration key对应的配置项加载到spring容器
 *  
 *  只有spring.boot.enableautoconfiguration为true（默认为true）的时候，才启用自动配置
 *  @EnableAutoConfiguration还可以进行排除，排除方式有2中，一是根据class来排除（exclude），二是根据class name（excludeName）来排除
 *  
 *  其内部实现的关键点有
 *  1：ImportSelector 该接口的方法的返回值都会被纳入到spring容器管理中
 *  2：SpringFactoriesLoader 该类可以从classpath中搜索所有META-INF/spring.factories配置文件，并读取配置
 *  
 *  
 */
@EnableConfigurationProperties
public class App {
	
	@Bean
	public Gson gson2() {
		return new Gson();
	}
	
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(App.class);
    	ConfigurableApplicationContext context = app.run(args);
    	System.out.println(context.getBean(Runnable.class));
    	System.out.println(context.getBean(User.class));
    	System.out.println(context.getBean(Role.class));
    	System.out.println(context.getBean(Role.class));
    	System.out.println(context.getBeansOfType(Gson.class));
    	context.close();
    }
}
