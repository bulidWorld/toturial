package org.zwx.example.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        ByteBuf byteBuf = ctx.alloc().buffer(4);

        byteBuf.writeInt((int)(System.currentTimeMillis()/1000L + 2208988800L));

        final ChannelFuture f = ctx.writeAndFlush(byteBuf);

        f.addListener((future)-> {
            System.out.println(f == future);
            ctx.close();
        });
    }
}
