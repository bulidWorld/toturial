package com.edu.spring.springboot;

import org.apache.catalina.valves.AccessLogValve;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

//@SpringBootConfiguration
public class WebServerConfiguration {

	@Bean
	public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory(){
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(10008);
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
		factory.addInitializers((servletContext) -> {
			System.out.println("=========servletContext startup==========");
			servletContext.setAttribute("startup", "true");
		});
		factory.addContextValves(getLogAccessLogValve());
		return factory;
	}
	
	private AccessLogValve getLogAccessLogValve(){
		AccessLogValve log = new AccessLogValve();
		log.setDirectory("e:/tmp/logs");
		log.setEnabled(true);
		log.setPattern("%h %l %u %t \"%r\" %s %b");
		log.setPrefix("springboot-access-log");
		log.setSuffix(".txt");
		return log;
	}
}
