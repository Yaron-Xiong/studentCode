package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 2606. 找到最大开销的子字符串
 * 提示
 * 中等
 * 5
 * 相关企业
 * 给你一个字符串 s ，一个字符 互不相同 的字符串 chars 和一个长度与 chars 相同的整数数组 vals 。
 * <p>
 * 子字符串的开销 是一个子字符串中所有字符对应价值之和。空字符串的开销是 0 。
 * <p>
 * 字符的价值 定义如下：
 * <p>
 * 如果字符不在字符串 chars 中，那么它的价值是它在字母表中的位置（下标从 1 开始）。
 * 比方说，'a' 的价值为 1 ，'b' 的价值为 2 ，以此类推，'z' 的价值为 26 。
 * 否则，如果这个字符在 chars 中的位置为 i ，那么它的价值就是 vals[i] 。
 * 请你返回字符串 s 的所有子字符串中的最大开销。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "adaa", chars = "d", vals = [-1000]
 * 输出：2
 * 解释：字符 "a" 和 "d" 的价值分别为 1 和 -1000 。
 * 最大开销子字符串是 "aa" ，它的开销为 1 + 1 = 2 。
 * 2 是最大开销。
 * 示例 2：
 * <p>
 * 输入：s = "abc", chars = "abc", vals = [-1,-1,-1]
 * 输出：0
 * 解释：字符 "a" ，"b" 和 "c" 的价值分别为 -1 ，-1 和 -1 。
 * 最大开销子字符串是 "" ，它的开销为 0 。
 * 0 是最大开销。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含小写英文字母。
 * 1 <= chars.length <= 26
 * chars 只包含小写英文字母，且 互不相同 。
 * vals.length == chars.length
 * -1000 <= vals[i] <= 1000
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-substring-with-maximum-cost/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2606_MaximumCostSubstring {
    public static void main(String[] args) {
        L2606_MaximumCostSubstring l2606MaximumCostSubstring = new L2606_MaximumCostSubstring();
        System.out.println(l2606MaximumCostSubstring.maximumCostSubstring("zox", "zoxr", new int[]{2, -5, -4, -5}));
    }

    Map<Character, Integer> map = new HashMap<>();

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), vals[i]);
        }
        int[] dp = new int[s.length()];
        dp[0] = getCost(s.charAt(0));
        int res = dp[0];
        for (int i = 1; i < s.length(); i++) {
            //当前点有选择和不选择
            int curCost = getCost(s.charAt(i));
            dp[i] = Math.max(dp[i - 1] + curCost, curCost);
            res = Math.max(dp[i], res);
        }
        return Math.max(0, res);
    }

    public int getCost(Character character) {
        return map.containsKey(character) ? map.get(character) : character - 'a' + 1;
    }
}
