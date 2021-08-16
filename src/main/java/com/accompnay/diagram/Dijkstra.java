package com.accompnay.diagram;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.*;

public class Dijkstra {

	public static class Node {
		public String name;
		public List<Side> sideList;

		public Node(String name) {
			this.name = name;
			this.sideList = new ArrayList<>();
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Node node = (Node) o;
			return Objects.equal(name, node.name);
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(name);
		}

		@Override
		public String toString() {
			return "Node{" +
					"name='" + name + '\'' +
					'}';
		}
	}

	public static class Side implements Comparable<Side> {
		public Node start;
		public Node end;
		public int free;

		public Side(Node start, Node end, int free) {
			this.start = start;
			this.end = end;
			this.free = free;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Side side = (Side) o;
			return free == side.free &&
					Objects.equal(start, side.start) &&
					Objects.equal(end, side.end);
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(start, end, free);
		}

		@Override
		public int compareTo(Side o) {
			return Integer.compare(this.free, o.free);
		}

		@Override
		public String toString() {
			return "Side{" +
					"start=" + start +
					", end=" + end +
					", free=" + free +
					'}';
		}
	}

	public static class FreeNode {
		public Node parent;
		public int free;

		public FreeNode(Node parent, int free) {
			this.parent = parent;
			this.free = free;
		}

		@Override
		public String toString() {
			return "FreeNode{" +
					"parent=" + parent +
					", free=" + free +
					'}';
		}
	}

	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		a.sideList.add(new Side(a, b, 5));
		a.sideList.add(new Side(a, c, 10));
		b.sideList.add(new Side(b, d, 15));
		b.sideList.add(new Side(b, e, 20));
		b.sideList.add(new Side(b, c, 1));
		c.sideList.add(new Side(c, d, 2));
		c.sideList.add(new Side(c, e, 35));
		d.sideList.add(new Side(d, f, 15));
		e.sideList.add(new Side(e, f, 11));
		FreeNode freeNode = dijkstra(a, f);
		System.out.println(freeNode);
	}


	/**
	 * 标记处理过的点
	 * @param start
	 * @param end
	 * @return
	 */
	public static FreeNode dijkstra(Node start, Node end) {
		Map<Node, FreeNode> freeMap = Maps.newHashMap();
		Set<Side> handlerSet = Sets.newHashSet();
		Queue<Side> queue = new PriorityQueue<>();
		queue.addAll(start.sideList);
		while (!queue.isEmpty()) {
			Side side = queue.poll();
			if (handlerSet.contains(side)){
				continue;
			}
			handlerSet.add(side);
			FreeNode startFreeNode = freeMap.get(side.start);
			FreeNode endFreeNode = freeMap.get(side.end);
			int startFree = startFreeNode == null ? 0 : startFreeNode.free;
			int endFree = endFreeNode == null ? Integer.MAX_VALUE : endFreeNode.free;
			int newEndFree = startFree + side.free;
			FreeNode freeNode;
			if (newEndFree <= endFree) {
				freeNode = new FreeNode(side.start, newEndFree);
			} else {
				freeNode = endFreeNode;
			}
			freeMap.put(side.end, freeNode);
			queue.addAll(side.end.sideList);
		}
		printPath(freeMap, end);
		return freeMap.get(end);
	}

	private static void printPath(Map<Node, FreeNode> freeMap, Node node) {
		System.out.println(node);
		FreeNode freeNode = freeMap.get(node);
		if (freeNode == null) {
			return;
		}
		Node parent = freeNode.parent;
		printPath(freeMap, parent);
	}
}
