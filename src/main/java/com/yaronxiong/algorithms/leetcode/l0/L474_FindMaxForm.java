package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 474. 一和零
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * <p>
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/ones-and-zeroes/description/?envType=daily-question&envId=2025-11-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L474_FindMaxForm {
    public static void main(String[] args) {
        L474_FindMaxForm l474FindMaxForm = new L474_FindMaxForm();
        System.out.println(l474FindMaxForm.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] arr = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    arr[i][0]++;
                } else {
                    arr[i][1]++;
                }
            }
        }
        int[][][] memo = new int[strs.length][m + 1][n + 1];
        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs2(0, arr, m, n, memo);
    }

    private int dfs2(int i, int[][] arr, int m, int n, int[][][] memo) {
        if (i >= arr.length) {
            return 0;
        }
        if (memo[i][m][n] != -1) {
            return memo[i][m][n];
        }
        //不选择
        int ans = dfs2(i + 1, arr, m, n, memo);
        //是否可以选择
        int newM = m - arr[i][0];
        int newN = n - arr[i][1];
        if (newM >= 0 && newN >= 0) {
            ans = Math.max(ans, dfs2(i + 1, arr, newM, newN, memo) + 1);
        }
        return memo[i][m][n] = ans;
    }
}
