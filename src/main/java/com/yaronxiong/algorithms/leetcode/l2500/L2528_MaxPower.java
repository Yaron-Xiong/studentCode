package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 2528. 最大化城市的最小电量
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 n 的整数数组 stations ，其中 stations[i] 表示第 i 座城市的供电站数目。
 * <p>
 * 每个供电站可以在一定 范围 内给所有城市提供电力。换句话说，如果给定的范围是 r ，在城市 i 处的供电站可以给所有满足 |i - j| <= r 且 0 <= i, j <= n - 1 的城市 j 供电。
 * <p>
 * |x| 表示 x 的 绝对值 。比方说，|7 - 5| = 2 ，|3 - 10| = 7 。
 * 一座城市的 电量 是所有能给它供电的供电站数目。
 * <p>
 * 政府批准了可以额外建造 k 座供电站，你需要决定这些供电站分别应该建在哪里，这些供电站与已经存在的供电站有相同的供电范围。
 * <p>
 * 给你两个整数 r 和 k ，如果以最优策略建造额外的发电站，返回所有城市中，最小电量的最大值是多少。
 * <p>
 * 这 k 座供电站可以建在多个城市。
 * <p>
 * 示例 1：
 * <p>
 * 输入：stations = [1,2,4,5,0], r = 1, k = 2
 * 输出：5
 * 解释：
 * 最优方案之一是把 2 座供电站都建在城市 1 。
 * 每座城市的供电站数目分别为 [1,4,4,5,0] 。
 * - 城市 0 的供电站数目为 1 + 4 = 5 。
 * - 城市 1 的供电站数目为 1 + 4 + 4 = 9 。
 * - 城市 2 的供电站数目为 4 + 4 + 5 = 13 。
 * - 城市 3 的供电站数目为 5 + 4 = 9 。
 * - 城市 4 的供电站数目为 5 + 0 = 5 。
 * 供电站数目最少是 5 。
 * 无法得到更优解，所以我们返回 5 。
 * 示例 2：
 * <p>
 * 输入：stations = [4,4,4,4], r = 0, k = 3
 * 输出：4
 * 解释：
 * 无论如何安排，总有一座城市的供电站数目是 4 ，所以最优解是 4 。
 * <p>
 * 提示：
 * <p>
 * n == stations.length
 * 1 <= n <= 105
 * 0 <= stations[i] <= 105
 * 0 <= r <= n - 1
 * 0 <= k <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximize-the-minimum-powered-city/description/?envType=daily-question&envId=2025-11-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2528_MaxPower {
    public static void main(String[] args) {
        L2528_MaxPower l2528MaxPower = new L2528_MaxPower();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(100000);
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(l2528MaxPower.maxPower(array, 99999, 1000000000));
        System.out.println(l2528MaxPower.maxPower(new int[]{13, 12, 8, 14, 7}, 2, 23));
        System.out.println(l2528MaxPower.maxPower(new int[]{4, 2}, 1, 1));
        System.out.println(l2528MaxPower.maxPower(new int[]{1}, 0, 0));
        System.out.println(l2528MaxPower.maxPower(new int[]{4, 4, 4, 4}, 0, 3));
        System.out.println(l2528MaxPower.maxPower(new int[]{1, 2, 4, 5, 0}, 1, 2));
    }

    public long maxPower(int[] stations, int r, int k) {
        //前缀和 方便获取 某个区间的和
        long[] preSum = new long[stations.length + 1];
        for (int i = 0; i < stations.length; i++) {
            preSum[i + 1] = preSum[i] + stations[i];
        }

        //每个站点的初始电量
        long[] power = new long[stations.length];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < power.length; i++) {
            int right = Math.min(i + r + 1, preSum.length - 1);
            int left = Math.max(i - r, 0);
            power[i] = preSum[right] - preSum[left];
            min = Math.min(min, power[i]);
        }

        //二分检查
        long left = min + (k / stations.length);
        long right = min + k + 1;
        while (left + 1 < right) {
            long mid = (left + right) >> 1;
            boolean b = check(power, mid, r, k);
            if (b) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(long[] power, long target, int r, int k) {
        //尝试将power中所有的节点值 变成 >= target
        long[] diffArr = new long[power.length + 1];
        long sum = 0;
        for (int i = 0; i < power.length; i++) {
            sum += diffArr[i];
            long curPower = sum + power[i];
            if (curPower >= target) {
                continue;
            }
            //差值
            long diff = target - curPower;
            if (diff > k) {
                return false;
            }
            k -= (int) diff;
            //将i+r+r的位置加上diff
            sum += diff;
            diffArr[Math.min(i + r + r + 1, diffArr.length - 1)] -= diff;
        }
        return true;
    }
}
