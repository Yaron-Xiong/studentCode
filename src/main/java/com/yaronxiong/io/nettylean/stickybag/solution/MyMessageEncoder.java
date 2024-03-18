package com.yaronxiong.io.nettylean.stickybag.solution;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyMessageEncoder extends MessageToByteEncoder<MessageProtocol> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("encoder被调用了");
        int len = msg.getLen();
        byte[] content = msg.getContent();
        out.writeInt(len);
        out.writeBytes(content);
    }
}
