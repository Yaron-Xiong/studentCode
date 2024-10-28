package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 910. 最小差值 II
 * 算术评级: 5
 * 第 103 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 2135
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums，和一个整数 k 。
 * <p>
 * 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
 * <p>
 * nums 的 分数 是 nums 中最大元素和最小元素的差值。
 * <p>
 * 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：分数 = max(nums) - min(nums) = 1 - 1 = 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：将数组变为 [2, 8] 。分数 = max(nums) - min(nums) = 8 - 2 = 6 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,3,6], k = 3
 * 输出：3
 * 解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 104
 * 0 <= k <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-range-ii/description/?envType=daily-question&envId=2024-10-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L910_SmallestRangeII {
    public static void main(String[] args) {
        L910_SmallestRangeII l910SmallestRangeII = new L910_SmallestRangeII();
        System.out.println(l910SmallestRangeII.smallestRangeII(new int[]{7, 8, 8}, 5));
    }

    public int smallestRangeII(int[] nums, int k) {
        //让元素靠近中间
        Arrays.sort(nums);
        int ans = nums[nums.length - 1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = Math.max(nums[i - 1] + k, nums[nums.length - 1] - k);
            int mn = Math.min(nums[0] + k, nums[i] - k);
            ans = Math.min(ans, mx - mn);
        }
        return ans;
    }
}
