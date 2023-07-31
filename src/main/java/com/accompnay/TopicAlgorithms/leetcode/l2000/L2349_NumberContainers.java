package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.*;

/**
 * 2349. 设计数字容器系统
 * 提示
 * 中等
 * 26
 * 相关企业
 * 设计一个数字容器系统，可以实现以下功能：
 * <p>
 * 在系统中给定下标处 插入 或者 替换 一个数字。
 * 返回 系统中给定数字的最小下标。
 * 请你实现一个 NumberContainers 类：
 * <p>
 * NumberContainers() 初始化数字容器系统。
 * void change(int index, int number) 在下标 index 处填入 number 。如果该下标 index 处已经有数字了，那么用 number 替换该数字。
 * int find(int number) 返回给定数字 number 在系统中的最小下标。如果系统中没有 number ，那么返回 -1 。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
 * [[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
 * 输出：
 * [null, -1, null, null, null, null, 1, null, 2]
 * <p>
 * 解释：
 * NumberContainers nc = new NumberContainers();
 * nc.find(10); // 没有数字 10 ，所以返回 -1 。
 * nc.change(2, 10); // 容器中下标为 2 处填入数字 10 。
 * nc.change(1, 10); // 容器中下标为 1 处填入数字 10 。
 * nc.change(3, 10); // 容器中下标为 3 处填入数字 10 。
 * nc.change(5, 10); // 容器中下标为 5 处填入数字 10 。
 * nc.find(10); // 数字 10 所在的下标为 1 ，2 ，3 和 5 。因为最小下标为 1 ，所以返回 1 。
 * nc.change(1, 20); // 容器中下标为 1 处填入数字 20 。注意，下标 1 处之前为 10 ，现在被替换为 20 。
 * nc.find(10); // 数字 10 所在下标为 2 ，3 和 5 。最小下标为 2 ，所以返回 2 。
 * <p>
 * 提示：
 * <p>
 * 1 <= index, number <= 109
 * 调用 change 和 find 的 总次数 不超过 105 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/design-a-number-container-system/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2349_NumberContainers {
    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        numberContainers.change(1, 10);
        numberContainers.find(10);
        numberContainers.change(1, 20);
        numberContainers.find(10);
        numberContainers.find(20);
        numberContainers.find(30);

    }

    public static class NumberContainers {
        private Map<Integer, Queue<Integer>> value2Index;
        private Map<Integer, Integer> index2Value;

        public NumberContainers() {
            value2Index = new HashMap<>();
            index2Value = new HashMap<>();
        }

        public void change(int index, int number) {
            index2Value.put(index, number);
            Queue<Integer> queue = value2Index.computeIfAbsent(number, (k) -> new PriorityQueue<>());
            queue.add(index);
        }

        public int find(int number) {
            if (!value2Index.containsKey(number) || value2Index.get(number).isEmpty()) {
                return -1;
            }
            Queue<Integer> queue = value2Index.get(number);
            while (!queue.isEmpty() && index2Value.get(queue.peek()) != number) {
                queue.poll();
            }
            return queue.isEmpty() ? -1 : queue.peek();
        }
    }
}
