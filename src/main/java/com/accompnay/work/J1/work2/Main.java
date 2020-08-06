package com.accompnay.work.J1.work2;

import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		String filePath = args[0];
		String poolSize = args[1];
		IWordRead wordRead = new DirectoryReadImpl(Integer.parseInt(poolSize));
		List<String> wordList = wordRead.wordList(filePath);
		WordHandler handler = new WordHandler();
		List<String> list = handler.handler(wordList,10);
		System.out.println(list);
	}
}
