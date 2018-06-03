package org.zwx.io.nio2;

import org.zwx.io.nio.NioServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class Nio2Server {


    private AsynchronousServerSocketChannel channel;


    class ServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Void> {

        private AsynchronousServerSocketChannel serverChannel;
        private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        private CharBuffer charBuffer;

        private CharsetDecoder decoder = Charset.defaultCharset().newDecoder();

        public ServerCompletionHandler(AsynchronousServerSocketChannel channel) {
            this.serverChannel = channel;
        }



        @Override
        public void completed(AsynchronousSocketChannel result, Void attachment) {

            serverChannel.accept(null, this);
            try {
                while (result.read(byteBuffer).get() != -1) {
                    byteBuffer.flip();

                    charBuffer = decoder.decode(byteBuffer);
                    String request = charBuffer.toString().trim();
                    System.out.println("收到请求:" + request);

                    result.write(ByteBuffer.wrap("收到请求".getBytes()));

                    if (byteBuffer.hasRemaining()) {
                        byteBuffer.compact();
                    } else {
                        byteBuffer.clear();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                try {
                    result.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        public void failed(Throwable exc, Void attachment) {
            serverChannel.accept(null, this);

            throw new RuntimeException("链接失败");
        }
    }

    public void init() throws IOException {

        channel = AsynchronousServerSocketChannel.open();
        if (channel.isOpen()) {
            channel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
            channel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            channel.bind(new InetSocketAddress("127.0.0.1", 8090));
        } else {
            throw new RuntimeException("open channel failed");
        }
    }

    public void start() throws InterruptedException {
        channel.accept(null, new ServerCompletionHandler(channel));

        while (true) {
            Thread.sleep(5000);
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Nio2Server nio2Server = new Nio2Server();
        nio2Server.init();
        nio2Server.start();
    }
}

