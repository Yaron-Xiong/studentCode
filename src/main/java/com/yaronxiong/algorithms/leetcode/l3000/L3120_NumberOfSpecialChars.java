package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3120. 统计特殊字母的数量 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。
 * <p>
 * 返回 word 中 特殊字母 的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入：word = "aaAbcBC"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * word 中的特殊字母是 'a'、'b' 和 'c'。
 * <p>
 * 示例 2:
 * <p>
 * 输入：word = "abc"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * word 中不存在大小写形式同时出现的字母。
 * <p>
 * 示例 3:
 * <p>
 * 输入：word = "abBCab"
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * word 中唯一的特殊字母是 'b'。
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 50
 * word 仅由小写和大写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-the-number-of-special-characters-i/description/?envType=daily-question&envId=2026-05-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3120_NumberOfSpecialChars {
    public int numberOfSpecialChars(String word) {
        int[] up = new int[26];
        int[] low = new int[26];
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                up[c - 'A']++;
            }else {
                low[c - 'a']++;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (up[i] > 0 && low[i] > 0) {
                count++;
            }
        }
        return count;
    }
}
