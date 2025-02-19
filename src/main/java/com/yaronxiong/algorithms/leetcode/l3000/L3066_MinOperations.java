package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.PriorityQueue;

/**
 * 3066. 超过阈值的最少操作数 II
 * 算术评级: 3
 * 第 125 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1400
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 一次操作中，你将执行：
 * <p>
 * 选择 nums 中最小的两个整数 x 和 y 。
 * 将 x 和 y 从 nums 中删除。
 * 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。
 * 注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。
 * <p>
 * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,11,10,1,3], k = 10
 * 输出：2
 * 解释：第一次操作中，我们删除元素 1 和 2 ，然后添加 1 * 2 + 2 到 nums 中，nums 变为 [4, 11, 10, 3] 。
 * 第二次操作中，我们删除元素 3 和 4 ，然后添加 3 * 2 + 4 到 nums 中，nums 变为 [10, 11, 10] 。
 * 此时，数组中的所有元素都大于等于 10 ，所以我们停止操作。
 * 使数组中所有元素都大于等于 10 需要的最少操作次数为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,4,9], k = 20
 * 输出：4
 * 解释：第一次操作后，nums 变为 [2, 4, 9, 3] 。
 * 第二次操作后，nums 变为 [7, 4, 9] 。
 * 第三次操作后，nums 变为 [15, 9] 。
 * 第四次操作后，nums 变为 [33] 。
 * 此时，数组中的所有元素都大于等于 20 ，所以我们停止操作。
 * 使数组中所有元素都大于等于 20 需要的最少操作次数为 4 。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2 * 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 * 输入保证答案一定存在，也就是说一定存在一个操作序列使数组中所有元素都大于等于 k 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-ii/description/?envType=daily-question&envId=2025-01-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3066_MinOperations {
    public static void main(String[] args) {
        L3066_MinOperations l3066MinOperations = new L3066_MinOperations();
        System.out.println(l3066MinOperations.minOperations(new int[]{999999999, 999999999, 999999999}, 1000000000));
    }

    public int minOperations(int[] nums, int k) {
        if (nums.length <= 1) return 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add((long) num);
        }
        int ans = 0;
        while (pq.peek() < k) {
            long a = pq.poll();
            long b = pq.poll();
            //min(x, y) * 2 + max(x, y)
            long newVal = a * 2 + b;
            pq.add(newVal);
            ans++;
        }
        return ans;
    }
}
