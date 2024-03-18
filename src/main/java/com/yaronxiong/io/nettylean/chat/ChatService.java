package com.yaronxiong.io.nettylean.chat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class ChatService {
    private Selector selector;
    private int port = 8009;
    private final ServerSocketChannel listenChannel;

    public ChatService() {
        try {
            this.selector = Selector.open();
            this.listenChannel = ServerSocketChannel.open();
            this.listenChannel.socket().bind(new InetSocketAddress(port));
            this.listenChannel.configureBlocking(false);
            this.listenChannel.register(this.selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void listen() {
        try {
            while (true) {
                int selectCnt = this.selector.select();
                if (selectCnt > 0) {
                    //这时候拿到的key对应的状态是 已完成tcp三次握手
                    Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        if (selectionKey.isAcceptable()) {
                            SocketChannel accept = listenChannel.accept();
                            accept.configureBlocking(false);
                            //这时候注册一个新事件，当这个连接完成时 再通知回来
                            accept.register(this.selector, SelectionKey.OP_READ);
                            System.out.println(accept.getRemoteAddress() + "上线");
                        }
                        if (selectionKey.isReadable()) {
                            readData(selectionKey);
                        }
                        iterator.remove();
                    }
                } else {
                    System.out.println("等待客户端接入");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readData(SelectionKey selectionKey) {
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int size = channel.read(byteBuffer);
            if (size > 0) {
                String msg = new String(byteBuffer.array());
                System.out.println("客户端发的消息为：" + msg.trim());
                sendInfoToOtherClients(msg, channel);
            }
        } catch (IOException e) {
            if (channel == null) {
                System.out.println("Io异常无法获取客户端socket" + e.toString());
                return;
            }
            try {
                selectionKey.cancel();
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void sendInfoToOtherClients(String msg, SocketChannel channel) throws IOException {
        System.out.println("服务端开始转发消息到其他客户端");
        for (SelectionKey selectionKey : this.selector.keys()) {
            Channel targetChannel = selectionKey.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != channel) {
                SocketChannel dest = (SocketChannel) targetChannel;
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
                dest.write(byteBuffer);
            }
        }
    }

    public static void main(String[] args) {
        ChatService chatService = new ChatService();
        chatService.listen();
    }
}
