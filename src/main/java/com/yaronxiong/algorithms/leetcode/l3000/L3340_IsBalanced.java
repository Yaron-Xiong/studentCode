package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3340. 检查平衡字符串
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个仅由数字 0 - 9 组成的字符串 num。如果偶数下标处的数字之和等于奇数下标处的数字之和，则认为该数字字符串是一个 平衡字符串。
 * <p>
 * 如果 num 是一个 平衡字符串，则返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "1234"
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 偶数下标处的数字之和为 1 + 3 = 4，奇数下标处的数字之和为 2 + 4 = 6。
 * 由于 4 不等于 6，num 不是平衡字符串。
 * 示例 2：
 * <p>
 * 输入：num = "24123"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 偶数下标处的数字之和为 2 + 1 + 3 = 6，奇数下标处的数字之和为 4 + 2 = 6。
 * 由于两者相等，num 是平衡字符串。
 * <p>
 * 提示：
 * <p>
 * 2 <= num.length <= 100
 * num 仅由数字 0 - 9 组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-balanced-string/description/?envType=daily-question&envId=2025-03-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3340_IsBalanced {
    public boolean isBalanced(String num) {
        int oddSum = 0;
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int value = c - '0';
            sum += value;
            if (i % 2 != 0) {
                oddSum += value;
            }
        }
        return oddSum * 2 == sum;
    }
}
