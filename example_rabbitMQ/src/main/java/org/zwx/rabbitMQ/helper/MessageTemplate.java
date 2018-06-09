package org.zwx.rabbitMQ.helper;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.Receiver;
import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.TimeoutException;

public class MessageTemplate {


    private static final String HOST = "123.206.112.118";


    public void work(Action action) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPassword("admin");
        factory.setUsername("admin");
//        factory.setPort(PORT);
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        action.action(channel);

//        connection.close();
//        channel.close();
    }


    public static String getMessage() {
        return "msg:" + Instant.now();
    }


    public static void consumeMsg(Channel channel, String queueName) throws IOException {

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);

    }
}
