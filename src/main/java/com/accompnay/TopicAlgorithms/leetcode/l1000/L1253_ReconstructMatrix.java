package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 1253. 重构 2 行二进制矩阵
 * 提示
 * 中等
 * 42
 * 相关企业
 * 给你一个 2 行 n 列的二进制数组：
 * <p>
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 * 第 0 行的元素之和为 upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 * <p>
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 * <p>
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：upper = 2, lower = 1, colsum = [1,1,1]
 * 输出：[[1,1,0],[0,0,1]]
 * 解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
 * 示例 2：
 * <p>
 * 输入：upper = 2, lower = 3, colsum = [2,2,1,1]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * 输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= colsum.length <= 10^5
 * 0 <= upper, lower <= colsum.length
 * 0 <= colsum[i] <= 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/reconstruct-a-2-row-binary-matrix/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1253_ReconstructMatrix {
    public static void main(String[] args) {
        L1253_ReconstructMatrix l1253ReconstructMatrix = new L1253_ReconstructMatrix();
        System.out.println(l1253ReconstructMatrix.reconstructMatrix(4, 7, new int[]{2, 1, 2, 2, 1, 1, 1}));
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        //为什么可以用贪心？ 刚好两行、并且值刚好为 0、1
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        List<Integer> upperList = res.get(0);
        List<Integer> lowerList = res.get(1);
        for (int i = 0; i < colsum.length; i++) {
            int upperValue = 0;
            int lowerValue = 0;
            if (colsum[i] == 2) {
                upperValue = 1;
                lowerValue = 1;
            } else if (colsum[i] == 1) {
                if (upper > lower) {
                    upperValue = 1;
                } else {
                    lowerValue = 1;
                }
            }
            upper = upperValue == 1 ? upper - 1 : upper;
            lower = lowerValue == 1 ? lower - 1 : lower;
            upperList.add(upperValue);
            lowerList.add(lowerValue);
            if (upper < 0 || lower < 0) {
                return new ArrayList<>();
            }
        }
        return upper == 0 && lower == 0 ? res : new ArrayList<>();
    }
}
