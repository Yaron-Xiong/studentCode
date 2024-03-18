package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1335. 工作计划的最低难度
 * 提示
 * 困难
 * 106
 * 相关企业
 * 你需要制定一份 d 天的工作计划表。工作之间存在依赖，要想执行第 i 项工作，你必须完成全部 j 项工作（ 0 <= j < i）。
 * <p>
 * 你每天 至少 需要完成一项任务。工作计划的总难度是这 d 天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
 * <p>
 * 给你一个整数数组 jobDifficulty 和一个整数 d，分别代表工作难度和需要计划的天数。第 i 项工作的难度是 jobDifficulty[i]。
 * <p>
 * 返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：jobDifficulty = [6,5,4,3,2,1], d = 2
 * 输出：7
 * 解释：第一天，您可以完成前 5 项工作，总难度 = 6.
 * 第二天，您可以完成最后一项工作，总难度 = 1.
 * 计划表的难度 = 6 + 1 = 7
 * 示例 2：
 * <p>
 * 输入：jobDifficulty = [9,9,9], d = 4
 * 输出：-1
 * 解释：就算你每天完成一项工作，仍然有一天是空闲的，你无法制定一份能够满足既定工作时间的计划表。
 * 示例 3：
 * <p>
 * 输入：jobDifficulty = [1,1,1], d = 3
 * 输出：3
 * 解释：工作计划为每天一项工作，总难度为 3 。
 * 示例 4：
 * <p>
 * 输入：jobDifficulty = [7,1,7,1,7,1], d = 3
 * 输出：15
 * 示例 5：
 * <p>
 * 输入：jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
 * 输出：843
 * <p>
 * 提示：
 * <p>
 * 1 <= jobDifficulty.length <= 300
 * 0 <= jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1335_MinDifficulty {

    public static void main(String[] args) {
        L1335_MinDifficulty l1335MinDifficulty = new L1335_MinDifficulty();
        System.out.println(l1335MinDifficulty.minDifficulty(new int[]{11,111,22,222,33,333,44,444}, 6));
    }


    int[][] memo;
    int[] jobDifficulty;
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        this.memo = new int[jobDifficulty.length][d + 1];
        this.jobDifficulty = jobDifficulty;
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(d, jobDifficulty.length - 1);
    }

    private int dfs(int d, int rightIndex) {
        if (memo[rightIndex][d] != -1) {
            return memo[rightIndex][d];
        }
        int leftIndex = d - 1;
        if (d == 1) {
            int minV = jobDifficulty[leftIndex];
            for (int j = leftIndex; j <= rightIndex; j++) {
                minV = Math.max(minV, jobDifficulty[j]);
            }
            return memo[rightIndex][d] = minV;
        }
        int minDifficulty = Integer.MAX_VALUE;
        //rightIndex向leftIndex靠近
        //构成桶的区间为 i~rightIndex
        int maxV = jobDifficulty[rightIndex];
        for (int i = rightIndex; i >= leftIndex; i--) {
            maxV = Math.max(maxV, jobDifficulty[i]);
            minDifficulty = Math.min(minDifficulty, dfs(d - 1, i - 1) + maxV);
        }
        return memo[rightIndex][d] = minDifficulty;
    }

}
