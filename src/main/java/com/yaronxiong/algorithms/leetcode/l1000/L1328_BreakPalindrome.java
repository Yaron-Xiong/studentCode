package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1328. 破坏回文串
 * 算术评级: 4
 * 第 18 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1474
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由小写英文字母组成的回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的 字典序最小 ，且 不是 回文串。
 * <p>
 * 请你返回结果字符串。如果无法做到，则返回一个 空串 。
 * <p>
 * 如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符严格小于 b 中的对应字符。例如，"abcc” 字典序比 "abcd" 小，因为不同的第一个位置是在第四个字符，显然 'c' 比 'd' 小。
 * <p>
 * 示例 1：
 * <p>
 * 输入：palindrome = "abccba"
 * 输出："aaccba"
 * 解释：存在多种方法可以使 "abccba" 不是回文，例如 "zbccba", "aaccba", 和 "abacba" 。
 * 在所有方法中，"aaccba" 的字典序最小。
 * 示例 2：
 * <p>
 * 输入：palindrome = "a"
 * 输出：""
 * 解释：不存在替换一个字符使 "a" 变成非回文的方法，所以返回空字符串。
 * <p>
 * 提示：
 * <p>
 * 1 <= palindrome.length <= 1000
 * palindrome 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/break-a-palindrome/description/?envType=daily-question&envId=2025-03-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1328_BreakPalindrome {
    public static void main(String[] args) {
        L1328_BreakPalindrome l1328BreakPalindrome = new L1328_BreakPalindrome();
        System.out.println(l1328BreakPalindrome.breakPalindrome("a"));
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        //输入的字符串一定是回文
        char[] charArray = palindrome.toCharArray();
        for (int index = 0; index < palindrome.length() / 2; index++) {
            if (charArray[index] == 'a') {
                continue;
            }
            charArray[index] = 'a';
            return new String(charArray);
        }
        //没答案，往后挪
        charArray[charArray.length - 1] = 'b';
        return new String(charArray);
    }

}
