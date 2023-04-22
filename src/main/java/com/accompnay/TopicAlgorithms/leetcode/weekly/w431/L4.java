package com.accompnay.TopicAlgorithms.leetcode.weekly.w431;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L4 {

	public static void main(String[] args) {
		L4 l4 = new L4();
		System.out.println(l4.minimumTotalPrice(4, new int[][]{{0, 1}, {1, 2}, {1, 3}}, new int[]{2, 2, 10, 6}, new int[][]{{0, 3}, {2, 1}, {2, 3}}));
	}

	public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		//寻找路径
		//计算每个节点出现的次数
		int[] emergency = new int[price.length];
		for (int[] trip : trips) {
			findPath(graph, trip[0], trip[1], emergency);
		}
		//计算各种可能的折扣
		int[] dfs = dfs(graph, price, 0, new boolean[price.length], emergency);
		return Math.min(dfs[0], dfs[1]);
	}

	//计算打折方案
	private int[] dfs(List<List<Integer>> graph, int[] price, int node, boolean[] visit, int[] emergency) {
		visit[node] = true;
		int[] res = new int[]{(price[node] * emergency[node]) / 2, price[node] * emergency[node]};
		for (Integer neighbor : graph.get(node)) {
			if (visit[neighbor]) {
				continue;
			}
			int[] dfs = dfs(graph, price, neighbor, visit, emergency);
			//如果当前节点打折了
			res[0] += dfs[1];
			//如果当前节点不打折
			res[1] += Math.min(dfs[0], dfs[1]);
		}
		return res;
	}

	public class Node {
		int val;
		Node preNode;

		public Node(int val, Node preNode) {
			this.val = val;
			this.preNode = preNode;
		}
	}

	public void findPath(List<List<Integer>> graph, int start, int end, int[] emergency) {
		//bfs
		Deque<Node> deque = new ArrayDeque<>();
		Node root = new Node(start, null);
		deque.add(root);
		Node res = null;
		boolean[] visit = new boolean[graph.size()];
		while (!deque.isEmpty()) {
			Node node = deque.pop();
			if (visit[node.val]) {
				continue;
			}
			visit[node.val] = true;
			if (node.val == end) {
				res = node;
				break;
			}
			for (Integer integer : graph.get(node.val)) {
				deque.offer(new Node(integer, node));
			}
		}
		while (res != null) {
			emergency[res.val]++;
			res = res.preNode;
		}
	}
}
