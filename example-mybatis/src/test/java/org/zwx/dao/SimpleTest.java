package org.zwx.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mybatis-spring_config.xml")
public class SimpleTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testInterface() {
        System.out.println(personMapper.findById(1));
    }

}
