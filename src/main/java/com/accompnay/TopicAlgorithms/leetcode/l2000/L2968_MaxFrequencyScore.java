package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2968. 执行操作使频率分数最大
 * 困难
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 你可以对数组执行 至多 k 次操作：
 * <p>
 * 从数组中选择一个下标 i ，将 nums[i] 增加 或者 减少 1 。
 * 最终数组的频率分数定义为数组中众数的 频率 。
 * <p>
 * 请你返回你可以得到的 最大 频率分数。
 * <p>
 * 众数指的是数组中出现次数最多的数。一个元素的频率指的是数组中这个元素的出现次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,6,4], k = 3
 * 输出：3
 * 解释：我们可以对数组执行以下操作：
 * - 选择 i = 0 ，将 nums[0] 增加 1 。得到数组 [2,2,6,4] 。
 * - 选择 i = 3 ，将 nums[3] 减少 1 ，得到数组 [2,2,6,3] 。
 * - 选择 i = 3 ，将 nums[3] 减少 1 ，得到数组 [2,2,6,2] 。
 * 元素 2 是最终数组中的众数，出现了 3 次，所以频率分数为 3 。
 * 3 是所有可行方案里的最大频率分数。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,4,2,4], k = 0
 * 输出：3
 * 解释：我们无法执行任何操作，所以得到的频率分数是原数组中众数的频率 3 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 0 <= k <= 1014
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/apply-operations-to-maximize-frequency-score/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2968_MaxFrequencyScore {
    public static void main(String[] args) {
        L2968_MaxFrequencyScore l2968MaxFrequencyScore = new L2968_MaxFrequencyScore();
        System.out.println(l2968MaxFrequencyScore.maxFrequencyScore(new int[]{1, 2, 6, 4}, 3));
    }

    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        long[] preSum = new long[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            //检查 (left,i) 区间的操作数 是否 >k
            while (distanceSum(left, i, preSum, nums) > k) {
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    private long distanceSum(int left, int right, long[] preSum, int[] nums) {
        int mid = (left + right) >> 1;
        //小于mid的值
        long leftValue = preSum[mid] - preSum[left];
        long leftCnt = (long) (mid - left) * nums[mid];
        //大于mid的值
        long rightValue = preSum[right + 1] - preSum[mid + 1];
        long rightCnt = (long) (right - mid) * nums[mid];
        //leftValue + rightValue 向 mid跃迁
        return (leftCnt - leftValue) + (rightValue - rightCnt);
    }
}
