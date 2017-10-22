package org.zwx.config.register;

import org.omg.SendingContext.RunTime;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.zwx.config.annotation.RestController;
import org.zwx.config.linstener.SpringContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RestApplication extends Application implements ServletContextListener {

    private Set<Object> serviceRegister;

    private static boolean bScaned = false;

    private static ApplicationContext context;

    public RestApplication() {
        if (context != null) {
            init();
        }
    }

    private void init() {
        if (context == null) {
            throw new RuntimeException("spring context not init");
        }
        Map<String, Object> restBeans = context.getBeansWithAnnotation(RestController.class);
        serviceRegister = new HashSet<Object>(restBeans.values());
        bScaned = true;
    }

    @Override
    public Set<Object> getSingletons() {
        return serviceRegister;
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        this.context = (ApplicationContext) servletContextEvent.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
