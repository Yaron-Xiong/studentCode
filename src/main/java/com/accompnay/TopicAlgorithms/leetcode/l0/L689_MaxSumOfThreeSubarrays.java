package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 689. 三个无重叠子数组的最大和
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且全部数字和（3 * k 项）最大的子数组，并返回这三个子数组。
 * <p>
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,2,6,7,5,1], k = 2
 * 输出：[0,3,5]
 * 解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
 * 也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
 * 输出：[0,2,4]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] < 216
 * 1 <= k <= floor(nums.length / 3)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-sum-of-3-non-overlapping-subarrays/description/?envType=daily-question&envId=2023-11-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L689_MaxSumOfThreeSubarrays {
    public static void main(String[] args) {
        L689_MaxSumOfThreeSubarrays l689MaxSumOfThreeSubarrays = new L689_MaxSumOfThreeSubarrays();
        int[] ints = l689MaxSumOfThreeSubarrays.maxSumOfThreeSubarrays(new int[]{7, 13, 20, 19, 19, 2, 10, 1, 1, 19}, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        long[][] f = new long[n + 10][4];
        for (int i = n - k + 1; i >= 1; i--) {
            for (int j = 1; j < 4; j++) {
                f[i][j] = Math.max(f[i + 1][j], f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]);
            }
        }
        int[] ans = new int[3];
        int i = 1, j = 3, idx = 0;
        while (j > 0) {
            if (f[i + 1][j] > f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]) {
                i++;
            } else {
                ans[idx++] = i - 1;
                i += k; j--;
            }
        }
        return ans;
    }

}
