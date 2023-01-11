package com.accompnay.TopicAlgorithms.practiceSet.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 323. 无向图中连通分量的数目
 * 中等
 * 题目链接：
 * <p>
 * 题目描述:
 * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
 * <p>
 * 示例:
 * 示例 1:
 * <p>
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
 * <p>
 * 0          3
 * |          |
 * 1 --- 2    4
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * <p>
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * <p>
 * 输出:  1
 * 注意:
 * <p>
 * 你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0] 相同，所以它们不会同时在 edges 中出现。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountComponents {
	public static void main(String[] args) {
		CountComponents countComponents = new CountComponents();
		int i = countComponents.countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}});
		System.out.println(i);
	}

	public int countComponents(int n, int[][] edges) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			map.put(i, i);
			count++;
		}
		for (int[] edge : edges) {
			int one = edge[0];
			int two = edge[1];
			int rootA = find(one, map);
			int rootB = find(two, map);
			if (rootA != rootB) {
				count--;
				map.put(rootA, rootB);
			}
		}
		return count;
	}

	private int find(int one, Map<Integer, Integer> map) {
		Integer cur = one;
		while (!cur.equals(map.get(cur))) {
			cur = map.get(cur);
		}
		return cur;
	}
}
