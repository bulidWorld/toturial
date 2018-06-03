package com.edu.spring.springboot.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("=================");
		System.out.println("application is started");
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}
}
