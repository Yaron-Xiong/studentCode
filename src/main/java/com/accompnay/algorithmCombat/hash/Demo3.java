package com.accompnay.algorithmCombat.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Accompany
 * LeetCode 15
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *  *  *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class Demo3 {
    /*//复杂度高的吓人
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> map =new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0)break;
            //避免重复计算
            if (i>=1&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                //避免重复计算
                if (j>=i+2&&nums[j]==nums[j-1]){
                    continue;
                }
                int r = -(nums[i]+nums[j]);
                if (map.get(r)==null) continue;
                if (map.get(r)!=i&&map.get(r)!=j&&map.get(r)>j){
                    ArrayList<Integer> rs = new ArrayList<>();
                    rs.add(nums[i]);
                    rs.add(nums[j]);
                    rs.add(r);
                    list.add(rs);
                }
            }
        }
        return list;
    }*/

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        List<List<Integer>> threeSum = demo3.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(threeSum);
    }

    private List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length-3; i++) {
            if (nums[i]>0)break;
            if (i>=1&&nums[i]==nums[i-1])continue;
            int l = i +1;
            int r = nums.length-1;
            while (l!=r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum==0){
                    ans.add(Arrays.asList(nums[i],nums[l++],nums[r]));
                    while (l<r&&nums[l]==nums[l-1])l++;
                    while (l<r&&r<nums.length-1&&nums[r]==nums[r+1])r--;
                }else if (sum<0){
                    l++;
                    while (l<r&&nums[l]==nums[l-1])l++;
                }
                else {
                    r--;
                    while (l<r&&r<nums.length-1&&nums[r]==nums[r+1])r--;
                }
            }
        }
        return ans;
    }
}
