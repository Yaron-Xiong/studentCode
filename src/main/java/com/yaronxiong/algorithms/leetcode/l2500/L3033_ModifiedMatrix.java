package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 3033. 修改矩阵
 * 算术评级: 2
 * 第 384 场周赛
 * Q1
 * 1181
 * 相关标签
 * 相关企业
 * 给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、名为 answer 的矩阵。
 * 使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。
 * <p>
 * 返回矩阵 answer 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
 * 输出：[[1,2,9],[4,8,6],[7,8,9]]
 * 解释：上图显示了发生替换的元素（蓝色区域）。
 * - 将单元格 [1][1] 中的值替换为列 1 中的最大值 8 。
 * - 将单元格 [0][2] 中的值替换为列 2 中的最大值 9 。
 * 示例 2：
 * <p>
 * 输入：matrix = [[3,-1],[5,2]]
 * 输出：[[3,2],[5,2]]
 * 解释：上图显示了发生替换的元素（蓝色区域）。
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 2 <= m, n <= 50
 * -1 <= matrix[i][j] <= 100
 * 测试用例中生成的输入满足每列至少包含一个非负整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/modify-the-matrix/description/?envType=daily-question&envId=2024-07-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3033_ModifiedMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            int max = 0;
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
                ans[j][i] = matrix[j][i];
                if (matrix[j][i] == -1) {
                    rows.add(j);
                }
            }
            for (Integer row : rows) {
                ans[row][i] = max;
            }
        }
        return ans;
    }
}
