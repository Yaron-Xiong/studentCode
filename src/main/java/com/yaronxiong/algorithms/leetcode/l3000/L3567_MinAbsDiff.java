package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 3567. 子矩阵的最小绝对差
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的整数矩阵 grid 和一个整数 k。
 * <p>
 * 对于矩阵 grid 中的每个连续的 k x k 子矩阵，计算其中任意两个 不同值 之间的 最小绝对差 。
 * <p>
 * 返回一个大小为 (m - k + 1) x (n - k + 1) 的二维数组 ans，其中 ans[i][j] 表示以 grid 中坐标 (i, j) 为左上角的子矩阵的最小绝对差。
 * <p>
 * 注意：如果子矩阵中的所有元素都相同，则答案为 0。
 * <p>
 * 子矩阵 (x1, y1, x2, y2) 是一个由选择矩阵中所有满足 x1 <= x <= x2 且 y1 <= y <= y2 的单元格 matrix[x][y] 组成的矩阵。
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[1,8],[3,-2]], k = 2
 * <p>
 * 输出： [[2]]
 * <p>
 * 解释：
 * <p>
 * 只有一个可能的 k x k 子矩阵：[[1, 8], [3, -2]]。
 * 子矩阵中的不同值为 [1, 8, 3, -2]。
 * 子矩阵中的最小绝对差为 |1 - 3| = 2。因此，答案为 [[2]]。
 * 示例 2：
 * <p>
 * 输入： grid = [[3,-1]], k = 1
 * <p>
 * 输出： [[0,0]]
 * <p>
 * 解释：
 * <p>
 * 每个 k x k 子矩阵中只有一个不同的元素。
 * 因此，答案为 [[0, 0]]。
 * 示例 3：
 * <p>
 * 输入： grid = [[1,-2,3],[2,3,5]], k = 2
 * <p>
 * 输出： [[1,2]]
 * <p>
 * 解释：
 * <p>
 * 有两个可能的 k × k 子矩阵：
 * 以 (0, 0) 为起点的子矩阵：[[1, -2], [2, 3]]。
 * 子矩阵中的不同值为 [1, -2, 2, 3]。
 * 子矩阵中的最小绝对差为 |1 - 2| = 1。
 * 以 (0, 1) 为起点的子矩阵：[[-2, 3], [3, 5]]。
 * 子矩阵中的不同值为 [-2, 3, 5]。
 * 子矩阵中的最小绝对差为 |3 - 5| = 2。
 * 因此，答案为 [[1, 2]]。
 * <p>
 * 提示：
 * <p>
 * 1 <= m == grid.length <= 30
 * 1 <= n == grid[i].length <= 30
 * -105 <= grid[i][j] <= 105
 * 1 <= k <= min(m, n)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-absolute-difference-in-sliding-submatrix/description/?envType=daily-question&envId=2026-03-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3567_MinAbsDiff {
    public static void main(String[] args) {
        L3567_MinAbsDiff l3567MinAbsDiff = new L3567_MinAbsDiff();
        System.out.println(Arrays.deepToString(l3567MinAbsDiff.minAbsDiff(new int[][]{{1, -2, 3}, {2, 3, 5}}, 2)));
        System.out.println(Arrays.deepToString(l3567MinAbsDiff.minAbsDiff(new int[][]{{3, -1}}, 1)));
        System.out.println(Arrays.deepToString(l3567MinAbsDiff.minAbsDiff(new int[][]{{1, 8}, {3, -2}}, 2)));
    }

    public int[][] minAbsDiff(int[][] grid, int k) {
        int[][] ans = new int[grid.length - k + 1][grid[0].length - k + 1];
        if (k == 1) {
            return ans;
        }
        for (int i = 0; i < grid.length && i + k <= grid.length; i++) {
            for (int j = 0; j < grid[i].length && j + k <= grid[i].length; j++) {
                //找到最小差值
                List<Integer> list = new ArrayList<>();
                for (int z = i; z < i + k; z++) {
                    for (int x = j; x < j + k; x++) {
                        list.add(grid[z][x]);
                    }
                }
                list.sort(Integer::compareTo);
                int min = Integer.MAX_VALUE;
                for (int z = 1; z < list.size(); z++) {
                    if (Objects.equals(list.get(z), list.get(z - 1))) {
                        continue;
                    }
                    min = Math.min(min, list.get(z) - list.get(z - 1));
                }
                if (min != Integer.MAX_VALUE) {
                    ans[i][j] = min;
                }
            }
        }
        return ans;
    }
}
