package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1935. 可以输入的最大单词数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
 * <p>
 * 给你一个由若干单词组成的字符串 text ，单词间由单个空格组成（不含前导和尾随空格）；
 * 另有一个字符串 brokenLetters ，由所有已损坏的不同字母键组成，返回你可以使用此键盘完全输入的 text 中单词的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "hello world", brokenLetters = "ad"
 * 输出：1
 * 解释：无法输入 "world" ，因为字母键 'd' 已损坏。
 * 示例 2：
 * <p>
 * 输入：text = "leet code", brokenLetters = "lt"
 * 输出：1
 * 解释：无法输入 "leet" ，因为字母键 'l' 和 't' 已损坏。
 * 示例 3：
 * <p>
 * 输入：text = "leet code", brokenLetters = "e"
 * 输出：0
 * 解释：无法输入任何单词，因为字母键 'e' 已损坏。
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 104
 * 0 <= brokenLetters.length <= 26
 * text 由若干用单个空格分隔的单词组成，且不含任何前导和尾随空格
 * 每个单词仅由小写英文字母组成
 * brokenLetters 由 互不相同 的小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-words-you-can-type/description/?envType=daily-question&envId=2025-09-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1935_CanBeTypedWords {
    public static void main(String[] args) {
        L1935_CanBeTypedWords l1935CanBeTypedWords = new L1935_CanBeTypedWords();
        System.out.println(l1935CanBeTypedWords.canBeTypedWords("hello world", "ad"));
    }
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (int i = 0; i < brokenLetters.length(); i++) {
            broken[brokenLetters.charAt(i) - 'a'] = true;
        }
        String[] split = text.split(" ");
        int ans = 0;
        for (String s : split) {
            boolean match = false;
            for (int i = 0; i < s.length(); i++) {
                if (broken[s.charAt(i) - 'a']) {
                    match = true;
                    break;
                }
            }
            if (!match) {
                ans++;
            }
        }
        return ans;
    }
}
