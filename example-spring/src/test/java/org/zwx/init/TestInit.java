package org.zwx.init;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zwx.spring.stu.init.BeanFactoryAwareImpl;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-application.xml"})
public class TestInit {

    @Resource
    private BeanFactoryAwareImpl obj;

    @Test
    public void testBeanFactoryAware() {
        obj.doSth();
    }
}
