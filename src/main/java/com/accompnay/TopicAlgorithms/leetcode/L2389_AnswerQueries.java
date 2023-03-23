package com.accompnay.TopicAlgorithms.leetcode;

import java.util.Arrays;

/**
 * 2389. 和有限的最长子序列
 * 提示
 * 简单
 * 42
 * 相关企业
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 * <p>
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
 * <p>
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,2,1], queries = [3,10,21]
 * 输出：[2,3,4]
 * 解释：queries 对应的 answer 如下：
 * - 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
 * - 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
 * - 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,4,5], queries = [1]
 * 输出：[0]
 * 解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 1000
 * 1 <= nums[i], queries[i] <= 106
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-subarrays-with-median-k/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2389_AnswerQueries {
	public static void main(String[] args) {
		L2389_AnswerQueries l2389AnswerQueries = new L2389_AnswerQueries();
		int[] x = l2389AnswerQueries.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21});
		System.out.println(Arrays.toString(x));
	}

	public int[] answerQueries(int[] nums, int[] queries) {
		Arrays.sort(nums);
		int[] preSum = new int[nums.length];
		preSum[0] = nums[0];
		for (int i = 1; i < preSum.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i];
		}
		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int left = 0;
			int right = preSum.length;
			int mid = 0;
			while (left < right) {
				mid = (left + right) >> 1;
				if (queries[i] > preSum[mid]) {
					left = mid + 1;
				} else if (queries[i] < preSum[mid]) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			ans[i] = right;
		}
		return ans;
	}


}
