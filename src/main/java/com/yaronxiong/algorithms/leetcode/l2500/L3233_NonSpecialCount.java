package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3233. 统计不是特殊数字的数字数量
 * 算术评级: 4
 * 第 408 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1509
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个 正整数 l 和 r。对于任何数字 x，x 的所有正因数（除了 x 本身）被称为 x 的 真因数。
 * <p>
 * 如果一个数字恰好仅有两个 真因数，则称该数字为 特殊数字。例如：
 * <p>
 * 数字 4 是 特殊数字，因为它的真因数为 1 和 2。
 * 数字 6 不是 特殊数字，因为它的真因数为 1、2 和 3。
 * 返回区间 [l, r] 内 不是 特殊数字 的数字数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入： l = 5, r = 7
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 区间 [5, 7] 内不存在特殊数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入： l = 4, r = 16
 * <p>
 * 输出： 11
 * <p>
 * 解释：
 * <p>
 * 区间 [4, 16] 内的特殊数字为 4 和 9。
 * <p>
 * 提示：
 * <p>
 * 1 <= l <= r <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-count-of-numbers-which-are-not-special/description/?envType=daily-question&envId=2024-11-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3233_NonSpecialCount {
    private static final int MX = 31622;
    private static final int[] PI = new int[MX + 1];

    static {
        for (int i = 2; i <= MX; i++) {
            if (PI[i] == 0) { // i 是质数
                PI[i] = PI[i - 1] + 1;
                for (int j = i * i; j <= MX; j += i) { // 注：如果 MX 比较大，小心 i*i 溢出
                    PI[j] = -1; // 标记 i 的倍数为合数
                }
            } else {
                PI[i] = PI[i - 1];
            }
        }
    }

    public int nonSpecialCount(int l, int r) {
        return r - l + 1 - (PI[(int) Math.sqrt(r)] - PI[(int) Math.sqrt(l - 1)]);
    }
}
