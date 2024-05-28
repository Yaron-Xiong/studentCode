package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.*;

/**
 * 2671. 频率跟踪器
 * 第 344 场周赛
 * Q2
 * 1510
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。
 * <p>
 * 实现 FrequencyTracker 类：
 * <p>
 * FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。
 * void add(int number)：添加一个 number 到数据结构中。
 * void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内容。
 * bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["FrequencyTracker", "add", "add", "hasFrequency"]
 * [[], [3], [3], [2]]
 * 输出
 * [null, null, null, true]
 * <p>
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
 * frequencyTracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
 * 示例 2：
 * <p>
 * 输入
 * ["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
 * [[], [1], [1], [1]]
 * 输出
 * [null, null, null, false]
 * <p>
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(1); // 数据结构现在包含 [1]
 * frequencyTracker.deleteOne(1); // 数据结构现在为空 []
 * frequencyTracker.hasFrequency(1); // 返回 false ，因为数据结构为空
 * 示例 3：
 * <p>
 * 输入
 * ["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
 * [[], [2], [3], [1]]
 * 输出
 * [null, false, null, true]
 * <p>
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.hasFrequency(2); // 返回 false ，因为数据结构为空
 * frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
 * <p>
 * 提示：
 * <p>
 * 1 <= number <= 105
 * 1 <= frequency <= 105
 * 最多调用 add、deleteOne 和 hasFrequency 共计 2 * 105 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/frequency-tracker/description/?envType=daily-question&envId=2024-03-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2671_FrequencyTracker {
    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(6);
        frequencyTracker.add(6);
        System.out.println(frequencyTracker.hasFrequency(1));
        frequencyTracker.deleteOne(6);
        frequencyTracker.deleteOne(6);
        frequencyTracker.deleteOne(6);
        System.out.println(frequencyTracker.hasFrequency(1));
        /*System.out.println(frequencyTracker.hasFrequency(1)); // null
        frequencyTracker.add(3);
        frequencyTracker.add(1);
        System.out.println(frequencyTracker.hasFrequency(1));//1->[3,1]
        frequencyTracker.add(3);
        System.out.println(frequencyTracker.hasFrequency(2));//1->[1] 2->[3]
        frequencyTracker.add(1);
        System.out.println(frequencyTracker.hasFrequency(2));//2->[1,3]
        frequencyTracker.deleteOne(10);
        System.out.println(frequencyTracker.hasFrequency(2));//2->[1,3]
        frequencyTracker.deleteOne(6);
        frequencyTracker.add(7);
        frequencyTracker.deleteOne(10);
        System.out.println(frequencyTracker.hasFrequency(2));//1->[7] 2->[1,3]
        System.out.println(frequencyTracker.hasFrequency(1));
        frequencyTracker.add(1);
        frequencyTracker.add(2);
        frequencyTracker.add(3);
        System.out.println(frequencyTracker.hasFrequency(1));//1->[2,7] 3->[1,3]
        frequencyTracker.deleteOne(3);
        System.out.println(frequencyTracker.hasFrequency(2));//1->[2,7] 3->[1,3]
        System.out.println(frequencyTracker.hasFrequency(3));*/
    }

    static class FrequencyTracker {
        Map<Integer, Integer> frequency2Number;
        Map<Integer, Integer> number2Frequency;

        public FrequencyTracker() {
            frequency2Number = new HashMap<>();
            number2Frequency = new HashMap<>();
        }

        public void update(int number, int delta) {
            Integer newFrequency = number2Frequency.merge(number, delta, Integer::sum);
            frequency2Number.merge(newFrequency, 1, Integer::sum);
            frequency2Number.merge(newFrequency - delta, -1, Integer::sum);
        }

        public void add(int number) {
            update(number, 1);
        }

        public void deleteOne(int number) {
            if (number2Frequency.getOrDefault(number,0) > 0) {
                update(number, -1);
            }
        }

        public boolean hasFrequency(int frequency) {
            return frequency2Number.getOrDefault(frequency, 0) > 0;
        }
    }
}
