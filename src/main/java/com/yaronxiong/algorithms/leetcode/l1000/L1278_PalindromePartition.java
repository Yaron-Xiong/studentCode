package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1278. 分割回文串 III
 * 算术评级: 8
 * 第 165 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1979
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由小写字母组成的字符串 s，和一个整数 k。
 * <p>
 * 请你按下面的要求分割字符串：
 * <p>
 * 首先，你可以将 s 中的部分字符修改为其他的小写英文字母。
 * 接着，你需要把 s 分割成 k 个非空且不相交的子串，并且每个子串都是回文串。
 * 请返回以这种方式分割字符串所需修改的最少字符数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", k = 2
 * 输出：1
 * 解释：你可以把字符串分割成 "ab" 和 "c"，并修改 "ab" 中的 1 个字符，将它变成回文串。
 * 示例 2：
 * <p>
 * 输入：s = "aabbc", k = 3
 * 输出：0
 * 解释：你可以把字符串分割成 "aa"、"bb" 和 "c"，它们都是回文串。
 * 示例 3：
 * <p>
 * 输入：s = "leetcode", k = 8
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= s.length <= 100
 * s 中只含有小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/palindrome-partitioning-iii/?envType=daily-question&envId=2025-03-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1278_PalindromePartition {
    public static void main(String[] args) {
        L1278_PalindromePartition l1278PalindromePartition = new L1278_PalindromePartition();
        System.out.println(l1278PalindromePartition.palindromePartition("tcymekt", 4));
    }

    public int palindromePartition(String s, int k) {
        //一共要切割k次，最后剩余的字符串长度一定要>=k
        memo = new int[s.length() + 1][k + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs2(0, k, s);
    }

    private int[][] memo;

    private int dfs2(int index, int k, String s) {
        if (s.length() - index == k) {
            return 0;
        }
        if (k <= 0) {
            return Integer.MAX_VALUE / 2;
        }
        if (memo[index][k] != -1) {
            return memo[index][k];
        }
        //从index->N(s.length-index == k) 作为一个回文进行处理，需要变更多少次
        int ans = Integer.MAX_VALUE/2;
        for (int i = index; i < s.length() - k + 1; i++) {
            //检查(index,i)的回文情况
            int value = dfs2(i + 1, k - 1, s);
            int cnt = past(index, i, s) + value;
            ans = Math.min(cnt, ans);
        }
        return memo[index][k] = ans;
    }

    private int past(int left, int right, String s) {
        int cnt = 0;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                cnt++;
            }
            left++;
            right--;
        }
        return cnt;
    }
}
