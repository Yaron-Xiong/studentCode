package com.yaronxiong.algorithms.swordFingerOffer.search;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I :
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 提示：
 * nums是一个非递减数组
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S53_Search_I {
    public int search(int[] nums, int target) {
        //搜索左边界
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target <= nums[mid]) {
                right = mid;
            }
        }
        int leftResult = right;
        // 搜索右边界
        left = leftResult;
        right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            }
        }
        return left - leftResult;
    }

    public static void main(String[] args) {
        S53_Search_I search_i = new S53_Search_I();
        int count = search_i.search(new int[]{5, 7, 8, 8, 8, 10}, 1);
        System.out.println(count);
    }
}
