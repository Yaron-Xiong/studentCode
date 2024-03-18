package com.carlotta;

import java.util.Scanner;

/**
 * @author qiuping zeng
 * notice:
 *        while循环先判断循环条件是否满足，再执行循环语句；while循环可能一次都不执行；编写循环时要注意循环条件，并避免死循环。
 *        do while循环先执行循环，再判断条件；do while循环会至少执行一次。
 * pratice:
 *        使用while计算从m到n的和：
 */
public class DemoBy4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("input start number:");
		int start = scanner.nextInt();
		System.out.println("input end number:");
		int end = scanner.nextInt();
		int sum = 0;
		while (start <= end) {
			sum = sum + start;
			start++;
		}
		System.out.printf("sum From start to end:%d", sum);
	}
}
