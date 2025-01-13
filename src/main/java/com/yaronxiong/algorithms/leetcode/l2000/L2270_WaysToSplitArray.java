package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2270. 分割数组的方案数
 * 算术评级: 3
 * 第 78 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1334
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
 * 如果以下描述为真，那么 nums 在下标 i 处有一个 合法的分割 ：
 * <p>
 * 前 i + 1 个元素的和 大于等于 剩下的 n - i - 1 个元素的和。
 * 下标 i 的右边 至少有一个 元素，也就是说下标 i 满足 0 <= i < n - 1 。
 * 请你返回 nums 中的 合法分割 方案数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,4,-8,7]
 * 输出：2
 * 解释：
 * 总共有 3 种不同的方案可以将 nums 分割成两个非空的部分：
 * - 在下标 0 处分割 nums 。那么第一部分为 [10] ，和为 10 。第二部分为 [4,-8,7] ，和为 3 。因为 10 >= 3 ，所以 i = 0 是一个合法的分割。
 * - 在下标 1 处分割 nums 。那么第一部分为 [10,4] ，和为 14 。第二部分为 [-8,7] ，和为 -1 。因为 14 >= -1 ，所以 i = 1 是一个合法的分割。
 * - 在下标 2 处分割 nums 。那么第一部分为 [10,4,-8] ，和为 6 。第二部分为 [7] ，和为 7 。因为 6 < 7 ，所以 i = 2 不是一个合法的分割。
 * 所以 nums 中总共合法分割方案受为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1,0]
 * 输出：2
 * 解释：
 * 总共有 2 种 nums 的合法分割：
 * - 在下标 1 处分割 nums 。那么第一部分为 [2,3] ，和为 5 。第二部分为 [1,0] ，和为 1 。因为 5 >= 1 ，所以 i = 1 是一个合法的分割。
 * - 在下标 2 处分割 nums 。那么第一部分为 [2,3,1] ，和为 6 。第二部分为 [0] ，和为 0 。因为 6 >= 0 ，所以 i = 2 是一个合法的分割。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-ways-to-split-array/description/?envType=daily-question&envId=2025-01-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2270_WaysToSplitArray {
    public static void main(String[] args) {
        L2270_WaysToSplitArray l2270WaysToSplitArray = new L2270_WaysToSplitArray();
        System.out.println(l2270WaysToSplitArray.waysToSplitArray(new int[]{10, 4, -8, 7}));
    }

    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int ans = 0;
        long preSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            preSum += nums[i];
            if (preSum >= sum - preSum) {
                ans++;
            }
        }
        return ans;
    }
}
