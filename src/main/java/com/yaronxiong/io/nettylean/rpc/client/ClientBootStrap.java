package com.yaronxiong.io.nettylean.rpc.client;

import com.yaronxiong.io.nettylean.rpc.HelloService;

import java.util.concurrent.TimeUnit;

public class ClientBootStrap {

    public static final String providerName = HelloService.class.getName();

    public static void main(String[] args) throws InterruptedException {
        NettyClient nettyClient = new NettyClient();
        HelloService bean = (HelloService) nettyClient.getBean(HelloService.class, providerName);
        int count = 0;
        for (; ; ) {
            TimeUnit.SECONDS.sleep(2);
            String hello = bean.hello("你好 dubbo~ " + (++count));
            System.out.println("调用的结果" + hello);
        }

    }
}
