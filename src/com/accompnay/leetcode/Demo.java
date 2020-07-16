package com.accompnay.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * leetcode 128
 * 给定一个无序的整数类型数组，求最长的连续元素序列的长度。
 * 例如：
 * 给出的数组为[100, 4, 200, 1, 3, 2],
 * 最长的连续元素序列为[1, 2, 3, 4]. 返回这个序列的长度：4
 * 你需要给出时间复杂度在O（n）之内的算法。语言不限。
 */
public class Demo {

    public static void main(String[] args) {
        int [] arr = new int []{100, 4, 200, 1, 3, 2};
        int result = method(arr);
        System.out.println(result);
    }

    public static int method(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int item : nums) {
            set.add(item);
        }
        int maxLen = 0;
        for (int item : nums) {
            int lItem = item - 1;
            int rItem = item + 1;
            int lLen = 0;
            int rLen = 0;
            while (set.contains(lItem)) {
                set.remove(lItem);
                ++lLen;
                --lItem;
            }
            while (set.contains(rItem)) {
                set.remove(rItem);
                ++rLen;
                ++rItem;
            }
            int itemLen = lLen + rLen + 1 ;
            maxLen = Math.max(maxLen, itemLen);
            set.remove(item);
        }
        return maxLen;
    }

}
