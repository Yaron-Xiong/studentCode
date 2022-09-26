package com.accompnay.TopicAlgorithms.practiceSet.dp;

/**
 * 174. 地下城游戏
 * <p>
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。
 * <p>
 * 我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；
 * 其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * <p>
 * -2 (K)	-3	3
 * <p>
 * -5	-10	1
 * <p>
 * 10	30	-5 (P)
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * <p>
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CalculateMinimumHP {
	public static void main(String[] args) {
		int[][] dungeon = new int[][]{{-2}, {1}};
		CalculateMinimumHP calculateMinimumHP = new CalculateMinimumHP();
		int i = calculateMinimumHP.calculateMinimumHP(dungeon);
		System.out.println(i);
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int rowCount = dungeon.length;
		int colCount = dungeon[0].length;
		int[][] dp = new int[rowCount][colCount];
		dp[rowCount - 1][colCount - 1] = ofValue(1 - dungeon[rowCount - 1][colCount - 1]);

		for (int i = rowCount - 2; i >= 0; i--) {
			dp[i][colCount - 1] = ofValue(dp[i + 1][colCount - 1] - dungeon[i][colCount - 1]);
		}


		for (int i = colCount - 2; i >= 0; i--) {
			dp[rowCount - 1][i] = ofValue(dp[rowCount - 1][i + 1] - dungeon[rowCount - 1][i]);
		}

		for (int i = rowCount - 2; i >= 0; i--) {
			for (int j = colCount - 2; j >= 0; j--) {
				dp[i][j] = ofValue(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
			}
		}

		return dp[0][0];
	}

	private int ofValue(int initValue) {
		return initValue <= 0 ? 1 : initValue;
	}

}
