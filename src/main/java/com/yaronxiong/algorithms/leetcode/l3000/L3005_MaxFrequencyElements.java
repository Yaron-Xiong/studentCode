package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3005. 最大频率元素计数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由 正整数 组成的数组 nums 。
 * <p>
 * 返回数组 nums 中所有具有 最大 频率的元素的 总频率 。
 * <p>
 * 元素的 频率 是指该元素在数组中出现的次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,3,1,4]
 * 输出：4
 * 解释：元素 1 和 2 的频率为 2 ，是数组中的最大频率。
 * 因此具有最大频率的元素在数组中的数量是 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：5
 * 解释：数组中的所有元素的频率都为 1 ，是最大频率。
 * 因此具有最大频率的元素在数组中的数量是 5 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-elements-with-maximum-frequency/description/?envType=daily-question&envId=2025-09-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3005_MaxFrequencyElements {
    public static void main(String[] args) {
        L3005_MaxFrequencyElements l3005MaxFrequencyElements = new L3005_MaxFrequencyElements();
        System.out.println(l3005MaxFrequencyElements.maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
    }
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        int maxFrequency = 0;
        int ans = 0;
        for (int num : nums) {
            int merge = ++arr[num];
            if (merge > maxFrequency) {
                maxFrequency = merge;
                ans = merge;
            } else if (merge == maxFrequency) {
                ans += merge;
            }
        }
        return ans;
    }
}
