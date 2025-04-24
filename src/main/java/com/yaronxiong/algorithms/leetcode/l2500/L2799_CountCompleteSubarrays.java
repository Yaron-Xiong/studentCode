package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 2799. 统计完全子数组的数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由 正 整数组成的数组 nums 。
 * <p>
 * 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
 * <p>
 * 子数组中 不同 元素的数目等于整个数组不同元素的数目。
 * 返回数组中 完全子数组 的数目。
 * <p>
 * 子数组 是数组中的一个连续非空序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1,2,2]
 * 输出：4
 * 解释：完全子数组有：[1,3,1,2]、[1,3,1,2,2]、[3,1,2] 和 [3,1,2,2] 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,5,5,5]
 * 输出：10
 * 解释：数组仅由整数 5 组成，所以任意子数组都满足完全子数组的条件。子数组的总数为 10 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-complete-subarrays-in-an-array/description/?envType=daily-question&envId=2025-04-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2799_CountCompleteSubarrays {
    public static void main(String[] args) {
        L2799_CountCompleteSubarrays l2799CountCompleteSubarrays = new L2799_CountCompleteSubarrays();
        System.out.println(l2799CountCompleteSubarrays.countCompleteSubarrays(new int[]{1, 3, 1, 2, 2}));
    }

    public int countCompleteSubarrays(int[] nums) {
        //滑动窗口
        int differentCnt = 0;
        int[] arr = new int[2001];
        for (int num : nums) {
            if (++arr[num]  == 1){
                differentCnt++;
            }
        }
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            //尝试收回左边界
            while (map.getOrDefault(nums[left], 0) > 1) {
                if (map.merge(nums[left], -1, Integer::sum) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            if (map.size() == differentCnt) {
                ans += left + 1;
            }
        }
        return ans;
    }
}
