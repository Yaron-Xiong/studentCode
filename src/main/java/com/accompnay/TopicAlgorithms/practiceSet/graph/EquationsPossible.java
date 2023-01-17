package com.accompnay.TopicAlgorithms.practiceSet.graph;

/**
 * 990. 等式方程的可满足性
 * 中等
 * 277
 * 相关企业
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一：
 * "a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * <p>
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 * <p>
 * 输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 * <p>
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/satisfiability-of-equality-equations/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EquationsPossible {
	public static void main(String[] args) {
		EquationsPossible equationsPossible = new EquationsPossible();
		boolean b = equationsPossible.equationsPossible(new String[]{"a==b", "b!=c", "c==a"});
		System.out.println(b);
	}

	public boolean equationsPossible(String[] equations) {
		if (equations == null || equations.length == 0) {
			return true;
		}
		UnionFind equationUnionFind = new UnionFind();
		for (String equation : equations) {
			char a = equation.charAt(0);
			char b = equation.charAt(3);
			String expression = equation.substring(1, 3);
			if ("==".equals(expression)) {
				equationUnionFind.union(a, b);
			}
		}

		for (String equation : equations) {
			char a = equation.charAt(0);
			char b = equation.charAt(3);
			String expression = equation.substring(1, 3);
			if ("!=".equals(expression) && equationUnionFind.isConnect(a, b)) {
				return false;
			}
		}
		return true;
	}

	public class UnionFind {
		int[] parent;
		int[] size;

		public UnionFind() {
			parent = new int[26];
			size = new int[26];
			for (int i = 0; i < 26; i++) {
				parent[i] = i;
				size[i] = 0;
			}
		}

		public void union(char a, char b) {
			int indexA = getIndex(a);
			int indexB = getIndex(b);
			int parentA = find(indexA);
			int parentB = find(indexB);
			if (parentA == parentB) {
				return;
			}
			if (size[parentA] > size[parentB]) {
				parent[parentB] = parentA;
				size[parentA] += size[parentB];
			} else {
				parent[parentA] = parentB;
				size[parentB] += size[parentA];
			}
		}

		private int getIndex(char node) {
			return node - 'a';
		}

		public boolean isConnect(char a, char b) {
			int indexA = getIndex(a);
			int indexB = getIndex(b);
			int rootA = find(indexA);
			int rootB = find(indexB);
			return rootA == rootB;
		}

		private int find(int node) {
			if (parent[node] == node) {
				return node;
			}
			return parent[node] = find(parent[parent[node]]);
		}
	}

}
