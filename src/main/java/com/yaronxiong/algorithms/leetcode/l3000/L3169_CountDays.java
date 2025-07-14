package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3169. 无需开会的工作日
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。
 * 另给你一个二维数组 meetings，长度为 n，其中 meetings[i] = [start_i, end_i] 表示第 i 次会议的开始和结束天数（包含首尾）。
 * <p>
 * 返回员工可工作且没有安排会议的天数。
 * <p>
 * 注意：会议时间可能会有重叠。
 * <p>
 * 示例 1：
 * <p>
 * 输入：days = 10, meetings = [[5,7],[1,3],[9,10]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 第 4 天和第 8 天没有安排会议。
 * <p>
 * 示例 2：
 * <p>
 * 输入：days = 5, meetings = [[2,4],[1,3]]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 第 5 天没有安排会议。
 * <p>
 * 示例 3：
 * <p>
 * 输入：days = 6, meetings = [[1,6]]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 所有工作日都安排了会议。
 * <p>
 * 提示：
 * <p>
 * 1 <= days <= 109
 * 1 <= meetings.length <= 105
 * meetings[i].length == 2
 * 1 <= meetings[i][0] <= meetings[i][1] <= days
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-days-without-meetings/description/?envType=daily-question&envId=2025-07-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3169_CountDays {
    public static void main(String[] args) {
        L3169_CountDays l3169CountDays = new L3169_CountDays();
        System.out.println(l3169CountDays.countDays(8, new int[][]{{3, 4}, {4, 8}, {2, 5}, {3, 8}}));
        System.out.println(l3169CountDays.countDays(5, new int[][]{{2, 4}, {1, 3}}));
        System.out.println(l3169CountDays.countDays(10, new int[][]{{5, 7}, {1, 3}, {9, 10}}));
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        //开始合并区间
        int ans = 0;
        int preEnd = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            int left = meetings[i][0];
            int right = meetings[i][1];
            if (left > preEnd) {
                ans += left - preEnd - 1;
            }
            preEnd = Math.max(preEnd, right);
        }
        if (meetings[0][0] != 1) {
            ans += meetings[0][0] - 1;
        }
        if (days != preEnd) {
            ans += days - preEnd;
        }
        return ans;
    }
}
