package com.yaronxiong.io.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Response {
	private Request request;
	private Socket connection;

	public Response(Request request, Socket connection) {
		this.request = request;
		this.connection = connection;
	}


	public void send() throws IOException {
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		//返回一个状态行
		out.println("HTTP/1.0 201 你是个小可爱");
		out.println("Content-Typeasdasd:HTTP/1.1 301 你是个小可爱2222");
		out.println("我是新来的");
		//返回一个首部
		out.println("Content-Type:text/html;charset=" + request.getEncoding());
		// 根据 HTTP 协议, 空行将结束头信息
		out.println();

		// 输出请求资源
		out.println("<h1 style='color: green'> Hello Http Server</h1>");
		out.println("你好, 这是一个 Java HTTP 服务器 demo 应用.<br>");
		out.println("您请求的路径是: " + request.getUri() + "<br>");
		out.close();
	}
}
