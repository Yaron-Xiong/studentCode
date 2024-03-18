package com.yaronxiong.algorithms.leetcode.l0;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU 缓存
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * <p>
 * 实现 LFUCache 类：
 * <p>
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。
 * 当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，
 * 应该去除 最近最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * <p>
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * <p>
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
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
 * 1 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * 最多调用 2 * 105 次 get 和 put 方法
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/lfu-cache/description/?envType=daily-question&envId=2023-09-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L460_LFUCache {
    public static void main(String[] args) {
        L460_LFUCache l460LfuCache = new L460_LFUCache(2);
        l460LfuCache.put(2, 1);
        l460LfuCache.put(3, 2);
        System.out.println(l460LfuCache.get(3));
        System.out.println(l460LfuCache.get(2));
        l460LfuCache.put(4, 3);
        System.out.println(l460LfuCache.get(2));
        System.out.println(l460LfuCache.get(3));
        System.out.println(l460LfuCache.get(4));
    }

    private Map<Integer, Node> map;
    private Map<Integer, Deque> frequentMap;
    private int capacity;
    private int minFrequent;

    public L460_LFUCache(int capacity) {
        map = new HashMap<>();
        frequentMap = new HashMap<>();
        this.capacity = capacity;
        this.minFrequent = -1;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return maintainKey(key).value;
    }

    private Node maintainKey(int key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        Deque deque = frequentMap.get(node.frequent).removeNode(node);
        if (deque.isEmpty()) {
            frequentMap.remove(node.frequent);
            if (minFrequent == node.frequent) {
                minFrequent = minFrequent + 1;
            }
        }
        Deque nextDeque = frequentMap.computeIfAbsent(++node.frequent, (a) -> new Deque());
        nextDeque.addToTail(node);
        return node;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() + 1 > this.capacity) {
                shrink();
            }
            minFrequent = 1;
            Node newNode = new Node(key, value, 1);
            map.put(key, newNode);
            frequentMap.computeIfAbsent(newNode.frequent, (a) -> new Deque()).addToTail(newNode);
        } else {
            Node node = map.get(key);
            node.value = value;
            maintainKey(key);
        }
    }

    private void shrink() {
        Deque deque = frequentMap.get(minFrequent);
        map.remove(deque.removeHead().key);
        if (deque.isEmpty()) {
            frequentMap.remove(minFrequent);
        }
    }

    static class Deque {
        Node head;
        Node tail;
        public int size;

        public Deque() {
            this.head = new Node(-1, -1, -1);
            this.tail = new Node(-10, -10, -10);
            this.head.nextNode = tail;
            this.tail.preNode = head;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addToTail(Node node) {
            Node preNode = this.tail.preNode;
            preNode.nextNode = node;
            node.preNode = preNode;
            node.nextNode = this.tail;
            this.tail.preNode = node;
            this.size++;
        }

        public Deque removeNode(Node node) {
            if (isEmpty()) {
                return this;
            }
            Node preNode = node.preNode;
            Node nextNode = node.nextNode;
            preNode.nextNode = nextNode;
            nextNode.preNode = preNode;
            node.preNode = null;
            node.nextNode = null;
            this.size--;
            return this;
        }

        public Node removeHead() {
            if (isEmpty()) {
                return null;
            }
            this.size--;
            Node nextNode = this.head.nextNode;
            Node doubleNext = nextNode.nextNode;
            this.head.nextNode = doubleNext;
            doubleNext.preNode = this.head;
            nextNode.preNode = null;
            nextNode.nextNode = null;
            return nextNode;
        }
    }

    static class Node {
        public int key;
        public int value;
        public int frequent;
        public Node preNode;
        public Node nextNode;

        public Node(int key, int value, int frequent) {
            this.key = key;
            this.value = value;
            this.frequent = frequent;
        }
    }
}
