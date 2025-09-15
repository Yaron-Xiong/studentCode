package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3195. 包含所有 1 的最小矩形面积 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二维 二进制 数组 grid。请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。
 * <p>
 * 返回这个矩形可能的 最小 面积。
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[0,1,0],[1,0,1]]
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * 这个最小矩形的高度为 2，宽度为 3，因此面积为 2 * 3 = 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入： grid = [[0,0],[1,0]]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 这个最小矩形的高度和宽度都是 1，因此面积为 1 * 1 = 1。
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[i].length <= 1000
 * grid[i][j] 是 0 或 1。
 * 输入保证 grid 中至少有一个 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-minimum-area-to-cover-all-ones-i/description/?envType=daily-question&envId=2025-08-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3195_MinimumArea {

    public int minimumArea(int[][] grid) {
        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                top = Math.min(top, i);
                left = Math.min(left, j);
                right = Math.max(right, j);
                bottom = Math.max(bottom, i);
            }
        }
        return (right - left + 1) * (bottom - top + 1);
    }
}
