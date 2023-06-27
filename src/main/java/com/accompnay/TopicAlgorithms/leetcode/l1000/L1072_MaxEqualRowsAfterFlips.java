package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.HashMap;
import java.util.Map;

/**
 * 1072. 按列翻转得到最大值等行数
 * 提示
 * 中等
 * 83
 * 相关企业
 * 给定 m x n 矩阵 matrix 。
 * <p>
 * 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）
 * <p>
 * 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 示例 2：
 * <p>
 * 输入：matrix = [[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 示例 3：
 * <p>
 * 输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] == 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1072_MaxEqualRowsAfterFlips {
    public static void main(String[] args) {

        System.out.println('0'^'1');
        System.out.println('0'^'0');
        L1072_MaxEqualRowsAfterFlips l1072MaxEqualRowsAfterFlips = new L1072_MaxEqualRowsAfterFlips();
        int x = l1072MaxEqualRowsAfterFlips.maxEqualRowsAfterFlips(new int[][]{{0, 0, 0}, {0, 0, 1}, {1, 1, 0}});
        System.out.println(x);
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>(matrix.length);
        int maxEqualRows = 0;
        char[] chars = new char[matrix[0].length];
        for (int[] arr : matrix) {
            for (int i = 0; i < arr.length; i++) {
                //以第一位为0作为基准
                //假设第一位为1 则将后面的位置全部取反
                //假设第一位为0 && 后面为0 -> 0 = 0;
                //假设第一位为0 && 后面为1 -> 1 = 1;
                chars[i] = (char) ('0' + arr[0] ^ arr[i]);
            }
            Integer value = map.compute(new String(chars), (k, v) -> v == null ? 1 : v + 1);
            maxEqualRows = Math.max(maxEqualRows, value);
        }
        return maxEqualRows;
    }
}
