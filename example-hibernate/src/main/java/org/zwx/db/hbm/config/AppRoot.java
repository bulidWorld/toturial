package org.zwx.db.hbm.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.zwx.db.hbm.module.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by Administrator on 2017/4/29.
 */

@Configuration
@ComponentScan(basePackages = {"org.zwx.db.hbm.repository", "org.zwx.db.hbm.service"})
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


    @Bean
    public LocalSessionFactoryBean localSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);

        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
//        props.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        //inject datasource as need connection info?????
//        props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/sms?characterEncoding=utf8&useSSL=false");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");


        sessionFactory.setHibernateProperties(props);
        sessionFactory.setPackagesToScan("org.zwx.db.hbm");

        return sessionFactory;
    }


    /**
     * should close dataSource when never used
     * @return
     */
    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setUser("root");
            dataSource.setPassword("123456");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return dataSource;
    }


    @Bean
    public PlatformTransactionManager txManager(LocalSessionFactoryBean localSessionFactoryBean) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();

        txManager.setSessionFactory(localSessionFactoryBean.getObject());
        return txManager;
    }












}
