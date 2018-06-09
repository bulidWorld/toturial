package org.zwx.rabbitMQ.ch2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import sun.nio.cs.StandardCharsets;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 任务处理
 */
public class Task {

    private static final String HOST = "";

    private static final int PORT = 0;

    private static final String QUEUE_NAME = "QUEQU_TASK";


    public static void main(String[] args) throws IOException, TimeoutException {
        String task = getTask();

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost(HOST);
        connectionFactory.setPort(PORT);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        //这个参数表示是否持久化
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);

        //发送任务
        channel.basicPublish("", QUEUE_NAME, null, task.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        channel.close();
        connection.close();

    }

    private static String getTask() {

        return "this is a Task, wait for deposite";
    }


}
