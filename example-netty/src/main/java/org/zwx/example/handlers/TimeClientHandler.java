package org.zwx.example.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf result = (ByteBuf) msg;


        try {
            long currentTimeMilli = (result.readUnsignedInt() - 2208988800L)*1000L;
            Date date = new Date(currentTimeMilli);

            System.out.println(date);
        } finally {
            result.release();
        }
    }
}
