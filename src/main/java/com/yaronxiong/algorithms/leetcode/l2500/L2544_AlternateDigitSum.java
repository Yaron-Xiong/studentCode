package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2544. 交替数字和
 * 提示
 * 简单
 * 24
 * 相关企业
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * <p>
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 返回所有数字及其对应符号的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 521
 * 输出：4
 * 解释：(+5) + (-2) + (+1) = 4
 * 示例 2：
 * <p>
 * 输入：n = 111
 * 输出：1
 * 解释：(+1) + (-1) + (+1) = 1
 * 示例 3：
 * <p>
 * 输入：n = 886996
 * 输出：0
 * 解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/alternating-digit-sum/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2544_AlternateDigitSum {
    public static void main(String[] args) {
        L2544_AlternateDigitSum l2544AlternateDigitSum = new L2544_AlternateDigitSum();
        System.out.println(l2544AlternateDigitSum.alternateDigitSum(111));
    }
    public int alternateDigitSum(int n) {
        String nStr = String.valueOf(n);
        int sign = 1;
        int res = 0;
        for (int i = 0; i < nStr.length(); i++) {
            char charAt = nStr.charAt(i);
            res += (charAt - '0') * sign;
            sign *= -1;
        }
        return res;
    }
}
