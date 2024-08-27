package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 552. 学生出勤记录 II
 * 算术评级: 7
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * 相关企业
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。
 * 答案可能很大，所以返回对 109 + 7 取余 的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：n = 10101
 * 输出：183236316
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/student-attendance-record-ii/description/?envType=daily-question&envId=2024-08-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L552_CheckRecord {
    public static void main(String[] args) {
        L552_CheckRecord l552CheckRecord = new L552_CheckRecord();
        System.out.println(l552CheckRecord.checkRecord(10101));
    }


    public int checkRecord(int n) {
        long[][][] dp = new long[n + 1][2][3];
        int MOD = 1000000007;
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;
        for (int i = 2; i <= n; i++) {
            //以P结尾 此次为准时到达
            for (int j = 0; j <= 2; j++) {
                dp[i][0][0] += dp[i - 1][0][j];
                dp[i][0][0] %= MOD;
                dp[i][1][0] += dp[i - 1][1][j];
                dp[i][1][0] %= MOD;
            }
            //以L结尾 此次为迟到
            for (int j = 1; j <= 2; j++) {
                dp[i][0][j] = dp[i - 1][0][j - 1];
                dp[i][1][j] = dp[i - 1][1][j - 1];
            }
            //以A结尾 此次为缺勤
            for (int j = 0; j <= 2; j++) {
                dp[i][1][0] += dp[i - 1][0][j];
                dp[i][1][0] %= MOD;
            }
        }
        long ans = 0;
        for (int i = 0; i < dp[n].length; i++) {
            for (int j = 0; j < dp[n][i].length; j++) {
                ans += dp[n][i][j];
                ans %= MOD;
            }
        }
        return (int) (ans % MOD);
    }

}
