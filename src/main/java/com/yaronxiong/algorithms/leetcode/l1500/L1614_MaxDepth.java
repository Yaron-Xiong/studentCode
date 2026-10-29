package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1614. 括号的最大嵌套深度
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定 有效括号字符串 s，返回 s 的 嵌套深度。嵌套深度是嵌套括号的 最大 数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(1+(2*3)+((8)/4))+1"
 * <p>
 * 输出：3
 * <p>
 * 解释：数字 8 在嵌套的 3 层括号中。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "(1)+((2))+(((3)))"
 * <p>
 * 输出：3
 * <p>
 * 解释：数字 3 在嵌套的 3 层括号中。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "()(())((()()))"
 * <p>
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
 * 题目数据保证括号字符串 s 是 有效的括号字符串
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/description/?envType=daily-question&envId=2026-09-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1614_MaxDepth {
    public int maxDepth(String s) {
        int ans = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                stack.pop();
            }
            ans = Math.max(ans, stack.size());
        }
        return ans;
    }
}
