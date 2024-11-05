package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 633. 平方数之和
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 0 <= c <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sum-of-square-numbers/description/?envType=daily-question&envId=2024-11-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L633_JudgeSquareSum {
    public static void main(String[] args) {
        L633_JudgeSquareSum l633JudgeSquareSum = new L633_JudgeSquareSum();
        System.out.println(l633JudgeSquareSum.judgeSquareSum(2147473645));
    }
    public boolean judgeSquareSum(int c) {
        //c = a + b
        //b = c-a^2
        for (long a = 0; a < Integer.MAX_VALUE; a++) {
            long v = c - (a * a);
            if (v < 0) {
                return false;
            }
            long sqrt = (long) Math.sqrt(v);
            if (sqrt * sqrt == v) {
                return true;
            }
        }
        return false;
    }
}
