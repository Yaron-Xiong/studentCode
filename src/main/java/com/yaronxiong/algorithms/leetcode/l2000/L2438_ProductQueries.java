package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2438. 二的幂数组中查询范围内的乘积
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数 n ，你需要找到一个下标从 0 开始的数组 powers ，它包含 最少 数目的 2 的幂，且它们的和为 n 。
 * powers 数组是 非递减 顺序的。根据前面描述，构造 powers 数组的方法是唯一的。
 * <p>
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] ，
 * 其中 queries[i] 表示请你求出满足 lefti <= j <= righti 的所有 powers[j] 的乘积。
 * <p>
 * 请你返回一个数组 answers ，长度与 queries 的长度相同，其中 answers[i]是第 i 个查询的答案。
 * 由于查询的结果可能非常大，请你将每个 answers[i] 都对 109 + 7 取余 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 15, queries = [[0,1],[2,2],[0,3]]
 * 输出：[2,4,64]
 * 解释：
 * 对于 n = 15 ，得到 powers = [1,2,4,8] 。没法得到元素数目更少的数组。
 * 第 1 个查询的答案：powers[0] * powers[1] = 1 * 2 = 2 。
 * 第 2 个查询的答案：powers[2] = 4 。
 * 第 3 个查询的答案：powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64 。
 * 每个答案对 109 + 7 得到的结果都相同，所以返回 [2,4,64] 。
 * 示例 2：
 * <p>
 * 输入：n = 2, queries = [[0,0]]
 * 输出：[2]
 * 解释：
 * 对于 n = 2, powers = [2] 。
 * 唯一一个查询的答案是 powers[0] = 2 。答案对 109 + 7 取余后结果相同，所以返回 [2] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 1 <= queries.length <= 105
 * 0 <= starti <= endi < powers.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/range-product-queries-of-powers/description/?envType=daily-question&envId=2025-08-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2438_ProductQueries {
    public static void main(String[] args) {
        L2438_ProductQueries l2438ProductQueries = new L2438_ProductQueries();
        System.out.println(Arrays.toString(l2438ProductQueries.productQueries(806335498, new int[][]{{4, 6}, {6, 6}, {0, 3}})));
        System.out.println(Arrays.toString(l2438ProductQueries.productQueries(2, new int[][]{{0, 0}})));
    }

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> lowPowerList = new ArrayList<>();
        int curN = n;
        while (curN > 0) {
            int lowBit = curN & -curN;
            lowPowerList.add(lowBit);
            curN ^= lowBit;
        }
        int[] ans = new int[queries.length];
        long mod = 1000000007;
        //计算queries
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long mul = 1;
            for (int j = left; j <= right; j++) {
                mul = (mul * lowPowerList.get(j)) % mod;
            }
            ans[i] = (int) (mul % mod);
        }
        return ans;
    }
}
