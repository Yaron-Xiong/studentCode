package com.yaronxiong.io.socket;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(4567);
		while (true){
			try {
				Socket connection  = serverSocket.accept();
				Thread task = new HttpSocket(connection);
				task.start();
			}catch (Exception e){
				System.out.println("出异常啦");
			}
		}
	}
}
