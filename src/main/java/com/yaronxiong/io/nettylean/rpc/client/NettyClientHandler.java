package com.yaronxiong.io.nettylean.rpc.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    private ChannelHandlerContext ctx;
    private String result;
    private String para;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(" channel active 被调用了");
        this.ctx = ctx;
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(" channel read 被调用了");
        this.result = msg.toString();
        this.notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }


    /**
     * 此时异步执行远程调用
     */
    @Override
    public synchronized Object call() throws Exception {
        System.out.println("call1 被调用了 ");
        ctx.writeAndFlush(this.para);
        //此时陷入等待，等待channelRead 调用notify
        this.wait();
        System.out.println("call2被调用了");
        return result;
    }

    void setPara(String para) {
        System.out.println("setParams 被调用了" + para);
        this.para = para;
    }
}
