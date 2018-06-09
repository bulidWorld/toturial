package org.zwx.rabbitMQ.ch1;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * 1.创建工厂
 * 2.设置工厂的链接属性
 * 3.new Connection
 * 4.从connection中创建channel
 * 5.通过channel声明Queue，并设置消息队列的属性
 * 6.发送/接受消息
 *
 */
public class Sender {

    private static final String HOST = "123.206.112.118";

//    private static final int PORT = 15672;

    private static final String QUEUE_NAME = "QUEUE_TEST";


    public static void main(String[] args) throws IOException, TimeoutException {
        String message = "hello world!";

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost(HOST);
//        connectionFactory.setPort(PORT);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        //先声明，声明之后才能使用
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //声明消息的属性
        BasicProperties properties = null;

        //提供的静态声明
//        properties = MessageProperties.PERSISTENT_TEXT_PLAIN;

        //声明header
        Map<String, Object> header = new HashMap<>();
        header.put("a", "1");
        header.put("b", "2");

        //自己构建
//        properties = new AMQP.BasicProperties.Builder()
//                .deliveryMode(2)
//                .contentType("application/json")
//                .priority(1)
//                .userId("sd")
//                .headers(header)
//                .build();


        //使用之前声明的
        //ROUTING KEY 可以是QUEUE NAME 也可以是个关键词
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        channel.close();
        connection.close();

    }
}
