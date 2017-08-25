package org.zwx.toturial.comsumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class MessageReceive {

    public String start() throws JMSException {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = null;
        Session session = null;
        try {
            connection = connectionFactory.createConnection();

            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("test.queue");

            MessageConsumer messageConsumer = session.createConsumer(destination);

            Message message = messageConsumer.receive(1000);


            if (message instanceof TextMessage) {
                return ((TextMessage) message).getText();
            }

            if (message instanceof ObjectMessage) {
                return message.toString();
            }

            if (message instanceof MapMessage) {
                return message.toString();
            }

            return message.toString();

        } catch (JMSException e) {
            e.printStackTrace();
            return null;
        } finally {
            connection.close();
            session.close();
        }

    }
}

