package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2589. 完成所有任务的最少时间
 * 算术评级: 8
 * 第 336 场周赛
 * Q4
 * 2381
 * 相关标签
 * 相关企业
 * 提示
 * 你有一台电脑，它可以 同时 运行无数个任务。
 * 给你一个二维整数数组 tasks ，其中 tasks[i] = [starti, endi, durationi]
 * 表示第 i 个任务需要在 闭区间 时间段 [starti, endi] 内运行 durationi 个整数时间点（但不需要连续）。
 * <p>
 * 当电脑需要运行任务时，你可以打开电脑，如果空闲时，你可以将电脑关闭。
 * <p>
 * 请你返回完成所有任务的情况下，电脑最少需要运行多少秒。
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = [[2,3,1],[4,5,1],[1,5,2]]
 * 输出：2
 * 解释：
 * - 第一个任务在闭区间 [2, 2] 运行。
 * - 第二个任务在闭区间 [5, 5] 运行。
 * - 第三个任务在闭区间 [2, 2] 和 [5, 5] 运行。
 * 电脑总共运行 2 个整数时间点。
 * 示例 2：
 * <p>
 * 输入：tasks = [[1,3,2],[2,5,3],[5,6,2]]
 * 输出：4
 * 解释：
 * - 第一个任务在闭区间 [2, 3] 运行
 * - 第二个任务在闭区间 [2, 3] 和 [5, 5] 运行。
 * - 第三个任务在闭区间 [5, 6] 运行。
 * 电脑总共运行 4 个整数时间点。
 * <p>
 * 提示：
 * <p>
 * 1 <= tasks.length <= 2000
 * tasks[i].length == 3
 * 1 <= starti, endi <= 2000
 * 1 <= durationi <= endi - starti + 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-rounds-to-complete-all-tasks/description/?envType=daily-question&envId=2024-05-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2589_FindMinimumTime {
    public static void main(String[] args) {
        L2589_FindMinimumTime l2589FindMinimumTime = new L2589_FindMinimumTime();
        System.out.println(l2589FindMinimumTime.findMinimumTime(new int[][]{{1,15,5},{5,13,2},{1,18,6},{2,12,1}}));
    }

    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            int compare = Integer.compare(a[1], b[1]);
            if (compare != 0) {
                return compare;
            }
            compare = Integer.compare(a[0], b[0]);
            if (compare != 0) {
                return compare;
            }
            return -Integer.compare(a[2], b[2]);
        });
        int max = tasks[tasks.length - 1][1];
        boolean[] useRecord = new boolean[max + 1];
        int[] preWindows = new int[]{0, 0};
        int ans = 0;
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            for (int j = preWindows[1]; j >= task[0] && task[2] > 0; j--) {
                if (useRecord[j]) {
                    task[2]--;
                }
            }
            //填充后面的数值
            for (int j = task[1]; j >= task[0] && task[2] > 0; j--) {
                if (useRecord[j]) {
                    continue;
                }
                task[2]--;
                useRecord[j] = true;
                ans++;
            }
            //合并windows
            if (preWindows[1] >= task[0]) {
                preWindows[0] = Math.min(preWindows[0], task[0]);
                preWindows[1] = task[1];
            } else {
                preWindows[0] = task[0];
                preWindows[1] = task[1];
            }
        }
        return ans;
    }
}
