package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2760. 最长奇偶子数组
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。
 * <p>
 * 请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
 * <p>
 * nums[l] % 2 == 0
 * 对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
 * 对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
 * 以整数形式返回满足题目要求的最长子数组的长度。
 * <p>
 * 注意：子数组 是数组中的一个连续非空元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,5,4], threshold = 5
 * 输出：3
 * 解释：在这个示例中，我们选择从 l = 1 开始、到 r = 3 结束的子数组 => [2,5,4] ，满足上述条件。
 * 因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2], threshold = 2
 * 输出：1
 * 解释：
 * 在这个示例中，我们选择从 l = 1 开始、到 r = 1 结束的子数组 => [2] 。
 * 该子数组满足上述全部条件。可以证明 1 是满足题目要求的最大长度。
 * 示例 3：
 * <p>
 * 输入：nums = [2,3,4,5], threshold = 4
 * 输出：3
 * 解释：
 * 在这个示例中，我们选择从 l = 0 开始、到 r = 2 结束的子数组 => [2,3,4] 。
 * 该子数组满足上述全部条件。
 * 因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= threshold <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/description/?envType=daily-question&envId=2023-11-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2760_LongestAlternatingSubarray {
    public static void main(String[] args) {
        L2760_LongestAlternatingSubarray l2760LongestAlternatingSubarray = new L2760_LongestAlternatingSubarray();
        System.out.println(l2760LongestAlternatingSubarray.longestAlternatingSubarray(new int[]{2, 8}, 4));
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int left = 0;
        int ans = 0;
        while (left < nums.length) {
            //找到第一个符合的left
            if (nums[left] % 2 != 0 || nums[left] > threshold) {
                left++;
                continue;
            }
            int right = left + 1;
            while (right < nums.length && nums[right] <= threshold && nums[right] % 2 != nums[right - 1] % 2) {
                right++;
            }
            ans = Math.max(ans, right - left);
            left++;
        }
        return ans;
    }

}
