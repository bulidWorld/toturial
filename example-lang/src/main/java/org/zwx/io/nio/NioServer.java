package org.zwx.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServer {
    private Selector selector;


    private void init() throws IOException {

        this.selector = Selector.open();

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);

        ServerSocket serverSocket = channel.socket();

        serverSocket.bind(new InetSocketAddress(8090));
        //服务端注册接受事件
        channel.register(this.selector, SelectionKey.OP_ACCEPT);
    }


    private void start() throws IOException {
        while (true) {

            this.selector.select();

            Iterator<SelectionKey> iterator = this.selector.keys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                iterator.remove();
                if (key.isAcceptable()) {
                    accept(key);
                } else if (key.isReadable()) {
                    read(key);
                }

            }


        }
    }

    private void read(SelectionKey key) throws IOException {

        SocketChannel channel = (SocketChannel) key.channel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        System.out.println(new String(buffer.array()));

        channel.write(ByteBuffer.wrap("请求收到！".getBytes()));
    }


    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        serverSocketChannel.accept();
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
    }


    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer();
        nioServer.init();
        nioServer.start();
    }

}
