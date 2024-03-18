package com.yaronxiong.algorithms.practiceSet.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 877. 石子游戏
 * Alice 和 Bob 用几堆石子在做游戏。
 * 一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
 * <p>
 * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
 * <p>
 * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。
 * 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
 * <p>
 * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [5,3,4,5]
 * 输出：true
 * 解释：
 * Alice 先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果 Bob 拿走前 3 颗，那么剩下的是 [4,5]，Alice 拿走后 5 颗赢得 10 分。
 * 如果 Bob 拿走后 5 颗，那么剩下的是 [3,4]，Alice 拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对 Alice 来说是一个胜利的举动，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：piles = [3,7,2,3]
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 2 <= piles.length <= 500
 * piles.length 是 偶数
 * 1 <= piles[i] <= 500
 * sum(piles[i]) 是 奇数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/stone-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StoneGame {

	public static void main(String[] args) {
		StoneGame stoneGame = new StoneGame();
		boolean b = stoneGame.stoneGame2(new int[]{2, 8, 3, 5});
		System.out.println(b);
	}

	public boolean stoneGame2(int[] piles) {
		int n = piles.length;
		int[][][] dp = new int[n][n][2];
		for (int i = 0; i < n; i++) {
			dp[i][i][0] = piles[i];
			dp[i][i][1] = 0;
		}
		int row = dp.length - 2;
		while (row >= 0) {
			int j = dp.length - 1;
			int i = row;
			while (i >= 0 && j >= 0) {
				int a = dp[i][j - 1][1] + piles[j];
				int b = dp[i + 1][j][1] + piles[i];
				if (a > b) {
					dp[i][j][0] = a;
					dp[i][j][1] = dp[i][j - 1][0];
				} else {
					dp[i][j][0] = b;
					dp[i][j][1] = dp[i + 1][j][0];
				}
				j--;
				i--;
			}
			row--;
		}
		return dp[0][n - 1][0] - dp[0][n - 1][1] > 0;
	}

	public boolean stoneGame(int[] piles) {
		for (int pile : piles) {
			mun += pile;
		}
		mun = mun / 2;
		return dp(piles, 0, piles.length - 1, true);
	}

	int mun = 0;
	int aValue = 0;
	int bValue = 0;
	private Set<String> memo = new HashSet<>();

	private boolean dp(int[] piles, int start, int end, boolean flag) {
		if (start >= piles.length || start > end || end <= 0) {
			return aValue > bValue;
		}
		if (aValue >= mun) {
			return true;
		}
		if (bValue >= mun) {
			return false;
		}
		String key = start + "#" + end + "#" + flag;
		if (memo.contains(key)) {
			return false;
		}
		aValue = flag ? aValue + piles[start] : aValue;
		bValue = !flag ? bValue + piles[start] : bValue;
		if (dp(piles, start + 1, end, !flag)) {
			return true;
		}
		aValue = flag ? aValue - piles[start] : aValue;
		bValue = !flag ? bValue - piles[start] : bValue;

		aValue = flag ? aValue + piles[end] : aValue;
		bValue = !flag ? bValue + piles[end] : bValue;
		if (dp(piles, start, end - 1, !flag)) {
			return true;
		}
		aValue = flag ? aValue - piles[end] : aValue;
		bValue = !flag ? bValue - piles[end] : bValue;
		memo.add(key);
		return false;
	}
}
