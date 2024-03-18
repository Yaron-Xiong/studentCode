package com.yaronxiong.algorithms.practiceSet.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * <p>
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
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lru-cache/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCacheV2 {
	public static void main(String[] args) {
		LRUCacheV2 lruCache = new LRUCacheV2(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1));
		lruCache.put(3, 3);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));
	}

	public static class Node {
		public int key;
		public int value;
		public Node pre;
		public Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int maxCapacity;
	private Node head;
	private Node tail;
	private Map<Integer, Node> map;


	public LRUCacheV2(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		map = new HashMap<>(maxCapacity);
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node keyNode = map.get(key);
			removeNode(keyNode);
			insertLast(keyNode);
			return keyNode.value;
		}
		return -1;
	}

	private void removeNode(Node node) {
		Node pre = node.pre;
		Node next = node.next;
		next.pre = pre;
		pre.next = next;
		node.pre = null;
		node.next = null;
	}

	private void insertLast(Node node) {
		Node tailPre = tail.pre;
		tailPre.next = node;
		node.pre = tailPre;

		node.next = tail;
		tail.pre = node;
	}

	public void put(int key, int value) {
		Node newNode = new Node(key, value);
		Node oldNode = map.get(key);
		if (oldNode != null) {
			removeNode(oldNode);
		}
		map.put(key, newNode);
		insertLast(newNode);
		//缩容
		if (map.size() > maxCapacity) {
			Node next = head.next;
			removeNode(next);
			map.remove(next.key);
		}
	}
}
