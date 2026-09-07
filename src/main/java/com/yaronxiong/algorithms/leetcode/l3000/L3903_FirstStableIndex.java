package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3903. 最小稳定下标 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 和一个整数 k。
 * <p>
 * 对于每个下标 i，定义它的 不稳定值 为 max(nums[0..i]) - min(nums[i..n - 1])。
 * <p>
 * 换句话说：
 * <p>
 * max(nums[0..i]) 表示从下标 0 到下标 i 的元素中的 最大值 。
 * min(nums[i..n - 1]) 表示从下标 i 到下标 n - 1 的元素中的 最小值 。
 * 如果某个下标 i 的不稳定值 小于等于 k，则称该下标为 稳定下标 。
 * <p>
 * 返回 最小 的稳定下标。如果不存在这样的下标，则返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [5,0,1,4], k = 3
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 在下标 0 处：[5] 中的最大值是 5，[5, 0, 1, 4] 中的最小值是 0，因此不稳定值为 5 - 0 = 5。
 * 在下标 1 处：[5, 0] 中的最大值是 5，[0, 1, 4] 中的最小值是 0，因此不稳定值为 5 - 0 = 5。
 * 在下标 2 处：[5, 0, 1] 中的最大值是 5，[1, 4] 中的最小值是 1，因此不稳定值为 5 - 1 = 4。
 * 在下标 3 处：[5, 0, 1, 4] 中的最大值是 5，[4] 中的最小值是 4，因此不稳定值为 5 - 4 = 1。
 * 这是第一个不稳定值小于等于 k = 3 的下标，因此答案是 3。
 * 示例 2：
 * <p>
 * 输入： nums = [3,2,1], k = 1
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * 在下标 0 处，不稳定值为 3 - 1 = 2。
 * 在下标 1 处，不稳定值为 3 - 1 = 2。
 * 在下标 2 处，不稳定值为 3 - 1 = 2。
 * 这些值都不小于等于 k = 1，因此答案是 -1。
 * 示例 3：
 * <p>
 * 输入： nums = [0], k = 0
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 在下标 0 处，不稳定值为 0 - 0 = 0，它小于等于 k = 0。因此答案是 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * 0 <= k <= 109
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-stable-index-i/description/?envType=daily-question&envId=2026-09-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3903_FirstStableIndex {
    public static void main(String[] args) {
        L3903_FirstStableIndex l3903FirstStableIndex = new L3903_FirstStableIndex();
        System.out.println(l3903FirstStableIndex.firstStableIndex(new int[]{5, 0, 1, 4}, 3));
    }

    public int firstStableIndex(int[] nums, int k) {
        int[] subMin = new int[nums.length];
        subMin[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            subMin[i] = Math.min(nums[i], subMin[i + 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            if (max - subMin[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}
