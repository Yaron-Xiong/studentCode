package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1292. 元素和小于等于阈值的正方形的最大边长
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 * <p>
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * 输出：2
 * 解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
 * 示例 2：
 * <p>
 * 输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 300
 * 0 <= mat[i][j] <= 104
 * 0 <= threshold <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/description/?envType=daily-question&envId=2026-01-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1292_MaxSideLength {
    public static void main(String[] args) {
        L1292_MaxSideLength l1292MaxSideLength = new L1292_MaxSideLength();
        int[][] mat = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        System.out.println(l1292MaxSideLength.maxSideLength(mat, 4));
    }

    public int maxSideLength(int[][] mat, int threshold) {
        //来一个二维前缀和
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 1; j < prefixSum[i].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + mat[i - 1][j - 1];

                int i1 = i;
                int j1 = j;
                while (i1 > 0 && j1 > 0) {
                    int v = prefixSum[i][j] - prefixSum[i][j1 - 1] - prefixSum[i1 - 1][j] + prefixSum[i1 - 1][j1 - 1];
                    if (v > threshold) {
                        break;
                    }
                    ans = Math.max(ans, j - j1 + 1);
                    i1--;
                    j1--;
                }
            }
        }
        return ans;
    }
}
