package com.accompnay.algorithmCombat.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Accompany
 * LeetCode 1题
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，
 * 并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Demo2 {

    public int[] twoSum(int[] nums, int target) {
        //通过HashMap来存值
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        //将数组的值全部存入Map中
        for(int i =0 ; i<nums.length;i++) {
            map.put(nums[i], i);
        }
        //遍历数组获取目标值
        for(int i = 0; i<nums.length;i++) {
            if(map.get(target-nums[i])==null)
                continue;
            int j = map.get(target-nums[i]) ;
            if(i!=j) {
                return new int [] {i,j};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        int[] ints = demo2.twoSum(new int[]{3,3}, 6);
        System.out.println(Arrays.toString(ints));
    }
}
