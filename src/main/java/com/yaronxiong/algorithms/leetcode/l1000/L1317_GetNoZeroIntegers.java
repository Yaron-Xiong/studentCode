package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1317. 将整数转换为两个无零整数的和
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 * <p>
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [a, b]，满足：
 * <p>
 * a 和 b 都是无零整数
 * a + b = n
 * 题目数据保证至少有一个有效的解决方案。
 * <p>
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[1,1]
 * 解释：a = 1, b = 1。a + b = n 并且 a 和 b 的十进制表示形式都不包含任何 0。
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：[2,9]
 * 示例 3：
 * <p>
 * 输入：n = 10000
 * 输出：[1,9999]
 * 示例 4：
 * <p>
 * 输入：n = 69
 * 输出：[1,68]
 * 示例 5：
 * <p>
 * 输入：n = 1010
 * 输出：[11,999]
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/?envType=daily-question&envId=2025-09-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1317_GetNoZeroIntegers {
    public static void main(String[] args) {
        L1317_GetNoZeroIntegers l1317GetNoZeroIntegers = new L1317_GetNoZeroIntegers();
        int[] noZeroIntegers = l1317GetNoZeroIntegers.getNoZeroIntegers(2);
        System.out.println(Arrays.toString(noZeroIntegers));
    }
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for (int i = 1; i <= n / 2; i++) {
            int a = i;
            int b = n - a;
            if (String.valueOf(a).indexOf('0') == -1 && String.valueOf(b).indexOf('0') == -1) {
                ans[0] = a;
                ans[1] = b;
                break;
            }
        }
        return ans;
    }
}
