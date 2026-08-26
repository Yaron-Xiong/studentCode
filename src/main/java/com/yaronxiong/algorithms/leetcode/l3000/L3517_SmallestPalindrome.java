package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3517. 最小回文排列 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 回文 字符串 s。
 * <p>
 * 返回 s 的按字典序排列的 最小 回文排列。
 * <p>
 * 如果一个字符串从前往后和从后往前读都相同，那么这个字符串是一个 回文 字符串。
 * <p>
 * 排列 是字符串中所有字符的重排。
 * <p>
 * 如果字符串 a 按字典序小于字符串 b，则表示在第一个不同的位置，a 中的字符比 b 中的对应字符在字母表中更靠前。
 * 如果在前 min(a.length, b.length) 个字符中没有区别，则较短的字符串按字典序更小。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "z"
 * <p>
 * 输出： "z"
 * <p>
 * 解释：
 * <p>
 * 仅由一个字符组成的字符串已经是按字典序最小的回文。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "babab"
 * <p>
 * 输出： "abbba"
 * <p>
 * 解释：
 * <p>
 * 通过重排 "babab" → "abbba"，可以得到按字典序最小的回文。
 * <p>
 * 示例 3：
 * <p>
 * 输入： s = "daccad"
 * <p>
 * 输出： "acddca"
 * <p>
 * 解释：
 * <p>
 * 通过重排 "daccad" → "acddca"，可以得到按字典序最小的回文。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成。
 * 保证 s 是回文字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-palindromic-rearrangement-i/description/?envType=daily-question&envId=2026-07-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3517_SmallestPalindrome {
    public static void main(String[] args) {
        L3517_SmallestPalindrome l3517SmallestPalindrome = new L3517_SmallestPalindrome();
        System.out.println(l3517SmallestPalindrome.smallestPalindrome("z"));
        System.out.println(l3517SmallestPalindrome.smallestPalindrome("z"));
        System.out.println(l3517SmallestPalindrome.smallestPalindrome("jjejj"));
        System.out.println(l3517SmallestPalindrome.smallestPalindrome("babab"));
        System.out.println(l3517SmallestPalindrome.smallestPalindrome("daccad"));
    }

    public String smallestPalindrome(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        char[] newChars = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length() / 2; i++, chars[index] -= 2) {
            while (chars[index] < 2) {
                index++;
            }
            newChars[i] = (char) ('a' + index);
            newChars[s.length() - i - 1] = (char) ('a' + index);
        }
        if (s.length() % 2 == 1) {
            int oneCntIndex = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] % 2 != 0) {
                    oneCntIndex = i;
                    break;
                }
            }
            newChars[newChars.length / 2] = (char) ('a' + oneCntIndex);
        }
        return String.valueOf(newChars);
    }
}
