package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2536. 子矩阵元素加 1
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数 n ，表示最初有一个 n x n 、下标从 0 开始的整数矩阵 mat ，矩阵中填满了 0 。
 * <p>
 * 另给你一个二维整数数组 query 。针对每个查询 query[i] = [row1i, col1i, row2i, col2i] ，请你执行下述操作：
 * <p>
 * 找出 左上角 为 (row1i, col1i) 且 右下角 为 (row2i, col2i) 的子矩阵，将子矩阵中的 每个元素 加 1 。
 * 也就是给所有满足 row1i <= x <= row2i 和 col1i <= y <= col2i 的 mat[x][y] 加 1 。
 * 返回执行完所有操作后得到的矩阵 mat 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, queries = [[1,1,2,2],[0,0,1,1]]
 * 输出：[[1,1,0],[1,2,1],[0,1,1]]
 * 解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵、执行完第二个操作后的矩阵。
 * - 第一个操作：将左上角为 (1, 1) 且右下角为 (2, 2) 的子矩阵中的每个元素加 1 。
 * - 第二个操作：将左上角为 (0, 0) 且右下角为 (1, 1) 的子矩阵中的每个元素加 1 。
 * 示例 2：
 * <p>
 * 输入：n = 2, queries = [[0,0,1,1]]
 * 输出：[[1,1],[1,1]]
 * 解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵。
 * - 第一个操作：将矩阵中的每个元素加 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * 1 <= queries.length <= 104
 * 0 <= row1i <= row2i < n
 * 0 <= col1i <= col2i < n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/description/?envType=daily-question&envId=2024-09-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2536_RangeAddQueries {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        //二维差分
        int[][] diff = new int[n + 2][n + 2];
        for (int[] query : queries) {
            int x1 = query[0] + 1;
            int y1 = query[1] + 1;
            int x2 = query[2] + 1;
            int y2 = query[3] + 1;
            diff[x1][y1]++;
            diff[x2 + 1][y2 + 1]++;
            diff[x1][y2 + 1]--;
            diff[x2 + 1][y1]--;
        }
        //还原数组
        int[][] result = new int[n][n];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                diff[i + 1][j + 1] += diff[i][j + 1] + diff[i + 1][j] - diff[i][j];
                result[i][j] = diff[i + 1][j + 1];
            }
        }
        return result;
    }
}
