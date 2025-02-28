package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2595. 奇偶位数
 * 算术评级: 2
 * 第 337 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1207
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 正 整数 n 。
 * <p>
 * 用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。
 * <p>
 * 用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。
 * <p>
 * 请注意，在数字的二进制表示中，位下标的顺序 从右到左。
 * <p>
 * 返回整数数组 answer ，其中 answer = [even, odd] 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 50
 * <p>
 * 输出：[1,2]
 * <p>
 * 解释：
 * <p>
 * 50 的二进制表示是 110010。
 * <p>
 * 在下标 1，4，5 对应的值为 1。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2
 * <p>
 * 输出：[0,1]
 * <p>
 * 解释：
 * <p>
 * 2 的二进制表示是 10。
 * <p>
 * 只有下标 1 对应的值为 1。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-even-and-odd-bits/?envType=daily-question&envId=2025-02-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2595_EvenOddBit {
    public static void main(String[] args) {
        L2595_EvenOddBit l2595EvenOddBit = new L2595_EvenOddBit();
        System.out.println(Arrays.toString(l2595EvenOddBit.evenOddBit(50)));
    }
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        int index = 0;
        while (n > 0) {
            if ((n % 2) != 0) {
                ans[index % 2]++;
            }
            n /= 2;
            index++;
        }
        return ans;
    }
}
