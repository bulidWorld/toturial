package org.zwx.init;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOCINit {

    @Test
    public void test() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring-application.xml");

    }

}

