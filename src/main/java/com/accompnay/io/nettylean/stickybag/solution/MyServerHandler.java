package com.accompnay.io.nettylean.stickybag.solution;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;

public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    int count = 0;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();
        System.out.println("服务端接受到的内容如下");
        System.out.printf("长度 [%s]%n", len);
        System.out.printf("服务端接受到的内容 [%s]%n", new String(content, StandardCharsets.UTF_8));
        System.out.printf("服务端接受到的消息数 [%s]%n", ++this.count);


        String message = "receive the message , i'm server " +this.count;
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(bytes.length);
        messageProtocol.setContent(bytes);
        ctx.writeAndFlush(messageProtocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
