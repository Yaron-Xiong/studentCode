package com.yaronxiong.algorithms.practiceSet.list.binarysearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
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
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {
	public static void main(String[] args) {
		SearchRange searchRange = new SearchRange();
		int[] ints = searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 11);
		System.out.println(Arrays.toString(ints));
	}

	public int[] searchRange(int[] nums, int target) {
		int leftBond = getLeftBound(nums, target);
		int rightBound = leftBond == -1 ? -1 : getRightBound(nums, target);
		//寻找右边界
		return new int[]{leftBond, rightBound};
	}

	private int getRightBound(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (nums[mid] == target) {
				left = mid + 1;
			} else if (target > nums[mid]) {
				left = mid + 1;
			} else if (target < nums[mid]) {
				right = mid;
			}
		}
		return nums[left - 1] != target ? -1 : left - 1;
	}

	private int getLeftBound(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (nums[mid] == target) {
				right = mid;
			} else if (target < nums[mid]) {
				right = mid;
			} else if (target > nums[mid]) {
				left = mid + 1;
			}
		}
		return left == nums.length || nums[left] != target ? -1 : left;
	}

}
