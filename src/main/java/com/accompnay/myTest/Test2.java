package com.accompnay.myTest;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	public static void main(String[] args) throws Exception {
		String argsStr = "\"\" ab \"ad\" bc\"ac";
		List<String> result1 = method2(argsStr);
		List<String> result = method3(argsStr);
		if (!equals(result1,result)) {
			System.out.println(result);
			System.out.println(result1);
		}
	}

	private static boolean equals(List<String> list1,List<String> list2){
		if (list1.size() != list2.size()){
			return false;
		}
		for (int i = 0; i < list1.size(); i++) {
			String s = list1.get(i);
			String s1 = list2.get(i);
			if (!s.equals(s1)) {
				return false;
			}
		}
		return true;
	}
	private static List<String> method3(String argsStr) {
		String pattern = "\"(?<value>.*?)\"";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(argsStr);
		StringBuilder builder = new StringBuilder(argsStr);
		List<String> values = Lists.newArrayList();
		String placeholder = "#RNG#";
		while (matcher.find()) {
			String s = matcher.group();
			String value = matcher.group("value");
			values.add(value);
			int indexOf = builder.indexOf(s);
			builder.replace(indexOf, indexOf + s.length(), placeholder);
		}

		String[] result = builder.toString().split("\\s+");
		int index = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[i].equals(placeholder)) {
				result[i] = values.get(index++);
			}
		}
		return Lists.newArrayList(result);
	}


	private static List<String> method2(String argsStr) {
		boolean flag = false;
		boolean blank = false;
		String temp = "";
		List<String> result = Lists.newArrayList();
		for (char c : argsStr.toCharArray()) {
			//结束多空格模式
			if (c != ' ' && blank) {
				result.add(temp);
				temp = "";
				blank = false;
			}
			//左引号
			if (c == '"' && !flag) {
				flag = true;
				continue;
			}
			//右引号
			if (c == '"' && flag) {
				flag = false;
				continue;
			}
			//分号里面的空格
			if (c == ' ' && flag) {
				temp += c;
				continue;
			}
			//空格模式
			if (c == ' ' && !flag) {
				blank = true;
				continue;
			}
			//计算正常字符
			temp += c;
		}
		if (flag){
			//throw new RuntimeException("分号不成对");
		}
		result.add(temp);
		return result;
	}

}
