package org.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zwx.toturial.comsumer.MessageReceive;
import org.zwx.toturial.comsumer.SpringMessageReceive;

import javax.jms.JMSException;
import javax.jms.TextMessage;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestConsumer {

    @Autowired
    private MessageReceive messageReceive;

    @Test
    public void test() throws JMSException {

        for (int i = 0; i < 15; i++) {
           String s = messageReceive.start();
           System.out.println(s);
        }

    }


    @Test
    public void testSpringJms() throws JMSException {
        SpringMessageReceive messageReceive = SpringMessageReceive.getInstance();
        TextMessage textMessage = (TextMessage) messageReceive.getMessage("testSpring");

        System.out.println(textMessage.getText());


    }

}
