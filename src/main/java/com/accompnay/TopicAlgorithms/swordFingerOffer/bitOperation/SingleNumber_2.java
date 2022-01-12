package com.accompnay.TopicAlgorithms.swordFingerOffer.bitOperation;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 */
public class SingleNumber_2 {
	public static void main(String[] args) {
		SingleNumber_2 singleNumber_2 = new SingleNumber_2();
		int i = singleNumber_2.singleNumber(new int[]{4, 4, 4, 6});
		System.out.println(i);
	}

	public int singleNumber(int[] nums) {
		int[] arr = new int[32];
		for (int num : nums) {
			for (int i = 0; i < 32; i++) {
				arr[i] += num & 1;
				num >>>= 1;
			}
		}
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res |= (arr[i] % 3) << i;
		}
		return res;
	}
}
