package com.accompnay.TopicAlgorithms.practiceSet.lfu;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU 缓存
 * 困难
 * 616
 * 相关企业
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * <p>
 * 实现 LFUCache 类：
 * <p>
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。
 * 当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * <p>
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * <p>
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。
 * 对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * <p>
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * <p>
 * 解释：
 * // cnt(x) = 键 x 的使用计数
 * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // 返回 1
 * // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
 * // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 * // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // 返回 4
 * // cache=[3,4], cnt(4)=2, cnt(3)=3
 * <p>
 * 提示：
 * <p>
 * 0 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * 最多调用 2 * 105 次 get 和 put 方法
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lru-cache/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LFUCache {
	public static class Node {
		public int key;
		public int val;
		public Node next;
		public Node pre;
		public int freq;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.freq = 0;
		}
	}

	public static class Deque {
		public Node tail;
		public Node head;
		private int size;
		private int freq;

		public Deque(int freq) {
			tail = new Node(-1, -1);
			head = new Node(-1, -1);
			head.next = tail;
			tail.pre = head;
			size = 0;
			this.freq = freq;
		}

		public void addToTail(Node node) {
			Node pre = tail.pre;
			pre.next = node;
			node.pre = pre;
			node.next = tail;
			tail.pre = node;
			size++;
		}

		public Node removeHead() {
			if (size == 0) {
				return null;
			}
			return removeNode(head.next);
		}

		public int getSize() {
			return size;
		}

		public Node removeNode(Node removeNode) {
			Node nextNode = removeNode.next;
			Node preNode = removeNode.pre;
			preNode.next = nextNode;
			nextNode.pre = preNode;

			removeNode.next = null;
			removeNode.pre = null;

			size--;
			return removeNode;
		}
	}

	private int maxCapacity;
	//key 2 node
	private Map<Integer, Node> nodeMap;
	//freq 2 Deque
	private Map<Integer, Deque> dequeMap;

	private int minFeq;


	public LFUCache(int capacity) {
		maxCapacity = capacity;
		nodeMap = new HashMap<>();
		dequeMap = new HashMap<>();
	}

	public int get(int key) {
		if (!nodeMap.containsKey(key)) {
			return -1;
		}
		Node node = nodeMap.get(key);
		maintainFreqMap(node);
		return node.val;
	}

	private void maintainFreqMap(Node node) {
		int curFreq = node.freq;
		//维护node.freq
		int newFreq = node.freq + 1;
		node.freq = newFreq;
		//维护deque中node的位置
		if (curFreq != 0) {
			//说明其之前存在过deque
			//将其从旧的deque移除 将Node移动至高的deque中去
			Deque deque = dequeMap.get(curFreq);
			deque.removeNode(node);
			if (deque.getSize() == 0) {
				dequeMap.remove(curFreq);
			}
			if (deque.getSize() == 0 && curFreq == minFeq) {
				minFeq = curFreq + 1;
			}
		} else {
			//说明其之前没有放进过deque
			minFeq = 1;
		}
		Deque nextDeque = dequeMap.computeIfAbsent(newFreq, Deque::new);
		nextDeque.addToTail(node);
	}

	public void put(int key, int value) {
		if (nodeMap.containsKey(key)) {
			Node node = nodeMap.get(key);
			node.val = value;
			maintainFreqMap(node);
		} else {
			if (maxCapacity == 0) {
				return;
			}
			//容量检测
			if (nodeMap.size() + 1 > maxCapacity) {
				//超过容量，缩容
				shrink();
			}
			Node newNode = new Node(key, value);
			nodeMap.put(key, newNode);
			maintainFreqMap(newNode);
		}
	}

	private void shrink() {
		Deque deque = dequeMap.get(minFeq);
		Node removeNode = deque.removeHead();
		nodeMap.remove(removeNode.key);
	}

	public static void main(String[] args) {
		LFUCache lfuCache = new LFUCache(0);
		lfuCache.put(0, 0);
		System.out.println(lfuCache.get(0));
	}
}
