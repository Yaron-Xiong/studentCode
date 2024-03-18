package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1615. 最大网络秩
 * 提示
 * 中等
 * 59
 * 相关企业
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 * <p>
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 * <p>
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
 * <p>
 * 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * 输出：4
 * 解释：城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次。
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
 * 输出：5
 * 解释：共有 5 条道路与城市 1 或 2 相连。
 * 示例 3：
 * <p>
 * 输入：n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
 * 输出：5
 * 解释：2 和 5 的网络秩为 5，注意并非所有的城市都需要连接起来。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * 0 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 2
 * 0 <= ai, bi <= n-1
 * ai != bi
 * 每对城市之间 最多只有一条 道路相连
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximal-network-rank/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1615_MaximalNetworkRank {
	public static void main(String[] args) {
		L1615_MaximalNetworkRank l1615MaximalNetworkRank = new L1615_MaximalNetworkRank();
		System.out.println(l1615MaximalNetworkRank.maximalNetworkRank2(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}));
	}

	public int maximalNetworkRank2(int n, int[][] roads) {
		int[][] matrix = new int[n + 1][n + 1];
		for (int[] road : roads) {
			matrix[road[0]][road[1]] = 1;
			matrix[road[1]][road[0]] = 1;
			matrix[road[0]][n]++;
			matrix[road[1]][n]++;
		}
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				int temp = matrix[i][n] + matrix[j][n];;
				if (matrix[i][j] == 1) {
					temp--;
				}
				res = Math.max(temp, res);
			}
		}
		return res;
	}

	public int maximalNetworkRank(int n, int[][] roads) {
		int[][] matrix = new int[n][n];
		for (int[] road : roads) {
			matrix[road[0]][road[1]] = 1;
			matrix[road[1]][road[0]] = 1;
		}
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				int temp = 0;
				for (int z = 0; z < n; z++) {
					temp = temp + matrix[i][z] + matrix[j][z];
				}
				if (matrix[i][j] == 1) {
					temp--;
				}
				res = Math.max(temp, res);
			}
		}
		return res;
	}
}
