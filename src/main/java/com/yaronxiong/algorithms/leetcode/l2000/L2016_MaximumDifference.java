package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2016. 增量元素之间的最大差值
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，
 * 请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 * <p>
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [7,1,5,4]
 * 输出：4
 * 解释：
 * 最大差值出现在 i = 1 且 j = 2 时，nums[j] - nums[i] = 5 - 1 = 4 。
 * 注意，尽管 i = 1 且 j = 0 时 ，nums[j] - nums[i] = 7 - 1 = 6 > 4 ，但 i > j 不满足题面要求，所以 6 不是有效的答案。
 * 示例 2：
 * <p>
 * 输入：nums = [9,4,3,2]
 * 输出：-1
 * 解释：
 * 不存在同时满足 i < j 和 nums[i] < nums[j] 这两个条件的 i, j 组合。
 * 示例 3：
 * <p>
 * 输入：nums = [1,5,2,10]
 * 输出：9
 * 解释：
 * 最大差值出现在 i = 0 且 j = 3 时，nums[j] - nums[i] = 10 - 1 = 9 。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 2 <= n <= 1000
 * 1 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-difference-between-increasing-elements/description/?envType=daily-question&envId=2025-06-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2016_MaximumDifference {
    public static void main(String[] args) {
        int i = new L2016_MaximumDifference().maximumDifference(new int[]{7, 1, 5, 4});
        System.out.println(i);
    }
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int maxRight = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            maxRight = Math.max(maxRight, nums[i]);
            if (nums[i] >= maxRight) {
                continue;
            }
            ans = Math.max(ans, maxRight - nums[i]);
        }
        return ans;
    }
}
