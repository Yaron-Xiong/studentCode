package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.PriorityQueue;

/**
 * 3541. 找到频率最高的元音和辅音
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由小写英文字母（'a' 到 'z'）组成的字符串 s。你的任务是找出出现频率 最高 的元音（'a'、'e'、'i'、'o'、'u' 中的一个）和出现频率最高的辅音（除元音以外的所有字母），并返回这两个频率之和。
 * <p>
 * 注意：如果有多个元音或辅音具有相同的最高频率，可以任选其中一个。如果字符串中没有元音或没有辅音，则其频率视为 0。
 * <p>
 * 一个字母 x 的 频率 是它在字符串中出现的次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "successes"
 * <p>
 * 输出: 6
 * <p>
 * 解释:
 * <p>
 * 元音有：'u' 出现 1 次，'e' 出现 2 次。最大元音频率 = 2。
 * 辅音有：'s' 出现 4 次，'c' 出现 2 次。最大辅音频率 = 4。
 * 输出为 2 + 4 = 6。
 * 示例 2：
 * <p>
 * 输入: s = "aeiaeia"
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * <p>
 * 元音有：'a' 出现 3 次，'e' 出现 2 次，'i' 出现 2 次。最大元音频率 = 3。
 * s 中没有辅音。因此，最大辅音频率 = 0。
 * 输出为 3 + 0 = 3。
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写英文字母
 */
public class L3541_MaxFreqSum {
    public int maxFreqSum(String s) {
        int[] arr = new int[26];
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            int index = charAt - 'a';
            arr[index]++;
            if (charAt == 'a' || charAt == 'e' || charAt == 'i'  || charAt == 'o' || charAt == 'u') {
                ans1 = Math.max(ans1, arr[index]);
            }else {
                ans2 = Math.max(ans2, arr[index]);
            }
        }
        return ans1 + ans2;
    }
}
