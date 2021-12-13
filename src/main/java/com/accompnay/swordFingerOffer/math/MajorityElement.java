package com.accompnay.swordFingerOffer.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 */
public class MajorityElement {
	public static void main(String[] args) {
		MajorityElement majorityElement = new MajorityElement();
		int i = majorityElement.majorityElement3(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
		System.out.println(i);
	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.merge(num, 1, (oldValue, newValue) -> oldValue + 1);
		}
		int i = nums.length / 2;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > i) {
				return entry.getKey();
			}
		}
		return 0;
	}

	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[Math.floorDiv(nums.length, 2)];
	}

	public int majorityElement3(int[] nums) {
		int num = nums[0];
		int stick = 0;
		for (int i : nums) {
			if (stick == 0) {
				num = i;
			}
			if (i == num) {
				stick++;
			} else {
				stick--;
			}
		}
		return num;
	}
}
