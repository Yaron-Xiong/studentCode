package com.yaronxiong.algorithms.practiceSet.graph;

import java.util.*;

/**
 * 1514. 概率最大的路径
 * 中等
 * 116
 * 相关企业
 * 给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
 * <p>
 * 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
 * <p>
 * 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
 * <p>c
 * 示例 1：
 * <p>
 * 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * 输出：0.25000
 * 解释：从起点到终点有两条路径，其中一条的成功概率为 0.2 ，而另一条为 0.5 * 0.5 = 0.25
 * 示例 2：
 * <p>
 * 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
 * 输出：0.30000
 * 示例 3：
 * <p>
 * 输入：n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
 * 输出：0.00000
 * 解释：节点 0 和 节点 2 之间不存在路径
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 10^4
 * 0 <= start, end < n
 * start != end
 * 0 <= a, b < n
 * a != b
 * 0 <= succProb.length == edges.length <= 2*10^4
 * 0 <= succProb[i] <= 1
 * 每两个节点之间最多有一条边
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/network-delay-time/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProbability {
	public static void main(String[] args) {
		MaxProbability maxProbability = new MaxProbability();
		double v = maxProbability.maxProbability(5, new int[][]{{1, 4}, {2, 4}, {0, 4}, {0, 3}, {0, 2}, {2, 3}}, new double[]{0.37, 0.17, 0.93, 0.23, 0.39, 0.04}, 3, 4);
		System.out.println(v);
	}

	class Node {
		int id;
		double fee;

		public Node(int id, double fee) {
			this.id = id;
			this.fee = fee;
		}
	}

	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		List<List<Node>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			graph.get(edge[0]).add(new Node(edge[1], succProb[i]));
			graph.get(edge[1]).add(new Node(edge[0], succProb[i]));
		}
		double[] dist = new double[n];
		Arrays.fill(dist, 0);
		Queue<Node> queue = new PriorityQueue<>((o1, o2) -> -Double.compare(o1.fee, o2.fee));
		queue.offer(new Node(start, 1));
		dist[start] = 1;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.id == end) {
				return dist[end];
			}
			for (Node neighbor : graph.get(node.id)) {
				double previousFee = dist[neighbor.id];
				double curFee = dist[node.id] * neighbor.fee;
				if (curFee > previousFee) {
					neighbor.fee = curFee;
					dist[neighbor.id] = curFee;
					queue.offer(neighbor);
				}
			}
		}
		return dist[end];
	}
}
