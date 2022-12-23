package com.accompnay.TopicAlgorithms.practiceSet.graph;

import java.util.*;

/**
 * 210. 课程表 II
 * 中等
 * 732
 * 相关企业
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 * <p>
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 * <p>
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/course-schedule-ii/description/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindOrder {
	public static void main(String[] args) {
		FindOrder findOrder = new FindOrder();
		int[] order = findOrder.findOrder2(2, new int[][]{});
		System.out.println(Arrays.toString(order));
	}

	public int[] findOrder2(int numCourses, int[][] prerequisites) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			list.add(new ArrayList<>());
		}
		for (int[] prerequisite : prerequisites) {
			list.get(prerequisite[0]).add(prerequisite[1]);
		}
		int[] visitor = new int[numCourses];
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			boolean cycle = dfs(list, i, visitor, res);
			if (cycle) {
				return new int[0];
			}
		}
		int[] resArr = new int[numCourses];
		for (int i = 0; i < res.size(); i++) {
			resArr[i] = res.get(i);
		}
		return resArr;
	}

	private boolean dfs(List<List<Integer>> list, int curNode, int[] visitor, List<Integer> res) {
		if (visitor[curNode] == 1) {
			return true;
		}
		if (visitor[curNode] == 2) {
			return false;
		}
		visitor[curNode] = 1;
		for (Integer nextNode : list.get(curNode)) {
			if (dfs(list, nextNode, visitor, res)) {
				return false;
			}
		}
		res.add(curNode);
		visitor[curNode] = 2;
		return false;
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, Integer> outDegree = new HashMap<>(prerequisites.length);
		Map<Integer, List<Integer>> inDegree = new HashMap<>(prerequisites.length);

		for (int i = 0; i < numCourses; i++) {
			outDegree.put(i, 0);
			inDegree.put(i, new ArrayList<>());
		}

		for (int[] prerequisite : prerequisites) {
			outDegree.computeIfPresent(prerequisite[0], (k, v) -> v + 1);
			inDegree.get(prerequisite[1]).add(prerequisite[0]);
		}

		Queue<Integer> queue = new LinkedList<>();
		outDegree.forEach((k, v) -> {
			if (v == 0) {
				queue.add(k);
			}
		});

		int curCourses = 0;
		int[] res = new int[numCourses];
		while (!queue.isEmpty()) {
			Integer baseCourses = queue.poll();
			res[curCourses++] = baseCourses;
			List<Integer> list = inDegree.get(baseCourses);
			for (Integer item : list) {
				outDegree.computeIfPresent(item, (k, v) -> v - 1);
				if (outDegree.get(item) == 0) {
					queue.add(item);
				}
			}
		}
		return curCourses != numCourses ? new int[0] : res;
	}
}
