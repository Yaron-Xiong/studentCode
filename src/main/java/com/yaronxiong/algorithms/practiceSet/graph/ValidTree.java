package com.yaronxiong.algorithms.practiceSet.graph;

/**
 * 给定编号从 0 到 n - 1 的 n 个结点。给定一个整数 n 和一个 edges 列表，
 * 其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间存在一条无向边。
 * <p>
 * 如果这些边能够形成一个合法有效的树结构，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * 输出: true
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * 输出: false
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2000
 * 0 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * 不存在自循环或重复的边
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/graph-valid-tree/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidTree {
	public static void main(String[] args) {
		ValidTree validTree = new ValidTree();
		boolean b = validTree.validTree(5, new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}});
		System.out.println(b);
	}

	public boolean validTree(int n, int[][] edges) {
		UnionFind unionFind = new UnionFind(n);
		for (int[] edge : edges) {
			if (unionFind.isConnect(edge[0], edge[1])) {
				return false;
			}
			unionFind.union(edge[0], edge[1]);
		}
		return unionFind.count == 1;
	}

	public class UnionFind {
		int count;
		int[] parent;
		int[] size;

		public UnionFind(int n) {
			count = n;
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		public void union(int nodeA, int nodeB) {
			int rootA = find(nodeA);
			int rootB = find(nodeB);
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

		private int find(int node) {
			if (parent[node] == node) {
				return node;
			}
			return parent[node] = find(parent[parent[node]]);
		}

		public boolean isConnect(int nodeA, int nodeB) {
			int rootA = find(nodeA);
			int rootB = find(nodeB);
			return rootA == rootB;
		}

	}

}
