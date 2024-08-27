package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 392. 判断子序列
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 简单
 * 相关标签
 * 相关企业
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/is-subsequence/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L392_IsSubsequence {
    public static void main(String[] args) {
        new L392_IsSubsequence().isSubsequence("axc", "ahbgdc");
    }

    public boolean isSubsequence(String s, String t) {
        if (t.isEmpty() && !s.isEmpty()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        char[] tCharArray = t.toCharArray();
        char[] sCharArray = s.toCharArray();
        int k = 0;
        for (char tChar : tCharArray) {
            if (tChar == sCharArray[k] && ++k == sCharArray.length) {
                return true;
            }
        }
        return false;
    }
}
