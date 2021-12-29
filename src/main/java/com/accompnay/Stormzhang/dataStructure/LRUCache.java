package com.accompnay.Stormzhang.dataStructure;

import java.util.HashMap;

/**
 * 146. LRU 缓存:https://leetcode-cn.com/problems/lru-cache/
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {
	class Node {
		public int key;
		public int val;
		public Node preNode;
		public Node nextNode;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	class SefLikedList {
		public Node head;
		public Node tail;

		SefLikedList() {
			head = new Node(-1, -1);
			tail = new Node(-1, -1);
			head.nextNode = tail;
			tail.preNode = head;
		}

		public Node delHead() {
			Node node = head.nextNode;
			del(node);
			return node;
		}

		public void del(Node node) {
			Node preNode = node.preNode;
			Node nextNode = node.nextNode;
			preNode.nextNode = nextNode;
			nextNode.preNode = preNode;
			node.preNode = null;
			node.nextNode = null;
		}

		public void add(Node node) {
			Node nextNode = head.nextNode;

			head.nextNode = node;
			node.preNode = head;

			node.nextNode = nextNode;
			nextNode.preNode = node;
		}

		public void moveToTail(Node node) {
			Node preNode = node.preNode;
			Node nextNode = node.nextNode;
			preNode.nextNode = nextNode;
			nextNode.preNode = preNode;

			Node tailPre = tail.preNode;
			tailPre.nextNode = node;
			node.preNode = tailPre;
			node.nextNode = tail;

			tail.preNode = node;
		}
	}

	private HashMap<Integer, Node> map;
	private int capacity;
	private SefLikedList sefLikedList;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>(capacity);
		sefLikedList = new SefLikedList();
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) return -1;
		sefLikedList.moveToTail(node);
		return node.val;
	}

	public void put(int key, int value) {
		if (capacity < map.size() + 1) {
			Node node = sefLikedList.delHead();
			map.remove(node.key);
		}
		Node node = new Node(key, value);
		sefLikedList.add(node);
		map.put(key, node);
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		int i = lruCache.get(0);
		System.out.println(i);
		lruCache.put(0, 0);
		System.out.println(lruCache.get(0));
		lruCache.put(1, 1);
		System.out.println(lruCache.get(1));
		lruCache.put(2, 2);
		System.out.println(lruCache.get(2));
		System.out.println(lruCache.get(0));
	}
}
