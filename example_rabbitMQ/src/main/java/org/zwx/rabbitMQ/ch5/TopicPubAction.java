package org.zwx.rabbitMQ.ch5;

import com.rabbitmq.client.Channel;
import org.zwx.rabbitMQ.helper.Action;
import org.zwx.rabbitMQ.helper.MessageTemplate;

import java.io.IOException;

import static org.zwx.rabbitMQ.helper.Constant.TOPIC_EXCHANGE_NAME;

public class TopicPubAction implements Action {

    private final String ROUTING_KEY = "a.b.c";


    @Override
    public void action(Channel channel) throws IOException {

        //绑定通道
        channel.exchangeDeclare(TOPIC_EXCHANGE_NAME, "topic");

        //发送消息
        channel.basicPublish(TOPIC_EXCHANGE_NAME, ROUTING_KEY, null, MessageTemplate.getMessage().getBytes());

    }
}
