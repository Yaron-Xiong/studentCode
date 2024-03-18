package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2413. 最小偶倍数
 * 提示
 * 简单
 * 38
 * 相关企业
 * 给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：10
 * 解释：5 和 2 的最小公倍数是 10 。
 * 示例 2：
 * <p>
 * 输入：n = 6
 * 输出：6
 * 解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 150
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-even-multiple/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2413_SmallestEvenMultiple {
    public static void main(String[] args) {
        L2413_SmallestEvenMultiple l2413SmallestEvenMultiple = new L2413_SmallestEvenMultiple();
        System.out.println(l2413SmallestEvenMultiple.smallestEvenMultiple(3));
    }

    public int smallestEvenMultiple(int n) {
        //如果n是奇数 则 return 2 *n
        //如果n是偶数 则 return n
        return (n % 2 + 1) * n;
    }

}
