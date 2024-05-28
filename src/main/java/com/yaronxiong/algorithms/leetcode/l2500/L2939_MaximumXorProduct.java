package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2939. 最大异或乘积
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你三个整数 a ，b 和 n ，请你返回 (a XOR x) * (b XOR x) 的 最大值 且 x 需要满足 0 <= x < 2n。
 * <p>
 * 由于答案可能会很大，返回它对 109 + 7 取余 后的结果。
 * <p>
 * 注意，XOR 是按位异或操作。
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 12, b = 5, n = 4
 * 输出：98
 * 解释：当 x = 2 时，(a XOR x) = 14 且 (b XOR x) = 7 。所以，(a XOR x) * (b XOR x) = 98 。
 * 98 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。
 * 示例 2：
 * <p>
 * 输入：a = 6, b = 7 , n = 5
 * 输出：930
 * 解释：当 x = 25 时，(a XOR x) = 31 且 (b XOR x) = 30 。所以，(a XOR x) * (b XOR x) = 930 。
 * 930 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。
 * 示例 3：
 * <p>
 * 输入：a = 1, b = 6, n = 3
 * 输出：12
 * 解释： 当 x = 5 时，(a XOR x) = 4 且 (b XOR x) = 3 。所以，(a XOR x) * (b XOR x) = 12 。
 * 12 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。
 * <p>
 * 提示：
 * <p>
 * 0 <= a, b < 250
 * 0 <= n <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-xor-product/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2939_MaximumXorProduct {
    public static void main(String[] args) {
        L2939_MaximumXorProduct l2939MaximumXorProduct = new L2939_MaximumXorProduct();
        System.out.println(l2939MaximumXorProduct.maximumXorProduct(12,5,4));
    }
    public int maximumXorProduct(long a, long b, int n) {
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }
        //判断n 落在max 与 min的什么位置
        long mask = (1L << n) - 1;
        long ax = a & ~mask; //第n位及其左边 无法被x影响 先计算
        long bx = b & ~mask;
        a &= mask;
        b &= mask;

        return -1;
    }
}
