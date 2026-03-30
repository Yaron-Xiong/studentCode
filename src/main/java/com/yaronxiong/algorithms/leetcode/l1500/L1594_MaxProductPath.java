package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1594. 矩阵的最大非负积
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个大小为 m x n 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
 * <p>
 * 在从左上角 (0, 0) 开始到右下角 (m - 1, n - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
 * <p>
 * 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为 负数 ，则返回 -1 。
 * <p>
 * 注意，取余是在得到最大积之后执行的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
 * 输出：-1
 * 解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1 。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
 * 输出：8
 * 解释：最大非负积对应的路径如图所示 (1 * 1 * -2 * -4 * 1 = 8)
 * 示例 3：
 * <p>
 * 输入：grid = [[1,3],[0,-4]]
 * 输出：0
 * 解释：最大非负积对应的路径如图所示 (1 * 0 * -4 = 0)
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 15
 * -4 <= grid[i][j] <= 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-non-negative-product-in-a-matrix/description/?envType=daily-question&envId=2026-03-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1594_MaxProductPath {
    public static void main(String[] args) {
        L1594_MaxProductPath l1594MaxProductPath = new L1594_MaxProductPath();
        System.out.println(l1594MaxProductPath.maxProductPathV2(new int[][]{{2, 1, 3, 0, -3, 3, -4, 4, 0, -4}, {-4, -3, 2, 2, 3, -3, 1, -1, 1, -2}, {-2, 0, -4, 2, 4, -3, -4, -1, 3, 4}, {-1, 0, 1, 0, -3, 3, -2, -3, 1, 0}, {0, -1, -2, 0, -3, -4, 0, 3, -2, -2}, {-4, -2, 0, -1, 0, -3, 0, 4, 0, -3}, {-3, -4, 2, 1, 0, -4, 2, -4, -1, -3}, {3, -2, 0, -4, 1, 0, 1, -3, -1, -1}, {3, -4, 0, 2, 0, -2, 2, -4, -2, 4}, {0, 4, 0, -3, -4, 3, 3, -1, -2, -2}}));
        System.out.println(l1594MaxProductPath.maxProductPathV2(new int[][]{{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}}));
        System.out.println(l1594MaxProductPath.maxProductPathV2(new int[][]{{1, 3}, {0, -4}}));
        System.out.println(l1594MaxProductPath.maxProductPathV2(new int[][]{{1, -2, 1}, {1, -2, 1}, {3, -4, 1}}));
    }

    public static final int MOD = 1000000007;

    public int maxProductPathV2(int[][] grid) {
        long[][][] dp = new long[grid.length][grid[0].length][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = new long[]{Long.MIN_VALUE, Long.MIN_VALUE};
            }
        }
        dp[0][0] = new long[]{grid[0][0], grid[0][0]};
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = new long[]{dp[i - 1][0][0] * grid[i][0], dp[i - 1][0][1] * grid[i][0]};
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = new long[]{dp[0][i - 1][0] * grid[0][i], dp[0][i - 1][1] * grid[0][i]};
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                long v1 = dp[i - 1][j][0] * grid[i][j];
                long v2 = dp[i - 1][j][1] * grid[i][j];
                long v3 = dp[i][j - 1][0] * grid[i][j];
                long v4 = dp[i][j - 1][1] * grid[i][j];
                long minValue = Math.min(v1, v2);
                minValue = Math.min(minValue, Math.min(v3, v4));
                long maxValue = Math.max(v1, v2);
                maxValue = Math.max(maxValue, Math.max(v3, v4));
                dp[i][j] = new long[]{minValue, maxValue};
            }
        }
        int v1 = (int) (dp[grid.length - 1][grid[0].length - 1][0] % MOD);
        int v2 = (int) (dp[grid.length - 1][grid[0].length - 1][1] % MOD);
        return Math.max(v1, v2) < 0 ? -1 : Math.max(v1, v2);
    }

    public int maxProductPath(int[][] grid) {
        int v = (int) (dfs2(0, 0, grid, 1) % MOD);
        return v < 0 ? -1 : v;
    }

    private long dfs2(int x, int y, int[][] grid, long cur) {
        cur = cur * grid[x][y];
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return cur;
        }
        long ans = Long.MIN_VALUE;
        if (x + 1 < grid.length) {
            ans = Math.max(ans, dfs2(x + 1, y, grid, cur));
        }
        if (y + 1 < grid[0].length) {
            ans = Math.max(ans, dfs2(x, y + 1, grid, cur));
        }
        return ans;
    }
}
