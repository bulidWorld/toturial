package org.zwx.rabbitMQ.ch5;

import com.rabbitmq.client.Channel;
import org.zwx.rabbitMQ.helper.Action;
import org.zwx.rabbitMQ.helper.Constant;
import org.zwx.rabbitMQ.helper.MessageTemplate;

import java.io.IOException;

public class TopicSubAction implements Action {

    //#可以匹配任意多个字节点，但剩下的还是要进行完全匹配
    private static final String BINDING_KEY = "#.b";

    private static final String EXCHANGE_NAME = "log_topic";


    @Override
    public void action(Channel channel) throws IOException {

        //声明为topic类型的消息发布，订阅，且绑定到一个exchange上
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //获取一个随机的，exclusive， not durable的queue
        String queueName = channel.queueDeclare().getQueue();
        //把queue与binding key绑定起来
        channel.queueBind(queueName, Constant.TOPIC_EXCHANGE_NAME, BINDING_KEY);

        MessageTemplate.consumeMsg(channel, queueName);

    }
}
