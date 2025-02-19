package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2080. 区间内查询数字的频率
 * 算术评级: 5
 * 第 268 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1702
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
 * <p>
 * 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
 * <p>
 * 请你实现 RangeFreqQuery 类：
 * <p>
 * RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
 * int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
 * 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["RangeFreqQuery", "query", "query"]
 * [[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
 * 输出：
 * [null, 1, 2]
 * <p>
 * 解释：
 * RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]);
 * rangeFreqQuery.query(1, 2, 4); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
 * rangeFreqQuery.query(0, 11, 33); // 返回 2 。33 在整个子数组中出现 2 次。
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 105
 * 1 <= arr[i], value <= 104
 * 0 <= left <= right < arr.length
 * 调用 query 不超过 105 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/range-frequency-queries/description/?envType=daily-question&envId=2025-02-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2080_RangeFreqQuery {
    public static void main(String[] args) {
        int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
        int query = rangeFreqQuery.query(1, 2, 4);
        System.out.println(query);
        int query1 = rangeFreqQuery.query(0, 11, 33);
        System.out.println(query1);
    }

    static class RangeFreqQuery {
        private List<Integer>[] valueIndex;

        public RangeFreqQuery(int[] arr) {
            valueIndex = new List[10001];
            Arrays.setAll(valueIndex, a -> new ArrayList<Integer>());
            for (int i = 0; i < arr.length; i++) {
                valueIndex[arr[i]].add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> indexList = this.valueIndex[value];
            int a = getLeft(indexList, left);
            int b = getLeft(indexList, right + 1);
            return b - a;
        }

        private int getLeft(List<Integer> arr, int target) {
            int left = -1;
            int right = arr.size();
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (arr.get(mid) >= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }
    }
}
