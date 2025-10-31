package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3461. 判断操作后字符串中的数字是否相等 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由数字组成的字符串 s 。重复执行以下操作，直到字符串恰好包含 两个 数字：
 * <p>
 * 从第一个数字开始，对于 s 中的每一对连续数字，计算这两个数字的和 模 10。
 * 用计算得到的新数字依次替换 s 的每一个字符，并保持原本的顺序。
 * 如果 s 最后剩下的两个数字 相同 ，返回 true 。否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "3902"
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 一开始，s = "3902"
 * 第一次操作：
 * (s[0] + s[1]) % 10 = (3 + 9) % 10 = 2
 * (s[1] + s[2]) % 10 = (9 + 0) % 10 = 9
 * (s[2] + s[3]) % 10 = (0 + 2) % 10 = 2
 * s 变为 "292"
 * 第二次操作：
 * (s[0] + s[1]) % 10 = (2 + 9) % 10 = 1
 * (s[1] + s[2]) % 10 = (9 + 2) % 10 = 1
 * s 变为 "11"
 * 由于 "11" 中的数字相同，输出为 true。
 * 示例 2：
 * <p>
 * 输入： s = "34789"
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 一开始，s = "34789"。
 * 第一次操作后，s = "7157"。
 * 第二次操作后，s = "862"。
 * 第三次操作后，s = "48"。
 * 由于 '4' != '8'，输出为 false。
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 100
 * s 仅由数字组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-if-digits-are-equal-in-string-after-operations-i/description/?envType=daily-question&envId=2025-10-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3461_HasSameDigits {
    public boolean hasSameDigits(String s) {
        String cur = s;
        while (cur.length() != 2) {
            StringBuilder newS = new StringBuilder();
            for (int i = 0; i < cur.length() - 1; i++) {
                int a = cur.charAt(i) - '0';
                int b = cur.charAt(i + 1) - '0';
                newS.append((a + b) % 10);
            }
            cur = newS.toString();
        }
        return cur.charAt(0) == cur.charAt(1);
    }
}
