package org.zwx.rabbitMQ.ch4;

import com.rabbitmq.client.*;
import org.zwx.rabbitMQ.helper.Action;

import java.io.IOException;

public class DirectSubscribeAction  implements Action {

    private static final String EXCHANE_NAME = "direct_log";

    private static final String ROTING_INFO = "INFO";

    private static final String ROTING_WARN = "WARN";

    @Override
    public void action(Channel channel) throws IOException {
        channel.exchangeDeclare(EXCHANE_NAME, "direct");

        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName, EXCHANE_NAME, ROTING_INFO);
        channel.queueBind(queueName, EXCHANE_NAME, ROTING_WARN);

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
