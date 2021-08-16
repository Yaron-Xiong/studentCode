package com.carlotta;

import java.util.Scanner;

/**
 * @author qiuping.zeng
 * 2.流程控制
 * 从控制台读取一个字符串和一个整数的例子
 */
public class Demo1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("input your name:");
		String name = scanner.nextLine();
		System.out.println("input your age:");
		int age = scanner.nextInt();
		System.out.printf("Your name is:%s ;age is %d", name, age);
	}
}
