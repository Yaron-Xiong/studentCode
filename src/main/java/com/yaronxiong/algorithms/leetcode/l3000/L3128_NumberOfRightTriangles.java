package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3128. 直角三角形
 * 算术评级: 4
 * 第 129 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1541
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维 boolean 矩阵 grid 。
 * <p>
 * 请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。
 * <p>
 * 注意：
 * <p>
 * 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素互相之间不需要相邻。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 0	1	0
 * 0	1	1
 * 0	1	0
 * 0	1	0
 * 0	1	1
 * 0	1	0
 * 输入：grid = [[0,1,0],[0,1,1],[0,1,0]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 有 2 个直角三角形。
 * <p>
 * 示例 2：
 * <p>
 * 1	0	0	0
 * 0	1	0	1
 * 1	0	0	0
 * 输入：grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 没有直角三角形。
 * <p>
 * 示例 3：
 * <p>
 * 1	0	1
 * 1	0	0
 * 1	0	0
 * 1	0	1
 * 1	0	0
 * 1	0	0
 * 输入：grid = [[1,0,1],[1,0,0],[1,0,0]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 有两个直角三角形。
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 1000
 * 1 <= grid[i].length <= 1000
 * 0 <= grid[i][j] <= 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/right-triangles/description/?envType=daily-question&envId=2024-08-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3128_NumberOfRightTriangles {
    public static void main(String[] args) {
        L3128_NumberOfRightTriangles l3128NumberOfRightTriangles = new L3128_NumberOfRightTriangles();
        System.out.println(l3128NumberOfRightTriangles.numberOfRightTriangles(new int[][]{{0}, {0}}));
    }

    public long numberOfRightTriangles(int[][] grid) {
        long ans = 0;
        //前缀和
        int[] rowsPreSum = new int[grid.length];
        int[] colsPreSum = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rowsPreSum[i] += grid[i][j];
                colsPreSum[j] += grid[i][j];
            }
        }
        //开始统计
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //判断能够构成多少个三角形
                    int rows = rowsPreSum[i];
                    int cols = colsPreSum[j];
                    ans += (long) (rows - 1) * (cols - 1);
                }
            }
        }
        return ans;
    }
}
