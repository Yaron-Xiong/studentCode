package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2376. 统计特殊整数
 * 算术评级: 9
 * 第 306 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2120
 * 相关标签
 * 相关企业
 * 提示
 * 如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
 * <p>
 * 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 20
 * 输出：19
 * 解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * 解释：1 到 5 所有整数都是特殊整数。
 * 示例 3：
 * <p>
 * 输入：n = 135
 * 输出：110
 * 解释：从 1 到 135 总共有 110 个整数是特殊整数。
 * 不特殊的部分数字为：22 ，114 和 131 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-special-integers/description/?envType=daily-question&envId=2024-09-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2376_CountSpecialNumbers {
    public int countSpecialNumbers(int n) {
        char[] s = Integer.toString(n).toCharArray();
        int[][] memo = new int[s.length][1 << 10];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(0, 0, true, false, s, memo);
    }

    private int dfs(int i, int mask, boolean isLimit, boolean isNum, char[] s, int[][] memo) {
        if (i == s.length) {
            return isNum ? 1 : 0; // isNum 为 true 表示得到了一个合法数字
        }
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask]; // 之前计算过
        }
        int res = 0;
        if (!isNum) { // 可以跳过当前数位
            res = dfs(i + 1, mask, false, false, s, memo);
        }
        // 如果前面填的数字都和 n 的一样，那么这一位至多填数字 s[i]（否则就超过 n 啦）
        int up = isLimit ? s[i] - '0' : 9;
        // 枚举要填入的数字 d
        // 如果前面没有填数字，则必须从 1 开始（因为不能有前导零）
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if ((mask >> d & 1) == 0) { // d 不在 mask 中，说明之前没有填过 d
                res += dfs(i + 1, mask | (1 << d), isLimit && d == up, true, s, memo);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = res; // 记忆化
        }
        return res;
    }
}
