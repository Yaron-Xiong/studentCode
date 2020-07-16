package com.accompnay.leetcode;

import java.util.HashSet;
import java.util.Set;

 /**
 * 41.给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,-2,-5};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int num : nums) {
            set.add(num);
            max = Math.max(num, max);
        }
        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }
}
