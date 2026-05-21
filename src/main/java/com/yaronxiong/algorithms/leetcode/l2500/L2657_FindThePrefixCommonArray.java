package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2657. 找到两个数组的前缀公共数组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个下标从 0 开始长度为 n 的整数排列 A 和 B 。
 * <p>
 * A 和 B 的 前缀公共数组 定义为数组 C ，其中 C[i] 是数组 A 和 B 到下标为 i 之前公共元素的数目。
 * <p>
 * 请你返回 A 和 B 的 前缀公共数组 。
 * <p>
 * 如果一个长度为 n 的数组包含 1 到 n 的元素恰好一次，我们称这个数组是一个长度为 n 的 排列 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,3,2,4], B = [3,1,2,4]
 * 输出：[0,2,3,4]
 * 解释：i = 0：没有公共元素，所以 C[0] = 0 。
 * i = 1：1 和 3 是两个数组的前缀公共元素，所以 C[1] = 2 。
 * i = 2：1，2 和 3 是两个数组的前缀公共元素，所以 C[2] = 3 。
 * i = 3：1，2，3 和 4 是两个数组的前缀公共元素，所以 C[3] = 4 。
 * 示例 2：
 * <p>
 * 输入：A = [2,3,1], B = [3,1,2]
 * 输出：[0,1,3]
 * 解释：i = 0：没有公共元素，所以 C[0] = 0 。
 * i = 1：只有 3 是公共元素，所以 C[1] = 1 。
 * i = 2：1，2 和 3 是两个数组的前缀公共元素，所以 C[2] = 3 。
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length == B.length == n <= 50
 * 1 <= A[i], B[i] <= n
 * 题目保证 A 和 B 两个数组都是 n 个元素的排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-prefix-common-array-of-two-arrays/description/?envType=daily-question&envId=2026-05-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2657_FindThePrefixCommonArray {
    public static void main(String[] args) {
        L2657_FindThePrefixCommonArray l2657FindThePrefixCommonArray = new L2657_FindThePrefixCommonArray();
        System.out.println(Arrays.toString(l2657FindThePrefixCommonArray.findThePrefixCommonArray(new int[]{1, 2, 3}, new int[]{1, 3, 2})));
        System.out.println(Arrays.toString(l2657FindThePrefixCommonArray.findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(l2657FindThePrefixCommonArray.findThePrefixCommonArray(new int[]{2, 3, 1}, new int[]{3, 1, 2})));
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        long q = 0;
        long p = 0;
        for (int i = 0; i < A.length; i++) {
            q = 1L << A[i] | q;
            p = 1L << B[i] | p;
            ans[i] = Long.bitCount(q & p);
        }
        return ans;
    }

}
