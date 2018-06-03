package org.zwx.io.nio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Nio2Client {

    private AsynchronousSocketChannel channel;
    private CharBuffer charBuffer;

    private CharsetDecoder deecoder = Charset.defaultCharset().newDecoder();

    private BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));

    private void init() throws IOException {
        channel = AsynchronousSocketChannel.open();

        if (channel.isOpen()) {
            channel.setOption(StandardSocketOptions.SO_RCVBUF, 128 * 1024);
            channel.setOption(StandardSocketOptions.SO_SNDBUF, 128 * 1024);
            channel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
            Future<Void> connect = channel.connect(new InetSocketAddress("127.0.0.1", 8090));
        } else {
            throw new RuntimeException("channel is not open!!!");
        }
    }

    private void start() throws IOException, ExecutionException, InterruptedException {
        String request = clientInput.readLine();

        channel.write(ByteBuffer.wrap(request.getBytes()));

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (channel.read(byteBuffer).get() != -1) {
            byteBuffer.flip();
            charBuffer = deecoder.decode(byteBuffer);
            String response = charBuffer.toString().trim();

            System.out.println("响应请求：" + response);

            if (byteBuffer.hasRemaining()) {
                byteBuffer.compact();
            } else {
                byteBuffer.clear();
            }
            request = clientInput.readLine();

            channel.write(ByteBuffer.wrap(request.getBytes()));
        }

    }


    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        Nio2Client nio2Client = new Nio2Client();
        nio2Client.init();
        nio2Client.start();
    }

}
