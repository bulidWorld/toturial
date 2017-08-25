package com.study.config;

import com.study.module.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/4/29.
 */

@Configuration
@ComponentScan(basePackages = {"com.study.config", "com.study.controller"})
public class AppRoot {


    public SessionFactory sessionFactory(){
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration()
               // .addResource("com/metaarchit/bookshop/Book.hbm.xml")//.addJar(new File("module.jar"))
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect")
                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/sms?characterEncoding=utf8&useSSL=false")
                .setProperty("connection.pool_size", "100")
                .setProperty("connection.provider_class", "org.hibernate.c3p0.internal.C3P0ConnectionProvider")
                .setProperty("c3p0.acquire_increment", "5")
                .setProperty("c3p0.idle_test_period", "60")
                .setProperty("c3p0.max_size", "100")
                .setProperty("c3p0.min_size", "15")
                .setProperty("c3p0.max_statements", "100")
                .setProperty("c3p0.timeout", "1000")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "create")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "MyNewPass")
                .addAnnotatedClass(Person.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings
                (configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
