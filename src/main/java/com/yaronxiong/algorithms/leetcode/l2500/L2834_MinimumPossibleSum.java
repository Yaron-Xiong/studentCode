package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2834. 找出美丽数组的最小和
 * 第 360 场周赛
 * Q2
 * 1409
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个正整数：n 和 target 。
 * <p>
 * 如果数组 nums 满足下述条件，则称其为 美丽数组 。
 * <p>
 * nums.length == n.
 * nums 由两两互不相同的正整数组成。
 * 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。
 * 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 109 + 7。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, target = 3
 * 输出：4
 * 解释：nums = [1,3] 是美丽数组。
 * - nums 的长度为 n = 2 。
 * - nums 由两两互不相同的正整数组成。
 * - 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
 * 可以证明 4 是符合条件的美丽数组所可能具备的最小和。
 * 示例 2：
 * <p>
 * 输入：n = 3, target = 3
 * 输出：8
 * 解释：
 * nums = [1,3,4] 是美丽数组。
 * - nums 的长度为 n = 3 。
 * - nums 由两两互不相同的正整数组成。
 * - 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
 * 可以证明 8 是符合条件的美丽数组所可能具备的最小和。
 * 示例 3：
 * <p>
 * 输入：n = 1, target = 1
 * 输出：1
 * 解释：nums = [1] 是美丽数组。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 1 <= target <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-minimum-possible-sum-of-a-beautiful-array/description/?envType=daily-question&envId=2024-03-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2834_MinimumPossibleSum {
    public static void main(String[] args) {
        L2834_MinimumPossibleSum l2834MinimumPossibleSum = new L2834_MinimumPossibleSum();
        int i = l2834MinimumPossibleSum.minimumPossibleSum(1000000000, 1000000000);
        System.out.println(i);
    }

    public int minimumPossibleSum(int n, int target) {
        long m = Math.min(n, target / 2);
        return (int) (((m * (m + 1)) + ((n - m) * (2L * target + n - m - 1))) / 2 % 1_000_000_007);
    }

}
