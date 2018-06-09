package org.zwx.rabbitMQ.ch3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.Receiver;
import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.TimeoutException;


/**
 * 声明fanout类型的exchange
 */
public class Publisher {

    private static final String HOST = "123.206.112.118";

//    private static final int PORT = 0;

    private static final String EXCHANGE_NAME = "log";

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPassword("admin");
        factory.setUsername("admin");
//        factory.setPort(PORT);
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        //先声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        String msg = "log:" + Instant.now().toString();

        //使用exchange
        channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());


        channel.close();
        connection.close();

    }
}
