package com.accompnay.TopicAlgorithms.leetcode.l1500;

import java.util.Arrays;

/**
 * 1901. 寻找峰值 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
 * <p>
 * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
 * <p>
 * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
 * <p>
 * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 * <p>
 * 示例 1:
 * <p>
 * 输入: mat = [[1,4],[3,2]]
 * 输出: [0,1]
 * 解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
 * 输出: [1,1]
 * 解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 500
 * 1 <= mat[i][j] <= 105
 * 任意两个相邻元素均不相等.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-a-peak-element-ii/description/?envType=daily-question&envId=2023-12-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1901_FindPeakGrid {
    public static void main(String[] args) {
        L1901_FindPeakGrid l1901FindPeakGrid = new L1901_FindPeakGrid();
        System.out.println(Arrays.toString(l1901FindPeakGrid.findPeakGrid(new int[][]{{10,20,15},{21,30,14},{7,16,32}})));
    }

    public int[] findPeakGrid(int[][] mat) {
        int left = 0;
        int right = mat.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            //寻找当前行的最大值
            int maxIndex = findMaxIndex(mat[mid]);
            if (mat[mid][maxIndex] > mat[mid + 1][maxIndex]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{left, findMaxIndex(mat[left])};
    }

    public int findMaxIndex(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}
