package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2787. 将一个数字表示成幂的和的方案数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个 正 整数 n 和 x 。
 * <p>
 * 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。
 * 换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满足 n = n1x + n2x + ... + nkx 。
 * <p>
 * 由于答案可能非常大，请你将它对 109 + 7 取余后返回。
 * <p>
 * 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 23 + 33 + 53 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, x = 2
 * 输出：1
 * 解释：我们可以将 n 表示为：n = 32 + 12 = 10 。
 * 这是唯一将 10 表达成不同整数 2 次方之和的方案。
 * 示例 2：
 * <p>
 * 输入：n = 4, x = 1
 * 输出：2
 * 解释：我们可以将 n 按以下方案表示：
 * - n = 41 = 4 。
 * - n = 31 + 11 = 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 300
 * 1 <= x <= 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/ways-to-express-an-integer-as-sum-of-powers/description/?envType=daily-question&envId=2025-08-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2787_NumberOfWays {
    public static void main(String[] args) {
        L2787_NumberOfWays l2787NumberOfWays = new L2787_NumberOfWays();
        System.out.println(l2787NumberOfWays.numberOfWays(10, 2));
        System.out.println(l2787NumberOfWays.numberOfWays(4, 1));
    }

    public int numberOfWays(int n, int x) {
        int[][] memo = new int[n + 1][n + 1];
        return dfs(1, n, x, memo);
    }

    private int dfs(int i, int n, int x, int[][] memo) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        int value = n - (int) Math.pow(i, x);
        if (value < 0) {
            return 0;
        }
        if (memo[i][n] != 0) {
            return memo[i][n];
        }
        //不选择i
        int a = dfs(i + 1, n, x, memo) % 1000000007;
        //选择i
        int b = dfs(i + 1, value, x, memo) % 1000000007;
        return memo[i][n] = (a + b) % 1000000007;
    }
}
