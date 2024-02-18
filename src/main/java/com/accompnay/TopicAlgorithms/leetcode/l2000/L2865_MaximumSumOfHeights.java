package com.accompnay.TopicAlgorithms.leetcode.l2000;

import com.google.common.collect.Lists;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2865. 美丽塔 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
 * <p>
 * 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
 * <p>
 * 如果以下条件满足，我们称这些塔是 美丽 的：
 * <p>
 * 1 <= heights[i] <= maxHeights[i]
 * heights 是一个 山脉 数组。
 * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
 * <p>
 * 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
 * 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
 * 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：maxHeights = [5,3,4,1,1]
 * 输出：13
 * 解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，峰值在 i = 0 处。
 * 13 是所有美丽塔方案中的最大高度和。
 * 示例 2：
 * <p>
 * 输入：maxHeights = [6,5,3,9,2,7]
 * 输出：22
 * 解释： 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，峰值在 i = 3 处。
 * 22 是所有美丽塔方案中的最大高度和。
 * 示例 3：
 * <p>
 * 输入：maxHeights = [3,2,5,5,2,3]
 * 输出：18
 * 解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，最大值在 i = 2 处。
 * 注意，在这个方案中，i = 3 也是一个峰值。
 * 18 是所有美丽塔方案中的最大高度和。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == maxHeights <= 103
 * 1 <= maxHeights[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/beautiful-towers-i/description/?envType=daily-question&envId=2024-01-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2865_MaximumSumOfHeights {
    public static void main(String[] args) {
        L2865_MaximumSumOfHeights l2865MaximumSumOfHeights = new L2865_MaximumSumOfHeights();
        System.out.println(l2865MaximumSumOfHeights.maximumSumOfHeights(Lists.newArrayList(6, 5, 3, 9, 2, 7)));
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int[] arr = maxHeights.stream().mapToInt(i -> i).toArray();
        long[] left = new long[arr.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(-1);
        long leftSum = 0;
        //计算当前为山峰时 左边的值
        for (int i = 0; i < arr.length; i++) {
            while (deque.size() > 1 && arr[i] < arr[deque.peekFirst()]) {
                int index = deque.pollFirst();
                leftSum -= (long) arr[index] * (index - deque.peekFirst());
            }
            leftSum += (long) arr[i] * (i - deque.peekFirst());
            deque.addFirst(i);
            left[i] = leftSum;
        }
        long ans = 0;
        deque.clear();
        deque.addFirst(arr.length);
        long[] right = new long[arr.length];
        long rightSum = 0;
        //计算当前为山峰时 右边的值
        for (int i = arr.length - 1; i >= 0; i--) {
            while (deque.size() > 1 && arr[i] < arr[deque.peekFirst()]) {
                int index = deque.pollFirst();
                rightSum -= (long) arr[index] * (deque.peekFirst() - index);
            }
            rightSum += (long) arr[i] * (deque.peekFirst() - i);
            deque.addFirst(i);
            right[i] = rightSum;
            ans = Math.max(ans, right[i] + left[i] - arr[i]);
        }
        return ans;
    }
}
