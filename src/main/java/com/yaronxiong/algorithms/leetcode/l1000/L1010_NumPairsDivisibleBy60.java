package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * 提示
 * 中等
 * 271
 * 相关企业
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 * <p>
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1010_NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        L1010_NumPairsDivisibleBy60 l1010NumPairsDivisibleBy60 = new L1010_NumPairsDivisibleBy60();
        System.out.println(l1010NumPairsDivisibleBy60.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    public int numPairsDivisibleBy60(int[] time) {
        int[] dp = new int[60];
        int res = 0;
        for (int k : time) {
            int newTime = k % 60;
            int diff = (60 - newTime) % 60;
            res += dp[diff];
            dp[newTime]++;
        }
        return res;
    }
}
