package com.carlotta;

import java.util.Scanner;

/**
 * @author qiuping.zeng
 * 2.流程控制
 * 输入上次考试成绩（int）和本次考试成绩（int），然后输出成绩提高的百分比，保留两位小数位（例如，21.75%）。
 * 小结：
 * Java提供的输出包括：System.out.println() / print() / printf()，其中printf()可以格式化输出；
 * Java提供Scanner对象来方便输入，读取对应的类型可以使用：scanner.nextLine() / nextInt() / nextDouble() / ...
 */
public class DemoBy1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("input last score:");
		int last = scanner.nextInt();
		System.out.println("input current score:");
		int current = scanner.nextInt();
		System.out.printf("So,last score:%d,current score:%d\n ", last, current);
		DemoBy1.test(last, current);
	}

	public static void test(int x, int y) {
		double improve = (y - x) / x;
		System.out.printf("%.2f%%\n", improve);
	}
}
