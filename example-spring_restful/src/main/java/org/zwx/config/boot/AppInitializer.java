package org.zwx.config.boot;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RestConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{RestConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
