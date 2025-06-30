package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 594. 最长和谐子序列
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 给你一个整数数组 nums ，请你在所有可能的 子序列 中找到最长的和谐子序列的长度。
 * <p>
 * 数组的 子序列 是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 最长和谐子序列是 [3,2,2,2,3]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 最长和谐子序列是 [1,2]，[2,3] 和 [3,4]，长度都为 2。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 不存在和谐子序列。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-harmonious-subsequence/description/?envType=daily-question&envId=2025-06-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L594_FindLHS {
    public static void main(String[] args) {
        L594_FindLHS l594FindLHS = new L594_FindLHS();
        //3.2.2.2.3
        System.out.println(l594FindLHS.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int preNum = nums[0];
        int curCnt = 1;
        int preCnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                curCnt++;
            } else {
                preNum = nums[i - 1];
                preCnt = curCnt;
                curCnt = 1;
            }

            if (nums[i] - preNum == 1) {
                ans = Math.max(ans, curCnt + preCnt);
            }
        }
        return ans;
    }
}
