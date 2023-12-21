package com.accompnay.TopicAlgorithms.leetcode.l2000;

import com.google.common.collect.Lists;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2866. 美丽塔 II
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
 * 1 <= n == maxHeights <= 105
 * 1 <= maxHeights[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/beautiful-towers-ii/?envType=daily-question&envId=2023-12-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2866_MaximumSumOfHeights {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(6, 5, 3, 9, 2, 7);
        L2866_MaximumSumOfHeights l2866MaximumSumOfHeights = new L2866_MaximumSumOfHeights();
        System.out.println(l2866MaximumSumOfHeights.maximumSumOfHeights(integers));
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long[] left = new long[maxHeights.size()];
        Deque<int[]> leftStack = new LinkedList<>();
        left[0] = maxHeights.get(0);
        leftStack.addLast(new int[]{maxHeights.get(0), 1});
        for (int i = 1; i < maxHeights.size(); i++) {
            left[i] = left[i - 1] + maxHeights.get(i);
            int controlSize = 1;
            while (!leftStack.isEmpty() && maxHeights.get(i) < leftStack.peekFirst()[0]) {
                int[] node = leftStack.pollFirst();
                left[i] -= (long) (node[0] - maxHeights.get(i)) * node[1];
                controlSize += node[1];
            }
            leftStack.addFirst(new int[]{maxHeights.get(i), controlSize});
        }
        long ans = 0;
        long[] right = new long[maxHeights.size() + 1];
        Deque<int[]> rightStack = new LinkedList<>();
        for (int i = maxHeights.size() - 1; i >= 0; i--) {
            ans = Math.max(ans, left[i] + right[i + 1]);
            right[i] = right[i + 1] + maxHeights.get(i);
            int controlSize = 1;
            while (!rightStack.isEmpty() && maxHeights.get(i) < rightStack.peekFirst()[0]) {
                int[] node = rightStack.pollFirst();
                right[i] -= (long) (node[0] - maxHeights.get(i)) * node[1];
                controlSize += node[1];
            }
            rightStack.addFirst(new int[]{maxHeights.get(i), controlSize});
        }
        return ans;
    }
}
