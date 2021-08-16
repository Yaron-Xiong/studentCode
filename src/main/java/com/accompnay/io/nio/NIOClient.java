package com.accompnay.io.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NIOClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",4567);
		OutputStream stream = socket.getOutputStream();
		String s = "你真是一个B";
		stream.write(s.getBytes());
		stream.close();
	}
}
