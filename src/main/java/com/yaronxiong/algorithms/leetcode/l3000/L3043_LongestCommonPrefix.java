package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.HashSet;
import java.util.Set;

/**
 * 3043. 最长公共前缀的长度
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个 正整数 数组 arr1 和 arr2 。
 * <p>
 * 正整数的 前缀 是其 最左边 的一位或多位数字组成的整数。例如，123 是整数 12345 的前缀，而 234 不是 。
 * <p>
 * 设若整数 c 是整数 a 和 b 的 公共前缀 ，那么 c 需要同时是 a 和 b 的前缀。
 * 例如，5655359 和 56554 有公共前缀 565 和 5655，而 1223 和 43456 没有 公共前缀。
 * <p>
 * 你需要找出属于 arr1 的整数 x 和属于 arr2 的整数 y 组成的所有数对 (x, y) 之中最长的公共前缀的长度。
 * <p>
 * 返回所有数对之中最长公共前缀的长度。如果它们之间不存在公共前缀，则返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,10,100], arr2 = [1000]
 * 输出：3
 * 解释：存在 3 个数对 (arr1[i], arr2[j]) ：
 * - (1, 1000) 的最长公共前缀是 1 。
 * - (10, 1000) 的最长公共前缀是 10 。
 * - (100, 1000) 的最长公共前缀是 100 。
 * 最长的公共前缀是 100 ，长度为 3 。
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,2,3], arr2 = [4,4,4]
 * 输出：0
 * 解释：任何数对 (arr1[i], arr2[j]) 之中都不存在公共前缀，因此返回 0 。
 * 请注意，同一个数组内元素之间的公共前缀不在考虑范围内。
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 5 * 104
 * 1 <= arr1[i], arr2[i] <= 108
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix/description/?envType=daily-question&envId=2026-05-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3043_LongestCommonPrefix {
    public static void main(String[] args) {
        L3043_LongestCommonPrefix l3043LongestCommonPrefix = new L3043_LongestCommonPrefix();
        System.out.println(l3043LongestCommonPrefix.longestCommonPrefix(new int[]{10}, new int[]{17, 11}));
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();
        for (int k : arr1) {
            String s = String.valueOf(k);
            for (int j = 1; j <= s.length(); j++) {
                set.add(s.substring(0, j));
            }
        }
        int ans = 0;
        for (int k : arr2) {
            String s = String.valueOf(k);
            for (int j = 1; j <= s.length(); j++) {
                if (set.contains(s.substring(0, j))) {
                    ans = Math.max(ans, j);
                }
            }
        }
        return ans;
    }
}
