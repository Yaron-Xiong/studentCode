package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3644. 排序排列
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums，其中 nums 是范围 [0..n - 1] 内所有数字的一个 排列 。
 * <p>
 * 你可以在满足条件 nums[i] AND nums[j] == k 的情况下交换下标 i 和 j 的元素，其中 AND 表示按位与操作，k 是一个非负整数。
 * <p>
 * 返回可以使数组按 非递减 顺序排序的最大值 k（允许进行任意次这样的交换）。如果 nums 已经是有序的，返回 0。
 * <p>
 * 排列 是数组所有元素的一种重新排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,3,2,1]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 选择 k = 1。交换 nums[1] = 3 和 nums[3] = 1，因为 nums[1] AND nums[3] == 1，从而得到一个排序后的排列：[0, 1, 2, 3]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,3,2]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 选择 k = 2。交换 nums[2] = 3 和 nums[3] = 2，因为 nums[2] AND nums[3] == 2，从而得到一个排序后的排列：[0, 1, 2, 3]。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1,0]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 只有当 k = 0 时，才能进行排序，因为没有更大的 k 能够满足 nums[i] AND nums[j] == k 的交换条件。ohjnoklumhyjnhuu
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 105
 * 0 <= nums[i] <= n - 1
 * nums 是从 0 到 n - 1 的一个排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-k-to-sort-a-permutation/description/?envType=daily-question&envId=2026-10-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3644_SortPermutation {
    public static void main(String[] args) {
        L3644_SortPermutation l3644SortPermutation = new L3644_SortPermutation();
        System.out.println(l3644SortPermutation.sortPermutation(new int[]{0, 1}));
        System.out.println(l3644SortPermutation.sortPermutation(new int[]{0, 3, 2, 1}));
        System.out.println(l3644SortPermutation.sortPermutation(new int[]{0, 1, 3, 2}));
        System.out.println(l3644SortPermutation.sortPermutation(new int[]{3, 2, 1, 0}));
    }

    public int sortPermutation(int[] nums) {
        int ansK = (2 << 10) - 1;
        int index = 0;
        boolean flag = false;
        while (index < nums.length) {
            if (nums[index] != index) {
                //swap
                ansK &= nums[index];
                flag = true;
            }
            index++;
        }
        return flag ? ansK : 0;
    }
}
