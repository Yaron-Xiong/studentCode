package com.accompnay.TopicAlgorithms.leetcode.weekly.w431;

import java.util.Arrays;

/**
 * 2643. 一最多的行
 * 提示
 * 简单
 * 2
 * 相关企业
 * 给你一个大小为 m x n 的二进制矩阵 mat ，请你找出包含最多 1 的行的下标（从 0 开始）以及这一行中 1 的数目。
 * <p>
 * 如果有多行包含最多的 1 ，只需要选择 行下标最小 的那一行。
 * <p>
 * 返回一个由行下标和该行中 1 的数量组成的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[0,1],[1,0]]
 * 输出：[0,1]
 * 解释：两行中 1 的数量相同。所以返回下标最小的行，下标为 0 。该行 1 的数量为 1 。所以，答案为 [0,1] 。
 * 示例 2：
 * <p>
 * 输入：mat = [[0,0,0],[0,1,1]]
 * 输出：[1,2]
 * 解释：下标为 1 的行中 1 的数量最多。该行 1 的数量为 2 。所以，答案为 [1,2] 。
 * 示例 3：
 * <p>
 * 输入：mat = [[0,0],[1,1],[0,0]]
 * 输出：[1,2]
 * 解释：下标为 1 的行中 1 的数量最多。该行 1 的数量为 2 。所以，答案为 [1,2] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * mat[i][j] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/row-with-maximum-ones/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2643_RowAndMaximumOnes {
    public static void main(String[] args) {
        L2643_RowAndMaximumOnes l1 = new L2643_RowAndMaximumOnes();
        int[] x = l1.rowAndMaximumOnes(new int[][]{{0, 1}, {1, 0}});
        System.out.println(Arrays.toString(x));
    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        int resI = -1;
        int cnt = 0;
        for (int i = 0; i < mat.length; i++) {
            int temp = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    temp++;
                }
            }
            if (resI == -1 || temp > cnt) {
                resI = i;
                cnt = temp;
            }
        }
        return new int[]{resI, cnt};
    }
}
