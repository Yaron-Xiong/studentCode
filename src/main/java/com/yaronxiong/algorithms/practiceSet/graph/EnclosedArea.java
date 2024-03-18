package com.yaronxiong.algorithms.practiceSet.graph;

/**
 * 130. 被围绕的区域
 * 中等
 * 903
 * 相关企业
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/surrounded-regions/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EnclosedArea {
	public static void main(String[] args) {
		EnclosedArea enclosedArea = new EnclosedArea();
		char[][] board = new char[][]{{'X','X','X','X','O','O','X','X','O'},{'O','O','O','O','X','X','O','O','X'},{'X','O','X','O','O','X','X','O','X'},{'O','O','X','X','X','O','O','O','O'},{'X','O','O','X','X','X','X','X','O'},{'O','O','X','O','X','O','X','O','X'},{'O','O','O','X','X','O','X','O','X'},{'O','O','O','X','O','O','O','X','O'},{'O','X','O','O','O','X','O','X','O'}};
		enclosedArea.solve(board);
		System.out.println(board);
	}

	public void solve(char[][] board) {
		if (board.length == 0) return;
		int m = board.length;
		int n = board[0].length;
		UnionFind unionFind = new UnionFind(m * n + 1);
		int superRoot = m * n;
		for (int i = 0; i < board[0].length; i++) {
			int lastRow = board.length - 1;
			int firstRow = 0;
			if (board[firstRow][i] == 'O') {
				unionFind.union(firstRow * n + i, superRoot);
			}
			if (board[lastRow][i] == 'O') {
				unionFind.union(lastRow * n + i, superRoot);
			}
		}
		for (int i = 0; i < board.length; i++) {
			int lastRow = board[0].length - 1;
			int firstRow = 0;
			if (board[i][lastRow] == 'O') {
				unionFind.union(i * n + lastRow, superRoot);
			}
			if (board[i][firstRow] == 'O') {
				unionFind.union(i * n + firstRow, superRoot);
			}
		}

		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[i].length - 1; j++) {
				if (board[i][j] == 'O') {
					if (board[i][j - 1] == 'O') {
						unionFind.union(i * n + j, i * n + (j - 1));
					}
					if (board[i][j + 1] == 'O') {
						unionFind.union(i * n + j, i * n + (j + 1));
					}
					if (board[i - 1][j] == 'O') {
						unionFind.union(i * n + j, (i - 1) * n + j);
					}
					if (board[i + 1][j] == 'O') {
						unionFind.union(i * n + j, (i + 1) * n + j);
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O' && !unionFind.isConnect(i * n + j, superRoot)) {
					board[i][j] = 'X';
				}
			}
		}
	}

	private class UnionFind {
		int count;
		int[] parent;
		int[] size;

		public UnionFind(int size) {
			count = size;
			parent = new int[size];
			this.size = new int[size];

			for (int i = 0; i < size; i++) {
				parent[i] = i;
				this.size[i] = 1;
			}
		}

		public void union(int nodeA, int nodeB) {
			if (nodeA == nodeB) {
				parent[nodeA] = parent[nodeB];
				return;
			}
			int parentA = find(nodeA);
			int parentB = find(nodeB);
			if (parentA != parentB) {
				if (size[parentA] > size[parentB]) {
					parent[parentB] = parentA;
					size[parentA] += size[parentB];
				} else {
					parent[parentA] = parentB;
					size[parentB] += size[parentA];
				}
				count--;
			}
		}

		public boolean isConnect(int nodeA, int nodeB) {
			int parentA = find(nodeA);
			int parentB = find(nodeB);
			return parentA == parentB;
		}

		private int find(int nodeA) {
			if (parent[nodeA] == nodeA) {
				return nodeA;
			}
			return parent[nodeA] = find(parent[parent[nodeA]]);
		}
	}
}
