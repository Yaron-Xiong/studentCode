package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3115. 质数的最大距离
 * 算术评级: 3
 * 第 393 场周赛
 * Q2
 * 1294
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4,2,9,5,3]
 * <p>
 * 输出： 3
 * <p>
 * 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [4,8,2,8]
 * <p>
 * 输出： 0
 * <p>
 * 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 105
 * 1 <= nums[i] <= 100
 * 输入保证 nums 中至少有一个质数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-prime-difference/description/?envType=daily-question&envId=2024-07-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3115_MaximumPrimeDifference {
    private final static int MX = (int) 1e5;
    private final static boolean[] np = new boolean[MX + 1]; // 质数=false 非质数=true

    static {
        np[1] = true;
        for (int i = 2; i * i <= MX; i++) {
            if (!np[i]) {
                for (int j = i * i; j <= MX; j += i) {
                    np[j] = true;
                }
            }
        }
    }

    public int maximumPrimeDifference(int[] nums) {
        //如何判断一个数是不是质数？
        int left = nums.length;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!np[nums[i]]) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        return right - left;
    }
}
