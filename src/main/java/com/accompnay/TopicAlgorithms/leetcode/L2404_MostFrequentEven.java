package com.accompnay.TopicAlgorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2404. 出现最频繁的偶数元素
 * 提示
 * 简单
 * 29
 * 相关企业
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 * <p>
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,4,9,2,4]
 * 输出：4
 * 解释：4 是出现最频繁的偶数元素。
 * 示例 3：
 * <p>
 * 输入：nums = [29,47,21,41,13,37,25,7]
 * 输出：-1
 * 解释：不存在偶数元素。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * 0 <= nums[i] <= 105
 */
public class L2404_MostFrequentEven {
	public static void main(String[] args) {
		L2404_MostFrequentEven l2404MostFrequentEven = new L2404_MostFrequentEven();
		System.out.println(l2404MostFrequentEven.mostFrequentEven(new int[]{8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290}));
	}
	public int mostFrequentEven(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int curMaxNum = -1;
		for (int num : nums) {
			if (num % 2 != 0) {
				continue;
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
			if (curMaxNum == -1 || map.get(num) > map.get(curMaxNum) || (num < curMaxNum && map.get(num).equals(map.get(curMaxNum)))) {
				curMaxNum = num;
			}
		}
		return curMaxNum;
	}
}
