package com.accompnay.io.nettylean.rpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class NettyClient {
    private static AtomicInteger count = new AtomicInteger();
    private ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static NettyClientHandler client;

    public Object getBean(final Class<?> serviceClass, final String providerName) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{serviceClass}, (proxy, method, args) -> {
                    //System.out.println(proxy);
                    System.out.println(method);
                    System.out.println(Arrays.toString(args));
                    System.out.println("(proxy, method, args) 进入...[%s] 次" + count.incrementAndGet());
                    if (client == null) {
                        initClient();
                    }
                    client.setPara(serviceClass.getName()+"#"+ method.getName() + "#" + args[0]);

                    return executorService.submit(client).get();
                });
    }

    private void initClient() throws InterruptedException {
        client = new NettyClientHandler();
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new StringDecoder())
                                .addLast(new StringEncoder())
                                .addLast(client);
                    }
                });

        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9007).sync();
    }

}
