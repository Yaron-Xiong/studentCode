package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 1572. 矩阵对角线元素的和
 * 提示
 * 简单
 * 83
 * 相关企业
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * <p>
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 * 示例  1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * 示例  2：
 * <p>
 * 输入：mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/matrix-diagonal-sum/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1572_DiagonalSum {
    public static void main(String[] args) {
        L1572_DiagonalSum l1572DiagonalSum = new L1572_DiagonalSum();
        System.out.println(l1572DiagonalSum.diagonalSum(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}));
    }

    public int diagonalSum(int[][] mat) {
        dfs(mat, 0, 0, mat.length - 1, mat[0].length - 1);
        return res;
    }

    private void dfs(int[][] mat, int x, int y, int x1, int y1) {
        if (x > x1) {
            return;
        }
        if (x == x1 && y == y1) {
            res += mat[x][y];
            return;
        }
        res += mat[x][y];
        res += mat[x][y1];
        res += mat[x1][y];
        res += mat[x1][y1];
        dfs(mat, x + 1, y + 1, x1 - 1, y1 - 1);
    }

    int res = 0;
}
