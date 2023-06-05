package com.accompnay.TopicAlgorithms.leetcode;

import java.util.Arrays;

/**
 * 1439. 有序矩阵中的第 k 个最小数组和
 * 提示
 * 困难
 * 168
 * 相关企业
 * 给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
 * <p>
 * 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,3,11],[2,4,6]], k = 5
 * 输出：7
 * 解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
 * [1,2], [1,4], [3,2], [3,4], [1,6]。其中第 5 个的和是 7 。
 * 示例 2：
 * <p>
 * 输入：mat = [[1,3,11],[2,4,6]], k = 9
 * 输出：17
 * 示例 3：
 * <p>
 * 输入：mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
 * 输出：9
 * 解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
 * [1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]。其中第 7 个的和是 9 。
 * 示例 4：
 * <p>
 * 输入：mat = [[1,1,10],[2,2,9]], k = 7
 * 输出：12
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat.length[i]
 * 1 <= m, n <= 40
 * 1 <= k <= min(200, n ^ m)
 * 1 <= mat[i][j] <= 5000
 * mat[i] 是一个非递减数组
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1439_KthSmallest {
    public static void main(String[] args) {
        L1439_KthSmallest l1439KthSmallest = new L1439_KthSmallest();
        System.out.println(l1439KthSmallest.kthSmallest(new int[][]{{1, 3, 11}, {2, 4, 6}}, 5));
    }

    public int kthSmallest(int[][] mat, int k) {
        int[] preArr = new int[]{0};
        //由preArr & mat中每一行构建前K个数组
        for (int[] matArr : mat) {
            int[] newArr = new int[preArr.length * matArr.length];
            int i = 0;
            for (int matItem : matArr) {
                for (int preItem : preArr) {
                    newArr[i++] = matItem + preItem;
                }
            }
            Arrays.sort(newArr);
            preArr = new int[Math.min(k, newArr.length)];
            System.arraycopy(newArr, 0, preArr, 0, preArr.length);
        }
        return preArr[k - 1];
    }


}
