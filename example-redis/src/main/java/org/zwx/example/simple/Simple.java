package org.zwx.example.simple;

import redis.clients.jedis.Jedis;

public class Simple {

    public void testConnectRedis() {
        Jedis jedis = new Jedis("192.168.0.102", 6379, 5000);

        jedis.connect();

        System.out.println("test conn redis:" + jedis.ping());
    }
}
