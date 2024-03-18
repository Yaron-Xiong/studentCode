package com.yaronxiong.algorithms.swordFingerOffer.dfs;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length<= 100
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S29_SpiralOrder {

    public static void main(String[] args) {
        S29_SpiralOrder s29SpiralOrder = new S29_SpiralOrder();
        //int[] ints = s29SpiralOrder.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        int[] ints = s29SpiralOrder.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        //int[] ints = s29SpiralOrder.spiralOrder(new int[][]{});
        System.out.println(Arrays.toString(ints));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        this.matrix = matrix;
        this.res = new int[matrix.length * matrix[0].length];
        dfs(0, matrix[0].length - 1, 0, matrix.length - 1);
        return res;
    }

    int[][] matrix;
    int[] res;
    int resIndex = 0;

    public void dfs(int leftBound, int rightBound, int topBound, int buttonBound) {
        if (rightBound < leftBound || topBound > buttonBound) {
            return;
        }
        //向右 (topBound,leftBound) -> (topBound,rightBound)
        for (int i = leftBound; i <= rightBound; i++) {
            res[resIndex++] = matrix[topBound][i];
        }
        //向下 (topBound+1,rightBound) -> (buttonBound-1,rightBound)
        for (int i = topBound + 1; i <= buttonBound - 1; i++) {
            res[resIndex++] = matrix[i][rightBound];
        }
        //向左 (buttonBound,rightBound) -> (buttonBound,leftBound)
        for (int i = rightBound; topBound != buttonBound && i >= leftBound; i--) {
            res[resIndex++] = matrix[buttonBound][i];
        }
        //向上 (buttonBound-1,leftBound) -> (topBound+1,leftBound)
        for (int i = buttonBound - 1; leftBound != rightBound && i >= topBound + 1; i--) {
            res[resIndex++] = matrix[i][leftBound];
        }
        dfs(leftBound + 1, rightBound - 1, topBound + 1, buttonBound - 1);
    }

}
