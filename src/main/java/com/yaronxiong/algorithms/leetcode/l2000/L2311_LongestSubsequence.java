package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2311. 小于等于 K 的最长二进制子序列
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二进制字符串 s 和一个正整数 k 。
 * <p>
 * 请你返回 s 的 最长 子序列的长度，且该子序列对应的 二进制 数字小于等于 k 。
 * <p>
 * 注意：
 * <p>
 * 子序列可以有 前导 0 。
 * 空字符串视为 0 。
 * 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1001010", k = 5
 * 输出：5
 * 解释：s 中小于等于 5 的最长子序列是 "00010" ，对应的十进制数字是 2 。
 * 注意 "00100" 和 "00101" 也是可行的最长子序列，十进制分别对应 4 和 5 。
 * 最长子序列的长度为 5 ，所以返回 5 。
 * 示例 2：
 * <p>
 * 输入：s = "00101001", k = 1
 * 输出：6
 * 解释："000001" 是 s 中小于等于 1 的最长子序列，对应的十进制数字是 1 。
 * 最长子序列的长度为 6 ，所以返回 6 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 要么是 '0' ，要么是 '1' 。
 * 1 <= k <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-binary-subsequence-less-than-or-equal-to-k/description/?envType=daily-question&envId=2025-06-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2311_LongestSubsequence {
    public static void main(String[] args) {
        L2311_LongestSubsequence l2311LongestSubsequence = new L2311_LongestSubsequence();
        //System.out.println(l2311LongestSubsequence.longestSubsequence("1001010", 5));
        //System.out.println(l2311LongestSubsequence.longestSubsequence("00101001", 1));
        System.out.println(l2311LongestSubsequence.longestSubsequence("001010101011010100010101101010010", 93951055));
    }

    public int longestSubsequence(String s, int k) {
        //找1大赛
        int oneCnt = 0;
        long val = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '1') {
                continue;
            }
            val += (long) Math.pow(2, s.length() - 1 - i);
            if (val > k) {
                break;
            }
            oneCnt++;
        }
        int zeroCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroCnt++;
            }
        }
        return zeroCnt + oneCnt;
    }
}
