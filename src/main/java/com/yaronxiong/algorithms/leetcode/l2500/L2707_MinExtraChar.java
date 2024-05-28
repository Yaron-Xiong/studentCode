package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2707. 字符串中的额外字符
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。
 * 你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在 dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。
 * <p>
 * 请你采取最优策略分割 s ，使剩下的字符 最少 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
 * 输出：1
 * 解释：将 s 分成两个子字符串：下标从 0 到 3 的 "leet" 和下标从 5 到 8 的 "code" 。只有 1 个字符没有使用（下标为 4），所以我们返回 1 。
 * 示例 2：
 * <p>
 * 输入：s = "sayhelloworld", dictionary = ["hello","world"]
 * 输出：3
 * 解释：将 s 分成两个子字符串：下标从 3 到 7 的 "hello" 和下标从 8 到 12 的 "world" 。下标为 0 ，1 和 2 的字符没有使用，所以我们返回 3 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * 1 <= dictionary.length <= 50
 * 1 <= dictionary[i].length <= 50
 * dictionary[i] 和 s 只包含小写英文字母。
 * dictionary 中的单词互不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/extra-characters-in-a-string/description/?envType=daily-question&envId=2024-01-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2707_MinExtraChar {
    public int minExtraChar2(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = dp[i] + 1;
            for (int j = 0; j <= i; j++) {
                if (set.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j]);
                }
            }
        }
        return dp[s.length()];
    }

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s.length() - 1, dp, s, set);
    }

    private int dfs(int i, int[] dp, String s, Set<String> set) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int res = dfs(i - 1, dp, s, set) + 1;
        for (int j = 0; j <= i; j++) {
            if (set.contains(s.substring(j, i + 1))) {
                res = Math.min(res, dfs(j - 1, dp, s, set));
            }
        }
        return dp[i] = res;
    }

}
