package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 2713. 矩阵中严格递增的单元格数
 * 算术评级: 8
 * 第 347 场周赛
 * Q4
 * 2387
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 1 开始、大小为 m x n 的整数矩阵 mat，你可以选择任一单元格作为 起始单元格 。
 * <p>
 * 从起始单元格出发，你可以移动到 同一行或同一列 中的任何其他单元格，但前提是目标单元格的值 严格大于 当前单元格的值。
 * <p>
 * 你可以多次重复这一过程，从一个单元格移动到另一个单元格，直到无法再进行任何移动。
 * <p>
 * 请你找出从某个单元开始访问矩阵所能访问的 单元格的最大数量 。
 * <p>
 * 返回一个表示可访问单元格最大数量的整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[3,1],[3,4]]
 * 输出：2
 * 解释：上图展示了从第 1 行、第 2 列的单元格开始，可以访问 2 个单元格。可以证明，无论从哪个单元格开始，最多只能访问 2 个单元格，因此答案是 2 。
 * 示例 2：
 * <p>
 * 输入：mat = [[1,1],[1,1]]
 * 输出：1
 * 解释：由于目标单元格必须严格大于当前单元格，在本示例中只能访问 1 个单元格。
 * 示例 3：
 * <p>
 * 输入：mat = [[3,1,6],[-9,5,7]]
 * 输出：4
 * 解释：上图展示了从第 2 行、第 1 列的单元格开始，可以访问 4 个单元格。可以证明，无论从哪个单元格开始，最多只能访问 4 个单元格，因此答案是 4 。
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * -105 <= mat[i][j] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-strictly-increasing-cells-in-a-matrix/description/?envType=daily-question&envId=2024-06-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2713_MaxIncreasingCells {
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        TreeMap<Integer, List<int[]>> g = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 相同元素放在同一组，统计位置
                g.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int ans = 0;
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        for (List<int[]> pos : g.values()) {
            int[] mx = new int[pos.size()]; // 先把最大值算出来，再更新 rowMax 和 colMax
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0];
                int j = p[1];
                mx[k] = Math.max(rowMax[i], colMax[j]) + 1;
                ans = Math.max(ans, mx[k]);
            }
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0];
                int j = p[1];
                rowMax[i] = Math.max(rowMax[i], mx[k]); // 更新第 i 行的最大 f 值
                colMax[j] = Math.max(colMax[j], mx[k]); // 更新第 j 列的最大 f 值
            }
        }
        return ans;
    }

}
