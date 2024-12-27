package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3138. 同位字符串连接的最小长度
 * 算术评级: 5
 * 第 396 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1979
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，它由某个字符串 t 和若干 t  的 同位字符串 连接而成。
 * <p>
 * 请你返回字符串 t 的 最小 可能长度。
 * <p>
 * 同位字符串 指的是重新排列一个单词得到的另外一个字符串，原来字符串中的每个字符在新字符串中都恰好只使用一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abba"
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 一个可能的字符串 t 为 "ba" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cdef"
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 一个可能的字符串 t 为 "cdef" ，注意 t 可能等于 s 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-length-of-anagram-concatenation/description/?envType=daily-question&envId=2024-12-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3138_MinAnagramLength {
    public static void main(String[] args) {
        L3138_MinAnagramLength l3138MinAnagramLength = new L3138_MinAnagramLength();
        System.out.println(l3138MinAnagramLength.minAnagramLength("abbbaa"));
    }

    public int minAnagramLength(String s) {
        int[] cnts = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        for (int i = 1; i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            boolean check = check2(s, cnts, i);
            if (check) {
                return i;
            }
        }
        return n;
    }

    private boolean check2(String s, int[] cnts, int k) {
        int x = s.length() / k;
        //以k个为一组开始check
        for (int i = 0; i < s.length(); i += k) {
            //范围[i,k)
            int[] cnt = new int[26];
            for (int j = i; j < i + k; j++) {
                cnt[s.charAt(j) - 'a']++;
            }
            for (int j = 0; j < cnt.length; j++) {
                if (cnts[j] != cnt[j] * x) {
                    return false;
                }
            }
        }
        return true;
    }
}
