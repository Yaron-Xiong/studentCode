package com.yaronxiong.algorithms.practiceSet.list.binarysearch;

/**
 * 记录不同分类的二分搜索
 */
public class SearchDemo {
    public static void main(String[] args) {
        SearchDemo searchDemo = new SearchDemo();
        int[] nums = {1, 2, 2, 2, 2, 2, 3, 4, 5, 5, 5, 5, 5,6, 7, 8, 9, 10, 11};
        //int[] nums = new int[]{1};
        int target = 5;
        int leftIndex = searchDemo.searchLeft(nums, target);
        int targetIndex = searchDemo.searchTarget(nums, target);
        int rightIndex = searchDemo.searchRight(nums, target);
        System.out.println("Left index of " + target + ": " + leftIndex);
        System.out.println("Target index of " + target + ": " + targetIndex);
        System.out.println("Right index of " + target + ": " + rightIndex);
    }

    /**
     * 查询最右边的 target 下标，如果没有则返回第一个大于 target 的下标
     */
    public int searchRight(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (target >= nums[mid]) {
                //满足条件左移
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    /**
     * 查询最左边的 target 下标 如果没有则返回第一个小于 target 的下标
     */
    public int searchLeft(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (target <= nums[mid]) {
                //说明不满足 尝试缩小右边
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    /**
     * 精准查找 target 的下标 不管是第几个
     */
    public int searchTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
