package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 498. 对角线遍历
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/diagonal-traverse/description/?envType=daily-question&envId=2025-08-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L498_FindDiagonalOrder {
    public static void main(String[] args) {
        L498_FindDiagonalOrder l498FindDiagonalOrder = new L498_FindDiagonalOrder();
        /*int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] diagonalOrder = l498FindDiagonalOrder.findDiagonalOrder(mat);
        System.out.println(Arrays.toString(diagonalOrder));*/
        int[][] mat2 = new int[][]{{3}, {2}};
        int[] diagonalOrder2 = l498FindDiagonalOrder.findDiagonalOrder(mat2);
        System.out.println(Arrays.toString(diagonalOrder2));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int[] ans = new int[mat.length * mat[0].length];
        int index = 0;
        int level = 0;
        while (index < ans.length) {
            if (level % 2 == 0) {
                int x = level >= mat.length ? mat.length - 1 : level;
                int y = level >= mat.length ? level - x : 0;
                //向上走
                while (x >= 0 && y < mat[0].length) {
                    ans[index++] = mat[x][y];
                    x--;
                    y++;
                }
            } else {
                //向下走
                int y = level >= mat[0].length ? mat[0].length - 1 : level;
                int x = level >= mat[0].length ? level - y : 0;
                while (x < mat.length && y >= 0) {
                    ans[index++] = mat[x][y];
                    x++;
                    y--;
                }
            }
            level++;
        }
        return ans;
    }

}
