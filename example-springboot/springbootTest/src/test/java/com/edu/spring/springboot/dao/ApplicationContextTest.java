package com.edu.spring.springboot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.edu.spring.springboot.bean.User;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestBeanConfiguration.class)
public class ApplicationContextTest {

	@Autowired
	private ApplicationContext context;
	
	@Test
	public void testNull(){
		Assert.assertNotNull(context.getBean(User.class));
		Assert.assertNotNull(context.getBean(Runnable.class));
	}
	
}
