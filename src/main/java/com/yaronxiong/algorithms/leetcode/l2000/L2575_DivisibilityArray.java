package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2575. 找出字符串的可整除数组
 * 第 334 场周赛
 * Q2
 * 1541
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * <p>
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 * <p>
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 返回 word 的可整除数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "998244353", m = 3
 * 输出：[1,1,0,0,0,1,1,0,0]
 * 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
 * 示例 2：
 * <p>
 * 输入：word = "1010", m = 10
 * 输出：[0,1,0,1]
 * 解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * word.length == n
 * word 由数字 0 到 9 组成
 * 1 <= m <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/description/?envType=daily-question&envId=2024-03-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2575_DivisibilityArray {
    public static void main(String[] args) {
        L2575_DivisibilityArray l2575DivisibilityArray = new L2575_DivisibilityArray();
        System.out.println(Arrays.toString(l2575DivisibilityArray.divisibilityArray("91221181269244172125025075166510211202115152121212341281327", 21)));
    }

    public int[] divisibilityArray(String word, int m) {
        int[] ans = new int[word.length()];
        char[] chars = word.toCharArray();
        long curValue = 0;
        for (int i = 0; i < chars.length; i++) {
            curValue = curValue * 10 + chars[i] - '0';
            curValue = curValue % m;
            if (curValue == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }
}
