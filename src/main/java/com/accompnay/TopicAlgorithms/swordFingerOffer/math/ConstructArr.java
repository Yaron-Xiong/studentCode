package com.accompnay.TopicAlgorithms.swordFingerOffer.math;

import java.util.Arrays;

/**
 * 剑指 Offer 66. 构建乘积数组:https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * 提示：
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class ConstructArr {

	public static void main(String[] args) {
		ConstructArr constructArr = new ConstructArr();
		int[] ints = constructArr.constructArr(new int[]{1, 2, 3, 4, 5});
		System.out.println(Arrays.toString(ints));
	}

	public int[] constructArr(int[] a) {
		if (a==null || a.length == 0) return a;
		int[] b = new int[a.length];
		b[0] = 1;
		for (int i = 1; i < a.length; i++) {
			b[i] = b[i - 1] * a[i - 1];
		}
		int temp = 1;
		for (int i = a.length - 2; i >= 0; i--) {
			temp = temp * a[i + 1];
			b[i] = b[i] * temp;
		}
		return b;
	}

}
