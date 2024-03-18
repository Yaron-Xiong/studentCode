package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 2352. 相等行列对
 * 提示
 * 中等
 * 41
 * 相关企业
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * <p>
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * 示例 2：
 * <p>
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/equal-row-and-column-pairs/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2352_EqualPairs {
    public static void main(String[] args) {
        L2352_EqualPairs l2352EqualPairs = new L2352_EqualPairs();
        System.out.println(l2352EqualPairs.equalPairs2(new int[][]{{11, 1}, {1, 11}}));
    }

    /**
     * 通过对行列进行预先计算
     */
    public int equalPairs2(int[][] grid) {
        Map<String, Integer> columMap = new HashMap<>();
        for (int i = 0; i < grid[0].length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i]);
                sb.append(".");
            }
            columMap.compute(sb.toString(), (k, v) -> v == null ? 1 : v + 1);
        }


        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]);
                sb.append(".");
            }
            res += columMap.getOrDefault(sb.toString(), 0);
        }
        return res;
    }

    public int equalPairs(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean isEqual = check(grid, i, j);
                if (isEqual) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean check(int[][] grid, int i, int j) {
        int iIndex = 0;
        int jIndex = 0;
        while (iIndex < grid[i].length && jIndex < grid.length) {
            if (grid[i][iIndex] != grid[jIndex][j]) {
                return false;
            }
            iIndex++;
            jIndex++;
        }
        return true;
    }
}
