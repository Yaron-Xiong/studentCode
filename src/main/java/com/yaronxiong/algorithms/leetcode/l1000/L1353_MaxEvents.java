package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1353. 最多可以参加的会议数目
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * <p>
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。在任意一天 d 中只能参加一场会议。
 * <p>
 * 请你返回你可以参加的 最大 会议数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 * 示例 2：
 * <p>
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= events.length <= 105
 * events[i].length == 2
 * 1 <= startDayi <= endDayi <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended/description/?envType=daily-question&envId=2025-07-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1353_MaxEvents {
    public static void main(String[] args) {
        L1353_MaxEvents l1353MaxEvents = new L1353_MaxEvents();
        System.out.println(l1353MaxEvents.maxEvents(new int[][]{{1, 2}, {1, 2}, {1, 6}, {1, 2}, {1, 2}}));
        System.out.println(l1353MaxEvents.maxEvents(new int[][]{{1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}}));
        System.out.println(l1353MaxEvents.maxEvents(new int[][]{{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}}));
        System.out.println(l1353MaxEvents.maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
        System.out.println(l1353MaxEvents.maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    public int maxEvents(int[][] events) {
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        List<Integer>[] group = new List[maxDay + 1];
        Arrays.setAll(group, i -> new ArrayList<>());
        for (int[] event : events) {
            group[event[0]].add(event[1]);
        }
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int day = 0; day <= maxDay; day++) {
            while (!pq.isEmpty() && day > pq.peek()) {
                pq.poll();
            }
            for (Integer endDay : group[day]) {
                pq.offer(endDay);
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }
        return ans;
    }
}
