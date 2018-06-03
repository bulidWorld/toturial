package com.edu.spring.springboot;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *   装配DataSource的步骤
 *   1：加入数据库驱动
 *   2：配置
 *   spring.datasource.driverClassName=
	 spring.datasource.url=
	 spring.datasource.username=
	 spring.datasource.password=
	 
	  以上操作，springboot会自动装配好DataSource、JdbcTemplate，可以直接使用
	 
	 spring.datasource.type可以指定具体使用哪种数据源
	 默认支持tomcat-jdbc，Hikari，dbcp，dbcp2
	 
	 配置自己的DataSource
	 只需要装配一个DataSource到spring容器中即可
	 
	 
	 事务：
	 首先要使用@EnableTransactionManagement启用对事务的支持
	 然后，在需要使用事务的方法上面加上@Transactional
	 注意，默认只会对运行时异常进行事务回滚，非运行时异常不会回滚事务
	 
 *
 */
@SpringBootApplication
@EnableTransactionManagement
public class App {
    public static void main(String[] args) throws Exception {
    	ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    	DataSource ds = context.getBean(DataSource.class);
//    	Connection conn = ds.getConnection();
//    	System.out.println(conn.getCatalog());
//    	conn.close();
    	context.getBean(ProductDao.class).addProductBatch("TV","MP3","MP4");
    	System.out.println(ds.getClass());
    }
}
