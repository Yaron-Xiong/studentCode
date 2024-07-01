package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2732. 找到矩阵中的好子集
 * 算术评级: 8
 * 第 106 场双周赛
 * Q4
 * 2240
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 从原矩阵中选出若干行构成一个行的 非空 子集，如果子集中任何一列的和至多为子集大小的一半，那么我们称这个子集是 好子集。
 * <p>
 * 更正式的，如果选出来的行子集大小（即行的数量）为 k，那么每一列的和至多为 floor(k / 2) 。
 * <p>
 * 请你返回一个整数数组，它包含好子集的行下标，请你将子集中的元素 升序 返回。
 * <p>
 * 如果有多个好子集，你可以返回任意一个。如果没有好子集，请你返回一个空数组。
 * <p>
 * 一个矩阵 grid 的行 子集 ，是删除 grid 中某些（也可能不删除）行后，剩余行构成的元素集合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1,1,0],[0,0,0,1],[1,1,1,1]]
 * 输出：[0,1]
 * 解释：我们可以选择第 0 和第 1 行构成一个好子集。
 * 选出来的子集大小为 2 。
 * - 第 0 列的和为 0 + 0 = 0 ，小于等于子集大小的一半。
 * - 第 1 列的和为 1 + 0 = 1 ，小于等于子集大小的一半。
 * - 第 2 列的和为 1 + 0 = 1 ，小于等于子集大小的一半。
 * - 第 3 列的和为 0 + 1 = 1 ，小于等于子集大小的一半。
 * 示例 2：
 * <p>
 * 输入：grid = [[0]]
 * 输出：[0]
 * 解释：我们可以选择第 0 行构成一个好子集。
 * 选出来的子集大小为 1 。
 * - 第 0 列的和为 0 ，小于等于子集大小的一半。
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1],[1,1,1]]
 * 输出：[]
 * 解释：没有办法得到一个好子集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 104
 * 1 <= n <= 5
 * grid[i][j] 要么是 0 ，要么是 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-a-good-subset-of-the-matrix/description/?envType=daily-question&envId=2024-06-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2732_GoodSubsetofBinaryMatrix {
    public static void main(String[] args) {
        List<Integer> list = new L2732_GoodSubsetofBinaryMatrix().goodSubsetofBinaryMatrix(new int[][]{{1, 0, 0, 1, 0}, {1, 0, 1, 0, 1}, {0, 0, 0, 0, 1}, {1, 0, 1, 1, 1}});
        System.out.println(list);
    }

    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        return dfs2(grid, new LinkedList<>(), new boolean[grid.length], new int[grid[0].length]);
    }

    private List<Integer> dfs2(int[][] grid, Deque<Integer> path, boolean[] visit, int[] columValue) {
        for (int i = 0; i < grid.length; i++) {
            if (visit[i]) {
                continue;
            }
            //选择当前行
            visit[i] = true;
            path.addLast(i);
            int baseValue = path.size() / 2;
            boolean isAns = true;
            for (int j = 0; j < columValue.length; j++) {
                columValue[j] += grid[i][j];
                if (columValue[j] > baseValue) {
                    isAns = false;
                }
            }
            if (isAns) {
                return new ArrayList<>(path);
            }
            List<Integer> list = dfs2(grid, path, visit, columValue);
            for (int j = 0; j < columValue.length; j++) {
                columValue[j] -= grid[i][j];
            }
            path.removeLast();
            visit[i] = false;
            if (!list.isEmpty()) {
                return list;
            }
        }
        return new ArrayList<>();
    }
}
