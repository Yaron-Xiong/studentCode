package com.accompnay.io.nettycoreprinciple;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;

import java.nio.charset.StandardCharsets;

public class HttpClientHandler extends ChannelInboundHandlerAdapter  {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpContent) {
            HttpContent httpContent = (HttpContent) msg;
            ByteBuf byteBuf = httpContent.content();
            System.out.println(byteBuf.toString(StandardCharsets.UTF_8));
            byteBuf.release();
        }
    }
}
