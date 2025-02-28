package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;
import java.util.Random;

/**
 * 1206. 设计跳表
 * 已解答
 * 算术评级: 9
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * 相关企业
 * 不使用任何库函数，设计一个 跳表 。
 * <p>
 * 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 * <p>
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
 * <p>
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
 * <p>
 * 了解更多 : https://oi-wiki.org/ds/skiplist/
 * <p>
 * 在本题中，你的设计应该要包含这些函数：
 * <p>
 * bool search(int target) : 返回target是否存在于跳表中。
 * void add(int num): 插入一个元素到跳表。
 * bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 * <p>
 * 示例 1:
 * <p>
 * 输入
 * ["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
 * [[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
 * 输出
 * [null, null, null, null, false, null, true, false, true, false]
 * <p>
 * 解释
 * Skiplist skiplist = new Skiplist();
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // 返回 false
 * skiplist.add(4);
 * skiplist.search(1);   // 返回 true
 * skiplist.erase(0);    // 返回 false，0 不在跳表中
 * skiplist.erase(1);    // 返回 true
 * skiplist.search(1);   // 返回 false，1 已被擦除
 * <p>
 * 提示:
 * <p>
 * 0 <= num, target <= 2 * 104
 * 调用search, add,  erase操作次数不大于 5 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/design-skiplist/description/?envType=daily-question&envId=2025-02-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1206_Skiplist {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0));
        skiplist.add(4);
        System.out.println(skiplist.search(1));
        System.out.println(skiplist.erase(0));
        System.out.println(skiplist.erase(1));
        System.out.println(skiplist.search(1));
    }

    static class Skiplist {
        public static final int maxLevel = 32;
        private static final double P = 0.5;
        private final Random RANDOM = new Random();

        class Node {
            private int val;
            private Node[] levelNextNode;

            public Node(int val, int maxLevel) {
                this.val = val;
                this.levelNextNode = new Node[maxLevel];
            }

            public Node getNextNode(int level) {
                return levelNextNode[level];
            }

            public Node setNextNode(int level, Node nextNode) {
                levelNextNode[level] = nextNode;
                return nextNode;
            }

            public int getVal() {
                return val;
            }

            public Node[] getLevelNextNode() {
                return levelNextNode;
            }
        }

        private Node head;
        private Node tail;

        public Skiplist() {
            head = new Node(Integer.MIN_VALUE, maxLevel);
            tail = new Node(Integer.MAX_VALUE, maxLevel);
            Arrays.fill(head.getLevelNextNode(), tail);
        }

        public boolean search(int target) {
            //这个时候的值 <= target
            Node curNode = find(target, 0);
            return curNode.getVal() == target;
        }

        private Node find(int target, int minLevel) {
            //从head开始到tail
            //从上往下开始遍历（level--)
            Node curNode = head;
            for (int i = maxLevel - 1; i >= minLevel; i--) {
                //单个层级遍历，链式遍历 命中则继续探测直到碰到 > 的停下
                while (curNode.getNextNode(i) != tail && curNode.getNextNode(i).getVal() <= target) {
                    curNode = curNode.getNextNode(i);
                }
                //说明碰到了尝试降级
            }
            return curNode;
        }

        public void add(int num) {
            //计算需要插入的节点应该放置到第几层
            int numLevel = getRandomLevel();
            Node newNode = new Node(num, maxLevel);
            for (int i = 0; i <= numLevel; i++) {
                Node node = find(num, i);
                Node nextNode = node.getNextNode(i);
                node.setNextNode(i, newNode);
                newNode.setNextNode(i, nextNode);
            }
        }

        private int getRandomLevel() {
            int curLevel = 0;
            while (RANDOM.nextDouble() <= P && curLevel < maxLevel) {
                curLevel++;
            }
            return curLevel;
        }

        public boolean erase(int num) {
            boolean erased = false;
            for (int level = maxLevel - 1; level >= 0; level--) {
                Node curNode = find(num - 1, level);
                Node nextNode = curNode.getNextNode(level);
                if (nextNode.getVal() == num) {
                    //说明命中需要删除
                    Node nextNextNode = nextNode.getNextNode(level);
                    curNode.setNextNode(level, nextNextNode);
                    nextNode.setNextNode(level, null);
                    erased = true;
                }
            }
            return erased;
        }
    }
}
