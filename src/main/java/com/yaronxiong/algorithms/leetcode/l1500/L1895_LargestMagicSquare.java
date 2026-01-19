package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1895. 最大的幻方
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个 k x k 的 幻方 指的是一个 k x k 填满整数的方格阵，且每一行、每一列以及两条对角线的和 全部相等 。
 * 幻方中的整数 不需要互不相同 。显然，每个 1 x 1 的方格都是一个幻方。
 * <p>
 * 给你一个 m x n 的整数矩阵 grid ，请你返回矩阵中 最大幻方 的 尺寸 （即边长 k）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
 * 输出：3
 * 解释：最大幻方尺寸为 3 。
 * 每一行，每一列以及两条对角线的和都等于 12 。
 * - 每一行的和：5+1+6 = 5+4+3 = 2+7+3 = 12
 * - 每一列的和：5+5+2 = 1+4+7 = 6+3+3 = 12
 * - 对角线的和：5+4+3 = 6+4+2 = 12
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/largest-magic-square/description/?envType=daily-question&envId=2026-01-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1895_LargestMagicSquare {
    public static void main(String[] args) {
        L1895_LargestMagicSquare l1895LargestMagicSquare = new L1895_LargestMagicSquare();
        System.out.println(l1895LargestMagicSquare.largestMagicSquare(new int[][]{{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}}));
    }

    public int largestMagicSquare(int[][] grid) {
        int[][] rowPreSum = new int[grid.length + 1][grid[0].length + 2];
        int[][] colPreSum = new int[grid.length + 1][grid[0].length + 2];
        int[][] diagPreSum = new int[grid.length + 1][grid[0].length + 2];
        int[][] antiDiagPreSum = new int[grid.length + 1][grid[0].length + 2];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowPreSum[i + 1][j + 1] = rowPreSum[i + 1][j] + grid[i][j];
                colPreSum[i + 1][j + 1] = colPreSum[i][j + 1] + grid[i][j];
                diagPreSum[i + 1][j + 1] = diagPreSum[i][j] + grid[i][j];
                antiDiagPreSum[i + 1][j + 1] = antiDiagPreSum[i][j + 2] + grid[i][j];
            }
        }

        int ans = 0;
        //开始统计
        for (int i = 1; i < rowPreSum.length; i++) {
            for (int j = 1; j < rowPreSum[i].length - 1; j++) {
                //按长度遍历 (i,j) 作为右下角  (i1,j1) 作为左上角
                int i1 = i;
                int j1 = j;
                while (i1 > 0 && j1 > 0) {
                    //判断每一行是否一致
                    boolean match = true;
                    int baseValue = rowPreSum[i1][j] - rowPreSum[i1][j1 - 1];
                    for (int z = i1; z <= i && match; z++) {
                        if (rowPreSum[z][j] - rowPreSum[z][j1 - 1] != baseValue) {
                            match = false;
                            break;
                        }
                    }
                    //判断每一列是否一致
                    for (int z = j1; z <= j && match; z++) {
                        if (colPreSum[i][z] - colPreSum[i1 - 1][z] != baseValue) {
                            match = false;
                            break;
                        }
                    }
                    //斜对角
                    if (diagPreSum[i][j] - diagPreSum[i1 - 1][j1 - 1] != baseValue) {
                        match = false;
                    }
                    //反斜对角
                    if (antiDiagPreSum[i][j1] - antiDiagPreSum[i1 - 1][j + 1] != baseValue) {
                        match = false;
                    }
                    if (match) {
                        ans = Math.max(ans, i - i1 + 1);
                    }
                    i1--;
                    j1--;
                }
            }
        }
        return ans;
    }
}
