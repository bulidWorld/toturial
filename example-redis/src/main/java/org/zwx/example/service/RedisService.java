package org.zwx.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.zwx.example.utils.RedisComponent;

import javax.annotation.Resource;

@Service
public class RedisService {

    @Autowired
    RedisComponent redisComponent;

    @Resource(name="redisTemplate")
    ValueOperations valueOperations;

    @Resource(name = "redisTemplate")
    ListOperations<String, String> lstOper;

    @Autowired
    StringRedisTemplate strTemplate;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public void save2Redis(String key, String val) {
        RedisConnection conn = redisComponent.getRedisConn();
        conn.sAdd(key.getBytes(), val.getBytes());
    }

    public void saveByVauleOper() {
        valueOperations.set("valoperkey1", "valoperkey2");
    }

    public void saveByLstOper() {
        lstOper.leftPush("lstKey", "lstVal");
    }

    public String getByLstOper() {
        return lstOper.index("lstKey", 1L);
    }


    public void saveByStrTmp() {
        strTemplate.opsForValue().set("strTmp", "strVal");
    }
}
