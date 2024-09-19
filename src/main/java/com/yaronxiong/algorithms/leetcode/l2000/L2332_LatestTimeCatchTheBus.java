package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2332. 坐上公交的最晚时间
 * 算术评级: 6
 * 第 82 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1841
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 n 的整数数组 buses ，其中 buses[i] 表示第 i 辆公交车的出发时间。
 * 同时给你一个下标从 0 开始长度为 m 的整数数组 passengers ，其中 passengers[j] 表示第 j 位乘客的到达时间。
 * 所有公交车出发的时间互不相同，所有乘客到达的时间也互不相同。
 * <p>
 * 给你一个整数 capacity ，表示每辆公交车 最多 能容纳的乘客数目。
 * <p>
 * 每位乘客都会搭乘下一辆有座位的公交车。如果你在 y 时刻到达，公交在 x 时刻出发，满足 y <= x  且公交没有满，那么你可以搭乘这一辆公交。最早 到达的乘客优先上车。
 * <p>
 * 返回你可以搭乘公交车的最晚到达公交站时间。你 不能 跟别的乘客同时刻到达。
 * <p>
 * 注意：数组 buses 和 passengers 不一定是有序的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：buses = [10,20], passengers = [2,17,18,19], capacity = 2
 * 输出：16
 * 解释：
 * 第 1 辆公交车载着第 1 位乘客。
 * 第 2 辆公交车载着你和第 2 位乘客。
 * 注意你不能跟其他乘客同一时间到达，所以你必须在第二位乘客之前到达。
 * 示例 2：
 * <p>
 * 输入：buses = [20,30,10], passengers = [19,13,26,4,25,11,21], capacity = 2
 * 输出：20
 * 解释：
 * 第 1 辆公交车载着第 4 位乘客。
 * 第 2 辆公交车载着第 6 位和第 2 位乘客。
 * 第 3 辆公交车载着第 1 位乘客和你。
 * <p>
 * 提示：
 * <p>
 * n == buses.length
 * m == passengers.length
 * 1 <= n, m, capacity <= 105
 * 2 <= buses[i], passengers[i] <= 109
 * buses 中的元素 互不相同 。
 * passengers 中的元素 互不相同 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/the-latest-time-to-catch-a-bus/description/?envType=daily-question&envId=2024-09-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2332_LatestTimeCatchTheBus {
    public static void main(String[] args) {
        L2332_LatestTimeCatchTheBus l2332LatestTimeCatchTheBus = new L2332_LatestTimeCatchTheBus();
        int[] buses = {3};
        int[] passengers = {2, 3};
        int capacity = 2;
        System.out.println(l2332LatestTimeCatchTheBus.latestTimeCatchTheBus(buses, passengers, capacity));
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int pIndex = 0;
        int curCapacity = 0;
        for (int i = 0; i < buses.length; i++) {
            curCapacity = capacity;
            while (curCapacity > 0 && pIndex < passengers.length && passengers[pIndex] <= buses[i]) {
                pIndex++;
                curCapacity--;
            }
        }
        pIndex--;
        int ans = curCapacity > 0 ? buses[buses.length - 1] : passengers[pIndex];
        while (pIndex >= 0 && ans == passengers[pIndex]) {
            ans = passengers[pIndex] - 1;
            pIndex--;
        }
        return ans;
    }
}
