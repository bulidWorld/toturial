package test.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zwx.toturial.producer.MessageFactory;
import org.zwx.toturial.producer.SpringMessageProducer;
import sun.plugin2.message.Message;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestProducer {

    @Autowired
    private MessageFactory messageProducer;

    @Test
    public void test() {

        for (int i = 0; i < 10; i++) {
            messageProducer.start("hello world!!" + i);
        }

    }

    @Test
    public void testSpring() {
        SpringMessageProducer messageProducer = SpringMessageProducer.getInstance();

        messageProducer.sendMessage("testSpring","hello spring jms");
    }

}
