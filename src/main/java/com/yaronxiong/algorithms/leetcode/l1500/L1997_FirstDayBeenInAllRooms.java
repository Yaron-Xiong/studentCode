package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1997. 访问完所有房间的第一天
 * 第 257 场周赛
 * Q3
 * 2260
 * 相关标签
 * 相关企业
 * 提示
 * 你需要访问 n 个房间，房间从 0 到 n - 1 编号。同时，每一天都有一个日期编号，从 0 开始，依天数递增。你每天都会访问一个房间。
 * <p>
 * 最开始的第 0 天，你访问 0 号房间。给你一个长度为 n 且 下标从 0 开始 的数组 nextVisit 。在接下来的几天中，你访问房间的 次序 将根据下面的 规则 决定：
 * <p>
 * 假设某一天，你访问 i 号房间。
 * 如果算上本次访问，访问 i 号房间的次数为 奇数 ，那么 第二天 需要访问 nextVisit[i] 所指定的房间，其中 0 <= nextVisit[i] <= i 。
 * 如果算上本次访问，访问 i 号房间的次数为 偶数 ，那么 第二天 需要访问 (i + 1) mod n 号房间。
 * 请返回你访问完所有房间的第一天的日期编号。题目数据保证总是存在这样的一天。由于答案可能很大，返回对 109 + 7 取余后的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nextVisit = [0,0]
 * 输出：2
 * 解释：
 * - 第 0 天，你访问房间 0 。访问 0 号房间的总次数为 1 ，次数为奇数。
 * 下一天你需要访问房间的编号是 nextVisit[0] = 0
 * - 第 1 天，你访问房间 0 。访问 0 号房间的总次数为 2 ，次数为偶数。
 * 下一天你需要访问房间的编号是 (0 + 1) mod 2 = 1
 * - 第 2 天，你访问房间 1 。这是你第一次完成访问所有房间的那天。
 * 示例 2：
 * <p>
 * 输入：nextVisit = [0,0,2]
 * 输出：6
 * 解释：
 * 你每天访问房间的次序是 [0,0,1,0,0,1,2,...] 。
 * 第 6 天是你访问完所有房间的第一天。
 * 示例 3：
 * <p>
 * 输入：nextVisit = [0,1,2,0]
 * 输出：6
 * 解释：
 * 你每天访问房间的次序是 [0,0,1,1,2,2,3,...] 。
 * 第 6 天是你访问完所有房间的第一天。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nextVisit.length
 * 2 <= n <= 105
 * 0 <= nextVisit[i] <= i
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/first-day-where-you-have-been-in-all-the-rooms/description/?envType=daily-question&envId=2024-03-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1997_FirstDayBeenInAllRooms {
    public static void main(String[] args) {
        L1997_FirstDayBeenInAllRooms l1997FirstDayBeenInAllRooms = new L1997_FirstDayBeenInAllRooms();
        System.out.println(l1997FirstDayBeenInAllRooms.firstDayBeenInAllRooms(new int[]{0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 27, 28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34, 35, 35, 36, 36, 37, 37, 38, 38, 39, 39, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48}));
    }

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        //假设
        // 第一次抵达第i个房间的 天数为f(i)
        // 第二次抵达第i个房间的 天数为q(i)
        //从题目已知   q(i-1) = f(i-1) + f(i-1) - f(nextVisit[i-1]) + 1
        // f(i) = q(i-1) + 1
        //      = f(i-1) + f(i-1) - f(nextVisit[i-1]) + 1  + 1
        //      = 2 * f(i-1) - f(nextVisit[i-1])+2
        int n = nextVisit.length;
        long[] dp = new long[n];
        long MOD = (long) (1e9 + 7);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = (2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2 + MOD) % MOD;
        }
        return (int) dp[n - 1];
    }
}
