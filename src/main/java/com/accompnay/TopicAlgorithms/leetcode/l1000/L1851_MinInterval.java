package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1851. 包含每个查询的最小区间
 * 提示
 * 困难
 * 63
 * 相关企业
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti]
 * 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。
 * 区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。
 * <p>
 * 再给你一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1 。
 * <p>
 * 以数组形式返回对应查询的所有答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
 * 输出：[3,3,1,4]
 * 解释：查询处理如下：
 * - Query = 2 ：区间 [2,4] 是包含 2 的最小区间，答案为 4 - 2 + 1 = 3 。
 * - Query = 3 ：区间 [2,4] 是包含 3 的最小区间，答案为 4 - 2 + 1 = 3 。
 * - Query = 4 ：区间 [4,4] 是包含 4 的最小区间，答案为 4 - 4 + 1 = 1 。
 * - Query = 5 ：区间 [3,6] 是包含 5 的最小区间，答案为 6 - 3 + 1 = 4 。
 * 示例 2：
 * <p>
 * 输入：intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
 * 输出：[2,-1,4,6]
 * 解释：查询处理如下：
 * - Query = 2 ：区间 [2,3] 是包含 2 的最小区间，答案为 3 - 2 + 1 = 2 。
 * - Query = 19：不存在包含 19 的区间，答案为 -1 。
 * - Query = 5 ：区间 [2,5] 是包含 5 的最小区间，答案为 5 - 2 + 1 = 4 。
 * - Query = 22：区间 [20,25] 是包含 22 的最小区间，答案为 25 - 20 + 1 = 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 1 <= lefti <= righti <= 107
 * 1 <= queries[j] <= 107
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-interval-to-include-each-query/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1851_MinInterval {
    public static void main(String[] args) {
        L1851_MinInterval l1851MinInterval = new L1851_MinInterval();
        int[] ints = l1851MinInterval.minInterval2(new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}}, new int[]{2, 19, 5, 22});
        System.out.println(Arrays.toString(ints));
    }

    public int[] minInterval2(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //qb的意义在于 在对queries排序后，依旧记录 元素之前的下标
        //用于在得出结果时 设置结果的位置
        int[][] qb = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            qb[i] = new int[]{queries[i], i};
        }
        Arrays.sort(qb, Comparator.comparing(a -> a[0]));
        int[] res = new int[queries.length];
        //根据size排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0])));
        int intervalIndex = 0;
        Arrays.fill(res, -1);
        for (int[] dpItem : qb) {
            while (intervalIndex < intervals.length && dpItem[0] >= intervals[intervalIndex][0]) {
                int[] interval = intervals[intervalIndex];
                int right = interval[1];
                int left = interval[0];
                queue.offer(new int[]{right - left + 1, right});
                intervalIndex++;
            }
            while (!queue.isEmpty() && queue.peek()[1] < dpItem[0]) {
                //说明元素不符合
                queue.poll();
            }
            if (!queue.isEmpty()) {
                res[dpItem[1]] = queue.peek()[0];
            }
        }
        return res;
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] dp = new int[10000001];
        Arrays.fill(dp, -1);
        for (int[] interval : intervals) {
            int right = interval[1];
            int left = interval[0];
            int size = right - left + 1;
            //填充 left->right
            //如何快速的对left->right进行标记？
            for (int i = left; i <= right; i++) {
                if (dp[i] == -1) {
                    dp[i] = size;
                } else {
                    dp[i] = Math.min(size, dp[i]);
                }
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            res[i] = dp[query];
        }
        return res;
    }
}
