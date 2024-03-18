package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2789. 合并后数组中的最大元素
 * 第 355 场周赛
 * Q2
 * 1485
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、由正整数组成的数组 nums 。
 * <p>
 * 你可以在数组上执行下述操作 任意 次：
 * <p>
 * 选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。
 * 将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1] ，并从数组中删除元素 nums[i] 。
 * 返回你可以从最终数组中获得的 最大 元素的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,7,9,3]
 * 输出：21
 * 解释：我们可以在数组上执行下述操作：
 * - 选中 i = 0 ，得到数组 nums = [5,7,9,3] 。
 * - 选中 i = 1 ，得到数组 nums = [5,16,3] 。
 * - 选中 i = 0 ，得到数组 nums = [21,3] 。
 * 最终数组中的最大元素是 21 。可以证明我们无法获得更大的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [5,3,3]
 * 输出：11
 * 解释：我们可以在数组上执行下述操作：
 * - 选中 i = 1 ，得到数组 nums = [5,6] 。
 * - 选中 i = 0 ，得到数组 nums = [11] 。
 * 最终数组中只有一个元素，即 11 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/largest-element-in-an-array-after-merge-operations/?envType=daily-question&envId=2024-03-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2789_MaxArrayValue {
    public static void main(String[] args) {
        L2789_MaxArrayValue l2789MaxArrayValue = new L2789_MaxArrayValue();
        System.out.println(l2789MaxArrayValue.maxArrayValue(new int[]{2, 3, 7, 9, 3}));
    }

    public long maxArrayValue(int[] nums) {
        long ans = nums[nums.length - 1];
        long sum = ans; //记录右边最大连续和
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= sum) {
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }


}
