package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1680. 连接连续二进制数字
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：二进制的 "1" 对应着十进制的 1 。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：27
 * 解释：二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
 * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
 * 示例 3：
 * <p>
 * 输入：n = 12
 * 输出：505379714
 * 解释：连接结果为 "1101110010111011110001001101010111100" 。
 * 对应的十进制数字为 118505380540 。
 * 对 109 + 7 取余后，结果为 505379714 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers/description/?envType=daily-question&envId=2026-02-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1680_ConcatenatedBinary {
    public static void main(String[] args) {
        L1680_ConcatenatedBinary l1680ConcatenatedBinary = new L1680_ConcatenatedBinary();
        System.out.println(l1680ConcatenatedBinary.concatenatedBinary(418));
        System.out.println(l1680ConcatenatedBinary.concatenatedBinary(3));
        System.out.println(l1680ConcatenatedBinary.concatenatedBinary(12));
    }

    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long power = 1;
        long ans = 0;
        for (int i = n; i > 0; i--) {
            String binary = Integer.toBinaryString(i);
            for (int j = binary.length() - 1; j >= 0; j--) {
                if (binary.charAt(j) == '1') {
                    ans = (ans + power) % mod;
                }
                power = (power * 2) % mod;
            }
        }
        return (int) (ans % mod);
    }
}
