package org.zwx.toturial.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.ConnectionFactory;

public class ConnectUtil {

    public static ConnectionFactory getConnFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        return connectionFactory;
    }
}
