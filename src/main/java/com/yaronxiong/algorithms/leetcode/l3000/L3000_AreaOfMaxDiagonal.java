package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3000. 对角线最长的矩形的面积
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二维整数数组 dimensions。
 * <p>
 * 对于所有下标 i（0 <= i < dimensions.length），dimensions[i][0] 表示矩形 i 的长度，而 dimensions[i][1] 表示矩形 i 的宽度。
 * <p>
 * 返回对角线最 长 的矩形的 面积 。如果存在多个对角线长度相同的矩形，返回面积最 大 的矩形的面积。
 * <p>
 * 示例 1：
 * <p>
 * 输入：dimensions = [[9,3],[8,6]]
 * 输出：48
 * 解释：
 * 下标 = 0，长度 = 9，宽度 = 3。对角线长度 = sqrt(9 * 9 + 3 * 3) = sqrt(90) ≈ 9.487。
 * 下标 = 1，长度 = 8，宽度 = 6。对角线长度 = sqrt(8 * 8 + 6 * 6) = sqrt(100) = 10。
 * 因此，下标为 1 的矩形对角线更长，所以返回面积 = 8 * 6 = 48。
 * 示例 2：
 * <p>
 * 输入：dimensions = [[3,4],[4,3]]
 * 输出：12
 * 解释：两个矩形的对角线长度相同，为 5，所以最大面积 = 12。
 * <p>
 * 提示：
 * <p>
 * 1 <= dimensions.length <= 100
 * dimensions[i].length == 2
 * 1 <= dimensions[i][0], dimensions[i][1] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-area-of-longest-diagonal-rectangle/description/?envType=daily-question&envId=2025-08-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3000_AreaOfMaxDiagonal {
    public static void main(String[] args) {
        L3000_AreaOfMaxDiagonal l3000AreaOfMaxDiagonal = new L3000_AreaOfMaxDiagonal();
        System.out.println(l3000AreaOfMaxDiagonal.areaOfMaxDiagonal(new int[][]{{6, 5}, {8, 6}, {2, 10}, {8, 1}, {9, 2}, {3, 5}, {3, 5}}));
    }

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max = 0;
        int ans = 0;
        for (int i = 0; i < dimensions.length; i++) {
            int[] dimension = dimensions[i];
            int length = dimension[0];
            int width = dimension[1];
            int diagonal = (length * length) + (width * width);
            if ((diagonal > max) || (diagonal == max && ans < length * width)) {
                max = diagonal;
                ans = length * width;
            }
        }
        return ans;
    }
}
