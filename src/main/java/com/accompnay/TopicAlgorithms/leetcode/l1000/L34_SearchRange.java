package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 中等
 * 2.2K
 * 相关企业
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：n
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L34_SearchRange {
	public static void main(String[] args) {
		L34_SearchRange l34SearchRange = new L34_SearchRange();
		int[] ints = l34SearchRange.searchRange(new int[]{5, 7, 7, 8, 8, 8}, 8);
		System.out.println(Arrays.toString(ints));
	}

	public int[] searchRange(int[] nums, int target) {
		int leftIndex = getLeftIndex(nums, target, 0, nums.length);
		if (leftIndex < 0) {
			return new int[]{-1, -1};
		}
		int rightIndex = getRightIndex(nums, target, leftIndex, nums.length);
		return new int[]{leftIndex, rightIndex};
	}

	public int getLeftIndex(int[] nums, int target, int left, int right) {
		int index = -1;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (target > nums[mid]) {
				left = mid + 1;
			} else if (target < nums[mid]) {
				right = mid;
			} else {
				index = mid;
				right = mid;
			}
		}
		return index;
	}

	public int getRightIndex(int[] nums, int target, int left, int right) {
		int index = -1;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (target > nums[mid]) {
				left = mid + 1;
			} else if (target < nums[mid]) {
				right = mid;
			} else {
				index = mid;
				left = mid + 1;
			}
		}
		return index;
	}


}
