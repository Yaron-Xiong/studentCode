package com.accompnay.TopicAlgorithms.swordFingerOffer.search;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I :https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 提示：
 * nums是一个非递减数组
 * <p>
 * <p>
 */
public class Search_I {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int leftIndex = -1;
		int rightIndex = 0;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				leftIndex = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (leftIndex == -1) {
			return 0;
		}

		left = 0;
		right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				rightIndex = mid;
				left = mid + 1;
			} else {
				left = mid + 1;
			}
		}
		return rightIndex - leftIndex + 1;
	}

	public static void main(String[] args) {
		Search_I search_i = new Search_I();
		int count = search_i.search(new int[]{5, 7, 8, 8, 8, 10}, 8);
		System.out.println(count);
	}
}
