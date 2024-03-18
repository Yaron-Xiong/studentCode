package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 415. 字符串相加
 * 简单
 * 738
 * 相关企业
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/add-strings/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L415_AddStrings {
    public static void main(String[] args) {
        L415_AddStrings l415AddStrings = new L415_AddStrings();
        System.out.println(l415AddStrings.addStrings("1", "9"));
    }

    public String addStrings(String num1, String num2) {
        char[] chars = new char[Math.max(num1.length(), num2.length()) + 1];
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int charIndex = chars.length - 1;
        int carry = 0;
        while (l1 >= 0 || l2 >= 0) {
            int v1 = l1 >= 0 ? (num1.charAt(l1) - '0') : 0;
            int v2 = l2 >= 0 ? (num2.charAt(l2) - '0') : 0;
            int value = v1 + v2 + carry;
            carry = (value / 10);
            value = value % 10;
            chars[charIndex] = (char) (value + '0');
            charIndex--;
            l1--;
            l2--;
        }
        if (carry > 0) {
            chars[0] = (char) (carry + '0');
        }
        return !Character.isDigit(chars[0]) ? new String(chars, 1, chars.length - 1) : new String(chars);
    }
}
