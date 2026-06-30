package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1358. 包含所有三种字符的子字符串数目
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * <p>
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc",
 * "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 * 示例 2：
 * <p>
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 5 x 10^4
 * s 只包含字符 a，b 和 c 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/description/?envType=daily-question&envId=2026-06-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1358_NumberOfSubstrings {
    public static void main(String[] args) {
        L1358_NumberOfSubstrings l1358NumberOfSubstrings = new L1358_NumberOfSubstrings();
        System.out.println(l1358NumberOfSubstrings.numberOfSubstrings("abcabc"));
        System.out.println(l1358NumberOfSubstrings.numberOfSubstrings("aaacb"));
        System.out.println(l1358NumberOfSubstrings.numberOfSubstrings("abc"));
    }

    public int numberOfSubstrings(String s) {
        int left = 0;
        int[] temp = new int[3];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
            while (left < s.length() && temp[s.charAt(left) - 'a'] > 1) {
                temp[s.charAt(left) - 'a']--;
                left++;
            }
            if (temp[0] >= 1 && temp[1] >= 1 && temp[2] >= 1) {
                ans += left + 1;
            }
        }
        return ans;
    }
}
