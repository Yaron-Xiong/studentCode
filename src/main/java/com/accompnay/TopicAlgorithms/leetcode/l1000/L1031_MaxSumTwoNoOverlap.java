package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 1031. 两个非重叠子数组的最大和
 * 提示
 * 中等
 * 187
 * 相关企业
 * 给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 firstLen 和 secondLen 。
 * <p>
 * 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。
 * <p>
 * 子数组是数组的一个 连续 部分。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * 示例 2：
 * <p>
 * 输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= firstLen, secondLen <= 1000
 * 2 <= firstLen + secondLen <= 1000
 * firstLen + secondLen <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1031_MaxSumTwoNoOverlap {
    public static void main(String[] args) {
        L1031_MaxSumTwoNoOverlap l1031MaxSumTwoNoOverlap = new L1031_MaxSumTwoNoOverlap();
        System.out.println(l1031MaxSumTwoNoOverlap.maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3));
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        return Math.max(dfs(preSum, firstLen, secondLen), dfs(preSum, secondLen, firstLen));
    }

    private int dfs(int[] preSum, int firstLen, int secondLen) {
        int maxSum = 0;
        int maxLeft = 0;
        for (int i = secondLen; i + firstLen < preSum.length; i++) {
            //i-secondLen 为为了second准备的空间
            maxLeft = Math.max(maxLeft, preSum[i] - preSum[i - secondLen]);
            //i+1 ~ i+1+firstLen 是firstLen的空间
            int maxFirst = preSum[i + firstLen] - preSum[i];
            maxSum = Math.max(maxSum, maxLeft + maxFirst);
        }
        return maxSum;
    }

}
