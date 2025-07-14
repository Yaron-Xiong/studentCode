package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 3439. 重新安排会议得到最多空余时间 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。
 * <p>
 * 同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为 [startTime[i], endTime[i]] 。
 * <p>
 * 你可以重新安排 至多 k 个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 相邻两个会议之间的 最长 连续空余时间。
 * <p>
 * 移动前后所有会议之间的 相对 顺序需要保持不变，而且会议时间也需要保持互不重叠。
 * <p>
 * 请你返回重新安排会议以后，可以得到的 最大 空余时间。
 * <p>
 * 注意，会议 不能 安排到整个活动的时间以外。
 * <p>
 * 示例 1：
 * <p>
 * 输入：eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 将 [1, 2] 的会议安排到 [2, 3] ，得到空余时间 [0, 2] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * <p>
 * 将 [2, 4] 的会议安排到 [1, 3] ，得到空余时间 [3, 9] 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 活动中的所有时间都被会议安排满了。
 * <p>
 * 提示：
 * <p>
 * 1 <= eventTime <= 109
 * n == startTime.length == endTime.length
 * 2 <= n <= 105
 * 1 <= k <= n
 * 0 <= startTime[i] < endTime[i] <= eventTime
 * endTime[i] <= startTime[i + 1] 其中 i 在范围 [0, n - 2] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/reschedule-meetings-for-maximum-free-time-i/description/?envType=daily-question&envId=2025-07-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3439_MaxFreeTime {
    public static void main(String[] args) {
        L3439_MaxFreeTime solution = new L3439_MaxFreeTime();
        System.out.println(solution.maxFreeTime(21, 1, new int[]{7, 10, 16}, new int[]{10, 14, 18}));
        System.out.println(solution.maxFreeTime(5, 1, new int[]{1, 3}, new int[]{2, 5}));
        System.out.println(solution.maxFreeTime(10, 1, new int[]{0, 2, 9}, new int[]{1, 4, 10}));
    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        //统计有多少个间隙
        List<Integer> gapList = new ArrayList<>();
        if (startTime[0] != 0) {
            gapList.add(startTime[0]);
        }
        int pre = endTime[0];
        for (int i = 1; i < startTime.length; i++) {
            gapList.add(startTime[i] - pre);
            pre = endTime[i];
        }
        int last = eventTime - endTime[endTime.length - 1];
        if (last != 0) {
            gapList.add(last);
        }

        //通过固定窗口计算最大值
        int ans = 0;
        int curWin = 0;
        for (int i = 0; i < gapList.size(); i++) {
            curWin += gapList.get(i);
            if (i > k) {
                curWin -= gapList.get(i - k - 1);
            }
            ans = Math.max(ans, curWin);
        }
        return ans;
    }
}
