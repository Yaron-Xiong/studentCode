package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2529. 正整数和负整数的最大计数
 * 第 327 场周赛
 * Q1
 * 1196
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * <p>
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,-1,-1,1,2,3]
 * 输出：3
 * 解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [-3,-2,-1,0,0,1,2]
 * 输出：3
 * 解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,20,66,1314]
 * 输出：4
 * 解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * -2000 <= nums[i] <= 2000
 * nums 按 非递减顺序 排列。
 * <p>
 * 进阶：你可以设计并实现时间复杂度为 O(log(n)) 的算法解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/?envType=daily-question&envId=2024-04-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2529_MaximumCount {

    public static void main(String[] args) {
        L2529_MaximumCount l2529MaximumCount = new L2529_MaximumCount();
        System.out.println(l2529MaximumCount.maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));
    }

    public int maximumCount(int[] nums) {
        int negCnt = getIndex(nums, 0);
        int posCnt = getIndex(nums, 1);
        //假设没有0，并且全部都是负数 那么negCnt=nums.length
        //假设没有0，并且全部都是正数 那么negCnt=0
        return Math.max(negCnt, nums.length - posCnt);
    }

    private int getIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //找0的区间
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}
