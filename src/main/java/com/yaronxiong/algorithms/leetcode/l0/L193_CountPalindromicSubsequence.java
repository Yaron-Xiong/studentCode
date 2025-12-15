package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 1930. 长度为 3 的不同回文子序列
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。
 * <p>
 * 即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。
 * <p>
 * 回文 是正着读和反着读一样的字符串。
 * <p>
 * 子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的一个子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabca"
 * 输出：3
 * 解释：长度为 3 的 3 个回文子序列分别是：
 * - "aba" ("aabca" 的子序列)
 * - "aaa" ("aabca" 的子序列)
 * - "aca" ("aabca" 的子序列)
 * 示例 2：
 * <p>
 * 输入：s = "adc"
 * 输出：0
 * 解释："adc" 不存在长度为 3 的回文子序列。
 * 示例 3：
 * <p>
 * 输入：s = "bbcbaba"
 * 输出：4
 * 解释：长度为 3 的 4 个回文子序列分别是：
 * - "bbb" ("bbcbaba" 的子序列)
 * - "bcb" ("bbcbaba" 的子序列)
 * - "bab" ("bbcbaba" 的子序列)
 * - "aba" ("bbcbaba" 的子序列)
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 105
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/unique-length-3-palindromic-subsequences/description/?envType=daily-question&envId=2025-11-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L193_CountPalindromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        int[] leftArr = new int[26];
        Arrays.fill(leftArr, s.length());
        int[] rightArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            leftArr[index] = Math.min(leftArr[index], i);
            rightArr[index] = Math.max(rightArr[index], i);
        }
        int ans = 0;
        for (int i = 0; i < leftArr.length; i++) {
            int left = leftArr[i];
            int right = rightArr[i];
            if (left == s.length() || left == right) {
                continue;
            }
            //找到left 跟 right之间有多少个差异数
            boolean[] flag = new boolean[26];
            int diff = 0;
            for (int j = left + 1; j < right; j++) {
                int index = s.charAt(j) - 'a';
                if (!flag[index]) {
                    diff++;
                }
                flag[index] = true;
            }
            ans += diff;
        }
        return ans;
    }
}
