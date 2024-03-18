package com.yaronxiong.algorithms.practiceSet.graph;

import java.util.*;

/**
 * 797. 所有可能的路径
 * 中等
 * 351
 * 相关企业
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * <p>
 * graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 * <p>
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/insert-delete-getrandom-o1/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllPathsSourceTarget {
	public static void main(String[] args) {
		AllPathsSourceTarget allPathsSourceTarget = new AllPathsSourceTarget();
		List<List<Integer>> lists = allPathsSourceTarget.allPathsSourceTarget2(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
		System.out.println(lists);
	}

	public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		dfs2(0, graph, res, new LinkedList<>());
		return res;
	}

	private void dfs2(int curNode, int[][] graph, List<List<Integer>> res, Deque<Integer> path) {
		path.add(curNode);
		if (curNode == graph.length - 1) {
			res.add(new ArrayList<>(path));
		} else {
			for (int i : graph[curNode]) {
				dfs2(i, graph, res, path);
			}
		}
		path.removeLast();
	}


	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		// 都有什么节点 能到这个节点
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < graph.length; i++) {
			int[] ints = graph[i];
			for (int anInt : ints) {
				List<Integer> list = map.computeIfAbsent(anInt, (key) -> new ArrayList<>());
				list.add(i);
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		dfs(graph.length - 1, map, res, new LinkedList<>());
		return res;
	}

	private void dfs(int curNode, Map<Integer, List<Integer>> map, List<List<Integer>> res, Deque<Integer> tempRes) {
		tempRes.addFirst(curNode);
		if (curNode == 0) {
			List<Integer> list = new ArrayList<>(tempRes);
			res.add(list);
		} else {
			List<Integer> canToCurNodeList = map.getOrDefault(curNode, new ArrayList<>());
			for (Integer preNode : canToCurNodeList) {
				dfs(preNode, map, res, tempRes);
			}
		}
		tempRes.removeFirst();
	}
}
