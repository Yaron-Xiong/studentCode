package com.yaronxiong.algorithms.leetcode.weekly.w340;

import java.util.*;

/**
 * 6360. 等值距离和
 * 提示
 * 中等
 * 2
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums 。现有一个长度等于 nums.length 的数组 arr 。
 * 对于满足 nums[j] == nums[i] 且 j != i 的所有 j ，arr[i] 等于所有 |i - j| 之和。如果不存在这样的 j ，则令 arr[i] 等于 0 。
 * <p>
 * 返回数组 arr 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1,1,2]
 * 输出：[5,0,3,4,0]
 * 解释：
 * i = 0 ，nums[0] == nums[2] 且 nums[0] == nums[3] 。因此，arr[0] = |0 - 2| + |0 - 3| = 5 。
 * i = 1 ，arr[1] = 0 因为不存在值等于 3 的其他下标。
 * i = 2 ，nums[2] == nums[0] 且 nums[2] == nums[3] 。因此，arr[2] = |2 - 0| + |2 - 3| = 3 。
 * i = 3 ，nums[3] == nums[0] 且 nums[3] == nums[2] 。因此，arr[3] = |3 - 0| + |3 - 2| = 4 。
 * i = 4 ，arr[4] = 0 因为不存在值等于 2 的其他下标。
 * 示例 2：
 * <p>
 * 输入：nums = [0,5,3]
 * 输出：[0,0,0]
 * 解释：因为 nums 中的元素互不相同，对于所有 i ，都有 arr[i] = 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sum-of-distances/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L6360_Distance {
	public static void main(String[] args) {
		L6360_Distance l6360Distance = new L6360_Distance();
		long[] distance = l6360Distance.distance(new int[]{0, 5, 3, 1, 2, 8, 6, 6, 6});
		System.out.println(Arrays.toString(distance));
	}

	public long[] distance(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.computeIfAbsent(nums[i], (k) -> new ArrayList<>()).add(i);
		}
		long[] res = new long[nums.length];
		long[] preSum = new long[nums.length];
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> indexList = entry.getValue();
			preSum[0] = indexList.get(0);
			for (int i = 1; i < indexList.size(); i++) {
				preSum[i] = preSum[i - 1] + indexList.get(i);
			}
			for (int i = 0; i < indexList.size(); i++) {
				long lowValue = i > 0 ? (long) i * indexList.get(i) - preSum[i - 1] : 0;
				long highValue = (preSum[indexList.size() - 1] - preSum[i]) - ((long) (indexList.size() - i - 1) * indexList.get(i));
				res[indexList.get(i)] = lowValue + highValue;
			}
		}
		return res;
	}
}
