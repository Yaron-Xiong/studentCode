package com.accompnay.TopicAlgorithms.leetcode;

/**
 * 1590. 使数组和能被 P 整除
 * 提示
 * 中等
 * 90
 * 相关企业
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 * <p>
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 * <p>
 * 子数组 定义为原数组中连续的一组元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,4,2], p = 6
 * 输出：1
 * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [6,3,5,2], p = 9
 * 输出：2
 * 解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3], p = 3
 * 输出：0
 * 解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
 * 示例  4：
 * <p>
 * 输入：nums = [1,2,3], p = 7
 * 输出：-1
 * 解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
 * 示例 5：
 * <p>
 * 输入：nums = [1000000000,1000000000,1000000000], p = 3
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= p <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1509_MinSubarray {
	public static void main(String[] args) {
		L1509_MinSubarray l1509MinSubarray = new L1509_MinSubarray();
		System.out.println(l1509MinSubarray.minSubarray(new int[]{1000000000,1000000000,1000000000}, 3));
	}

	public int minSubarray(int[] nums, int p) {
		long[] preCount = new long[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			preCount[i + 1] = preCount[i] + nums[i];
		}
		long allAmount = preCount[preCount.length - 1];
		if (allAmount % p == 0) {
			return 0;
		}
		int delCount = 1;
		while (delCount + 1 < preCount.length) {
			for (int i = delCount; i < preCount.length; i++) {
				if ((allAmount - (preCount[i] - preCount[i - delCount])) % p == 0) {
					return delCount;
				}
			}
			delCount++;
		}
		return -1;
	}
}
