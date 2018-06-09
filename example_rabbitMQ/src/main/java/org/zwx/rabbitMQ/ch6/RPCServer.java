package org.zwx.rabbitMQ.ch6;

import com.rabbitmq.client.*;
import org.zwx.rabbitMQ.helper.Constant;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;

public class RPCServer {

    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost(Constant.HOST);
        factory.setUsername("admin");
        factory.setPassword("admin");
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Connection connection = null;
        try {
            connection      = factory.newConnection();
            final Channel channel = connection.createChannel();

            channel.queueDeclare(Constant.RPC_QUEUE, false, false, false, null);

            //设置preFetchCount属性，为了平衡性能
            channel.basicQos(1);

            System.out.println(" [x] Awaiting RPC requests");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                   //设置消息的属性
                    AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                            .Builder()
                            .correlationId(properties.getCorrelationId())
                            .build();
                    //properties 含有的属性：。。。


                    String response = "";

                    try {
                        String message = new String(body,"UTF-8");
                        int n = Integer.parseInt(message);

                        System.out.println(" [.] fib(" + message + ")");
                        response += fib(n);
                    }
                    catch (RuntimeException e){
                        System.out.println(" [.] " + e.toString());
                    }
                    finally {
                        //最后返回消息给QUEUE，以待RPC的调用者接受result
                        channel.basicPublish( "", properties.getReplyTo(), replyProps, response.getBytes("UTF-8"));
                        //确认收到消息
//                        channel.basicAck(envelope.getDeliveryTag(), false);
                        // RabbitMq consumer worker thread notifies the RPC server owner thread
                        //唤醒自己所在的线程
                        synchronized(this) {
                            this.notify();
                        }
                    }
                }
            };

            boolean autoAck = false;
            channel.basicConsume(Constant.RPC_QUEUE, autoAck, consumer);

            // Wait and be prepared to consume the message from RPC client.
            while (true) {
                synchronized(consumer) {
                    try {
                        consumer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (IOException _ignore) {}
        }

    }


    //斐波那契数列求和
    private static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }
}
