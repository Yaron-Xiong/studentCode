package com.accompnay.TopicAlgorithms.practiceSet.list.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class SubarraySum {
	public static void main(String[] args) {
		SubarraySum subarraySum = new SubarraySum();
		int i = subarraySum.subarraySum(new int[]{0, 0}, 0);
		System.out.println(i);
	}

	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		map.put(0, 1);

		int preSum = 0;
		int res = 0;

		for (int num : nums) {
			preSum += num;
			int j = preSum - k;
			if (map.containsKey(j)) {
				res += map.get(j);
			}
			Integer count = map.computeIfAbsent(preSum, (key) -> 0);
			map.put(preSum, count + 1);
		}
		return res;
	}
}
