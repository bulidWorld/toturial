package org.zwx.config.boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.spi.resolver.LocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "org.zwx.controller")
public class RestConfig extends WebMvcConfigurerAdapter {

    private ObjectMapper objectMapper = new ObjectMapper();

    private Marshaller marshaller = new Jaxb2Marshaller();

    private Unmarshaller unmarshaller = new Jaxb2Marshaller();

    private SpringValidatorAdapter validatorAdapter = new OptionalValidatorFactoryBean();

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new SourceHttpMessageConverter<>());

        MarshallingHttpMessageConverter xmlConvert = new MarshallingHttpMessageConverter();

        xmlConvert.setSupportedMediaTypes(Arrays.asList(new MediaType("application","xml"), new MediaType("text","xml")));

        xmlConvert.setMarshaller(this.marshaller);
        xmlConvert.setUnmarshaller(this.unmarshaller);

        converters.add(xmlConvert);

        MappingJackson2HttpMessageConverter jsonConvert = new MappingJackson2HttpMessageConverter();
        jsonConvert.setSupportedMediaTypes(Arrays.asList(new MediaType("application","json"), new MediaType("text","json")));
        jsonConvert.setObjectMapper(this.objectMapper);

        converters.add(jsonConvert);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public Validator getValidator() {
        return this.validatorAdapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new AcceptHeaderLocaleResolver();
    }

    @Bean
    public HandlerAdapter handlerAdapter() {
        return new SimpleServletHandlerAdapter();
    }
}
