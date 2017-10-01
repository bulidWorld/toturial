package org.zwx.example.simple;

import redis.clients.jedis.Jedis;

public class Simple {

    public void testConnectRedis() {
        Jedis jedis = new Jedis("192.168.0.103", 6379, 100000);

        jedis.connect();

        jedis.sadd("key1", "1");

        jedis.save();

        System.out.println("test conn redis:" + jedis.ping());
    }
}
