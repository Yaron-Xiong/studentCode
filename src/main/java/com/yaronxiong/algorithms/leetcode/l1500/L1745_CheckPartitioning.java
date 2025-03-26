package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1745. 分割回文串 IV
 * 算术评级: 6
 * 第 226 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1925
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，如果可以将它分割成三个 非空 回文子字符串，那么返回 true ，否则返回 false 。
 * <p>
 * 当一个字符串正着读和反着读是一模一样的，就称其为 回文字符串 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcbdd"
 * 输出：true
 * 解释："abcbdd" = "a" + "bcb" + "dd"，三个子字符串都是回文的。
 * 示例 2：
 * <p>
 * 输入：s = "bcbddxy"
 * 输出：false
 * 解释：s 没办法被分割成 3 个回文子字符串。
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 2000
 * s 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/palindrome-partitioning-iv/description/?envType=daily-question&envId=2025-03-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1745_CheckPartitioning {
    public static void main(String[] args) {
        L1745_CheckPartitioning l1745CheckPartitioning = new L1745_CheckPartitioning();
        System.out.println(l1745CheckPartitioning.checkPartitioning("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttxxvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"));
    }

    public boolean checkPartitioning(String s) {
        //计算回文情况
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        //按长度去计算回文情况
        for (int length = 1; length < s.length(); length++) {
            for (int start = 0; start <= s.length() - length; start++) {
                int end = start + length - 1;
                if (length == 1) {
                    isPalindrome[start][end] = true;
                } else if (length == 2) {
                    isPalindrome[start][end] = (s.charAt(start) == s.charAt(end));
                } else {
                    isPalindrome[start][end] = ((s.charAt(start) == s.charAt(end)) && (isPalindrome[start+1][end-1]));
                }
            }
        }

        this.memo = new Boolean[s.length()][4];
        //开始分组
        return dfs2(0, 3, isPalindrome);
    }

    Boolean[][] memo;

    private boolean dfs2(int index, int k, boolean[][] past) {
        if (k == 0 && index == past.length) {
            return true;
        } else if (k == 0 || index == past.length) {
            return false;
        }
        if (memo[index][k] != null) {
            return memo[index][k];
        }
        if (k == 1) {
            return memo[index][k] = past[index][past.length - 1];
        }
        for (int right = past.length - 1; right >= index; right--) {
            if (!past[index][right]) {
                continue;
            }
            if (dfs2(right + 1, k - 1, past)) {
                return memo[index][k] = true;
            }
        }
        return memo[index][k] = false;
    }

}
