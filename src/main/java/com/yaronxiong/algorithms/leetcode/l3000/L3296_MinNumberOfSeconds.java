package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3296. 移山所需的最少秒数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 mountainHeight 表示山的高度。
 * <p>
 * 同时给你一个整数数组 workerTimes，表示工人们的工作时间（单位：秒）。
 * <p>
 * 工人们需要 同时 进行工作以 降低 山的高度。对于工人 i :
 * <p>
 * 山的高度降低 x，需要花费 workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x 秒。例如：
 * 山的高度降低 1，需要 workerTimes[i] 秒。
 * 山的高度降低 2，需要 workerTimes[i] + workerTimes[i] * 2 秒，依此类推。
 * 返回一个整数，表示工人们使山的高度降低到 0 所需的 最少 秒数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： mountainHeight = 4, workerTimes = [2,1,1]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 将山的高度降低到 0 的一种方式是：
 * <p>
 * 工人 0 将高度降低 1，花费 workerTimes[0] = 2 秒。
 * 工人 1 将高度降低 2，花费 workerTimes[1] + workerTimes[1] * 2 = 3 秒。
 * 工人 2 将高度降低 1，花费 workerTimes[2] = 1 秒。
 * 因为工人同时工作，所需的最少时间为 max(2, 3, 1) = 3 秒。
 * <p>
 * 示例 2：
 * <p>
 * 输入： mountainHeight = 10, workerTimes = [3,2,2,4]
 * <p>
 * 输出： 12
 * <p>
 * 解释：
 * <p>
 * 工人 0 将高度降低 2，花费 workerTimes[0] + workerTimes[0] * 2 = 9 秒。
 * 工人 1 将高度降低 3，花费 workerTimes[1] + workerTimes[1] * 2 + workerTimes[1] * 3 = 12 秒。
 * 工人 2 将高度降低 3，花费 workerTimes[2] + workerTimes[2] * 2 + workerTimes[2] * 3 = 12 秒。
 * 工人 3 将高度降低 2，花费 workerTimes[3] + workerTimes[3] * 2 = 12 秒。
 * 所需的最少时间为 max(9, 12, 12, 12) = 12 秒。
 * <p>
 * 示例 3：
 * <p>
 * 输入： mountainHeight = 5, workerTimes = [1]
 * <p>
 * 输出： 15
 * <p>
 * 解释：
 * <p>
 * 这个示例中只有一个工人，所以答案是 workerTimes[0] + workerTimes[0] * 2 + workerTimes[0] * 3 + workerTimes[0] * 4 + workerTimes[0] * 5 = 15 秒。
 * <p>
 * 提示：
 * <p>
 * 1 <= mountainHeight <= 105
 * 1 <= workerTimes.length <= 104
 * 1 <= workerTimes[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-seconds-to-make-mountain-height-zero/description/?envType=daily-question&envId=2026-03-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3296_MinNumberOfSeconds {
    public static void main(String[] args) {
        L3296_MinNumberOfSeconds l3296MinNumberOfSeconds = new L3296_MinNumberOfSeconds();
        System.out.println(l3296MinNumberOfSeconds.minNumberOfSeconds(5, new int[]{1}));
        System.out.println(l3296MinNumberOfSeconds.minNumberOfSeconds(10, new int[]{3, 2, 2, 4}));
        System.out.println(l3296MinNumberOfSeconds.minNumberOfSeconds(4, new int[]{2, 1, 1}));
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        //二分答案
        int maxWorkerTimes = 0;
        for (int t : workerTimes) {
            maxWorkerTimes = Math.max(maxWorkerTimes, t);
        }
        long left = 0;
        long right = (long) maxWorkerTimes * mountainHeight * (mountainHeight + 1) / 2;
        while (left < right) {
            long mid = left + (right - left) / 2;
            boolean check = check2(mid, mountainHeight, workerTimes);
            if (check) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check2(long target, int mountainHeight, int[] workerTimes) {
        //每个工人最多工作target秒
        long cnt = 0;
        for (int workerTime : workerTimes) {
            long work = target / workerTime;
            long k = (long) ((-1.0 + Math.sqrt(1 + (work * 8))) / 2);
            cnt += k;
            if (cnt >= mountainHeight) {
                return true;
            }
        }
        return false;
    }
}
