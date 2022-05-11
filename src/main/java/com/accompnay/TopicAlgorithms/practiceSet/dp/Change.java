package com.accompnay.TopicAlgorithms.practiceSet.dp;

/**
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 * <p>
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 * <p>
 * 输入：amount = 10, coins = [10]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * coins 中的所有值 互不相同
 * 0 <= amount <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Change {
	public static void main(String[] args) {
		Change change = new Change();
		int change1 = change.change(0, new int[]{7});
		System.out.println(change1);
	}

	public int change(int amount, int[] coins) {
		if (amount <= 0) {
			return 1;
		}
		return dp(amount, coins, 0);
	}

	private int dp(int amount, int[] coins, int i) {
		if (amount < 0) {
			return 0;
		}
		if (amount == 0) {
			return 1;
		}
		int res = 0;
		for (int j = i; j < coins.length; j++) {
			res += dp(amount - coins[j], coins, j);
		}
		return res;
	}
}
