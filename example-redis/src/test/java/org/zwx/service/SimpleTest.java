package org.zwx.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zwx.SpringCtx;
import org.zwx.example.service.RedisService;


@ContextConfiguration(locations = "classpath:application-cfg.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void test() {
        redisService.save2Redis("key2", "val2.4");
    }

    @Test
    public void testValOper() {
        redisService.saveByVauleOper();
    }

    @Test
    public void testStrTmp() {
        redisService.saveByStrTmp();
    }

    @Test
    public void testLstOper() {
        redisService.saveByLstOper();
    }

    @Test
    public void getByLstOper() {
        String s = redisService.getByLstOper();
        System.out.println(s);
    }
}
