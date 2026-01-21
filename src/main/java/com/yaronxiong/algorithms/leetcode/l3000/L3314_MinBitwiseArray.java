package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.List;

/**
 * 3314. 构造最小位运算数组 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的质数数组 nums 。你的任务是返回一个长度为 n 的数组 ans ，对于每个下标 i ，以下 条件 均成立：
 * <p>
 * ans[i] OR (ans[i] + 1) == nums[i]
 * 除此以外，你需要 最小化 结果数组里每一个 ans[i] 。
 * <p>
 * 如果没法找到符合 条件 的 ans[i] ，那么 ans[i] = -1 。
 * <p>
 * 质数 指的是一个大于 1 的自然数，且它只有 1 和自己两个因数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,5,7]
 * <p>
 * 输出：[-1,1,4,3]
 * <p>
 * 解释：
 * <p>
 * 对于 i = 0 ，不存在 ans[0] 满足 ans[0] OR (ans[0] + 1) = 2 ，所以 ans[0] = -1 。
 * 对于 i = 1 ，满足 ans[1] OR (ans[1] + 1) = 3 的最小 ans[1] 为 1 ，因为 1 OR (1 + 1) = 3 。
 * 对于 i = 2 ，满足 ans[2] OR (ans[2] + 1) = 5 的最小 ans[2] 为 4 ，因为 4 OR (4 + 1) = 5 。
 * 对于 i = 3 ，满足 ans[3] OR (ans[3] + 1) = 7 的最小 ans[3] 为 3 ，因为 3 OR (3 + 1) = 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [11,13,31]
 * <p>
 * 输出：[9,12,15]
 * <p>
 * 解释：
 * <p>
 * 对于 i = 0 ，满足 ans[0] OR (ans[0] + 1) = 11 的最小 ans[0] 为 9 ，因为 9 OR (9 + 1) = 11 。
 * 对于 i = 1 ，满足 ans[1] OR (ans[1] + 1) = 13 的最小 ans[1] 为 12 ，因为 12 OR (12 + 1) = 13 。
 * 对于 i = 2 ，满足 ans[2] OR (ans[2] + 1) = 31 的最小 ans[2] 为 15 ，因为 15 OR (15 + 1) = 31 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 2 <= nums[i] <= 1000
 * nums[i] 是一个质数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/construct-the-minimum-bitwise-array-i/description/?envType=daily-question&envId=Invalid%20Date">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3314_MinBitwiseArray {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            if (x == 2) {
                ans[i] = -1;
            } else {
                int t = ~x;
                int lowbit = t & -t;
                ans[i] = x ^ (lowbit >> 1);
            }
        }
        return ans;
    }
}
