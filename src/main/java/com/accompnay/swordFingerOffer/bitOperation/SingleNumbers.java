package com.accompnay.swordFingerOffer.bitOperation;

import java.util.Arrays;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数:https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 */
public class SingleNumbers {
	public static void main(String[] args) {
		SingleNumbers singleNumbers = new SingleNumbers();
		int[] ints = singleNumbers.singleNumbers(new int[]{4, 1, 4, 6});
		System.out.println(Arrays.toString(ints));
	}

	public int[] singleNumbers(int[] nums) {
		int n = 0;
		for (int num : nums) {
			n ^= num;
		}
		int m = 1;
		while ((n & m) == 0) {
			m <<= 1;
		}
		int x = 0;
		int y = 0;
		for (int num : nums) {
			if ((num & m) == 0) x ^= num;
			else y ^= num;
		}
		return new int[]{x, y};
	}
}
