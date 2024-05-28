package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.*;

/**
 * 1673. 找出最具竞争力的子序列
 * 算术评级: 6
 * 第 217 场周赛
 * Q2
 * 1802
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 * <p>
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 * <p>
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，
 * 那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。
 * 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,3,3,5,4,9,6], k = 4
 * 输出：[2,3,3,4]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-most-competitive-subsequence/description/?envType=daily-question&envId=2024-05-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1673_MostCompetitive {
    public static void main(String[] args) {
        L1673_MostCompetitive l1673MostCompetitive = new L1673_MostCompetitive();
        int[] a = l1673MostCompetitive.mostCompetitive(new int[]{84, 10, 71, 23, 66, 61, 62, 64, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55, 8, 85, 61, 95, 71}, 24);
        System.out.println(Arrays.toString(a));
    }

    public int[] mostCompetitive(int[] nums, int k) {
        //其实只要越前面的数字越小即可
        int[] ans = new int[k];
        int ansLength = 0;
        for (int i = 0; i < nums.length; i++) {
            //寻找nums[i] 插入到ans的位置
            //插入位置的要求 剩余nums的元素需要满足
            //ans长度要求
            int value = nums[i];
            while (ansLength > 0 && value < ans[ansLength - 1] && nums.length - i + ansLength > k) {
                ansLength--;
            }
            if (ansLength < k) {
                ans[ansLength++] = value;
            }
        }
        return ans;
    }
}
