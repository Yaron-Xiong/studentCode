package com.accompnay.leetcode;

import java.util.Arrays;

public class Demo4 {
    public static void main(String[] args) {
        //int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //int[][] matrix = new int[][]{{6,9,7}};
        int[][] matrix = new int[][]{{6}, {9}, {7}};

        Demo4 demo4 = new Demo4();
        int[] test = demo4.spiralOrder(matrix);
        System.out.println(Arrays.toString(test));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int[] result = new int[(right + 1) * (bottom + 1)];
        int index = 0;
        while (left <= right && top <= bottom) {
            //从左往右
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;
            //从上往下
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;
            //从右往左
            for (int i = right; i >= left && top <= bottom; i--) {
                result[index++] = matrix[bottom][i];
            }
            bottom--;
            //从下往上
            for (int i = bottom; i >= top && left <= right; i--) {
                result[index++] = matrix[i][left];
            }
            left++;
        }
        return result;
    }
}
