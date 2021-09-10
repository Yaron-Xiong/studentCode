package com.accompnay.swordFingerOffer.doublePointer;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Exchange {
	public int[] exchange(int[] nums) {
		int evenPoint = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 != 0) {
				swap(nums, i, evenPoint + 1);
				evenPoint++;
			}
		}
		return nums;
	}

	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void main(String[] args) {
		Exchange exchange = new Exchange();
		int[] exchange1 = exchange.exchange(new int[]{});
		System.out.println(Arrays.toString(exchange1));
	}
}
