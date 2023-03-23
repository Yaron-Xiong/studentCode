package com.accompnay.TopicAlgorithms.leetcode;

import java.util.*;

/**
 * 2488. 统计中位数为 K 的子数组
 * 提示
 * 困难
 * 60
 * 相关企业
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 * <p>
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 * <p>
 * 注意：
 * <p>
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * 子数组是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,1,4,5], k = 4
 * 输出：3
 * 解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1], k = 3
 * 输出：1
 * 解释：[3] 是唯一一个中位数等于 3 的子数组。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i], k <= n
 * nums 中的整数互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-subarrays-with-median-k/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2488_CountSubarrays {
	public static void main(String[] args) {
		L2488_CountSubarrays l2488CountSubarrays = new L2488_CountSubarrays();
		System.out.println(l2488CountSubarrays.countSubarrays(new int[]{3, 2, 1, 4, 5}, 4));
	}


	public int countSubarrays(int[] nums, int k) {
		int kIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == k) {
				kIndex = i;
				break;
			}
		}

		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		int sum = 0;
		map.put(0, 1);//相当于直接就是k当做子数组
		for (int i = 0; i < nums.length; i++) {
			sum += getSum(nums[i] - k);
			if (i < kIndex) {
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			} else {
				int a = map.getOrDefault(sum, 0);
				int b = map.getOrDefault(sum - 1, 0);
				res = res + a + b;
			}
		}
		return res;
	}

	public int getSum(int num) {
		if (num == 0) return 0;
		return num > 0 ? 1 : -1;
	}
}
