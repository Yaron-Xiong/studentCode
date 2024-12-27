package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.List;

/**
 * 3148. 矩阵中的最大得分
 * 算术评级: 6
 * 第 397 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1820
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由 正整数 组成、大小为 m x n 的矩阵 grid。
 * 你可以从矩阵中的任一单元格移动到另一个位于正下方或正右侧的任意单元格（不必相邻）。
 * 从值为 c1 的单元格移动到值为 c2 的单元格的得分为 c2 - c1 。
 * <p>
 * 你可以从 任一 单元格开始，并且必须至少移动一次。
 * <p>
 * 返回你能得到的 最大 总得分。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]
 * <p>
 * 输出：9
 * <p>
 * 解释：从单元格 (0, 1) 开始，并执行以下移动：
 * - 从单元格 (0, 1) 移动到 (2, 1)，得分为 7 - 5 = 2 。
 * - 从单元格 (2, 1) 移动到 (2, 2)，得分为 14 - 7 = 7 。
 * 总得分为 2 + 7 = 9 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[4,3,2],[3,2,1]]
 * <p>
 * 输出：-1
 * <p>
 * 解释：从单元格 (0, 0) 开始，执行一次移动：从 (0, 0) 到 (0, 1) 。得分为 3 - 4 = -1 。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 1 <= grid[i][j] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-difference-score-in-a-grid/description/?envType=daily-question&envId=2024-08-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3148_MaxScore {
    public int maxScore(List<List<Integer>> grid) {
        int ans = Integer.MIN_VALUE;
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] f = new int[m][n];
        f[0][0] = grid.get(0).get(0);
        for (int i = 1; i < n; i++) {
            Integer value = grid.get(0).get(i);
            ans = Math.max(ans, value - f[0][i - 1]);
            f[0][i] = Math.min(f[0][i - 1], value);
        }
        for (int i = 1; i < m; i++) {
            Integer value = grid.get(i).get(0);
            ans = Math.max(ans, value - f[i - 1][0]);
            f[i][0] = Math.min(f[i - 1][0], value);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int top = f[i - 1][j];
                int left = f[i][j - 1];
                Integer curValue = grid.get(i).get(j);
                f[i][j] = Math.min(Math.min(top, left), curValue);
                ans = Math.max(ans, Math.max(curValue - top, curValue - left));
            }
        }
        return ans;
    }
}
