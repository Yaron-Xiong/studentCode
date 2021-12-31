package com.accompnay.Stormzhang.dataStructure;

import java.util.HashMap;
import java.util.LinkedHashMap;

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

		public void addToTail(Node node) {
			Node preNode = tail.preNode;
			preNode.nextNode = node;
			node.preNode = preNode;
			node.nextNode = tail;
			tail.preNode = node;
		}
	}

	private int capacity;
	private HashMap<Integer, Node> map;
	private SefLikedList sefLikedList;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>(capacity);
		sefLikedList = new SefLikedList();
	}

	private void makeRecently(int key) {
		Node node = map.get(key);
		if (node == null) {
			return;
		}
		sefLikedList.del(node);
		sefLikedList.addToTail(node);
	}

	private Node remove(int key){
		if (!map.containsKey(key)){
			return null;
		}
		Node node = map.remove(key);
		sefLikedList.del(node);
		return node;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) return -1;
		makeRecently(key);
		return node.val;
	}

	public void put(int key, int value) {
		Node newNode = new Node(key, value);
		if (map.containsKey(key)) {
			remove(key);
		}
		ensureCapacityInternal(map.size() + 1);
		sefLikedList.addToTail(newNode);
		map.put(key, newNode);
	}

	private void ensureCapacityInternal(int i) {
		if (capacity < i){
			Node nodeTemp = sefLikedList.delHead();
			map.remove(nodeTemp.key);
		}
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
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
}
