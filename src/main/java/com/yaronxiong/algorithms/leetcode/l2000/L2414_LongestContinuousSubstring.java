package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2414. 最长的字母序连续子字符串的长度
 * 算术评级: 3
 * 第 311 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1222
 * 相关标签
 * 相关企业
 * 提示
 * 字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
 * <p>
 * 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
 * 给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abacaba"
 * 输出：2
 * 解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
 * "ab" 是最长的字母序连续子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "abcde"
 * 输出：5
 * 解释："abcde" 是最长的字母序连续子字符串。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/length-of-the-longest-alphabetical-continuous-substring/description/?envType=daily-question&envId=2024-09-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2414_LongestContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int maxLen = 1;
        int preLen = 1;
        char[] charArray = s.toCharArray();
        int preChar = charArray[0];
        for (int i = 1; i < charArray.length; i++) {
            preLen = charArray[i] == preChar + 1 ? preLen + 1 : 1;
            maxLen = Math.max(maxLen, preLen);
            preChar = charArray[i];
        }
        return maxLen;
    }
}
