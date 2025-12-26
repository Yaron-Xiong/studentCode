package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2054. 两个最好的不重叠活动
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二维整数数组 events ，其中 events[i] = [startTimei, endTimei, valuei] 。第 i 个活动开始于 startTimei ，结束于 endTimei ，如果你参加这个活动，那么你可以得到价值 valuei 。你 最多 可以参加 两个时间不重叠 活动，使得它们的价值之和 最大 。
 * <p>
 * 请你返回价值之和的 最大值 。
 * <p>
 * 注意，活动的开始时间和结束时间是 包括 在活动时间内的，也就是说，你不能参加两个活动且它们之一的开始时间等于另一个活动的结束时间。更具体的，如果你参加一个活动，且结束时间为 t ，那么下一个活动必须在 t + 1 或之后的时间开始。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：events = [[1,3,2],[4,5,2],[2,4,3]]
 * 输出：4
 * 解释：选择绿色的活动 0 和 1 ，价值之和为 2 + 2 = 4 。
 * 示例 2：
 * <p>
 * Example 1 Diagram
 * <p>
 * 输入：events = [[1,3,2],[4,5,2],[1,5,5]]
 * 输出：5
 * 解释：选择活动 2 ，价值和为 5 。
 * 示例 3：
 * <p>
 * 输入：events = [[1,5,3],[1,5,1],[6,6,5]]
 * 输出：8
 * 解释：选择活动 0 和 2 ，价值之和为 3 + 5 = 8 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= events.length <= 105
 * events[i].length == 3
 * 1 <= startTimei <= endTimei <= 109
 * 1 <= valuei <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/two-best-non-overlapping-events/?envType=daily-question&envId=2025-12-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2054_MaxTwoEvents {
    public static void main(String[] args) {
        L2054_MaxTwoEvents l2054MaxTwoEvents = new L2054_MaxTwoEvents();
        System.out.println(l2054MaxTwoEvents.maxTwoEvents(new int[][]{{1, 3, 2}, {4, 5, 2}, {2, 4, 3}}));
        System.out.println(l2054MaxTwoEvents.maxTwoEvents(new int[][]{{1, 3, 2}, {4, 5, 2}, {1, 5, 5}}));
        System.out.println(l2054MaxTwoEvents.maxTwoEvents(new int[][]{{1, 5, 3}, {1, 5, 1}, {6, 6, 5}}));

    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        //[结束时间，价值]
        List<int[]> list = new ArrayList<>();
        //哨兵
        list.add(new int[]{0, 0});
        int ans = 0;
        for (int[] event : events) {
            int i = search(list, event[0]);
            ans = Math.max(ans, list.get(i)[1] + event[2]);
            if (event[2] > list.get(list.size() - 1)[1]) {
                list.add(new int[]{event[1], event[2]});
            }
        }
        return ans;
    }

    // [结束时间，价值]
    // [3 ,6] [4,10] [4,50] [6,100]
    // 输入 4 => 得 [3,6]
    // 输入 6 => 得 [4,50]
    // 输入 8 => 得 [6,100]
    private int search(List<int[]> list, int target) {
        int left = -1;
        int right = list.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target > list.get(mid)[0]) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
