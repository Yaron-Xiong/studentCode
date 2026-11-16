package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2747. 统计没有收到请求的服务器数目
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n ，表示服务器的总数目，再给你一个下标从 0 开始的 二维 整数数组 logs ，
 * 其中 logs[i] = [server_id, time] 表示 id 为 server_id 的服务器在 time 时收到了一个请求。
 * <p>
 * 同时给你一个整数 x 和一个下标从 0 开始的整数数组 queries  。
 * <p>
 * 请你返回一个长度等于 queries.length 的数组 arr ，其中 arr[i] 表示在时间区间 [queries[i] - x, queries[i]] 内没有收到请求的服务器数目。
 * <p>
 * 注意时间区间是个闭区间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, logs = [[1,3],[2,6],[1,5]], x = 5, queries = [10,11]
 * 输出：[1,2]
 * 解释：
 * 对于 queries[0]：id 为 1 和 2 的服务器在区间 [5, 10] 内收到了请求，所以只有服务器 3 没有收到请求。
 * 对于 queries[1]：id 为 2 的服务器在区间 [6,11] 内收到了请求，所以 id 为 1 和 3 的服务器在这个时间段内没有收到请求。
 * 示例 2：
 * <p>
 * 输入：n = 3, logs = [[2,4],[2,1],[1,2],[3,1]], x = 2, queries = [3,4]
 * 输出：[0,1]
 * 解释：
 * 对于 queries[0]：区间 [1, 3] 内所有服务器都收到了请求。
 * 对于 queries[1]：只有 id 为 3 的服务器在区间 [2,4] 内没有收到请求。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 1 <= logs.length <= 105
 * 1 <= queries.length <= 105
 * logs[i].length == 2
 * 1 <= logs[i][0] <= n
 * 1 <= logs[i][1] <= 106
 * 1 <= x <= 105
 * x < queries[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-zero-request-servers/?envType=daily-question&envId=2026-11-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2747_CountServers {
    public static void main(String[] args) {
        L2747_CountServers l2747CountServers = new L2747_CountServers();
        System.out.println(Arrays.toString(l2747CountServers.countServers(3, new int[][]{{1, 3}, {2, 6}, {1, 5}}, 5, new int[]{10, 11})));
        System.out.println(Arrays.toString(l2747CountServers.countServers(3, new int[][]{{2, 4}, {2, 1}, {1, 2}, {3, 1}}, 2, new int[]{3, 4})));
    }

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        //服务器心跳排序
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        //查询按时间排序
        Integer[] idx = new Integer[queries.length];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (a, b) -> queries[a] - queries[b]);
        int[] ans = new int[queries.length];

        //当前符合查询条件的服务器数量
        int[] used = new int[n + 1];
        int cnt = 0;

        //记录logs使用到的位置
        int logsLeftIndex = 0;
        int logsRightIndex = 0;

        for (int i = 0; i < idx.length; i++) {
            //查询范围
            int right = queries[idx[i]];
            int left = right - x;
            //判断能否扩展
            while (logsRightIndex < logs.length && logs[logsRightIndex][1] <= right) {
                //服务器占用+1
                if (used[logs[logsRightIndex][0]] == 0) {
                    cnt++;
                }
                used[logs[logsRightIndex][0]]++;
                logsRightIndex++;
            }
            //左边界缩小
            while (logsLeftIndex < logs.length && logs[logsLeftIndex][1] < left) {
                if (used[logs[logsLeftIndex][0]] == 1) {
                    cnt--;
                }
                used[logs[logsLeftIndex][0]]--;
                logsLeftIndex++;
            }
            ans[idx[i]] = n - cnt;
        }
        return ans;
    }

}
