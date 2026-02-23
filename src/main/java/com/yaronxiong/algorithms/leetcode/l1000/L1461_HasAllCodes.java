package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二进制字符串 s 和一个整数 k 。如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 true ，否则请返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "00110110", k = 2
 * 输出：true
 * 解释：长度为 2 的二进制串包括 "00"，"01"，"10" 和 "11"。它们分别是 s 中下标为 0，1，3，2 开始的长度为 2 的子串。
 * 示例 2：
 * <p>
 * 输入：s = "0110", k = 1
 * 输出：true
 * 解释：长度为 1 的二进制串包括 "0" 和 "1"，显然它们都是 s 的子串。
 * 示例 3：
 * <p>
 * 输入：s = "0110", k = 2
 * 输出：false
 * 解释：长度为 2 的二进制串 "00" 没有出现在 s 中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 * 105
 * s[i] 不是'0' 就是 '1'
 * 1 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/?envType=daily-question&envId=2026-02-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1461_HasAllCodes {
    public static void main(String[] args) {
        L1461_HasAllCodes l1461HasAllCodes = new L1461_HasAllCodes();
        System.out.println(l1461HasAllCodes.hasAllCodes("00110110", 2));
        System.out.println(l1461HasAllCodes.hasAllCodes("0110", 1));
    }

    public boolean hasAllCodes(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int num = Integer.parseInt(s.substring(0, k), 2);
        set.add(num);
        for (int i = k; i < s.length(); i++) {
            num = (num << 1) | (s.charAt(i) - '0');
            num = num & ((1 << k) - 1);
            set.add(num);
        }
        return set.size() == (1 << k);
    }
}