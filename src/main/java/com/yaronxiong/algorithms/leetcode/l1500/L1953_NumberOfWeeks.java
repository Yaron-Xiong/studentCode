package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1953. 你可以工作的最大周数
 * 算术评级: 5
 * 第 252 场周赛
 * Q2
 * 1804
 * 相关标签
 * 相关企业
 * 提示
 * 给你 n 个项目，编号从 0 到 n - 1 。同时给你一个整数数组 milestones ，其中每个 milestones[i] 表示第 i 个项目中的阶段任务数量。
 * <p>
 * 你可以按下面两个规则参与项目中的工作：
 * <p>
 * 每周，你将会完成 某一个 项目中的 恰好一个 阶段任务。你每周都 必须 工作。
 * 在 连续的 两周中，你 不能 参与并完成同一个项目中的两个阶段任务。
 * 一旦所有项目中的全部阶段任务都完成，或者仅剩余一个阶段任务都会导致你违反上面的规则，那么你将 停止工作 。注意，由于这些条件的限制，你可能无法完成所有阶段任务。
 * <p>
 * 返回在不违反上面规则的情况下你 最多 能工作多少周。
 * <p>
 * 示例 1：
 * <p>
 * 输入：milestones = [1,2,3]
 * 输出：6
 * 解释：一种可能的情形是：
 * - 第 1 周，你参与并完成项目 0 中的一个阶段任务。
 * - 第 2 周，你参与并完成项目 2 中的一个阶段任务。
 * - 第 3 周，你参与并完成项目 1 中的一个阶段任务。
 * - 第 4 周，你参与并完成项目 2 中的一个阶段任务。
 * - 第 5 周，你参与并完成项目 1 中的一个阶段任务。
 * - 第 6 周，你参与并完成项目 2 中的一个阶段任务。
 * 总周数是 6 。
 * 示例 2：
 * <p>
 * 输入：milestones = [5,2,1]
 * 输出：7
 * 解释：一种可能的情形是：
 * - 第 1 周，你参与并完成项目 0 中的一个阶段任务。
 * - 第 2 周，你参与并完成项目 1 中的一个阶段任务。
 * - 第 3 周，你参与并完成项目 0 中的一个阶段任务。
 * - 第 4 周，你参与并完成项目 1 中的一个阶段任务。
 * - 第 5 周，你参与并完成项目 0 中的一个阶段任务。
 * - 第 6 周，你参与并完成项目 2 中的一个阶段任务。
 * - 第 7 周，你参与并完成项目 0 中的一个阶段任务。
 * 总周数是 7 。
 * 注意，你不能在第 8 周参与完成项目 0 中的最后一个阶段任务，因为这会违反规则。
 * 因此，项目 0 中会有一个阶段任务维持未完成状态。
 * <p>
 * 提示：
 * <p>
 * n == milestones.length
 * 1 <= n <= 105
 * 1 <= milestones[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-weeks-for-which-you-can-work/description/?envType=daily-question&envId=2024-05-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1953_NumberOfWeeks {
    public static void main(String[] args) {
        L1953_NumberOfWeeks l1953NumberOfWeeks = new L1953_NumberOfWeeks();
        System.out.println(l1953NumberOfWeeks.numberOfWeeks(new int[]{5, 7, 5, 7, 9, 7}));
    }

    public long numberOfWeeks(int[] milestones) {
        //假设最大的能被消耗掉，那么说明所有的任务都能被消耗掉
        //为什么？
        //假设 第一个元素 长度是是5，并且是数组中最大的，那么其会产生6个间隙，然后至少需要4个不同的元素才能执行完毕
        //假设执行成功，那么新的数组长度为10，那么会生产11个间隙，那么就支持插入11个新元素
        //那么我们回到上面，我们是从数组中找到最大 然后执行拼接，那么新元素一定小于5
        long maxValue = 0;
        long count = 0;
        for (int milestone : milestones) {
            maxValue = Math.max(maxValue, milestone);
            count += milestone;
        }
        if (count - maxValue >= maxValue) {
            //说明能消耗掉最值
            return count;
        } else {
            return (count - maxValue) * 2L +1;
        }
    }
}
