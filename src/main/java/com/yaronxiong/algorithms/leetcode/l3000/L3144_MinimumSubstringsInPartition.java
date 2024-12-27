package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3144. 分割字符频率相等的最少子字符串
 * 算术评级: 6
 * 第 130 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1917
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，你需要将它分割成一个或者更多的 平衡 子字符串。
 * 比方说，s == "ababcc" 那么 ("abab", "c", "c") ，("ab", "abc", "c") 和 ("ababcc") 都是合法分割，但是 ("a", "bab", "cc") ，("aba", "bc", "c") 和 ("ab", "abcc") 不是，不平衡的子字符串用粗体表示。
 * <p>
 * 请你返回 s 最少 能分割成多少个平衡子字符串。
 * <p>
 * 注意：一个 平衡 字符串指的是字符串中所有字符出现的次数都相同。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "fabccddg"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 我们可以将 s 分割成 3 个子字符串：("fab, "ccdd", "g") 或者 ("fabc", "cd", "dg") 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abababaccddb"
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 我们可以将 s 分割成 2 个子字符串：("abab", "abaccddb") 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-substring-partition-of-equal-character-frequency/description/?envType=daily-question&envId=2024-08-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3144_MinimumSubstringsInPartition {
    public static void main(String[] args) {
        L3144_MinimumSubstringsInPartition l3144MinimumSubstringsInPartition = new L3144_MinimumSubstringsInPartition();
        System.out.println(l3144MinimumSubstringsInPartition.minimumSubstringsInPartition("fabccddg"));
    }

    public int minimumSubstringsInPartition(String s) {
        int[] memo = new int[s.length() + 1];
        return dfs2(s, 0, memo);
    }

    private int dfs2(String s, int index, int[] memo) {
        if (index >= s.length()) {
            return 0;
        }
        if (memo[index] != 0) {
            return memo[index];
        }
        //尽可能匹配
        int[] size = new int[26];
        int cnt = 0;
        int maxValue = 0;
        //检查[index,index+n] 这个区间内什么字符串 是合法的
        int ans = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            int k = ++size[s.charAt(i) - 'a'];
            maxValue = Math.max(maxValue, k);
            cnt += k == 1 ? 1 : 0;
            if (cnt * maxValue == i - index + 1) {
                //说明匹配
                ans = Math.min(ans, dfs2(s, i + 1, memo) + 1);
            }
        }
        return memo[index] = ans;
    }
}
