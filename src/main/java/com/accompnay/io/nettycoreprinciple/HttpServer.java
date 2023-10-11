package com.accompnay.io.nettycoreprinciple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServer {
    public void start(int port) throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup bossEventLoopGroup = new NioEventLoopGroup();
        NioEventLoopGroup workEventLoopGroup = new NioEventLoopGroup();
        serverBootstrap.group(bossEventLoopGroup, workEventLoopGroup)
                .channel(NioServerSocketChannel.class)
                .localAddress(port)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast("codec", new HttpServerCodec()) // Http编码解析
                                .addLast("compressor", new HttpContentCompressor()) //Http Content 压缩
                                .addLast("aggregator", new HttpObjectAggregator(65536)) //Http消息聚合
                                .addLast("handler", new HttpServerHandler());
                    }
                })
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        ChannelFuture sync = serverBootstrap.bind().sync();
        System.out.println("Http Server started ,Listening on " + port);
        sync.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        new HttpServer().start(8091);
    }
}
