package com.accompnay.io.model1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Server {
	public static void testServer() throws IOException {
		//1.创建选择器
		Selector selector = Selector.open();

		//2.获取通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		//3.设置为非阻塞
		serverSocketChannel.configureBlocking(false);

		//4.绑定端口
		serverSocketChannel.bind(new InetSocketAddress(12456));

		//5.注册选择器，并且注册的操作为 “建立三次握手的连接”
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


	}
}
