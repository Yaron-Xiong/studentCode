package com.accompnay.io.nettylean.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class NettyServiceHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务端读取线程" + Thread.currentThread().getName());
        System.out.println("服务端 ctx" + ctx);
        System.out.println("看看channel 与 pipeline 的关系");
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline();

        ByteBuf buffer = (ByteBuf) msg;
        String message = buffer.toString(StandardCharsets.UTF_8);
        System.out.println("客户端发送的消息是" + message);
        System.out.println("客户端的地址是" + channel.remoteAddress());


        //向客户端发送异步消息
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("客户端你好呀2。".getBytes(StandardCharsets.UTF_8)));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("客户端你好呀3。".getBytes(StandardCharsets.UTF_8)));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("客户端你好呀4。".getBytes(StandardCharsets.UTF_8)));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 10, TimeUnit.SECONDS);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("客户端你好呀。".getBytes(StandardCharsets.UTF_8)));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
