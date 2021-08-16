package com.accompnay.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Request {
	private String uri;
	private InputStream inputStream;
	private String encoding = "GBK";

	public Request(String uri, InputStream inputStream) {
		this.uri = uri;
		this.inputStream = inputStream;
	}

	public Request(String uri, InputStream inputStream, String encoding) {
		this.uri = uri;
		this.inputStream = inputStream;
		this.encoding = encoding;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public static Request parse(Socket connection) throws IOException {
		System.out.println("解析请求头");
		//获取请求行
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = reader.readLine();
		System.out.println(line);
		return new Request(line,connection.getInputStream());
	}
}
