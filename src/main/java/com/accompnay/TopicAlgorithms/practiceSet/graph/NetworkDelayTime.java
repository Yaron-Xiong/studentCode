package com.accompnay.TopicAlgorithms.practiceSet.graph;

import java.util.*;

/**
 * 743. 网络延迟时间
 * 中等
 * 625
 * 相关企业
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/network-delay-time/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NetworkDelayTime {
	public static void main(String[] args) {
		NetworkDelayTime networkDelayTime = new NetworkDelayTime();
		int i = networkDelayTime.networkDelayTime(new int[][]{{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},{1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},{2,4,77},{5,2,74}}, 5, 3);
		System.out.println(i);
	}

	public int networkDelayTime(int[][] times, int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		Map<String, Integer> neighborCostMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		for (int[] time : times) {
			int from = time[0] - 1;
			int to = time[1] - 1;
			String key = from + "_" + to;
			neighborCostMap.put(key, time[2]);
			list.get(from).add(to);
		}

		Queue<Integer> queue = new LinkedList<>();
		Map<Integer, Integer> costMap = new HashMap<>();
		Set<Integer> visit = new HashSet<>();
		queue.add(k - 1);
		costMap.put(k - 1, 0);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				size--;
				Integer node = queue.poll();
				if (visit.contains(node)) {
					continue;
				}
				List<Integer> neighbor = list.get(node);
				for (Integer neighborNode : neighbor) {
					Integer cost = costMap.get(node);
					String key = node + "_" + neighborNode;
					Integer neighborCost = neighborCostMap.get(key);
					Integer oldCost = costMap.getOrDefault(neighborNode, Integer.MAX_VALUE);
					int newCost = cost + neighborCost;
					if (newCost < oldCost) {
						costMap.put(neighborNode, newCost);
					}
					queue.add(neighborNode);
				}
				visit.add(node);
			}
		}
		if (visit.size() == n) {
			return costMap.values().stream().max(Integer::compareTo).get();
		}
		return -1;
	}
}
