package com.yaronxiong.io.nettylean.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.net.InetSocketAddress;

public class MyServer {
    public void start(int port) throws InterruptedException {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new HttpServerCodec())
                                    .addLast(new ChunkedWriteHandler())
                                    .addLast(new HttpObjectAggregator(8192))
                                    .addLast(new WebSocketServerProtocolHandler("/hello2"))
                                    .addLast(new MyTextWebSocketFrameHandler());
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(port)).sync();
            channelFuture.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    System.out.println("websocket 绑定端口=" + port);
                } else {
                    System.out.println("websocket启动失败");
                }
            });
            channelFuture.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyServer myServer = new MyServer();
        myServer.start(9007);
    }
    /**
     * hello.html
     *
     * <!DOCTYPE html>
     * <html lang="en">
     * <head>
     *     <meta charset="UTF-8">
     *     <title>Title</title>
     * </head>
     * <body>
     * <script>
     *     var socket;
     *     //判断当前浏览器是否支持websocket
     *     if(window.WebSocket) {
     *         //go on
     *         socket = new WebSocket("ws://localhost:9007/hello2");
     *         //相当于channelReado, ev 收到服务器端回送的消息
     *         socket.onmessage = function (ev) {
     *             var rt = document.getElementById("responseText");
     *             rt.value = rt.value + "\n" + ev.data;
     *         }
     *
     *         //相当于连接开启(感知到连接开启)
     *         socket.onopen = function (ev) {
     *             var rt = document.getElementById("responseText");
     *             rt.value = "连接开启了.."
     *         }
     *
     *         //相当于连接关闭(感知到连接关闭)
     *         socket.onclose = function (ev) {
     *
     *             var rt = document.getElementById("responseText");
     *             rt.value = rt.value + "\n" + "连接关闭了.."
     *         }
     *     } else {
     *         alert("当前浏览器不支持websocket")
     *     }
     *
     *     //发送消息到服务器
     *     function send(message) {
     *         if(!window.socket) { //先判断socket是否创建好
     *             return;
     *         }
     *         if(socket.readyState == WebSocket.OPEN) {
     *             //通过socket 发送消息
     *             socket.send(message)
     *         } else {
     *             alert("连接没有开启");
     *         }
     *     }
     * </script>
     *     <form onsubmit="return false">
     *         <textarea name="message" style="height: 300px; width: 300px"></textarea>
     *         <input type="button" value="发生消息" onclick="send(this.form.message.value)">
     *         <textarea id="responseText" style="height: 300px; width: 300px"></textarea>
     *         <input type="button" value="清空内容" onclick="document.getElementById('responseText').value=''">
     *     </form>
     * </body>
     * </html>
     */
}
