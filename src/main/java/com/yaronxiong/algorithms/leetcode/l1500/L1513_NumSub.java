package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1513. 仅含 1 的子串数
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
 * <p>
 * 返回所有字符都为 1 的子字符串的数目。
 * <p>
 * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0110111"
 * 输出：9
 * 解释：共有 9 个子字符串仅由 '1' 组成
 * "1" -> 5 次
 * "11" -> 3 次
 * "111" -> 1 次
 * 示例 2：
 * <p>
 * 输入：s = "101"
 * 输出：2
 * 解释：子字符串 "1" 在 s 中共出现 2 次
 * 示例 3：
 * <p>
 * 输入：s = "111111"
 * 输出：21
 * 解释：每个子字符串都仅由 '1' 组成
 * 示例 4：
 * <p>
 * 输入：s = "000"
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * s[i] == '0' 或 s[i] == '1'
 * 1 <= s.length <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-substrings-with-only-1s/description/?envType=daily-question&envId=2025-11-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1513_NumSub {
    public static void main(String[] args) {
        L1513_NumSub l1513NumSub = new L1513_NumSub();
        System.out.println(l1513NumSub.numSub("0110111"));
    }

    public int numSub(String s) {
        char[] charArray = s.toCharArray();
        int index = 0;
        long ans = 0;
        int mod = 1000000007;
        while (index < charArray.length) {
            int left = index;
            while (index < charArray.length && charArray[index] == '1') {
                index++;
            }
            int len = index - left;
            ans += (len + (long) len * len) / 2;
            ans %= mod;
            index++;
        }
        return (int) (ans % mod);
    }
}
