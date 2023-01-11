package com.accompnay.TopicAlgorithms.practiceSet.graph;

/***
 * 547. 省份数量
 * 中等
 * 915
 * 相关企业
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 * 示例 1：
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *
 * 提示：
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/possible-bipartition/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindCircleNum {
	public static void main(String[] args) {
		FindCircleNum findCircleNum = new FindCircleNum();
		int circleNum = findCircleNum.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
		System.out.println(circleNum);
	}

	private int[] parent;
	private int[] size;

	public int findCircleNum(int[][] isConnected) {
		parent = new int[isConnected.length];
		size = new int[isConnected.length];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		int res = isConnected.length;
		for (int curNode = 0; curNode < isConnected.length; curNode++) {
			for (int neighborNode = 0; neighborNode < isConnected[curNode].length; neighborNode++) {
				if (isConnected[curNode][neighborNode] == 1) {
					int rootA = find(curNode);
					int rootB = find(neighborNode);
					if (rootA == rootB) {
						continue;
					}
					if (size[rootA] > size[rootB]) {
						parent[rootA] = rootB;
						size[rootB] += rootA;
					} else {
						parent[rootB] = rootA;
						size[rootA] += size[rootB];
					}
					res--;
				}
			}
		}
		return res;
	}

	private int find(int node) {
		if (node == parent[node]) {
			return node;
		}
		return parent[node] = find(parent[node]);
	}
}
