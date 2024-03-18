package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.*;

/**
 * 1617. 统计子树中城市之间最大距离
 * 提示
 * 困难
 * 123
 * 相关企业
 * 给你 n 个城市，编号为从 1 到 n 。同时给你一个大小为 n-1 的数组 edges ，其中 edges[i] = [ui, vi] 表示城市 ui 和 vi 之间有一条双向边。
 * 题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵 树 。
 * <p>
 * 一棵 子树 是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。
 * 两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另一棵子树中不存在。
 * <p>
 * 对于 d 从 1 到 n-1 ，请你找到城市间 最大距离 恰好为 d 的所有子树数目。
 * <p>
 * 请你返回一个大小为 n-1 的数组，其中第 d 个元素（下标从 1 开始）是城市间 最大距离 恰好等于 d 的子树数目。
 * <p>
 * 请注意，两个城市间距离定义为它们之间需要经过的边的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, edges = [[1,2],[2,3],[2,4]]
 * 输出：[3,4,0]
 * 解释：
 * 子树 {1,2}, {2,3} 和 {2,4} 最大距离都是 1 。
 * 子树 {1,2,3}, {1,2,4}, {2,3,4} 和 {1,2,3,4} 最大距离都为 2 。
 * 不存在城市间最大距离为 3 的子树。
 * 示例 2：
 * <p>
 * 输入：n = 2, edges = [[1,2]]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：n = 3, edges = [[1,2],[2,3]]
 * 输出：[2,1]
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 15
 * edges.length == n-1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * 题目保证 (ui, vi) 所表示的边互不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-subtrees-with-max-distance-between-cities/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1617_CountSubgraphsForEachDiameter {
	public static void main(String[] args) {
		L1617_CountSubgraphsForEachDiameter l1617CountSubgraphsForEachDiameter = new L1617_CountSubgraphsForEachDiameter();
		int[] diameter = l1617CountSubgraphsForEachDiameter.countSubgraphsForEachDiameter(4, new int[][]{{1, 3}, {1, 4}, {2, 3}});
		System.out.println(Arrays.toString(diameter));
	}

	int[] res;

	public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0] - 1).add(edge[1] - 1);
			graph.get(edge[1] - 1).add(edge[0] - 1);
		}
		Map<String, Integer> feeMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int fee = fee(i, j, graph);
				feeMap.put(i + "_" + j, fee);
			}
		}

		res = new int[n - 1];
		//计算任意两点的距离
		//计算所有子树的最大宽度
		Deque<Integer> path = new LinkedList<>();
		dfs2(0, n, path, graph, feeMap);
		return res;
	}

	private void dfs2(int curNode, int n, Deque<Integer> path, List<List<Integer>> graph, Map<String, Integer> feeMap) {
		if (curNode >= n) {
			//说明到了头,开始判断这个path是否构成了一个子树，如果构成，则计算宽度
			int fee = isTree(path, graph, feeMap);
			if (fee != -1) {
				System.out.println(path + "=" + fee);
				res[fee - 1]++;
			}
			return;
		}
		//不选择当前节点
		dfs2(curNode + 1, n, path, graph, feeMap);

		//选择当前节点
		path.addLast(curNode);
		dfs2(curNode + 1, n, path, graph, feeMap);
		path.removeLast();
	}

	private int isTree(Deque<Integer> path, List<List<Integer>> graph, Map<String, Integer> feeMap) {
		if (path.isEmpty() || path.size() == 1) {
			return -1;
		}
		Deque<Integer> deque = new LinkedList<>();
		Set<Integer> set = new HashSet<>(path);
		List<Integer> nodes = new ArrayList<>();
		deque.offer(path.getFirst());
		int maxFee = 0;
		while (!deque.isEmpty()) {
			Integer pop = deque.pop();
			for (Integer pathNode : nodes) {
				String key = pop > pathNode ? pathNode + "_" + pop : pop + "_" + pathNode;
				Integer fee = feeMap.get(key);
				maxFee = Math.max(fee, maxFee);
			}
			nodes.add(pop);
			set.remove(pop);
			for (Integer neighbor : graph.get(pop)) {
				if (set.contains(neighbor)){
					deque.offer(neighbor);
				}
			}

		}
		return !set.isEmpty() ? -1 : maxFee;
	}

	private int fee(int i, int j, List<List<Integer>> graph) {
		Deque<Integer> deque = new LinkedList<>();
		deque.add(i);
		int fee = 0;
		Set<Integer> set = new HashSet<>();
		while (!deque.isEmpty()) {
			int size = deque.size();
			while (size > 0) {
				size--;
				Integer node = deque.pop();
				set.add(node);
				if (node == j) {
					return fee;
				}
				for (Integer neighbor : graph.get(node)) {
					if (set.contains(neighbor)) {
						continue;
					}
					deque.offer(neighbor);
				}
			}
			fee++;
		}
		return fee;
	}
}
