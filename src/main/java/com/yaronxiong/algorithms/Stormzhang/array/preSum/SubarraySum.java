package com.yaronxiong.algorithms.Stormzhang.array.preSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * <p>
 * 给你一个整数数组 nums 和一个整数k ，请你统计并返回该数组中和为k的连续子数组的个数。
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
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraySum {
	public static void main(String[] args) {
		SubarraySum subarraySum = new SubarraySum();
		int i = subarraySum.subarraySum(new int[]{1}, 0);
		System.out.println(i);
	}

	/**
	 * 前缀和特性
	 * fx 为0~x的和
	 * fy 为0~y的和
	 * 那么如果求x~y的和则为  fx-fy-1
	 *
	 * 根据题意需要计算和为k的子序列
	 * 既 fx - fy = k
	 * 那么 fy = fx -k
	 * x 为 遍历的下表索引 并且 x!=y
	 */
	public int subarraySum(int[] nums, int k) {
		//前n项和
		int pre = 0;
		//符合的子序列次数
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		//因可以选择不与前面的和进行相减 故需要放入0,1
		map.put(0, 1);
		for (int num : nums) {
			pre += num;
			if (map.containsKey(pre - k)) {
				count += map.get(pre - k);
			}
			//因为 x!=y 故put需要放在判断后执行
			map.put(pre, map.getOrDefault(pre, 0) + 1);
		}
		return count;
	}

}
