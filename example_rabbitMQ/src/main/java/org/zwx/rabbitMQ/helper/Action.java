package org.zwx.rabbitMQ.helper;

import com.rabbitmq.client.Channel;

import java.io.IOException;

public interface Action {

    void action(Channel channel) throws IOException;
}
