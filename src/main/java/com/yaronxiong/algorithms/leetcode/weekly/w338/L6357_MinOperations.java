package com.yaronxiong.algorithms.leetcode.weekly.w338;

import java.util.*;

/**
 * 2602. 使数组元素全部相等的最少操作次数
 * 提示
 * 中等
 * 16
 * 相关企业
 * 给你一个正整数数组 nums 。
 * <p>
 * 同时给你一个长度为 m 的整数数组 queries 。第 i 个查询中，你需要将 nums 中所有元素变成 queries[i] 。你可以执行以下操作 任意 次：
 * <p>
 * 将数组里一个元素 增大 或者 减小 1 。
 * 请你返回一个长度为 m 的数组 answer ，其中 answer[i]是将 nums 中所有元素变成 queries[i] 的 最少 操作次数。
 * <p>
 * 注意，每次查询后，数组变回最开始的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,6,8], queries = [1,5]
 * 输出：[14,10]
 * 解释：第一个查询，我们可以执行以下操作：
 * - 将 nums[0] 减小 2 次，nums = [1,1,6,8] 。
 * - 将 nums[2] 减小 5 次，nums = [1,1,1,8] 。
 * - 将 nums[3] 减小 7 次，nums = [1,1,1,1] 。
 * 第一个查询的总操作次数为 2 + 5 + 7 = 14 。
 * 第二个查询，我们可以执行以下操作：
 * - 将 nums[0] 增大 2 次，nums = [5,1,6,8] 。
 * - 将 nums[1] 增大 4 次，nums = [5,5,6,8] 。
 * - 将 nums[2] 减小 1 次，nums = [5,5,5,8] 。
 * - 将 nums[3] 减小 3 次，nums = [5,5,5,5] 。
 * 第二个查询的总操作次数为 2 + 4 + 1 + 3 = 10 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,9,6,3], queries = [10]
 * 输出：[20]
 * 解释：我们可以将数组中所有元素都增大到 10 ，总操作次数为 8 + 1 + 4 + 7 = 20 。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 105
 * 1 <= nums[i], queries[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-operations-to-make-all-array-elements-equal/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L6357_MinOperations {
	public static void main(String[] args) {
		L6357_MinOperations l6357MinOperations = new L6357_MinOperations();
		System.out.println(l6357MinOperations.minOperations(new int[]{3, 1, 6, 8}, new int[]{1, 5}));
	}

	public List<Long> minOperations(int[] nums, int[] queries) {
		Arrays.sort(nums);
		long[] preSum = new long[nums.length];
		preSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i];
		}
		List<Long> res = new ArrayList<>();
		for (int i = 0; i < queries.length; i++) {
			int left = 0;
			int right = nums.length;
			int mid = 0;
			while (left < right) {
				mid = (left + right) >> 1;
				if (nums[mid] > queries[i]) {
					right = mid;
				} else if (nums[mid] < queries[i]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			long abs = 0;
			if (right > 0) {
				abs += Math.abs(preSum[right - 1] - ((long) queries[i] * (right)));
			}
			if (right < nums.length) {
				abs += Math.abs((preSum[nums.length - 1] - preSum[right] + nums[right]) - ((long) queries[i] * (nums.length - right)));
			}
			res.add(abs);
		}
		return res;
	}
}
