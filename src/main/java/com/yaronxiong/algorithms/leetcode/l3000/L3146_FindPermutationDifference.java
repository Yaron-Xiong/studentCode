package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3146. 两个字符串的排列差
 * 算术评级: 2
 * 第 397 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1152
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串 s 和 t，每个字符串中的字符都不重复，且 t 是 s 的一个排列。
 * <p>
 * 排列差 定义为 s 和 t 中每个字符在两个字符串中位置的绝对差值之和。
 * <p>
 * 返回 s 和 t 之间的 排列差 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "bac"
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 对于 s = "abc" 和 t = "bac"，排列差是：
 * <p>
 * "a" 在 s 中的位置与在 t 中的位置之差的绝对值。
 * "b" 在 s 中的位置与在 t 中的位置之差的绝对值。
 * "c" 在 s 中的位置与在 t 中的位置之差的绝对值。
 * 即，s 和 t 的排列差等于 |0 - 1| + |2 - 2| + |1 - 0| = 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abcde", t = "edbac"
 * <p>
 * 输出：12
 * <p>
 * 解释： s 和 t 的排列差等于 |0 - 3| + |1 - 2| + |2 - 4| + |3 - 1| + |4 - 0| = 12。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 26
 * 每个字符在 s 中最多出现一次。
 * t 是 s 的一个排列。
 * s 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/permutation-difference-between-two-strings/description/?envType=daily-question&envId=2024-08-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3146_FindPermutationDifference {
    public int findPermutationDifference(String s, String t) {
        int[] mapArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mapArr[s.charAt(i) - 'a'] = i;
        }
        int value = 0;
        for (int i = 0; i < t.length(); i++) {
            value += Math.abs(mapArr[t.charAt(i) - 'a'] - i);
        }
        return value;
    }
}
