package com.accompnay.io.nettylean.rpc;

public class ServerBootstrap {
    public static void main(String[] args) throws InterruptedException {
        NettyServer.startServer(9007);
    }
}
