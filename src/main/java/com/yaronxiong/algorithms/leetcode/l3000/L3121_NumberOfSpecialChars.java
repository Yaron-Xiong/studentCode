package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3121. 统计特殊字母的数量 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，
 * 并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称字母 c 是一个 特殊字母 。
 * <p>
 * 返回 word 中 特殊字母 的数量。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：word = "aaAbcBC"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 特殊字母是 'a'、'b' 和 'c'。
 * <p>
 * 示例 2:
 * <p>
 * 输入：word = "abc"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * word 中不存在特殊字母。
 * <p>
 * 示例 3:
 * <p>
 * 输入：word = "AbBCab"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * word 中不存在特殊字母。
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 2 * 105
 * word 仅由小写和大写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-the-number-of-special-characters-ii/description/?envType=daily-question&envId=2026-05-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3121_NumberOfSpecialChars {
    public static void main(String[] args) {
        L3121_NumberOfSpecialChars l3121NumberOfSpecialChars = new L3121_NumberOfSpecialChars();
        System.out.println(l3121NumberOfSpecialChars.numberOfSpecialChars("aaAbcBC"));
        System.out.println(l3121NumberOfSpecialChars.numberOfSpecialChars("abc"));
        System.out.println(l3121NumberOfSpecialChars.numberOfSpecialChars("AbBCab"));
    }

    public int numberOfSpecialChars(String word) {
        int[] upFirstIndex = new int[26];
        int[] lowLastIndex = new int[26];
        Arrays.fill(upFirstIndex, Integer.MAX_VALUE);
        Arrays.fill(lowLastIndex, -1);
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                int index = word.charAt(i) - 'A';
                upFirstIndex[index] = Math.min(upFirstIndex[index], i);
            } else {
                int index = word.charAt(i) - 'a';
                lowLastIndex[index] = Math.max(lowLastIndex[index], i);
            }
        }
        int count = 0;
        for (int i = 0; i < upFirstIndex.length; i++) {
            if (upFirstIndex[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (lowLastIndex[i] == -1) {
                continue;
            }
            if (lowLastIndex[i] > upFirstIndex[i]) {
                continue;
            }
            count++;
        }
        return count;
    }
}
