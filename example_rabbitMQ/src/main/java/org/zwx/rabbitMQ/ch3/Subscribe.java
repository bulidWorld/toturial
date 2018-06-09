package org.zwx.rabbitMQ.ch3;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.Receiver;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Subscribe {

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
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout", true);

        //先声明一个exclusive queue
        String queueName = channel.queueDeclare().getQueue();

        //绑定Exchange与Queue
        //第三个参数是roting key
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        //消费消息
        channel.basicConsume(queueName, true, consumer);
        channel.close();
        connection.close();
    }
}
