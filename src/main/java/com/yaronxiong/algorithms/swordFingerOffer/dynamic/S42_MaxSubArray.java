package com.yaronxiong.algorithms.swordFingerOffer.dynamic;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S42_MaxSubArray {
    public static void main(String[] args) {
        S42_MaxSubArray s42MaxSubArray = new S42_MaxSubArray();
        int i = s42MaxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            dp = Math.max(nums[i], dp);
        }
        return dp;
    }

}
