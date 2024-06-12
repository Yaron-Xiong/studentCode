package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 312. 戳气球
 * 算术评级: 8
 * 困难
 * 相关标签
 * 相关企业
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 * <p>
 * 输入：nums = [1,5]
 * 输出：10
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/burst-balloons/description/?envType=daily-question&envId=2024-06-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L312_MaxCoins {
    public static void main(String[] args) {
        L312_MaxCoins l312MaxCoins = new L312_MaxCoins();
        System.out.println(l312MaxCoins.maxCoins(new int[]{3, 1, 5, 8}));
    }

    public int maxCoins(int[] nums) {
        int[] newArr = new int[nums.length + 2];
        newArr[0] = 1;
        newArr[newArr.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            newArr[i + 1] = nums[i];
        }
        int[][] dp = new int[newArr.length][newArr.length];
        for (int length = 3; length <= newArr.length; length++) {
            for (int left = 0; left + length - 1 < newArr.length; left++) {
                int right = left + length - 1;
                for (int k = left + 1; k < right; k++) {
                    int i = (dp[left][k] + dp[k][right]) + (newArr[left] * newArr[right] * newArr[k]);
                    dp[left][right] = Math.max(i, dp[left][right]);
                }
            }
        }
        return dp[0][newArr.length - 1];
    }


}
