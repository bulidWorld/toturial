package org.zwx.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class RedisComponent {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    public RedisConnection getRedisConn() {
        return connectionFactory.getConnection();
    }
}
