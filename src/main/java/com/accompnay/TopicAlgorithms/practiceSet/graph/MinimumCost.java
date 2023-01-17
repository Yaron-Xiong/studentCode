package com.accompnay.TopicAlgorithms.practiceSet.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1135. 最低成本联通所有城市
 * <p>
 * 题目描述
 * 想象一下你是个城市基建规划者，地图上有 n 座城市，它们按以 1 到 n 的次序编号。
 * <p>
 * 给你整数 n 和一个数组 conections，其中 connections[i] = [xi, yi, costi] 表示将城市 xi 和城市 yi 连接所要的costi（连接是双向的）。
 * <p>
 * 返回连接所有城市的最低成本，每对城市之间至少有一条路径。如果无法连接所有 n 个城市，返回 -1
 * <p>
 * 该 最小成本 应该是所用全部连接成本的总和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
 * 输出：6
 * 解释：选出任意 2 条边都可以连接所有城市，我们从中选取成本最小的 2 条。
 * 示例 2：
 * <p>
 * 输入：n = 4, conections = [[1,2,3],[3,4,4]]
 * 输出：-1
 * 解释：即使连通所有的边，也无法连接所有城市。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 * 1 <= connections.length <= 104
 * connections[i].length == 3
 * 1 <= xi, yi <= n
 * xi != yi
 * 0 <= costi <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/connecting-cities-with-minimum-cost/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumCost {
	public static void main(String[] args) {
		MinimumCost minimumCost = new MinimumCost();
		int i = minimumCost.minimumCost(4, new int[][]{{1,2,3}, {3,4,4}});
		System.out.println(i);
	}

	/**
	 * 采用Kruskal算法（贪心算法实例）
	 * 此算法为先将所有边进行排序，从小开始遍历
	 * 如果两个点未连通则将其连通
	 * 最后检测连通分量是否等于1
	 *
	 * @param n
	 * @param connections
	 * @return
	 */
	public int minimumCost(int n, int[][] connections) {
		//目标1. 连通分量 == 1
		//目标2. 所有边总和成本最低
		Comparator<int[]> comparator = Comparator.comparingInt(o -> o[2]);
		List<int[]> sortList = Arrays.stream(connections).sorted(comparator).collect(Collectors.toList());
		UnionFind unionFind = new UnionFind(n);
		int cost = 0;
		for (int[] arr : sortList) {
			//检测是否连通
			int form = arr[0] - 1;
			int to = arr[1] - 1;
			if (unionFind.isConnect(form, to)) {
				continue;
			}
			unionFind.union(form, to);
			cost += arr[2];
		}
		//检测连通分量是否为1
		if (unionFind.count != 1) {
			return -1;
		}
		//返回所有边的总和
		return cost;
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
