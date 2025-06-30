package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3442. 奇偶频次间的最大差值 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由小写英文字母组成的字符串 s 。
 * <p>
 * 请你找出字符串中两个字符 a1 和 a2 的出现频次之间的 最大 差值 diff = a1 - a2，这两个字符需要满足：
 * <p>
 * a1 在字符串中出现 奇数次 。
 * a2 在字符串中出现 偶数次 。
 * 返回 最大 差值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaaaabbc"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 字符 'a' 出现 奇数次 ，次数为 5 ；字符 'b' 出现 偶数次 ，次数为 2 。
 * 最大差值为 5 - 2 = 3 。
 * 示例 2：
 * <p>
 * 输入：s = "abcabcab"
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 字符 'a' 出现 奇数次 ，次数为 3 ；字符 'c' 出现 偶数次 ，次数为 2 。
 * 最大差值为 3 - 2 = 1 。
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 100
 * s 仅由小写英文字母组成。
 * s 至少由一个出现奇数次的字符和一个出现偶数次的字符组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-difference-between-even-and-odd-frequency-i/description/?envType=daily-question&envId=2025-06-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3342_MaxDifference {
    public static void main(String[] args) {
        System.out.println(new L3342_MaxDifference().maxDifference("tzt"));
    }
    public int maxDifference(String s) {
        int[] cnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;
        for (int cnt : cnts) {
            if (cnt == 0) {
                continue;
            }
            if (cnt % 2 == 0) {
                minEven = Math.min(minEven, cnt);
            }else {
                maxOdd = Math.max(maxOdd, cnt);
            }
        }
        return maxOdd - minEven;
    }
}
