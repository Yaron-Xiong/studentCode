package com.carlotta;

import java.util.Random;
import java.util.Scanner;

/**
 * @author qiuping zeng
 * 2.流程控制
 * 小结：switch语句可以做多重选择，然后执行匹配的case语句后续代码；switch的计算结果必须是整型、字符串或枚举类型；
 * 注意千万不要漏写break，建议打开fall-through警告；总是写上default，建议打开missing default警告；
 * 从Java 14开始，switch语句正式升级为表达式，不再需要break，并且允许使用yield返回值。
 * 练习：
 * 使用switch实现一个简单的石头、剪子、布游戏。(Stone, scissors, cloth)
 */
public class DemoBy3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("石头是1，剪刀是2，布是3，请输入你的：");
		int user = scanner.nextInt();
		Random random = new Random();
		int computer = random.nextInt(2) + 1;
	}

	public static int play(int user, int computer) {
		int result = 0;
		switch (user) {
			case 1:
				switch (computer) {
					case 1:
						result = 0;
						break;
					case 2:
						result = 1;
						break;
					default:
						result = -1;
						break;
				}
				break;
		}
		return result;
	}
}
