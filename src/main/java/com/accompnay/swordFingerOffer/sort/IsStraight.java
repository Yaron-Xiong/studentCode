package com.accompnay.swordFingerOffer.sort;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 剑指 Offer 61. 扑克牌中的顺子：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * <p>
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 示例1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 */
public class IsStraight {
	public static void main(String[] args) {
		IsStraight isStraight = new IsStraight();
		boolean straight = isStraight.isStraight2(new int[]{0, 0, 1, 2, 5});
		System.out.println(straight);
	}

	public boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int joker = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				joker++;
			} else if (i > 0 && nums[i] == nums[i - 1]) {
				return false;
			}
		}
		return nums[nums.length - 1] - nums[joker] < 5;
	}

	public boolean isStraight2(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num == 0) continue;
			if (set.contains(num)) {
				return false;
			}
			set.add(num);
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		return max - min < 5;
	}
}
