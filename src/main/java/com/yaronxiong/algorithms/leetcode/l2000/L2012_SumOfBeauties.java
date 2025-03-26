package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * +
 * 2012. 数组美丽值求和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
 * <p>
 * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
 * 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
 * 0，如果上述条件全部不满足
 * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
 * - nums[1] 的美丽值等于 2
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6,4]
 * 输出：1
 * 解释：对于每个符合范围 1 <= i <= 2 的下标 i :
 * - nums[1] 的美丽值等于 1
 * - nums[2] 的美丽值等于 0
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：0
 * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
 * - nums[1] 的美丽值等于 0
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sum-of-beauty-in-the-array/description/?envType=daily-question&envId=2025-03-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2012_SumOfBeauties {
    public static void main(String[] args) {
        L2012_SumOfBeauties l2012SumOfBeauties = new L2012_SumOfBeauties();
        System.out.println(l2012SumOfBeauties.sumOfBeauties(new int[]{2,4,6,4}));
    }

    public int sumOfBeauties(int[] nums) {
        //左侧最大值
        int leftMax = nums[0];
        //右侧最小值
        int[] subMinVal = new int[nums.length];
        subMinVal[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            subMinVal[i] = Math.min(subMinVal[i + 1], nums[i]);
        }
        int rightIndex = 0;
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            //right可能是没元素了
            if (nums[i] > leftMax && nums[i] < subMinVal[i + 1]) {
                ans += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
            leftMax = Math.max(leftMax, nums[i]);
        }
        return ans;
    }
}
