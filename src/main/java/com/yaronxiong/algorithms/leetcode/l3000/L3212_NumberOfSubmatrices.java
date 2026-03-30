package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3212. 统计 X 和 Y 频数相等的子矩阵数量
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二维字符矩阵 grid，其中 grid[i][j] 可能是 'X'、'Y' 或 '.'，返回满足以下条件的子矩阵数量：
 * <p>
 * 包含 grid[0][0]
 * 'X' 和 'Y' 的频数相等。
 * 至少包含一个 'X'。
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [["X","Y","."],["Y",".","."]]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 示例 2：
 * <p>
 * 输入： grid = [["X","X"],["X","Y"]]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 不存在满足 'X' 和 'Y' 频数相等的子矩阵。
 * <p>
 * 示例 3：
 * <p>
 * 输入： grid = [[".","."],[".","."]]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 不存在满足至少包含一个 'X' 的子矩阵。
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[i].length <= 1000
 * grid[i][j] 可能是 'X'、'Y' 或 '.'.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/?envType=daily-question&envId=2026-03-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3212_NumberOfSubmatrices {
    public static void main(String[] args) {
        L3212_NumberOfSubmatrices l3212NumberOfSubmatrices = new L3212_NumberOfSubmatrices();
        System.out.println(l3212NumberOfSubmatrices.numberOfSubmatrices(new char[][]{{'X', 'Y', '.'}, {'Y', '.', '.'}}));
        System.out.println(l3212NumberOfSubmatrices.numberOfSubmatrices(new char[][]{{'X', 'X'}, {'X', 'Y'}}));
        System.out.println(l3212NumberOfSubmatrices.numberOfSubmatrices(new char[][]{{'.', '.'}, {'.', '.'}}));
    }

    public int numberOfSubmatrices(char[][] grid) {
        int[][][] preSnm = new int[grid.length + 1][grid[0].length + 1][2];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                preSnm[i + 1][j + 1][0] = preSnm[i + 1][j][0] + preSnm[i][j + 1][0] - preSnm[i][j][0];
                preSnm[i + 1][j + 1][1] = preSnm[i + 1][j][1] + preSnm[i][j + 1][1] - preSnm[i][j][1];
                if (grid[i][j] == 'X') {
                    preSnm[i + 1][j + 1][0]++;
                } else if (grid[i][j] == 'Y') {
                    preSnm[i + 1][j + 1][1]++;
                }
                if (preSnm[i + 1][j + 1][0] > 0 && preSnm[i + 1][j + 1][0] == preSnm[i + 1][j + 1][1]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
