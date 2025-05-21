package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.*;

/**
 * 2901. 最长相邻不相等子序列 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n 和一个下标从 0 开始的字符串数组 words ，和一个下标从 0 开始的数组 groups ，两个数组长度都是 n 。
 * <p>
 * 两个长度相等字符串的 汉明距离 定义为对应位置字符 不同 的数目。
 * <p>
 * 你需要从下标 [0, 1, ..., n - 1] 中选出一个 最长子序列 ，将这个子序列记作长度为 k 的 [i0, i1, ..., ik - 1] ，它需要满足以下条件：
 * <p>
 * 相邻 下标对应的 groups 值 不同。即，对于所有满足 0 < j + 1 < k 的 j 都有 groups[ij] != groups[ij + 1] 。
 * 对于所有 0 < j + 1 < k 的下标 j ，都满足 words[ij] 和 words[ij + 1] 的长度 相等 ，且两个字符串之间的 汉明距离 为 1 。
 * 请你返回一个字符串数组，它是下标子序列 依次 对应 words 数组中的字符串连接形成的字符串数组。如果有多个答案，返回任意一个。
 * <p>
 * 子序列 指的是从原数组中删掉一些（也可能一个也不删掉）元素，剩余元素不改变相对位置得到的新的数组。
 * <p>
 * 注意：words 中的字符串长度可能 不相等 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, words = ["bab","dab","cab"], groups = [1,2,2]
 * 输出：["bab","cab"]
 * 解释：一个可行的子序列是 [0,2] 。
 * - groups[0] != groups[2]
 * - words[0].length == words[2].length 且它们之间的汉明距离为 1 。
 * 所以一个可行的答案是 [words[0],words[2]] = ["bab","cab"] 。
 * 另一个可行的子序列是 [0,1] 。
 * - groups[0] != groups[1]
 * - words[0].length = words[1].length 且它们之间的汉明距离为 1 。
 * 所以另一个可行的答案是 [words[0],words[1]] = ["bab","dab"] 。
 * 符合题意的最长子序列的长度为 2 。
 * 示例 2：
 * <p>
 * 输入：n = 4, words = ["a","b","c","d"], groups = [1,2,3,4]
 * 输出：["a","b","c","d"]
 * 解释：我们选择子序列 [0,1,2,3] 。
 * 它同时满足两个条件。
 * 所以答案为 [words[0],words[1],words[2],words[3]] = ["a","b","c","d"] 。
 * 它是所有下标子序列里最长且满足所有条件的。
 * 所以它是唯一的答案。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == words.length == groups.length <= 1000
 * 1 <= words[i].length <= 10
 * 1 <= groups[i] <= n
 * words 中的字符串 互不相同 。
 * words[i] 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-ii/?envType=daily-question&envId=2025-05-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2901_GetWordsInLongestSubsequence {
    public static void main(String[] args) {
        L2901_GetWordsInLongestSubsequence l2901GetWordsInLongestSubsequence = new L2901_GetWordsInLongestSubsequence();
        String[] words = {"bab", "dab", "cab"};
        int[] groups = {1, 2, 2};
        List<String> wordsInLongestSubsequence = l2901GetWordsInLongestSubsequence.getWordsInLongestSubsequence(words, groups);
        System.out.println(wordsInLongestSubsequence);
    }


    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        //从那里来的
        int[] from = new int[words.length];
        Arrays.fill(from, -1);
        //最长长度
        int[] length = new int[words.length];
        //记录目前的最大长度是在什么下标产生的
        int maxIndex = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < words.length; j++) {
                //1. 判断i 后面接j 的长度是否为目前最长
                if (length[j] < length[i]) {
                    continue;
                }
                //2. 判断能不能从 i 后面能不能接 j
                if (groups[i] == groups[j] || !checkString(words[i], words[j], 1)) {
                    //不能接
                    continue;
                }
                //3. 说明i 后面接j 是目前最优解
                length[i] = length[j];
                from[i] = j;
            }
            //这里++ 是加上自身
            length[i]++;
            if (length[i] > length[maxIndex]) {
                maxIndex = i;
            }
        }

        List<String> ans = new ArrayList<>();
        //开始统计结果
        int curIndex = maxIndex;
        while (curIndex != -1) {
            ans.add(words[curIndex]);
            curIndex = from[curIndex];
        }
        return ans;
    }


    private boolean checkString(String a, String b, int targetDistance) {
        if (a.length() != b.length()) {
            return false;
        }
        //计算汉明距离
        int curDistance = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                curDistance++;
            }
            if (curDistance > targetDistance) {
                return false;
            }
        }
        return curDistance == targetDistance;
    }

}
