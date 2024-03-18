package com.yaronxiong.io.nettylean.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;

public class HttpMessageHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        System.out.println("对应channel=" + ctx.channel() + " pipeline=" + ctx.pipeline() + "通过pipeline获取到的channel=" + ctx.pipeline().channel());
        System.out.println("当前ctx的handler=" + ctx.handler());

        if (msg instanceof HttpRequest) {
            System.out.println("ctx类型= " + ctx.getClass());
            System.out.println("pipeline hashCode=" + ctx.pipeline().hashCode());
            System.out.println("msg类型= " + msg.getClass());
            System.out.println("客户端地址=" + ctx.channel().remoteAddress());
            HttpRequest httpRequest = (HttpRequest) msg;
            URI uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("请求了 favicon.ico 不做响应");
                return;
            }
            ByteBuf buf = Unpooled.copiedBuffer("hello 这里是熊熊 请问你需要什么？".getBytes(StandardCharsets.UTF_8));
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buf);
            response.headers().add(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, buf.readableBytes());
            response.headers().set(HttpHeaderNames.CONTENT_ENCODING, "utf8");
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }
    }
}
