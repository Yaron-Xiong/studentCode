package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3083. 字符串及其反转中是否存在同一子字符串
 * 算术评级: 2
 * 第 389 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1173
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
 * <p>
 * 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode"
 * <p>
 * 输出：true
 * <p>
 * 解释：子字符串 "ee" 的长度为 2，它也出现在 reverse(s) == "edocteel" 中。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abcba"
 * <p>
 * 输出：true
 * <p>
 * 解释：所有长度为 2 的子字符串 "ab"、"bc"、"cb"、"ba" 也都出现在 reverse(s) == "abcba" 中。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "abcd"
 * <p>
 * 输出：false
 * <p>
 * 解释：字符串 s 中不存在满足「在其反转后的字符串中也出现」且长度为 2 的子字符串。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * 字符串 s 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/?envType=daily-question&envId=2024-12-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3083_IsSubstringPresent {
    public static void main(String[] args) {
        L3083_IsSubstringPresent l3083IsSubstringPresent = new L3083_IsSubstringPresent();
        System.out.println(l3083IsSubstringPresent.isSubstringPresent("abcba"));
    }
    public boolean isSubstringPresent(String s) {
        boolean[][] vis = new boolean[26][26];
        for (int i = 1; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            int y = s.charAt(i - 1) - 'a';
            vis[x][y] = true;
            if (vis[y][x]) {
                return true;
            }
        }
        return false;
    }
}
