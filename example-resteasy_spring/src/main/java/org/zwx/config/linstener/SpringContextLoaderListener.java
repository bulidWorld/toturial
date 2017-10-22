package org.zwx.config.linstener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringContextLoaderListener implements ServletContextListener
{

    private static FileSystemXmlApplicationContext applicationContext = null;

    public static ApplicationContext getSpringContext() {
        return applicationContext;
    }

    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
         applicationContext = new FileSystemXmlApplicationContext("classpath:spring-context.xml");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        applicationContext.close();
    }
}
