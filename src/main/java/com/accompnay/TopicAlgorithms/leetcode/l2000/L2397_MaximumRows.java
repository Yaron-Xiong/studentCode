package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2397. 被列覆盖的最多行数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、大小为 m x n 的二进制矩阵 matrix ；另给你一个整数 numSelect，表示你必须从 matrix 中选择的 不同 列的数量。
 * <p>
 * 如果一行中所有的 1 都被你选中的列所覆盖，则认为这一行被 覆盖 了。
 * <p>
 * 形式上，假设 s = {c1, c2, ...., cnumSelect} 是你选择的列的集合。对于矩阵中的某一行 row ，如果满足下述条件，则认为这一行被集合 s 覆盖：
 * <p>
 * 对于满足 matrix[row][col] == 1 的每个单元格 matrix[row][col]（0 <= col <= n - 1），col 均存在于 s 中，或者
 * row 中 不存在 值为 1 的单元格。
 * 你需要从矩阵中选出 numSelect 个列，使集合覆盖的行数最大化。
 * <p>
 * 返回一个整数，表示可以由 numSelect 列构成的集合 覆盖 的 最大行数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[0,0,0],[1,0,1],[0,1,1],[0,0,1]], numSelect = 2
 * 输出：3
 * 解释：
 * 图示中显示了一种覆盖 3 行的可行办法。
 * 选择 s = {0, 2} 。
 * - 第 0 行被覆盖，因为其中没有出现 1 。
 * - 第 1 行被覆盖，因为值为 1 的两列（即 0 和 2）均存在于 s 中。
 * - 第 2 行未被覆盖，因为 matrix[2][1] == 1 但是 1 未存在于 s 中。
 * - 第 3 行被覆盖，因为 matrix[2][2] == 1 且 2 存在于 s 中。
 * 因此，可以覆盖 3 行。
 * 另外 s = {1, 2} 也可以覆盖 3 行，但可以证明无法覆盖更多行。
 * 示例 2：
 * <p>
 * 输入：matrix = [[1],[0]], numSelect = 1
 * 输出：2
 * 解释：
 * 选择唯一的一列，两行都被覆盖了，因为整个矩阵都被覆盖了。
 * 所以我们返回 2 。
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 12
 * matrix[i][j] 要么是 0 要么是 1
 * 1 <= numSelect <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-rows-covered-by-columns/description/?envType=daily-question&envId=2024-01-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2397_MaximumRows {
    public int maximumRows(int[][] matrix, int numSelect) {
        //构建位图
        int[] rowsCnt = new int[matrix.length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            int cnt = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                ans++;
            }
            rowsCnt[i] = cnt;
        }
        return ans + dfs(0, matrix, rowsCnt, numSelect);
    }

    private int dfs(int curCol, int[][] matrix, int[] rowsCnt, int numSelect) {
        if (curCol >= matrix[0].length || numSelect == 0) {
            return 0;
        }
        //选择当前列
        int ans1 = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][curCol] == 1) {
                if (--rowsCnt[i] == 0) {
                    ans1++;
                }
            }
        }
        ans1 += dfs(curCol + 1, matrix, rowsCnt, numSelect - 1);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][curCol] == 1) {
                ++rowsCnt[i];
            }
        }
        //不选择当前列
        int ans2 = dfs(curCol + 1, matrix, rowsCnt, numSelect);
        return Math.max(ans1, ans2);
    }
}
