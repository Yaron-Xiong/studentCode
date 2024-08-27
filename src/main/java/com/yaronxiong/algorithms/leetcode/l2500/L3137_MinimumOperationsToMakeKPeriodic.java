package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 3137. K 周期字符串需要的最少操作次数
 * 已解答
 * 算术评级: 3
 * 第 396 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1491
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的字符串 word 和一个整数 k ，其中 k 是 n 的因数。
 * <p>
 * 在一次操作中，你可以选择任意两个下标 i 和 j，其中 0 <= i, j < n ，且这两个下标都可以被 k 整除，
 * 然后用从 j 开始的长度为 k 的子串替换从 i 开始的长度为 k 的子串。也就是说，将子串 word[i..i + k - 1] 替换为子串 word[j..j + k - 1] 。
 * <p>
 * 返回使 word 成为 K 周期字符串 所需的 最少 操作次数。
 * <p>
 * 如果存在某个长度为 k 的字符串 s，使得 word 可以表示为任意次数连接 s ，则称字符串 word 是 K 周期字符串 。
 * 例如，如果 word == "ababab"，那么 word 就是 s = "ab" 时的 2 周期字符串 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "leetcodeleet", k = 4
 * <p>
 * 输出：1
 * <p>
 * 解释：可以选择 i = 4 和 j = 0 获得一个 4 周期字符串。这次操作后，word 变为 "leetleetleet" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：word = "leetcoleet", k = 2
 * <p>
 * 输出：3
 * <p>
 * 解释：可以执行以下操作获得一个 2 周期字符串。
 * <p>
 * i	j	word
 * 0	2	etetcoleet
 * 4	0	etetetleet
 * 6	0	etetetetet
 * <p>
 * 提示：
 * <p>
 * 1 <= n == word.length <= 105
 * 1 <= k <= word.length
 * k 能整除 word.length 。
 * word 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-word-k-periodic/description/?envType=daily-question&envId=2024-08-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3137_MinimumOperationsToMakeKPeriodic {
    public static void main(String[] args) {
        L3137_MinimumOperationsToMakeKPeriodic l3137MinimumOperationsToMakeKPeriodic = new L3137_MinimumOperationsToMakeKPeriodic();
        System.out.println(l3137MinimumOperationsToMakeKPeriodic.minimumOperationsToMakeKPeriodic("leetcoleet", 2));
    }

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        //按照k个下标分组
        Map<String, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < word.length(); i += k) {
            String sb = word.substring(i, i + k);
            Integer value = map.merge(sb, 1, Integer::sum);
            ans = Math.min(ans, word.length() / k - value);
        }
        return ans;
    }
}
