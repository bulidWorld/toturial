package org.zwx.rabbitMQ.ch5;

import org.zwx.rabbitMQ.helper.Action;
import org.zwx.rabbitMQ.helper.MessageTemplate;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TopicSubMain {

    public static void main(String[] args) throws IOException, TimeoutException {
        MessageTemplate mt = new MessageTemplate();

        Action action = new TopicSubAction();

        mt.work(action);

    }
}
