package com.accompnay.TopicAlgorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2367. 算术三元组的数目
 * 提示
 * 简单
 * 36
 * 相关企业
 * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
 * <p>
 * i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * 返回不同 算术三元组 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,4,6,7,10], diff = 3
 * 输出：2
 * 解释：
 * (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
 * (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,8,9], diff = 2
 * 输出：2
 * 解释：
 * (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
 * (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 200
 * 0 <= nums[i] <= 200
 * 1 <= diff <= 50
 * nums 严格 递增
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-arithmetic-triplets/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2367_ArithmeticTriplets {
	public static void main(String[] args) {
		L2367_ArithmeticTriplets l2367ArithmeticTriplets = new L2367_ArithmeticTriplets();
		System.out.println(l2367ArithmeticTriplets.arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
	}

	public int arithmeticTriplets(int[] nums, int diff) {
		Set<Integer> set = new HashSet<>();
		int res = 0;
		for (int num : nums) {
			if (set.contains(num - diff)) {
				if (set.contains(num - diff - diff)) {
					res++;
				}
			}
			set.add(num);
		}
		return res;
	}
}
