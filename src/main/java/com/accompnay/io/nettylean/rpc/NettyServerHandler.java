package com.accompnay.io.nettylean.rpc;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private HelloService helloService = new HelloServiceImpl();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("mes=" + msg);
        String[] split = msg.toString().split("#");
        String serviceName = split[0];
        String methodName = split[1];
        String body = split[2];
        if (serviceName.equals(HelloService.class.getName())) {
            for (Method method : HelloService.class.getMethods()) {
                if (method.getName().equals(methodName)) {
                    Object result = method.invoke(helloService, body);
                    ctx.writeAndFlush(result);
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
