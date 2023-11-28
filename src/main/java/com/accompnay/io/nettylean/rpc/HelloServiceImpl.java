package com.accompnay.io.nettylean.rpc;

import java.util.concurrent.atomic.AtomicInteger;

public class HelloServiceImpl implements HelloService {
    private static final AtomicInteger count = new AtomicInteger();

    @Override
    public String hello(String mes) {
        System.out.println(String.format("收到客户端消息[%s]", mes));
        if (mes != null) {
            return String.format("你好客户端，我已经收到了你的消息 [%s] 第 [%s] 次", mes, count.incrementAndGet());
        } else {
            return "你好客户端，我已经收到了你的消息";
        }
    }
}
