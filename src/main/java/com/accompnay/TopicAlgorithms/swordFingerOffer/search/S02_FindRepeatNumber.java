package com.accompnay.TopicAlgorithms.swordFingerOffer.search;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S02_FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int targetIndex = nums[index];
            //如果targetIndex的值 与当前nums[index]一直说明重复
            if (targetIndex != index && nums[targetIndex] == nums[index]) {
                return nums[index];
            } else if (targetIndex == index) {
                index++;
            }else {
                swap(nums, nums[index], index);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        S02_FindRepeatNumber s02FindRepeatNumber = new S02_FindRepeatNumber();
        int repeatNumber = s02FindRepeatNumber.findRepeatNumber(arr);
        System.out.println(repeatNumber);
    }
}
