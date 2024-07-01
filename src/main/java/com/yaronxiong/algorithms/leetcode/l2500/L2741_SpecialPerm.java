package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2741. 特别的排列
 * 算术评级: 8
 * 第 350 场周赛
 * Q3
 * 2021
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列：
 * <p>
 * 对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] == 0 。
 * 请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,6]
 * 输出：2
 * 解释：[3,6,2] 和 [2,6,3] 是 nums 两个特别的排列。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,3]
 * 输出：2
 * 解释：[3,1,4] 和 [4,1,3] 是 nums 两个特别的排列。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 14
 * 1 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/special-permutations/description/?envType=daily-question&envId=2024-06-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2741_SpecialPerm {



    public static void main(String[] args) {
        L2741_SpecialPerm l2741SpecialPerm = new L2741_SpecialPerm();
        System.out.println(l2741SpecialPerm.specialPerm(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192}));
    }

    int maxIndex;
    int[] nums;
    long[][] memo;
    long MOD = 1000000007L;

    public int specialPerm(int[] nums) {
        //全排列
        long ans = 0;
        this.maxIndex = (1 << nums.length) - 1;
        this.nums = nums;
        this.memo = new long[nums.length][maxIndex];
        for (long[] longs : memo) {
            Arrays.fill(longs, -1);
        }
        //如何做缓存？
        int visitIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            visitIndex = (1 << i) | visitIndex;
            ans += dfs2(i, visitIndex);
            visitIndex = ~(1 << i) & visitIndex;
        }
        return (int) (ans % MOD);
    }

    private long dfs2(int preItemIndex, int visitIndex) {
        if (visitIndex == maxIndex) {
            return 1;
        }
        if (memo[preItemIndex][visitIndex] != -1) {
            return memo[preItemIndex][visitIndex];
        }
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int tag = 1 << i;
            if ((visitIndex & tag) == tag) {
                continue;
            }
            //判断是否可以与前面的构建数字
            if (nums[i] % nums[preItemIndex] == 0 || nums[preItemIndex] % nums[i] == 0) {
                visitIndex = tag | visitIndex;
                ans += dfs2(i, visitIndex);
                ans %= MOD;
                visitIndex = ~tag & visitIndex;
            }
        }
        return memo[preItemIndex][visitIndex] = ans % MOD;
    }
}
