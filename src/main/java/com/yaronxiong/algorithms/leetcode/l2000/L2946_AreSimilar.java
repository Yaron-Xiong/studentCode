package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2946. 循环移位后的矩阵相似检查
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始且大小为 m x n 的整数矩阵 mat 和一个整数 k 。请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
 * <p>
 * 如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2
 * 输出：true
 * 解释：
 * <p>
 * 初始矩阵如图一所示。
 * 图二表示对奇数行右移一次且对偶数行左移一次后的矩阵状态。
 * 图三是经过两次循环移位后的最终矩阵状态，与初始矩阵相同。
 * 因此，返回 true 。
 * 示例 2：
 * <p>
 * 输入：mat = [[2,2],[2,2]], k = 3
 * 输出：true
 * 解释：由于矩阵中的所有值都相等，即使进行循环移位，矩阵仍然保持不变。因此，返回 true 。
 * 示例 3：
 * <p>
 * 输入：mat = [[1,2]], k = 1
 * 输出：false
 * 解释：循环移位一次后，mat = [[2,1]]，与初始矩阵不相等。因此，返回 false 。
 * <p>
 * 提示：
 * <p>
 * 1 <= mat.length <= 25
 * 1 <= mat[i].length <= 25
 * 1 <= mat[i][j] <= 25
 * 1 <= k <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/matrix-similarity-after-cyclic-shifts/?envType=daily-question&envId=2026-03-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2946_AreSimilar {
    public static void main(String[] args) {
        L2946_AreSimilar l2946AreSimilar = new L2946_AreSimilar();
        System.out.println(l2946AreSimilar.areSimilar(new int[][]{{9, 10, 10, 6, 6, 8, 10, 7, 10, 9}, {10, 6, 1, 10, 10, 5, 7, 9, 9, 2}, {8, 5, 8, 3, 5, 2, 2, 9, 7, 10}}, 20));
        l2946AreSimilar.areSimilar(new int[][]{{2,2},{2,2}}, 3);
        l2946AreSimilar.areSimilar(new int[][]{{1,2}}, 1);
    }
    public boolean areSimilar(int[][] mat, int k) {
        boolean ans = true;
        for (int[] arr : mat) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != arr[(j + k) % arr.length]) {
                    ans = false;
                    break;
                }
            }
        }
        return ans;
    }
}
