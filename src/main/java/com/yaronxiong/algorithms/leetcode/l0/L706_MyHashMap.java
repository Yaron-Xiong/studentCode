package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 706. 设计哈希映射
 * 算术评级: 3
 * 简单
 * 相关标签
 * 相关企业
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * <p>
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 * <p>
 * 提示：
 * <p>
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/design-hashmap/description/?envType=daily-question&envId=2024-04-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L706_MyHashMap {
    class MyList {
        private Node head;
        private Node tail;

        public MyList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void addToTail(Node node) {
            Node containsNode = find(node.key);
            if (containsNode != null) {
                containsNode.value = node.value;
                return;
            }
            Node pre = tail.prev;
            pre.next = node;
            node.prev = pre;
            node.next = tail;
            tail.prev = node;
        }

        public void removeNode(int key) {
            Node old = find(key);
            if (old == null) {
                return;
            }
            Node pre = old.prev;

            pre.next = old.next;
            old.next.prev = pre;
        }

        public Node find(Integer key) {
            Node curNode = head.next;
            while (curNode != tail) {
                if (curNode.key == key) {
                    return curNode;
                }
                curNode = curNode.next;
            }
            return null;
        }
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

    class MyHashMap {
        private MyList[] arr;

        public MyHashMap() {
            arr = new MyList[32];
        }

        public void put(int key, int value) {
            int index = getIndex(key);
            if (arr[index] == null) {
                arr[index] = new MyList();
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            arr[index].addToTail(node);
        }

        private int getIndex(int key) {
            return key % arr.length;
        }

        public int get(int key) {
            int index = getIndex(key);
            if (arr[index] == null) {
                return -1;
            }
            Node node = arr[index].find(key);
            if (node == null) {
                return -1;
            }
            return node.value;
        }

        public void remove(int key) {
            int index = getIndex(key);
            if (arr[index] == null) {
                return;
            }
            arr[index].removeNode(key);
        }
    }

}
