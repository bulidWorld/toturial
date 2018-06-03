package org.zwx.simple.test;

import redis.clients.jedis.Jedis;

public class Simple {

    public void testConnectRedis() {
        Jedis jedis = new Jedis("123.206.112.118", 6379, 100000);
        jedis.auth("123456");

        jedis.connect();

        jedis.sadd("key1", "1");
        jedis.set("hello1", "zwx");

        jedis.save();

        System.out.println("test conn redis:" + jedis.ping());
    }
}
