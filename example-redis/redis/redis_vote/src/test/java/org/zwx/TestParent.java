package org.zwx;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:application-cfg.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestParent {

    @Autowired
    protected RedisTemplate redisTemplate;
}
