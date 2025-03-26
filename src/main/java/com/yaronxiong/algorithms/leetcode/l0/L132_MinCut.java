package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 132. 分割回文串 II
 * 已解答
 * 算术评级: 6
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：s = "ab"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/palindrome-partitioning-ii/description/?envType=daily-question&envId=2025-03-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L132_MinCut {
    public static void main(String[] args) {
        L132_MinCut l132MinCut = new L132_MinCut();
        System.out.println(l132MinCut.minCut("aaa"));
    }

    public int minCut(String s) {
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        checkMemo = new Boolean[s.length()][s.length()];
        return dfs2(0, s) - 1;
    }

    int[] memo;
    Boolean[][] checkMemo;

    private int dfs2(int index, String s) {
        if (index >= s.length()) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        //尝试切割(index -> i)
        int ans = Integer.MAX_VALUE / 2;
        for (int i = s.length() - 1; i >= index; i--) {
            if (!check(index, i, s)) {
                continue;
            }
            ans = Math.min(ans, dfs2(i + 1, s) + 1);
        }
        return memo[index] = ans;
    }

    private boolean check(int left, int right, String s) {
        if (left > right) {
            return true;
        }
        if (checkMemo[left][right] != null) {
            return checkMemo[left][right];
        }
        return checkMemo[left][right] = s.charAt(left) == s.charAt(right) && check(left + 1, right - 1, s);
    }
}
