package com.yaronxiong.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
	public static void main(String[] args) throws IOException {
		System.out.println("开启服务器...");
		Selector serverSelector = Selector.open();

		Selector clientSelector = Selector.open();

		//处理接受到的请求，并且建立好了三次握手->将用户的socket转移到clientSelector
		new Thread(() -> {
			try {
				ServerSocketChannel listenerChannel = ServerSocketChannel.open();
				listenerChannel.socket().bind(new InetSocketAddress(4567));
				listenerChannel.configureBlocking(false); //非阻塞模型
				listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
				while (true) {
					//证明有新的连接
					if (serverSelector.select(1) > 0) {
						Set<SelectionKey> set = serverSelector.selectedKeys();
						Iterator<SelectionKey> keyIterator = set.iterator();
						while (keyIterator.hasNext()) {
							SelectionKey key = keyIterator.next();
							if (key.isAcceptable()) {
								try {
									System.out.println("三次握手建立完成...");
									SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
									clientChannel.configureBlocking(false);
									clientChannel.register(clientSelector, SelectionKey.OP_READ);
								} finally {
									keyIterator.remove();
								}
							}
						}
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();

		//处理用户的请求
		new Thread(() -> {
			try {
				while (true) {
					//用户传递好数据后开始
					if (clientSelector.select(1) > 0) {
						Set<SelectionKey> selectionKeys = clientSelector.selectedKeys();
						Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
						while (keyIterator.hasNext()){
							SelectionKey key = keyIterator.next();
							if (key.isReadable()) {
								try {
									System.out.println("开始处理用户请求");
									SocketChannel clientChannel = (SocketChannel) key.channel();
									ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
									clientChannel.read(byteBuffer);
									byteBuffer.flip();
									System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
								}catch (Exception e){
									keyIterator.remove();
									key.interestOps(SelectionKey.OP_READ);
								}
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
