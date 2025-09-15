package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1304. 和为零的 N 个不同整数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：[-1,0,1]
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-n-unique-integers-sum-up-to-zero/description/?envType=daily-question&envId=2025-09-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1304_SumZero {
    public static void main(String[] args) {
        L1304_SumZero l1304SumZero = new L1304_SumZero();
        System.out.println(Arrays.toString(l1304SumZero.sumZero(5)));
        System.out.println(Arrays.toString(l1304SumZero.sumZero(3)));
        System.out.println(Arrays.toString(l1304SumZero.sumZero(4)));
    }
    public int[] sumZero(int n) {
        int size = n / 2;
        int[] ans = new int[n];
        int start = size;
        for (int i = 0; i < size; i++) {
            ans[i] = -start;
            ans[n - i - 1] = start;
            start--;
        }
        return ans;
    }
}
