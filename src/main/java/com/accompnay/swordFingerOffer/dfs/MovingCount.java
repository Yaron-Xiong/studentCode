package com.accompnay.swordFingerOffer.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 剑指 Offer 13. 机器人的运动范围:https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k<= 20
 */
public class MovingCount {
	public static void main(String[] args) {
		MovingCount movingCount = new MovingCount();
		int i = movingCount.movingCount2(3, 2, 17);
		System.out.println(i);
	}

	public int movingCount2(int m, int n, int k) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0});
		int result = 0;
		boolean[][] matrix = new boolean[m][n];
		while (!queue.isEmpty()) {
			int[] ints = queue.poll();
			int curM = ints[0];
			int curN = ints[1];
			if (curM >= m || curN >= n || matrix[curM][curN] || getNumber(curM) + getNumber(curN) > k) {
				continue;
			}
			matrix[curM][curN] = true;
			queue.add(new int[]{curM + 1, curN});
			queue.add(new int[]{curM, curN + 1});
			result++;
		}
		return result;
	}

	private Set<String> set = new HashSet<>();

	public int movingCount(int m, int n, int k) {
		return dfs(m, n, 0, 0, k);
	}

	public int dfs(int m, int n, int y, int x, int k) {
		//当机器人走的位置超出了格子 或 当前存在障碍物则返回0
		if (y >= m || x >= n || getNumber(x) + getNumber(y) > k || !set.add(y + ":" + x)) {
			return 0;
		}
		return dfs(m, n, y + 1, x, k) + dfs(m, n, y, x + 1, k) + 1;
	}

	public int getNumber(int a) {
		int result = 0;
		while (a != 0) {
			result += a % 10;
			a = a / 10;
		}
		return result;
	}
}
