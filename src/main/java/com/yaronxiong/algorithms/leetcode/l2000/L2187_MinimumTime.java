package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2187. 完成旅途的最少时间
 * 算术评级: 5
 * 第 282 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1641
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。
 * <p>
 * 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在运行且互不影响。
 * <p>
 * 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = [1,2,3], totalTrips = 5
 * 输出：3
 * 解释：
 * - 时刻 t = 1 ，每辆公交车完成的旅途数分别为 [1,0,0] 。
 * 已完成的总旅途数为 1 + 0 + 0 = 1 。
 * - 时刻 t = 2 ，每辆公交车完成的旅途数分别为 [2,1,0] 。
 * 已完成的总旅途数为 2 + 1 + 0 = 3 。
 * - 时刻 t = 3 ，每辆公交车完成的旅途数分别为 [3,1,1] 。
 * 已完成的总旅途数为 3 + 1 + 1 = 5 。
 * 所以总共完成至少 5 趟旅途的最少时间为 3 。
 * 示例 2：
 * <p>
 * 输入：time = [2], totalTrips = 1
 * 输出：2
 * 解释：
 * 只有一辆公交车，它将在时刻 t = 2 完成第一趟旅途。
 * 所以完成 1 趟旅途的最少时间为 2 。
 * <p>
 * 提示：
 * <p>
 * 1 <= time.length <= 105
 * 1 <= time[i], totalTrips <= 107
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-time-to-complete-trips/description/?envType=daily-question&envId=2024-10-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2187_MinimumTime {
    public static void main(String[] args) {
        L2187_MinimumTime l2187MinimumTime = new L2187_MinimumTime();
        int[] time = {39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50, 13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100, 15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26, 63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25};
        System.out.println(l2187MinimumTime.minimumTime(time, 4187));
    }

    public long minimumTime(int[] time, int totalTrips) {
        //二分答案
        long right = Long.MAX_VALUE;
        long left = 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            //如果使用Mid分钟 能够跑多少趟？
            if (check(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] time, long useTime, int totalTrips) {
        long ans = 0;
        for (int i : time) {
            ans += useTime / i;
            if (ans >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
