package org.zwx.example.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.zwx.example.handlers.TimeClientHandler;

public class TimeClient {
    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup workGroup = new NioEventLoopGroup();

        Bootstrap b = new Bootstrap();
        b.group(workGroup);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE, true);

        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new TimeClientHandler());
            }
        });

        ChannelFuture cf = b.connect("127.0.0.1", 8081).sync();

    }
}
