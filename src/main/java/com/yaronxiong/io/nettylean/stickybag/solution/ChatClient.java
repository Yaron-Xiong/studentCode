package com.yaronxiong.io.nettylean.stickybag.solution;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class ChatClient {
    public void start(String host, int port) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new MyMessageEncoder())
                                    .addLast(new MyMessageDecoder())
                                    .addLast(new MyClientHandler());
                        }
                    });
            ChannelFuture sync = bootstrap.connect(new InetSocketAddress(host, port)).sync();
            sync.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ChatClient chatClient = new ChatClient();
        chatClient.start("127.0.0.1", 9007);
    }
}
