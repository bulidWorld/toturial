package org.zwx.toturial.producer;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.Session;

public class SpringMessageProducer {

    private JmsTemplate jmsTemplate = new JmsTemplate();

    private static Object lock = new Object();

    private static SpringMessageProducer INSTANCE;


    public static SpringMessageProducer getInstance() {
        synchronized (lock){
            if (INSTANCE == null) {
                INSTANCE = new SpringMessageProducer();
                INSTANCE.init();
            }
        }
        return INSTANCE;
    }

    private void init() {
        jmsTemplate.setConnectionFactory(ConnectUtil.getConnFactory());

    }


    public void sendMessage(final String destination, final String message) {

        jmsTemplate.send(destination, session -> session.createTextMessage(message));
    }

    public void sendMessageWithCallBack() {
        jmsTemplate.sendAndReceive();
        Session sess;
        Message mess;
    }


}
