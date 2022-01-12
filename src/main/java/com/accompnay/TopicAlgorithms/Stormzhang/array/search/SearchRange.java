package com.accompnay.TopicAlgorithms.Stormzhang.array.search;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置:https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例2：
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
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {
	public static void main(String[] args) {
		SearchRange searchRange = new SearchRange();
		searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
	}

	public int[] searchRange(int[] nums, int target) {
		int left = searchLeft(nums, target, 0, nums.length - 1);
		int right = left == -1 ? -1 : searchRight(nums, target, left, nums.length - 1);
		return new int[]{left, right};
	}

	public int searchLeft(int[] nums, int target, int left, int right) {
		int mid;
		while (left <= right) {
			mid = (left + right) >> 1;
			if (nums[mid] == target) {
				right = mid - 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (left > nums.length - 1 || nums[left] != target) return -1;
		return left;
	}

	public int searchRight(int[] nums, int target, int left, int right) {
		int mid;
		while (left <= right) {
			mid = (left + right) >> 1;
			if (nums[mid] == target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (right < 0 || nums[right] != target) return -1;
		return right;
	}


}
