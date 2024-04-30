package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1329. 将矩阵按对角线排序
 * 算术评级: 5
 * 第 18 场双周赛
 * Q3
 * 1548
 * 相关标签
 * 相关企业
 * 提示
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。
 * 例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
 * <p>
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 * 示例 2：
 * <p>
 * 输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
 * 输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * 1 <= mat[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sort-the-matrix-diagonally/description/?envType=daily-question&envId=2024-04-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1329_DiagonalSort {
    public static void main(String[] args) {
        L1329_DiagonalSort l1329DiagonalSort = new L1329_DiagonalSort();
        System.out.println(Arrays.deepToString(l1329DiagonalSort.diagonalSort(new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}})));
    }
    public int[][] diagonalSort(int[][] mat) {
        //一行一行进行排序
        for (int startY = 0; startY < mat.length; startY++) {
            sort(mat, startY, 0);
        }
        for (int i = 1; i < mat[0].length; i++) {
            sort(mat, 0, i);
        }
        return mat;
    }

    private void sort(int[][] mat, int startY, int startX) {
        int curY = startY + 1;
        int curX = startX + 1;
        while (curY < mat.length && curX < mat[curY].length) {
            int insertX = curX;
            int insertY = curY;
            while (insertX > 0 && insertY > 0 && mat[curY][curX] < mat[insertY - 1][insertX - 1]) {
                insertY--;
                insertX--;
            }
            //找到待插入区域(insertY,insertX)
            int insertValue = mat[curY][curX];
            //将待插入区域后的元素全部挪动
            int tempX = curX - 1;
            int tempY = curY - 1;
            while (tempX >= insertX && tempY >= insertY) {
                int temp = mat[tempY][tempX];
                mat[tempY][tempX] = mat[tempY + 1][tempX + 1];
                mat[tempY + 1][tempX + 1] = temp;
                tempY--;
                tempX--;
            }
            mat[insertY][insertX] = insertValue;
            curY++;
            curX++;
        }
    }
}
