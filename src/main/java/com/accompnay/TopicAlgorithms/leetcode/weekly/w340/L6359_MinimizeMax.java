package com.accompnay.TopicAlgorithms.leetcode.weekly.w340;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 6359. 最小化数对的最大差值
 * 提示
 * 中等
 * 1
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 p 。
 * 请你从 nums 中找到 p 个下标对，每个下标对对应数值取差值，你需要使得这 p 个差值的 最大值 最小。
 * 同时，你需要确保每个下标在这 p 个下标对中最多出现一次。
 * <p>
 * 对于一个下标对 i 和 j ，这一对的差值为 |nums[i] - nums[j]| ，其中 |x| 表示 x 的 绝对值 。
 * <p>
 * 请你返回 p 个下标对对应数值 最大差值 的 最小值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,1,2,7,1,3], p = 2
 * 输出：1
 * 解释：第一个下标对选择 1 和 4 ，第二个下标对选择 2 和 5 。
 * 最大差值为 max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1 。所以我们返回 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,2,1,2], p = 1
 * 输出：0
 * 解释：选择下标 1 和 3 构成下标对。差值为 |2 - 2| = 0 ，这是最大差值的最小值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= p <= (nums.length)/2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimize-the-maximum-difference-of-pairs/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L6359_MinimizeMax {
	public int minimizeMax(int[] nums, int p) {
		Integer[] sortArr = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			sortArr[i] = i;
		}
		Arrays.sort(sortArr, Comparator.comparingInt(a -> nums[a]));
		return -1;
	}
}
