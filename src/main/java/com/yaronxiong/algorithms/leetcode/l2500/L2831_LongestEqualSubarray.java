package com.yaronxiong.algorithms.leetcode.l2500;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2831. 找出最长等值子数组
 * 算术评级: 6
 * 第 359 场周赛
 * Q4
 * 1976
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
 * <p>
 * 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
 * <p>
 * 子数组 是数组中一个连续且可能为空的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,3,1,3], k = 3
 * 输出：3
 * 解释：最优的方案是删除下标 2 和下标 4 的元素。
 * 删除后，nums 等于 [1, 3, 3, 3] 。
 * 最长等值子数组从 i = 1 开始到 j = 3 结束，长度等于 3 。
 * 可以证明无法创建更长的等值子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,2,1,1], k = 2
 * 输出：4
 * 解释：最优的方案是删除下标 2 和下标 3 的元素。
 * 删除后，nums 等于 [1, 1, 1, 1] 。
 * 数组自身就是等值子数组，长度等于 4 。
 * 可以证明无法创建更长的等值子数组。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= nums.length
 * 0 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-longest-equal-subarray/description/?envType=daily-question&envId=2024-05-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class L2831_LongestEqualSubarray {
    public static void main(String[] args) {
        L2831_LongestEqualSubarray l2831LongestEqualSubarray = new L2831_LongestEqualSubarray();
        int i = l2831LongestEqualSubarray.longestEqualSubarray(Lists.newArrayList(9, 7, 2, 3, 2, 4, 7, 8, 10, 2, 6, 2, 9, 9, 10, 9, 3, 2, 8, 1, 4, 3, 3, 7, 7, 8, 3, 3, 10, 8, 5, 7, 4, 6, 3, 6, 9, 8, 7), 16);
        System.out.println(i);
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        //滑动窗口
        List<Integer>[] list = new List[nums.size() + 1];
        Arrays.setAll(list, a -> new ArrayList<>());
        for (int i = 0; i < nums.size(); i++) {
            list[nums.get(i)].add(i);
        }
        int ans = 1;
        for (List<Integer> indexList : list) {
            if (indexList.size() <= ans) {
                continue;
            }
            int left = 0;
            for (int right = 0; right < indexList.size(); right++) {
                //计算k值
                while ((indexList.get(right) - indexList.get(left)) - (right - left) > k) {
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }


}
