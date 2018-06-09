package org.zwx.rabbitMQ.ch2;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.Receiver;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Worker {

    private static final String HOST = "";

    private static final int PORT = 0;

    private static final String QUEUE_NAME = "QUEUE_TASK";

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //接收到消息手动通知broker

                try{
                    doWork(new String(body, StandardCharsets.UTF_8));
                } finally {
                    //是否通知up到目前为止的所有消息
                    boolean multiple = true;
                    channel.basicAck(envelope.getDeliveryTag(), multiple);

                    //拒绝消息,will discard message
//                    channel.basicReject(envelope.getDeliveryTag(), multiple);

                    //requeue message
//                    channel.basicNack(envelope.getDeliveryTag(), true, multiple);

                }

            }
        };

        //接受到消息是否自动通知broker
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);


    }

    /**
     * 处理Task
     * @param task
     */
    private static void doWork(String task) {
        LOG.info("receive Task:" + task);
    }
}
