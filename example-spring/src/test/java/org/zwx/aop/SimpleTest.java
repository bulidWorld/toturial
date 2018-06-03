package org.zwx.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-application.xml")
public class SimpleTest {

    @Autowired
    private SimpleService simpleService;

    @Autowired
    private NeedAOPService aopService;

    @Test
    public void test() {
        simpleService.doSth();
    }

    @Test
    public void testAOP() {
        simpleService.aopLOG(  );
    }

    @Test
    public void testOrderAOP() {
        simpleService.aopOrder();
    }

    @Test
    public void doSthWithArg() {
        simpleService.doSthWithArg("hello");
    }
}
