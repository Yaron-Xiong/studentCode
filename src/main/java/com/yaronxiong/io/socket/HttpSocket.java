package com.yaronxiong.io.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class HttpSocket extends Thread {
	private Socket connection;

	public HttpSocket(Socket connection) {
		this.connection = connection;
	}

	@Override
	public void run() {
		try {
			System.out.println("线程" + Thread.currentThread().getName());
			if (Objects.isNull(connection)) {
				throw new RuntimeException("连接异常");
			}
			Request request = Request.parse(connection);
			Response response = new Response(request, connection);
			response.send();
			closeConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeConnection() throws IOException {
		connection.close();
	}


}
