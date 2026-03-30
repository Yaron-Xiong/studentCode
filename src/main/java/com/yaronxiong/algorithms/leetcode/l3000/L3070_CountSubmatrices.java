package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3070. 元素和小于等于 k 的子矩阵的数目
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个下标从 0 开始的整数矩阵 grid 和一个整数 k。
 * <p>
 * 返回包含 grid 左上角元素、元素和小于或等于 k 的 子矩阵的数目。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[7,6,3],[6,6,1]], k = 18
 * 输出：4
 * 解释：如上图所示，只有 4 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 18 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20
 * 输出：6
 * 解释：如上图所示，只有 6 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 20 。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= n, m <= 1000
 * 0 <= grid[i][j] <= 1000
 * 1 <= k <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/?envType=daily-question&envId=2026-03-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3070_CountSubmatrices {
    public int countSubmatrices(int[][] grid, int k) {
        int ans = 0;
        //二维前缀合
        int[][] preSum = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                preSum[i + 1][j + 1] = grid[i][j] + preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j];
                if (preSum[i + 1][j + 1] <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
