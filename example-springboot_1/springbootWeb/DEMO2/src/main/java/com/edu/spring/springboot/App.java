package com.edu.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 *  spring boot 如何处理静态资源
 *  1：src/main/webapp目录下，就可以直接访问
 *	2：默认的静态资源的路径是：classpath:[/META-INF/resources/,/resources/, /static/, /public/]
 *  3：可以通过spring.resources.staticLocations配置项修改默认静态资源路径
 *  
 *  spring boot中使用servlet的API
 *  方法一：（servlet3可以使用这种方法）
 *  1：编写servlet，然后加上相应的注解
 *  2：需要启用@ServletComponentScan注解
 *  
 *  方法二：（servlet2.5及以下版本可以使用这种方法）
 *  1：编写servlet
 *  2：装配相应的bean到spring容器中
 *  servlet->ServletRegistrationBean
 *  filter ->FilterRegistrationBean
 *  listener -> ServletListenerRegistrationBean
 */
@ServletComponentScan
@SpringBootApplication
public class App {
    public static void main(String[] args) {
    	SpringApplication.run(App.class, args);
    }
}
