package com.yaronxiong.algorithms.practiceSet.graph;

import java.util.*;

/**
 * 1631. 最小体力消耗路径
 * 中等
 * 336
 * 相关企业
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * <p>
 * 提示：
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/network-delay-time/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yaoyuanxiong
 */
public class MinimumEffortPath {
	public static void main(String[] args) {
		MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
		int i = minimumEffortPath.minimumEffortPath2(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}});
		System.out.println(i);
	}

	public int minimumEffortPath2(int[][] heights) {
		List<int[]> edges = new ArrayList<>();
		int m = heights.length;
		int n = heights[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < heights[i].length; j++) {
				int id = i * n + j;
				if (i + 1 < m) {
					edges.add(new int[]{Math.abs(heights[i][j] - heights[i + 1][j]), id, id + n});
				}
				if (j + 1 < heights[i].length) {
					edges.add(new int[]{Math.abs(heights[i][j] - heights[i][j + 1]), id, id + 1});
				}
			}
		}
		edges.sort(Comparator.comparing(a -> a[0]));

		UnionFind unionFind = new UnionFind(m * n);
		int ans = 0;
		for (int[] edge : edges) {
			if (unionFind.isConnect(edge[1], edge[2])) {
				continue;
			}
			unionFind.union(edge[1], edge[2]);
			if (unionFind.isConnect(0, m * n - 1)) {
				ans = edge[0];
				break;
			}
		}
		return ans;
	}

	class UnionFind {
		int[] parent;
		int[] size;

		public UnionFind(int size) {
			this.parent = new int[size];
			this.size = new int[size];
			for (int i = 0; i < size; i++) {
				this.parent[i] = i;
				this.size[i] = 1;
			}
		}

		public boolean isConnect(int a, int b) {
			return find(a) == find(b);
		}

		public void union(int a, int b) {
			int aParent = find(a);
			int bParent = find(b);
			if (aParent == bParent){
				return;
			}
			if (size[aParent] > size[bParent]) {
				parent[bParent] = aParent;
				size[aParent] += size[bParent];
			} else {
				parent[aParent] = b;
				size[bParent] += size[aParent];
			}
		}

		public int find(int a) {
			if (parent[a] != a) {
				parent[a] = find(parent[parent[a]]);
			}
			return parent[a];
		}
	}

	public int minimumEffortPath(int[][] heights) {
		int[][] dist = new int[heights.length][heights[0].length];
		for (int[] ints : dist) {
			Arrays.fill(ints, Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
		queue.offer(new int[]{0, 0, 0});
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			//向邻居发射
			int curX = node[0];
			int curY = node[1];
			int curEffort = dist[curY][curX];
			for (int[] dir : dirs) {
				int neighborX = curX + dir[0];
				int neighborY = curY + dir[1];
				if (neighborY < 0 || neighborX < 0 || neighborY >= heights.length || neighborX >= heights[0].length) {
					continue;
				}
				int previousEffort = dist[neighborY][neighborX];
				int newEffort = Math.max(Math.abs(heights[curY][curX] - heights[neighborY][neighborX]), curEffort);
				if (newEffort >= previousEffort) {
					continue;
				}
				dist[neighborY][neighborX] = newEffort;
				queue.offer(new int[]{neighborX, neighborY, newEffort});
			}
		}
		return dist[heights.length - 1][heights[0].length - 1];
	}
}
