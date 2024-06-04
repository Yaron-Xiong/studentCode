package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2965. 找出缺失和重复的数字
 * 已解答
 * 算术评级: 3
 * 第 376 场周赛
 * Q1
 * 1245
 * 相关标签
 * 相关企业
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
 * <p>
 * 任务是找出重复的数字a 和缺失的数字 b 。
 * <p>
 * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,3],[2,2]]
 * 输出：[2,4]
 * 解释：数字 2 重复，数字 4 缺失，所以答案是 [2,4] 。
 * 示例 2：
 * <p>
 * 输入：grid = [[9,1,7],[8,9,2],[3,4,6]]
 * 输出：[9,5]
 * 解释：数字 9 重复，数字 5 缺失，所以答案是 [9,5] 。
 * <p>
 * 提示：
 * <p>
 * 2 <= n == grid.length == grid[i].length <= 50
 * 1 <= grid[i][j] <= n * n
 * 对于所有满足1 <= x <= n * n 的 x ，恰好存在一个 x 与矩阵中的任何成员都不相等。
 * 对于所有满足1 <= x <= n * n 的 x ，恰好存在一个 x 与矩阵中的两个成员相等。
 * 除上述的两个之外，对于所有满足1 <= x <= n * n 的 x ，都恰好存在一对 i, j 满足 0 <= i, j <= n - 1 且 grid[i][j] == x 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-missing-and-repeated-values/description/?envType=daily-question&envId=2024-05-31">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2965_FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        L2965_FindMissingAndRepeatedValues l2965FindMissingAndRepeatedValues = new L2965_FindMissingAndRepeatedValues();
        int[][] grid = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        System.out.println(Arrays.toString(l2965FindMissingAndRepeatedValues.findMissingAndRepeatedValues(grid)));
    }
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int n = grid.length;
        int length = n * n;
        for (int i = 1; i <= length; i++) {
            set.add(i);
        }
        int[] ans = new int[]{-1, -1};
        for (int[] ints : grid) {
            for (int item : ints) {
                if (!set.remove(item)) {
                    ans[0] = item;
                }
            }
        }
        for (Integer i : set) {
            ans[1] = i;
        }
        return ans;
    }
}
