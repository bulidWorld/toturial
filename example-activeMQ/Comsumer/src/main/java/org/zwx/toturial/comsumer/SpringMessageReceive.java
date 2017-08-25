package org.zwx.toturial.comsumer;

import org.jasypt.commons.CommonUtils;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Message;

public class SpringMessageReceive {

    private JmsTemplate jmsTemplate = new JmsTemplate();

    private static final Object lock = new Object();

    private static SpringMessageReceive INSTANCE;

    public void setConnFac(ConnectionFactory connFac) {
        jmsTemplate.setConnectionFactory(connFac);
    }

    private SpringMessageReceive() {

    }

    public static SpringMessageReceive getInstance() {
        synchronized (lock){
            if (INSTANCE == null) {
                INSTANCE = new SpringMessageReceive();
                INSTANCE.setConnFac(ConnectUtil.getConnFactory());
            }
        }
        return INSTANCE;
    }

    public Message getMessage(String destination) {

        Message message = jmsTemplate.receive(destination);
        return message;
    }
}
