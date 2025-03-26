package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.*;

/**
 * 2597. 美丽子集的数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由正整数组成的数组 nums 和一个 正 整数 k 。
 * <p>
 * 如果 nums 的子集中，任意两个整数的绝对差均不等于 k ，则认为该子数组是一个 美丽 子集。
 * <p>
 * 返回数组 nums 中 非空 且 美丽 的子集数目。
 * <p>
 * nums 的子集定义为：可以经由 nums 删除某些元素（也可能不删除）得到的一个数组。只有在删除元素时选择的索引不同的情况下，两个子集才会被视作是不同的子集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,4,6], k = 2
 * 输出：4
 * 解释：数组 nums 中的美丽子集有：[2], [4], [6], [2, 6] 。
 * 可以证明数组 [2,4,6] 中只存在 4 个美丽子集。
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：1
 * 解释：数组 nums 中的美丽数组有：[1] 。
 * 可以证明数组 [1] 中只存在 1 个美丽子集。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 18
 * 1 <= nums[i], k <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/the-number-of-beautiful-subsets/description/?envType=daily-question&envId=2025-03-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2597_BeautifulSubsets {
    public static void main(String[] args) {
        L2597_BeautifulSubsets l2597BeautifulSubsets = new L2597_BeautifulSubsets();
        System.out.println(l2597BeautifulSubsets.beautifulSubsets(new int[]{2, 4, 6}, 2));
    }

    public int beautifulSubsets(int[] nums, int k) {
        return dfs2(0, nums, k, new HashMap<>()) - 1;
    }

    private int dfs2(int index, int[] nums, int k, Map<Integer, Integer> cntMap) {
        if (index >= nums.length) {
            return 1;
        }
        //当前位置选不选
        //不选择 index
        int ans = 0;
        ans += dfs2(index + 1, nums, k, cntMap);
        //选择index
        if (cntMap.getOrDefault(nums[index] + k, 0) == 0 && cntMap.getOrDefault(nums[index] - k, 0) == 0) {
            cntMap.merge(nums[index], 1, Integer::sum);
            ans += dfs2(index + 1, nums, k, cntMap);
            cntMap.merge(nums[index], -1, Integer::sum);
        }
        return ans;
    }
}
