package com.accompnay.work.J1.work2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TxtWordReadImpl implements IWordRead {
	@Override
	public List<String> wordList(String filePath) throws Exception {
		List<String> result = new ArrayList<>();
		try (FileInputStream fileInputStream = new FileInputStream(filePath);
		     InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
		     BufferedReader bufferedReader = new BufferedReader(reader)) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String word = line.trim();
				result.add(word);
			}
		}
		return result;
	}
}
