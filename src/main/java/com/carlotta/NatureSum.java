package com.carlotta;

/**
 * @author.qiuqping.zeng 计算前N个自然数的和可以根据公式：
 * ((1+N)×N)/2
 * 请根据公式计算前N个自然数的和
 */
public class NatureSum {
	public static void main(String[] args) {
		int N = 100;
		NatureSum natureSum = new NatureSum();
		int sum = natureSum.Sum(N);
		System.out.println(sum);
		N = 1000;
		int sum1 = natureSum.Sum(N);
		System.out.println(sum1);
	}

	public int Sum(int a){
		return ((1+a)*a)/2;
	}

}
