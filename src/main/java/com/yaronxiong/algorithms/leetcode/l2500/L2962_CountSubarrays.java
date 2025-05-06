package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2962. 统计最大元素出现至少 K 次的子数组
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums 和一个 正整数 k 。
 * <p>
 * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
 * <p>
 * 子数组是数组中的一个连续元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,3,3], k = 2
 * 输出：6
 * 解释：包含元素 3 至少 2 次的子数组为：[1,3,2,3]、[1,3,2,3,3]、[3,2,3]、[3,2,3,3]、[2,3,3] 和 [3,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,2,1], k = 3
 * 输出：0
 * 解释：没有子数组包含元素 4 至少 3 次。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= k <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2025-04-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2962_CountSubarrays {
    public static void main(String[] args) {
        L2962_CountSubarrays l2962CountSubarrays = new L2962_CountSubarrays();
        long l = l2962CountSubarrays.countSubarrays(new int[]{1, 3, 2, 3, 3, 2}, 2);
        System.out.println(l);
    }

    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int left = 0;
        int cnt = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                cnt++;
            }
            while (cnt == k) {
                if (nums[left] == max) {
                    cnt--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
