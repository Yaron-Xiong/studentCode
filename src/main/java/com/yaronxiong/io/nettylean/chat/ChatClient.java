package com.yaronxiong.io.nettylean.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChatClient {

    private final SocketChannel socketChannel;
    private final Selector selector;
    private final String userName;

    public ChatClient() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8009));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        userName = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(userName + " is ok..");
    }

    public void sendInfo(String info) {
        info = userName + " 说:" + info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readInfo() throws IOException {
        int cnt = this.selector.select();
        if (cnt > 0) {
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    String s = new String(buffer.array());
                    System.out.println(s);
                }
            }
            iterator.remove();
        } else {
            System.out.println("等待服务器发送消息过来");
        }
    }

    public static void main(String[] args) throws IOException {
        ChatClient chatClient = new ChatClient();
        new Thread(() -> {
            while (true) {
                try {
                    chatClient.readInfo();
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            chatClient.sendInfo(nextLine);
        }
    }


}
