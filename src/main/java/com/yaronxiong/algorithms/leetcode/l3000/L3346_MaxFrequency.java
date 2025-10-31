package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3346. 执行操作后元素的最高频率 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和两个整数 k 和 numOperations 。
 * <p>
 * 你必须对 nums 执行 操作  numOperations 次。每次操作中，你可以：
 * <p>
 * 选择一个下标 i ，它在之前的操作中 没有 被选择过。
 * 将 nums[i] 增加范围 [-k, k] 中的一个整数。
 * 在执行完所有操作以后，请你返回 nums 中出现 频率最高 元素的出现次数。
 * <p>
 * 一个元素 x 的 频率 指的是它在数组中出现的次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,5], k = 1, numOperations = 2
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 通过以下操作得到最高频率 2 ：
 * <p>
 * 将 nums[1] 增加 0 ，nums 变为 [1, 4, 5] 。
 * 将 nums[2] 增加 -1 ，nums 变为 [1, 4, 4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,11,20,20], k = 5, numOperations = 1
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 通过以下操作得到最高频率 2 ：
 * <p>
 * 将 nums[1] 增加 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 0 <= k <= 105
 * 0 <= numOperations <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-frequency-of-an-element-after-performing-operations-i/description/?envType=daily-question&envId=2025-10-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3346_MaxFrequency {
    public static void main(String[] args) {
        L3346_MaxFrequency l3346MaxFrequency = new L3346_MaxFrequency();
        System.out.println(l3346MaxFrequency.maxFrequency(new int[]{88, 53}, 27, 2));
        System.out.println(l3346MaxFrequency.maxFrequency(new int[]{4, 39, 51}, 26, 1));
        System.out.println(l3346MaxFrequency.maxFrequency(new int[]{5, 11, 20, 20}, 5, 1));
        System.out.println(l3346MaxFrequency.maxFrequency(new int[]{37, 30, 37}, 26, 1));
        System.out.println(l3346MaxFrequency.maxFrequency(new int[]{1, 4, 5}, 1, 2));
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        int ans = 0;
        Map<Integer, Integer> numCount = new HashMap<>();

        int lastNumIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[lastNumIndex]) {
                numCount.put(nums[lastNumIndex], i - lastNumIndex);
                ans = Math.max(ans, i - lastNumIndex);
                lastNumIndex = i;
            }
        }

        numCount.put(nums[lastNumIndex], nums.length - lastNumIndex);
        ans = Math.max(ans, nums.length - lastNumIndex);

        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            int l = leftBound(nums, i - k);
            int r = rightBound(nums, i + k);
            int tempAns;
            if (numCount.containsKey(i)) {
                tempAns = Math.min(r - l + 1, numCount.get(i) + numOperations);
            } else {
                tempAns = Math.min(r - l + 1, numOperations);
            }
            ans = Math.max(ans, tempAns);
        }

        return ans;
    }

    private int leftBound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int rightBound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > value) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }


}
