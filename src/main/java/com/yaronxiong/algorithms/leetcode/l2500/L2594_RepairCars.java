package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2594. 修车的最少时间
 * 提示
 * 中等
 * 72
 * 相关企业
 * 给你一个整数数组 ranks ，表示一些机械工的 能力值 。
 * ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
 * <p>
 * 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
 * <p>
 * 请你返回修理所有汽车 最少 需要多少时间。
 * <p>
 * 注意：所有机械工可以同时修理汽车。
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranks = [4,2,3,1], cars = 10
 * 输出：16
 * 解释：
 * - 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
 * - 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
 * - 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
 * - 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * 16 分钟是修理完所有车需要的最少时间。
 * 示例 2：
 * <p>
 * 输入：ranks = [5,1,8], cars = 6
 * 输出：16
 * 解释：
 * - 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
 * - 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * - 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
 * 16 分钟时修理完所有车需要的最少时间。
 * <p>
 * 提示：
 * <p>
 * 1 <= ranks.length <= 105
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-time-to-repair-cars/?envType=daily-question&envId=2023-09-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2594_RepairCars {
    public static void main(String[] args) {
        L2594_RepairCars l2594RepairCars = new L2594_RepairCars();
        System.out.println(l2594RepairCars.repairCars(new int[]{5, 1, 8},
                6));
    }

    public long repairCars(int[] ranks, int cars) {
        int[] rankCount = new int[101];
        int minRank = ranks[0];
        for (int rank : ranks) {
            minRank = Math.min(rank, minRank);
            rankCount[rank]++;
        }
        long left = 0;
        long right = (long) minRank * cars * cars;
        while (left < right) {
            long mid = (right - left) / 2 + left;
            long repairCars = getCars(mid, rankCount);
            if (repairCars < cars) {
                //提高分钟
                left = mid + 1;
            } else if (repairCars >= cars) {
                //减少分钟
                right = mid;
            }
        }
        return left;
    }

    private long getCars(long time, int[] ranks) {
        long cars = 0;
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i] == 0) {
                continue;
            }
            double sqrt = Math.sqrt((double) time / i);
            cars += ((long) sqrt * ranks[i]);
        }
        return cars;
    }
}
