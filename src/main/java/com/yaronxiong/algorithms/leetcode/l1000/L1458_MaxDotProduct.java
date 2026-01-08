package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1458. 两个子序列的最大点积
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个数组 nums1 和 nums2 。
 * <p>
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 * <p>
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，
 * 但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * 输出：18
 * 解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
 * 它们的点积为 (2*3 + (-2)*(-6)) = 18 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,-2], nums2 = [2,-6,7]
 * 输出：21
 * 解释：从 nums1 中得到子序列 [3] ，从 nums2 中得到子序列 [7] 。
 * 它们的点积为 (3*7) = 21 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [-1,-1], nums2 = [1,1]
 * 输出：-1
 * 解释：从 nums1 中得到子序列 [-1] ，从 nums2 中得到子序列 [1] 。
 * 它们的点积为 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 1000
 * <p>
 * 点积：
 * <p>
 * 定义 a = [a1, a2,…, an] 和 b = [b1, b2,…, bn] 的点积为：
 * <p>
 * \mathbf{a}\cdot \mathbf{b} = \sum_{i=1}^n a_ib_i = a_1b_1 + a_2b_2 + \cdots + a_nb_n
 * <p>
 * 这里的 Σ 指示总和符号。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/max-dot-product-of-two-subsequences/description/?envType=daily-question&envId=2026-01-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1458_MaxDotProduct {
    public static void main(String[] args) {
        L1458_MaxDotProduct l1458MaxDotProduct = new L1458_MaxDotProduct();
        System.out.println(l1458MaxDotProduct.maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));
        System.out.println(l1458MaxDotProduct.maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));
        System.out.println(l1458MaxDotProduct.maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length][nums2.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        return dfs2(0, 0, nums1, nums2, memo);
    }

    private int dfs2(int i1, int i2, int[] nums1, int[] nums2, int[][] memo) {
        if (i1 == nums1.length || i2 == nums2.length) {
            return Integer.MIN_VALUE;
        }
        if (memo[i1][i2] != Integer.MAX_VALUE) {
            return memo[i1][i2];
        }
        //每个都判断是否选择  那么会有四个选择
        int v1 = Math.max(dfs2(i1 + 1, i2 + 1, nums1, nums2, memo), 0) + nums1[i1] * nums2[i2];
        int v2 = dfs2(i1 + 1, i2 + 1, nums1, nums2, memo);
        int v3 = dfs2(i1 + 1, i2, nums1, nums2, memo);
        int v4 = dfs2(i1, i2 + 1, nums1, nums2, memo);
        return memo[i1][i2] = Math.max(v1, Math.max(v2, Math.max(v3, v4)));
    }

}
