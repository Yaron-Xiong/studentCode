package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3099. 哈沙德数
 * 算术评级: 2
 * 第 391 场周赛
 * Q1
 * 1101
 * 相关标签
 * 相关企业
 * 提示
 * 如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。
 * 给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入： x = 18
 * <p>
 * 输出： 9
 * <p>
 * 解释：
 * <p>
 * x 各个数位上的数字之和为 9 。18 能被 9 整除。因此 18 是哈沙德数，答案是 9 。
 * <p>
 * 示例 2：
 * <p>
 * 输入： x = 23
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * x 各个数位上的数字之和为 5 。23 不能被 5 整除。因此 23 不是哈沙德数，答案是 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/harshad-number/description/?envType=daily-question&envId=2024-07-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3099_SumOfTheDigitsOfHarshadNumber {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int bitCnt = 0;
        int curX = x;
        while (curX > 0) {
            int a = curX % 10;
            curX = curX / 10;
            bitCnt += a;
        }
        return x % bitCnt == 0 ? bitCnt : -1;
    }
}
