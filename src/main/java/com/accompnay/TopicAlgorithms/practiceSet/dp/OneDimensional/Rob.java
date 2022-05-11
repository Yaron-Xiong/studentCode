package com.accompnay.TopicAlgorithms.practiceSet.dp.OneDimensional;

import java.util.HashMap;
import java.util.Map;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob {
	public static void main(String[] args) {
		Rob rob = new Rob();
		int rob1 = rob.rob2(new int[]{2, 7, 9, 3, 1});
		System.out.println(rob1);
	}

	public int rob2(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int n_2 = nums[0];
		int n_1 = Math.max(n_2, nums[1]);
		int maxDp = Math.max(n_2, n_1);
		for (int i = 2; i < nums.length; i++) {
			int temp = Math.max(n_2 + nums[i], n_1);
			n_2 = n_1;
			n_1 = temp;
			maxDp = Math.max(maxDp, temp);
		}
		return maxDp;
	}

	public int rob(int[] nums) {
		return dp(nums, nums.length - 1);
	}

	private Map<String, Integer> memo = new HashMap<>();

	private int dp(int[] nums, int i) {
		if (i < 0) {
			return 0;
		}
		String key = Integer.toString(i);
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		int dp;
		dp = dp(nums, i - 2) + nums[i];
		dp = Math.max(dp(nums, i - 1), dp);
		memo.put(key, dp);
		return dp;
	}
}
