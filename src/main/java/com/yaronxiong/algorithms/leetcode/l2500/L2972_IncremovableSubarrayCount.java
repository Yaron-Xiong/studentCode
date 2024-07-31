package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2972. 统计移除递增子数组的数目 II
 * 算术评级: 7
 * 第 120 场双周赛
 * Q3
 * 2153
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的 正 整数数组 nums 。
 * <p>
 * 如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，那么我们称这个子数组为 移除递增 子数组。
 * 比方说，[5, 3, 4, 6, 7] 中的 [3, 4] 是一个移除递增子数组，因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。
 * <p>
 * 请你返回 nums 中 移除递增 子数组的总数目。
 * <p>
 * 注意 ，剩余元素为空的数组也视为是递增的。
 * <p>
 * 子数组 指的是一个数组中一段连续的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：10
 * 解释：10 个移除递增子数组分别为：[1], [2], [3], [4], [1,2], [2,3], [3,4], [1,2,3], [2,3,4] 和 [1,2,3,4]。移除任意一个子数组后，剩余元素都是递增的。注意，空数组不是移除递增子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [6,5,7,8]
 * 输出：7
 * 解释：7 个移除递增子数组分别为：[5], [6], [5,7], [6,5], [5,7,8], [6,5,7] 和 [6,5,7,8] 。
 * nums 中只有这 7 个移除递增子数组。
 * 示例 3：
 * <p>
 * 输入：nums = [8,7,6,6]
 * 输出：3
 * 解释：3 个移除递增子数组分别为：[8,7,6], [7,6,6] 和 [8,7,6,6] 。注意 [8,7] 不是移除递增子数组因为移除 [8,7] 后 nums 变为 [6,6] ，它不是严格递增的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-ii/?envType=daily-question&envId=2024-07-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2972_IncremovableSubarrayCount {
    public static void main(String[] args) {
        L2972_IncremovableSubarrayCount l2972IncremovableSubarrayCount = new L2972_IncremovableSubarrayCount();
        System.out.println(l2972IncremovableSubarrayCount.incremovableSubarrayCount(new int[]{1, 2, 3, 4}));
    }

    public long incremovableSubarrayCount(int[] nums) {
        int left = 0;
        int n = nums.length;
        while (left + 1 < nums.length && nums[left + 1] > nums[left]) {
            left++;
        }
        if (nums.length - 1 == left) {
            return ((long) n * n + n) / 2;
        }
        long ans = left + 2;
        for (int right = nums.length - 1; right >= 0; right--) {
            if (right + 1 < nums.length && nums[right] >= nums[right + 1]) {
                break;
            }
            //缩小left
            while (left >= 0 && nums[left] > nums[right]) {
                left--;
            }
            if (left < 0) {
                ans++;
            } else {
                ans += left + 2;
            }
        }
        return ans;
    }
}
