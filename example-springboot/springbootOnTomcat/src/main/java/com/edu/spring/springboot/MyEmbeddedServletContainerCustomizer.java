package com.edu.spring.springboot;

import java.io.File;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

	public void customize(ConfigurableEmbeddedServletContainer container) {
		TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory)container;
		factory.setPort(10003);
		factory.setBaseDirectory(new File("e:/tmp/tomcat"));
		factory.addContextValves(getLogAccessLogValve());
		factory.addInitializers((servletContext) -> {
			System.out.println("=========servletContext startup==========");
		});
		factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
	}
	
	private AccessLogValve getLogAccessLogValve(){
		AccessLogValve log = new AccessLogValve();
//		log.setDirectory("e:/tmp/logs");
		log.setEnabled(true);
		log.setPattern("%h %l %u %t \"%r\" %s %b");
		log.setPrefix("springboot-access-log");
		log.setSuffix(".txt");
		return log;
	}
}
class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer {

	public void customize(Connector connector) {
		Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
		protocol.setMaxConnections(2000);//设置最大连接数
		protocol.setMaxThreads(500);//设置最大的线程数
	}
}





