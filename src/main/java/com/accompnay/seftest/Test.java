package com.accompnay.seftest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Test {

	public static class Student{
		 String name ;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\a.txt");
		FileOutputStream stream = new FileOutputStream(file);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 24000000; i++) {
			builder.append("abcde\n");
		}
		stream.write(builder.toString().getBytes(StandardCharsets.UTF_8));
		stream.close();
	}
}
