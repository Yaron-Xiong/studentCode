package com.yaronxiong.algorithms.leetcode.l3000;


/**
 * 3546. 等和矩阵分割 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由正整数组成的 m x n 矩阵 grid。你的任务是判断是否可以通过 一条水平或一条垂直分割线 将矩阵分割成两部分，使得：
 * <p>
 * 分割后形成的每个部分都是 非空 的。
 * 两个部分中所有元素的和 相等 。
 * 如果存在这样的分割，返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[1,4],[2,3]]
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 在第 0 行和第 1 行之间进行水平分割，得到两个非空部分，每部分的元素之和为 5。因此，答案是 true。
 * <p>
 * 示例 2：
 * <p>
 * 输入： grid = [[1,3],[2,4]]
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 无论是水平分割还是垂直分割，都无法使两个非空部分的元素之和相等。因此，答案是 false。
 * <p>
 * 提示：
 * <p>
 * 1 <= m == grid.length <= 105
 * 1 <= n == grid[i].length <= 105
 * 2 <= m * n <= 105
 * 1 <= grid[i][j] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/equal-sum-grid-partition-i/description/?envType=daily-question&envId=2026-03-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3546_CanPartitionGrid {
    public static void main(String[] args) {
        L3546_CanPartitionGrid l3546CanPartitionGrid = new L3546_CanPartitionGrid();
        boolean b = l3546CanPartitionGrid.canPartitionGrid(new int[][]{{1, 1, 1}});
        System.out.println(b);
    }
    public boolean canPartitionGrid(int[][] grid) {
        //先按行分割
        long sum = 0;
        for (int[] row : grid) {
            for (int i : row) {
                sum += i;
            }
        }

        long rowSum = 0;
        for (int[] row : grid) {
            for (int v : row) {
                rowSum += v;
            }
            if (rowSum * 2 == sum && rowSum == sum / 2) {
                return true;
            }
        }

        long colSum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int[] ints : grid) {
                colSum += ints[i];
            }
            if (colSum * 2 == sum && colSum == sum / 2) {
                return true;
            }
        }
        return false;
    }
}
