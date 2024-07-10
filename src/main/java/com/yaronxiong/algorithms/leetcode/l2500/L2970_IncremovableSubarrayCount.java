package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2970. 统计移除递增子数组的数目 I
 * 算术评级: 2
 * 第 120 场双周赛
 * Q1
 * 1563
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
 * 解释：10 个移除递增子数组分别为：[1], [2], [3], [4], [1,2], [2,3], [3,4], [1,2,3], [2,3,4] 和 [1,2,3,4]。
 * 移除任意一个子数组后，剩余元素都是递增的。注意，空数组不是移除递增子数组。
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
 * 解释：3 个移除递增子数组分别为：[8,7,6], [7,6,6] 和 [8,7,6,6] 。
 * 注意 [8,7] 不是移除递增子数组因为移除 [8,7] 后 nums 变为 [6,6] ，它不是严格递增的。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-i/description/?envType=daily-question&envId=2024-07-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2970_IncremovableSubarrayCount {
    public static void main(String[] args) {
        L2970_IncremovableSubarrayCount l2970IncremovableSubarrayCount = new L2970_IncremovableSubarrayCount();
        System.out.println(l2970IncremovableSubarrayCount.incremovableSubarrayCount(new int[]{6, 5, 7, 8}));
    }

    public int incremovableSubarrayCount(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                //假设移除(i,j) 看剩下元素是不是有序的
                //左边是否有序
                if (!check(nums, 0, i - 1, -1)) {
                    continue;
                }
                if (!check(nums, j + 1, nums.length - 1, i == 0 ? -1 : nums[i - 1])) {
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }

    public boolean check(int[] nums, int left, int right, int preValue) {
        if (left < 0 || right < left || right >= nums.length) {
            return true;
        }
        for (int i = left; i <= right; i++) {
            if (nums[i] <= preValue) {
                return false;
            }
            preValue = nums[i];
        }
        return true;
    }
}
