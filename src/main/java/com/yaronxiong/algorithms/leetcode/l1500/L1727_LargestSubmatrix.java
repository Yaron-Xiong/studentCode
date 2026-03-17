package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1727. 重新排列后的最大子矩阵
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二进制矩阵 matrix ，它的大小为 m x n ，你可以将 matrix 中的 列 按任意顺序重新排列。
 * <p>
 * 请你返回最优方案下将 matrix 重新排列后，全是 1 的子矩阵面积。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[0,0,1],[1,1,1],[1,0,1]]
 * 输出：4
 * 解释：你可以按照上图方式重新排列矩阵的每一列。
 * 最大的全 1 子矩阵是上图中加粗的部分，面积为 4 。
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,0,1,0,1]]
 * 输出：3
 * 解释：你可以按照上图方式重新排列矩阵的每一列。
 * 最大的全 1 子矩阵是上图中加粗的部分，面积为 3 。
 * 示例 3：
 * <p>
 * 输入：matrix = [[1,1,0],[1,0,1]]
 * 输出：2
 * 解释：由于你只能整列整列重新排布，所以没有比面积为 2 更大的全 1 子矩形。
 * 示例 4：
 * <p>
 * 输入：matrix = [[0,0],[0,0]]
 * 输出：0
 * 解释：由于矩阵中没有 1 ，没有任何全 1 的子矩阵，所以面积为 0 。
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m * n <= 105
 * matrix[i][j] 要么是 0 ，要么是 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/largest-submatrix-with-rearrangements/description/?envType=daily-question&envId=2026-03-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1727_LargestSubmatrix {
    public static void main(String[] args) {
        L1727_LargestSubmatrix l1727LargestSubmatrix = new L1727_LargestSubmatrix();
        System.out.println(l1727LargestSubmatrix.largestSubmatrix(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
                {0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}}));
    }

    public int largestSubmatrix(int[][] matrix) {
        //计算每一个列有多少个1
        int[] row = new int[matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                row[j] = matrix[i][j] == 1 ? row[j] + 1 : 0;
                if (row[j] > 0) {
                    list.add(row[j]);
                }
            }
            list.sort(Collections.reverseOrder());
            for (int j = 0; j < list.size(); j++) {
                ans = Math.max(ans, list.get(j) * (j + 1));
            }
        }
        return ans;
    }
}
