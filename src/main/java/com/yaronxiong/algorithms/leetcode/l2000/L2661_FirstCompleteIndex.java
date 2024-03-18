package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 2661. 找出叠涂元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。
 * arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
 * <p>
 * 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
 * <p>
 * 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。
 * <p>
 * 示例 1：
 * <p>
 * image explanation for example 1
 * 输入：arr = [1,3,4,2], mat = [[1,4],[2,3]]
 * 输出：2
 * 解释：遍历如上图所示，arr[2] 在矩阵中的第一行或第二列上都被涂色。
 * 示例 2：
 * <p>
 * image explanation for example 2
 * 输入：arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
 * 输出：3
 * 解释：遍历如上图所示，arr[3] 在矩阵中的第二列上都被涂色。
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n = mat[i].length
 * arr.length == m * n
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= arr[i], mat[r][c] <= m * n
 * arr 中的所有整数 互不相同
 * mat 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/first-completely-painted-row-or-column/description/?envType=daily-question&envId=2023-12-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2661_FirstCompleteIndex {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int colN = mat[0].length;
        int rowN = mat.length;
        int[] col = new int[colN];
        int[] row = new int[rowN];
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            if (!map.containsKey(item)) {
                continue;
            }
            int[] coordinate = map.get(item);
            if (++row[coordinate[0]] == colN) {
                return i;
            }
            if (++col[coordinate[1]] == rowN) {
                return i;
            }
        }
        return -1;
    }
}
