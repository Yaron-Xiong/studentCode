package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.HashMap;
import java.util.Map;

/**
 * 3046. 分割数组
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 偶数 的整数数组 nums 。你需要将这个数组分割成 nums1 和 nums2 两部分，要求：
 * <p>
 * nums1.length == nums2.length == nums.length / 2 。
 * nums1 应包含 互不相同 的元素。
 * nums2也应包含 互不相同 的元素。
 * 如果能够分割数组就返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,3,4]
 * 输出：true
 * 解释：分割 nums 的可行方案之一是 nums1 = [1,2,3] 和 nums2 = [1,2,4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：false
 * 解释：分割 nums 的唯一可行方案是 nums1 = [1,1] 和 nums2 = [1,1] 。但 nums1 和 nums2 都不是由互不相同的元素构成。因此，返回 false 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/split-the-array/description/?envType=daily-question&envId=2024-12-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3046_IsPossibleToSplit {
    public boolean isPossibleToSplit(int[] nums) {
        int[] arr = new int[101];
        for (int i = 0; i < nums.length; i++) {
            if (++arr[nums[i]] > 2) {
                return false;
            }
        }
        return true;
    }
}
