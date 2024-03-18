package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 35. 搜索插入位置
 * 简单
 * 1.9K
 * 相关企业
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/search-insert-position/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L35_SearchInsert {
	public static void main(String[] args) {
		L35_SearchInsert l35SearchInsert = new L35_SearchInsert();
		System.out.println(l35SearchInsert.searchInsert(new int[]{1,3,5,6}, 7));
	}

	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (target > nums[mid]) {
				left = mid + 1;
			} else if (target < nums[mid]) {
				right = mid;
			} else {
				left = mid;
				break;
			}
		}
		return left;
	}
}
