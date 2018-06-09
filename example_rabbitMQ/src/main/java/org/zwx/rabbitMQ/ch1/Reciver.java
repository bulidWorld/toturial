package org.zwx.rabbitMQ.ch1;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.Receiver;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Reciver {

    private static final String HOST = "123.206.112.118";

//    private static final int PORT = 0;

    private static final String QUEUE_NAME = "QUEUE_TEST";

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPassword("admin");
        factory.setUsername("admin");
//        factory.setPort(PORT);
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        //declare queue 为了保证queue的存在
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                LOG.info("receive message:{}", new String(body));
                System.out.println("receive message:" + new String(body));
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
