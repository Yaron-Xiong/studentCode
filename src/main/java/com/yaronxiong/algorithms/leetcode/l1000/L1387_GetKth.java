package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.*;

/**
 * 1387. 将整数按权重排序
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
 * <p>
 * 如果 x 是偶数，那么 x = x / 2
 * 如果 x 是奇数，那么 x = 3 * x + 1
 * 比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
 * <p>
 * 给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
 * <p>
 * 请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 * <p>
 * 注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：lo = 12, hi = 15, k = 2
 * 输出：13
 * 解释：12 的权重为 9（12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）
 * 13 的权重为 9
 * 14 的权重为 17
 * 15 的权重为 17
 * 区间内的数按权重排序以后的结果为 [12,13,14,15] 。对于 k = 2 ，答案是第二个整数也就是 13 。
 * 注意，12 和 13 有相同的权重，所以我们按照它们本身升序排序。14 和 15 同理。
 * 示例 2：
 * <p>
 * 输入：lo = 7, hi = 11, k = 4
 * 输出：7
 * 解释：区间内整数 [7, 8, 9, 10, 11] 对应的权重为 [16, 3, 19, 6, 14] 。
 * 按权重排序后得到的结果为 [8, 10, 11, 7, 9] 。
 * 排序后数组中第 4 个数字为 7 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= lo <= hi <= 1000
 * 1 <= k <= hi - lo + 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sort-integers-by-the-power-value/?envType=daily-question&envId=2024-12-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1387_GetKth {
    public static void main(String[] args) {
        L1387_GetKth l1387GetKth = new L1387_GetKth();
        System.out.println(l1387GetKth.getKth(7, 11, 4));
    }

    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 0);
        memo.put(0, 0);
        int[][] temp = new int[hi - lo + 1][2];
        for (int i = lo; i <= hi; i++) {
            int step = getStep(i, memo);
            temp[i - lo] = new int[]{i, step};
        }
        Arrays.sort(temp, (a, b) -> {
            int compare = Integer.compare(a[1], b[1]);
            if (compare == 0) {
                return Integer.compare(a[0], b[0]);
            }
            return compare;
        });
        return temp[k - 1][0];
    }


    public int getStep(int i, Map<Integer, Integer> memo) {
        if (i == 1) {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int ans = 1;
        if (i % 2 == 0) {
            ans += getStep(i / 2, memo);
        } else {
            ans += getStep((i * 3) + 1, memo);
        }
        memo.put(i, ans);
        return ans;
    }


}
