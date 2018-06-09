package org.zwx.rabbitMQ.ch4;

import com.rabbitmq.client.Channel;
import org.zwx.rabbitMQ.helper.Action;
import org.zwx.rabbitMQ.helper.MessageTemplate;

import java.io.IOException;

public class DirectPublishAction implements Action {

    private static final String EXCHANE_NAME = "direct_log";

    private static final String ROTING_INFO = "INFO2";
    @Override
    public void action(Channel channel) throws IOException {
        channel.exchangeDeclare(EXCHANE_NAME, "direct");

        channel.basicPublish(EXCHANE_NAME, ROTING_INFO, null, MessageTemplate.getMessage().getBytes());


    }
}
