package org.zwx.toturial.producer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.jms.*;


@Service
public class MessageFactory {

    public void start(String sendMessage) {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");


        try {
            Connection connection = connectionFactory.createConnection();

            connection.start();

            //Connection.createSessio.........两个参数分别代表什么意思？？？？
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("test.queue");

            MessageProducer messageProducer = session.createProducer(destination);

            TextMessage tm = session.createTextMessage(sendMessage);

            messageProducer.send(tm);

            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
