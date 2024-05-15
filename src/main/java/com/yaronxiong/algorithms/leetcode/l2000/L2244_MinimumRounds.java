package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 2244. 完成所有任务需要的最少轮数
 * 算术评级: 3
 * 第 289 场周赛
 * Q2
 * 1372
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。
 * <p>
 * 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = [2,2,3,3,2,4,4,4,4,4]
 * 输出：4
 * 解释：要想完成所有任务，一个可能的计划是：
 * - 第一轮，完成难度级别为 2 的 3 个任务。
 * - 第二轮，完成难度级别为 3 的 2 个任务。
 * - 第三轮，完成难度级别为 4 的 3 个任务。
 * - 第四轮，完成难度级别为 4 的 2 个任务。
 * 可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。
 * 示例 2：
 * <p>
 * 输入：tasks = [2,3,3]
 * 输出：-1
 * 解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务，答案为 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= tasks.length <= 105
 * 1 <= tasks[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-rounds-to-complete-all-tasks/description/?envType=daily-question&envId=2024-05-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2244_MinimumRounds {
    public static void main(String[] args) {
        L2244_MinimumRounds l2244MinimumRounds = new L2244_MinimumRounds();
        System.out.println(l2244MinimumRounds.minimumRounds(new int[]{69, 65, 62, 64, 70, 68, 69, 67, 60, 65, 69, 62, 65, 65, 61, 66, 68, 61, 65, 63, 60, 66, 68, 66, 67, 65, 63, 65, 70, 69, 70, 62, 68, 70, 60, 68, 65, 61, 64, 65, 63, 62, 62, 62, 67, 62, 62, 61, 66, 69}));
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.merge(task, 1, Integer::sum);
        }
        int ans = 0;
        for (Integer value : map.values()) {
            if (value == 1) {
                return -1;
            } else if (value % 3 == 0) {
                ans += value / 3;
            } else if (value % 3 == 2) {
                ans += (value + 1) / 3;
            } else {
                ans += (value + 4) / 3;
            }
        }
        return ans;
    }

}
