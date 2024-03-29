package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2321. 拼接数组的最大分数
 * 提示
 * 困难
 * 30
 * 相关企业
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，长度都是 n 。
 * <p>
 * 你可以选择两个整数 left 和 right ，其中 0 <= left <= right < n ，接着 交换 两个子数组 nums1[left...right] 和 nums2[left...right] 。
 * <p>
 * 例如，设 nums1 = [1,2,3,4,5] 和 nums2 = [11,12,13,14,15] ，
 * 整数选择 left = 1 和 right = 2，那么 nums1 会变为 [1,12,13,4,5] 而 nums2 会变为 [11,2,3,14,15] 。
 * 你可以选择执行上述操作 一次 或不执行任何操作。
 * <p>
 * 数组的 分数 取 sum(nums1) 和 sum(nums2) 中的最大值，其中 sum(arr) 是数组 arr 中所有元素之和。
 * <p>
 * 返回 可能的最大分数 。
 * <p>
 * 子数组 是数组中连续的一个元素序列。arr[left...right] 表示子数组包含 nums 中下标 left 和 right 之间的元素（含 下标 left 和 right 对应元素）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [60,60,60], nums2 = [10,90,10]
 * 输出：210
 * 解释：选择 left = 1 和 right = 1 ，得到 nums1 = [60,90,60] 和 nums2 = [10,60,10] 。
 * 分数为 max(sum(nums1), sum(nums2)) = max(210, 80) = 210 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [20,40,20,70,30], nums2 = [50,20,50,40,20]
 * 输出：220
 * 解释：选择 left = 3 和 right = 4 ，得到 nums1 = [20,40,20,40,20] 和 nums2 = [50,20,50,70,30] 。
 * 分数为 max(sum(nums1), sum(nums2)) = max(140, 220) = 220 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [7,11,13], nums2 = [1,1,1]
 * 输出：31
 * 解释：选择不交换任何子数组。
 * 分数为 max(sum(nums1), sum(nums2)) = max(31, 3) = 31 。
 * <p>
 * 提示：
 * <p>
 * n == nums1.length == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-score-of-spliced-array/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2321_MaximumsSplicedArray {
    public static void main(String[] args) {
        L2321_MaximumsSplicedArray l2321MaximumsSplicedArray = new L2321_MaximumsSplicedArray();
        System.out.println(l2321MaximumsSplicedArray.maximumsSplicedArray(new int[]{7, 11, 13}, new int[]{1, 1, 1}));
    }

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(getMax(nums1, nums2), getMax(nums2, nums1));
    }

    private int getMax(int[] nums1, int[] nums2) {
        int[] dp = new int[nums1.length];
        int sum = nums1[0];
        dp[0] = Math.max(nums2[0] - nums1[0], 0);
        int maxDiff = dp[0];
        for (int i = 1; i < nums1.length; i++) {
            dp[i] = Math.max(dp[i - 1] + (nums2[i] - nums1[i]), 0);
            maxDiff = Math.max(dp[i], maxDiff);
            sum += nums1[i];
        }
        return sum + maxDiff;
    }
}
