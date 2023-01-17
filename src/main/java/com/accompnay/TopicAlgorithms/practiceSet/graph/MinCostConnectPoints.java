package com.accompnay.TopicAlgorithms.practiceSet.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1584. 连接所有点的最小费用
 * 中等
 * 260
 * 相关企业
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * <p>
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * <p>
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 * <p>
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 * <p>
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 * <p>
 * 输入：points = [[0,0]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/connecting-cities-with-minimum-cost/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostConnectPoints {
	public static void main(String[] args) {
		MinCostConnectPoints minCostConnectPoints = new MinCostConnectPoints();
		int i = minCostConnectPoints.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}});
		System.out.println(i);
	}

	public int minCostConnectPoints(int[][] points) {
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
				list.add(new int[]{i, j, cost});
			}
		}
		list.sort(Comparator.comparingInt(a -> a[2]));
		UnionFind unionFind = new UnionFind(points.length);
		int countCost = 0;
		for (int[] arr : list) {
			int from = arr[0];
			int to = arr[1];
			int cost = arr[2];
			if (unionFind.isConnect(from, to)) {
				continue;
			}
			unionFind.union(from, to);
			countCost += cost;
		}
		return unionFind.count == 1 ? countCost : -1;
	}

	class UnionFind {
		int count;
		int[] parent;
		int[] size;

		public UnionFind(int count) {
			this.count = count;
			parent = new int[count];
			size = new int[count];

			for (int i = 0; i < count; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		public void union(int nodeA, int nodeB) {
			int rootA = findRoot(nodeA);
			int rootB = findRoot(nodeB);
			if (rootA == rootB) {
				return;
			}
			if (size[rootA] > size[rootB]) {
				parent[rootB] = rootA;
				size[rootA] += size[rootB];
			} else {
				parent[rootA] = rootB;
				size[rootB] += size[rootA];
			}
			count--;
		}

		private int findRoot(int node) {
			if (parent[node] == node) {
				return node;
			}
			return parent[node] = findRoot(parent[parent[node]]);
		}

		public boolean isConnect(int nodeA, int nodeB) {
			return findRoot(nodeA) == findRoot(nodeB);
		}

	}
}
