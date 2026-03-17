package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1582. 二进制矩阵中的特殊位置
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个 m x n 的二进制矩阵 mat，返回矩阵 mat 中特殊位置的数量。
 * <p>
 * 如果位置 (i, j) 满足 mat[i][j] == 1 并且行 i 与列 j 中的所有其他元素都是 0（行和列的下标从 0 开始计数），那么它被称为 特殊 位置。
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,0,0],[0,0,1],[1,0,0]]
 * 输出：1
 * 解释：位置 (1, 2) 是一个特殊位置，因为 mat[1][2] == 1 且第 1 行和第 2 列的其他所有元素都是 0。
 * 示例 2：
 * <p>
 * 输入：mat = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * 解释：位置 (0, 0)，(1, 1) 和 (2, 2) 都是特殊位置。
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * mat[i][j] 是 0 或 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/special-positions-in-a-binary-matrix/description/?envType=daily-question&envId=2026-03-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1582_NumSpecial {
    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
