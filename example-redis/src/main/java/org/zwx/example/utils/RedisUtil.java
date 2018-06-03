package org.zwx.example.utils;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public void testConnectRedis() {
        Jedis jedis = new Jedis("123.206.112.118", 6379, 100000);

        jedis.connect();

        jedis.sadd("key1", "1");
        jedis.set("hello1", "zwx");
        jedis.save();
        jedis.close();

        System.out.println("test conn redis:" + jedis.ping());
    }




}
