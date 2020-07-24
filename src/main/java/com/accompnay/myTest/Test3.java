package com.accompnay.myTest;

import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Test3 {
	public static void main(String[] args) {
		final String FORMAT = "%s = %s <%s@aobi.com>";
		String sourceFile = "E:\\service_info\\AUTHORS";
		String destFile = "E:\\service_info\\AUTHORS_GIT";
		try {
			List<String> lines = Files.readAllLines(Paths.get(sourceFile));
			List<String> text = new ArrayList<>();
			for (String line : lines) {
				String lineStr = StringUtils.trimWhitespace(line);
				String tmp = String.format(FORMAT, lineStr, lineStr , lineStr);
				text.add(tmp);
			}
			Files.write(Paths.get(destFile), text);
			System.out.println("vs记录转git模式生成完毕");
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}

