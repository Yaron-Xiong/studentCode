package com.yaronxiong.algorithms.leetcode.l0;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
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
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/lru-cache/description/?envType=daily-question&envId=2023-09-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L146_LRUCache {
    public static void main(String[] args) {
        L146_LRUCache l146LruCache = new L146_LRUCache(2);
        l146LruCache.put(1, 1);
        l146LruCache.put(2, 2);
        System.out.println(l146LruCache.get(1));
        l146LruCache.put(3, 3);
        System.out.println(l146LruCache.get(2));
        l146LruCache.put(4, 4);
        System.out.println(l146LruCache.get(1));
        System.out.println(l146LruCache.get(3));
        System.out.println(l146LruCache.get(4));
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    public L146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-10, -10);
        this.head.nextNode = tail;
        this.tail.preNode = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        //砍断联系
        unLinked(node);
        //添加尾部
        addToTail(node);
        return node.value;
    }

    private void addToTail(Node node) {
        Node preNode = this.tail.preNode;
        preNode.nextNode = node;
        node.preNode = preNode;
        node.nextNode = this.tail;
        this.tail.preNode = node;
    }

    public void unLinked(Node node) {
        Node preNode = node.preNode;
        Node nextNode = node.nextNode;
        preNode.nextNode = nextNode;
        nextNode.preNode = preNode;
        node.preNode = null;
        node.nextNode = null;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            unLinked(node);
            addToTail(node);
        } else {
            if (map.size() >= this.capacity) {
                //缩容
                Node delNode = this.head.nextNode;
                unLinked(delNode);
                this.map.remove(delNode.key);
            }
            Node newNode = new Node(key, value);
            this.map.put(key, newNode);
            addToTail(newNode);
        }
    }

    static class Node {
        public int key;
        public int value;
        public Node preNode;
        public Node nextNode;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
