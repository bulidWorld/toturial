package org.zwx.io.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioClient {

    private Selector selector;
    private BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));

    public void init() throws IOException {
        this.selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8090));
        socketChannel.register(this.selector, SelectionKey.OP_CONNECT);
    }

    public void start() throws IOException {
        while (true) {
            this.selector.select();
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //防止重复处理
                iterator.remove();
                if (key.isConnectable()) {
                    connect(key);
                } else if (key.isReadable()) {
                    read(key);
                }
            }

        }


    }

    private void connect(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        if (channel.isConnectionPending()) {
            if (channel.finishConnect()) {
                channel.configureBlocking(false);
                channel.register(this.selector, SelectionKey.OP_READ);
                String request = clientInput.readLine();
                channel.write(ByteBuffer.wrap(request.getBytes()));
            } else {
                key.cancel();
            }
        }
    }


    private void read(SelectionKey key) throws IOException {

        SocketChannel channel = (SocketChannel) key.channel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        String request = new String(byteBuffer.array()).trim();
        System.out.println("服务端响应：" + request);

        String nextRequest = clientInput.readLine();
        ByteBuffer buffer = ByteBuffer.wrap(nextRequest.getBytes());
        channel.write(buffer);
    }

    public static void main(String[] args) throws IOException {
        NioClient client = new NioClient();
        client.init();
        client.start();
    }


}
