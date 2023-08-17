package com.accompnay.TopicAlgorithms.swordFingerOffer.search;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S53_MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        //找到mid所在的index是否跟index一致
        while (left < right) {
            int mid = (left + right) >> 1;
            //说明left->mid 发生突变
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        S53_MissingNumber s53MissingNumber = new S53_MissingNumber();
        int number = s53MissingNumber.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9});
        System.out.println(number);
    }
}
