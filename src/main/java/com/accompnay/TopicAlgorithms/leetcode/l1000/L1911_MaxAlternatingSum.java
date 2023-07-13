package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 1911. 最大子序列交替和
 * 提示
 * 中等
 * 82
 * 相关企业
 * 一个下标从 0 开始的数组的 交替和 定义为 偶数 下标处元素之 和 减去 奇数 下标处元素之 和 。
 * <p>
 * 比方说，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。
 * 给你一个数组 nums ，请你返回 nums 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。
 * <p>
 * 一个数组的 子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。
 * 比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的一个子序列（加粗元素），但是 [2,4,2] 不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,5,3]
 * 输出：7
 * 解释：最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,7,8]
 * 输出：8
 * 解释：最优子序列为 [8] ，交替和为 8 。
 * 示例 3：
 * <p>
 * 输入：nums = [6,2,1,2,4,5]
 * 输出：10
 * 解释：最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-alternating-subsequence-sum/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1911_MaxAlternatingSum {
    public static void main(String[] args) {
        L1911_MaxAlternatingSum l1911MaxAlternatingSum = new L1911_MaxAlternatingSum();
        System.out.println(l1911MaxAlternatingSum.maxAlternatingSum(new int[]{6, 2, 1, 2, 4, 5}));
    }

    public long maxAlternatingSum(int[] nums) {
        //奇数是减去
        long preOddMax = 0;
        //偶数是加上
        long preEvenMax = nums[0];
        long res = preEvenMax;
        for (int i = 1; i < nums.length; i++) {
            long oddMax = Math.max(0, preEvenMax - nums[i]);
            long evenMax = preOddMax + nums[i];
            preEvenMax = Math.max(evenMax, preEvenMax);
            preOddMax = Math.max(oddMax, preOddMax);
            res = Math.max(evenMax, res);
        }
        return res;
    }

}
