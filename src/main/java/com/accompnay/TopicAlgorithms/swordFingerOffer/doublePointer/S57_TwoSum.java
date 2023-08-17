package com.accompnay.TopicAlgorithms.swordFingerOffer.doublePointer;

import java.util.Arrays;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i]<= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S57_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left] + nums[right];
            if (temp < target) {
                left++;
            } else if (temp > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        S57_TwoSum s57TwoSum = new S57_TwoSum();
        int[] sum = s57TwoSum.twoSum(new int[]{10, 26, 30, 31, 47, 60}, 50);
        System.out.println(Arrays.toString(sum));
    }
}
