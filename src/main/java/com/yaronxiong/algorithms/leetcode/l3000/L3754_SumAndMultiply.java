package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3754. 连接非零数字并乘以其数字和 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n。
 * <p>
 * 将 n 中所有的 非零数字 按照它们的原始顺序连接起来，形成一个新的整数 x。如果不存在 非零数字 ，则 x = 0。
 * <p>
 * sum 为 x 中所有数字的 数字和 。
 * <p>
 * 返回一个整数，表示 x * sum 的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 10203004
 * <p>
 * 输出： 12340
 * <p>
 * 解释：
 * <p>
 * 非零数字是 1、2、3 和 4。因此，x = 1234。
 * 数字和为 sum = 1 + 2 + 3 + 4 = 10。
 * 因此，答案是 x * sum = 1234 * 10 = 12340。
 * 示例 2：
 * <p>
 * 输入： n = 1000
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 非零数字是 1，因此 x = 1 且 sum = 1。
 * 因此，答案是 x * sum = 1 * 1 = 1。
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/?envType=daily-question&envId=2026-07-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3754_SumAndMultiply {
    public static void main(String[] args) {
        L3754_SumAndMultiply l3754SumAndMultiply = new L3754_SumAndMultiply();
        System.out.println(l3754SumAndMultiply.sumAndMultiply(10203004));
    }
    public long sumAndMultiply(int n) {
        int x = 0;
        int bit = 1;
        int sum = 0;
        while (n > 0) {
            int a = n % 10;
            n = n / 10;
            if (a == 0) {
                continue;
            }
            x += a * bit;
            bit *= 10;
            sum += a;
        }
        return (long) x * sum;
    }
}
