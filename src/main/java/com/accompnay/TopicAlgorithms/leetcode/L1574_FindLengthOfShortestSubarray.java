package com.accompnay.TopicAlgorithms.leetcode;

/**
 * 1574. 删除最短的子数组使剩余数组有序
 * 提示
 * 中等
 * 142
 * 相关企业
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * <p>
 * 一个子数组指的是原数组中连续的一个子序列。
 * <p>
 * 请你返回满足题目要求的最短子数组的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 * 示例 2：
 * <p>
 * 输入：arr = [5,4,3,2,1]
 * 输出：4
 * 解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3]
 * 输出：0
 * 解释：数组已经是非递减的了，我们不需要删除任何元素。
 * 示例 4：
 * <p>
 * 输入：arr = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1574_FindLengthOfShortestSubarray {
	public static void main(String[] args) {
		L1574_FindLengthOfShortestSubarray l1574FindLengthOfShortestSubarray = new L1574_FindLengthOfShortestSubarray();
		int lengthOfShortestSubarray = l1574FindLengthOfShortestSubarray.findLengthOfShortestSubarray(new int[]{10, 13, 17, 21, 15, 15, 9, 17, 22, 22, 13});
		System.out.println(lengthOfShortestSubarray);
	}

	public int findLengthOfShortestSubarray(int[] arr) {
		int right = arr.length - 1;
		while (right > 0 && arr[right] >= arr[right - 1]) {
			right--;
		}
		if (right == 0) {
			return 0;
		}
		int left = 0;
		int res = right;
		while (left == 0 || arr[left-1] <= arr[left]) {
			while (right < arr.length && arr[left] > arr[right]) {
				right++;
			}
			res = Math.min(res, right - left - 1);
			left++;
		}
		return res;
	}
}
