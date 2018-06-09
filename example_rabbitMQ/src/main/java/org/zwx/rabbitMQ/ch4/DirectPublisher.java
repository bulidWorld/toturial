package org.zwx.rabbitMQ.ch4;

import org.zwx.rabbitMQ.helper.Action;
import org.zwx.rabbitMQ.helper.MessageTemplate;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DirectPublisher {

    public static void main(String[] args) throws IOException, TimeoutException {
        MessageTemplate template = new MessageTemplate();

        Action action = new DirectPublishAction();
        template.work(action);
    }
}
