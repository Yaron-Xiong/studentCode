package com.carlotta;

import java.util.Scanner;

/**
 * @author qiuping zeng
 * 2.流程控制
 * 小结：
 * if ... else可以做条件判断，else是可选的；不推荐省略花括号{}；多个if ... else串联要特别注意判断顺序；要注意if的边界条件；
 * 要注意浮点数判断相等不能直接用==运算符；引用类型判断内容相等要使用equals()，注意避免NullPointerException。
 * 练习：
 * 请用if ... else编写一个程序，用于计算体质指数BMI，并打印结果。
 * BMI = 体重(kg)除以身高(m)的平方
 * BMI结果：过轻：低于18.5; 正常：18.5-25;  过重：25-28;  肥胖：28-32; 非常肥胖：高于32
 */
public class DemoBy2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("weight:");
		double weight = scanner.nextDouble();
		System.out.println("height:");
		double height = scanner.nextDouble();
		double BMI = DemoBy2.test(weight,height);
		if (BMI < 18.5) {
			System.out.println("过轻：低于18.5");
		} else if (BMI < 25 && BMI >= 18.5) {
			System.out.println("正常：18.5-25");
		} else if (BMI < 28 && BMI >= 25) {
			System.out.println("过重：25-28");
		} else if (BMI < 32 && BMI >= 28) {
			System.out.println("肥胖：28-32");
		} else {
			System.out.println("非常肥胖：高于32");
		}
	}

	public static double test(double weight, double height) {
		double BMI = weight / height;
		return BMI;
	}
}
