package com.accompnay.TopicAlgorithms.swordFingerOffer.search;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * <p>
 * 给定target=20，返回false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S04_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //先遍历行
        for (int[] row : matrix) {
            if (row.length == 0 || row[row.length - 1] < target || target < row[0]) {
                continue;
            }
            //说明数据一定在i行
            int left = 0;
            int right = row.length;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (target > row[mid]) {
                    left = mid + 1;
                } else if (target < row[mid]) {
                    right = mid;
                } else {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        S04_FindNumberIn2DArray s04FindNumberIn2DArray = new S04_FindNumberIn2DArray();
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1, 4, 7, 11, 15};
        matrix[1] = new int[]{2, 5, 8, 12, 19};
        matrix[2] = new int[]{3, 6, 9, 16, 22};
        matrix[3] = new int[]{10, 13, 14, 17, 24};
        matrix[4] = new int[]{18, 21, 23, 26, 30};
        boolean bole = s04FindNumberIn2DArray.findNumberIn2DArray(matrix, 5);
        System.out.println(bole);
    }
}
