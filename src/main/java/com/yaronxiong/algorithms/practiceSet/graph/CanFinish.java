package com.yaronxiong.algorithms.practiceSet.graph;

import java.util.*;

/**
 * 207. 课程表
 * 中等
 * 1.5K
 * 相关企业
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/insert-delete-getrandom-o1/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanFinish {
	public static void main(String[] args) {
		CanFinish canFinish = new CanFinish();
		boolean b = canFinish.canFinish(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}});
		System.out.println(b);
	}

	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		Deque<Integer> queue = new ArrayDeque<>();
		int[] inDegrees = new int[numCourses];

		List<List<Integer>> adjacency = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjacency.add(new ArrayList<>());
		}

		//构建入度 以及 邻接表
		for (int[] prerequisite : prerequisites) {
			int from = prerequisite[0];
			int to = prerequisite[1];
			inDegrees[to]++;
			adjacency.get(from).add(to);
		}
		int lastCourses = numCourses;
		//构建队列
		for (int i = 0; i < inDegrees.length; i++) {
			Integer inDegree = inDegrees[i];
			if (inDegree == 0) {
				queue.add(i);
				lastCourses--;
			}
		}

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			List<Integer> adjacencyList = adjacency.get(poll);
			for (Integer i : adjacencyList) {
				inDegrees[i]--;
				if (inDegrees[i] == 0) {
					queue.add(i);
					lastCourses--;
				}
			}
		}
		return lastCourses == 0;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] prerequisite : prerequisites) {
			List<Integer> list = map.computeIfAbsent(prerequisite[0], key -> new ArrayList<>());
			list.add(prerequisite[1]);
		}
		int[] visitor = new int[numCourses];
		for (int[] prerequisite : prerequisites) {
			boolean canFinish = dfs(prerequisite[0], map, visitor);
			if (!canFinish) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int curNode, Map<Integer, List<Integer>> map, int[] visitor) {
		if (visitor[curNode] == 2) {
			return true;
		}
		if (visitor[curNode] == 1) {
			return false;
		}
		visitor[curNode] = 1;
		for (Integer nextNode : map.getOrDefault(curNode, Collections.emptyList())) {
			if (!dfs(nextNode, map, visitor)) {
				return false;
			}
		}
		visitor[curNode] = 2;
		return true;
	}


}
