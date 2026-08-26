package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3090. 每个字符最多出现两次的最长子字符串
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "bcbbbcba"
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 以下子字符串长度为 4，并且每个字符最多出现两次："bcbbbcba"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "aaaa"
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 以下子字符串长度为 2，并且每个字符最多出现两次："aaaa"。
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 100
 * s 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/?envType=daily-question&envId=2026-08-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3090_MaximumLengthSubstring {
    public int maximumLengthSubstring(String s) {
        int[] charCnt = new int[26];
        int left = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            charCnt[index]++;
            while (charCnt[index] > 2) {
                left++;
                charCnt[s.charAt(left) - 'a']--;
            }
            ans = Math.max(ans, i - left);
        }
        return ans;
    }
}
