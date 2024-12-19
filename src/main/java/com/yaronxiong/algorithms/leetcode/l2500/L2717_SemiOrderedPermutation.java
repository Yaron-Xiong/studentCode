package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2717. 半有序排列
 * 算术评级: 3
 * 第 348 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1296
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、长度为 n 的整数排列 nums 。
 * <p>
 * 如果排列的第一个数字等于 1 且最后一个数字等于 n ，则称其为 半有序排列 。你可以执行多次下述操作，直到将 nums 变成一个 半有序排列 ：
 * <p>
 * 选择 nums 中相邻的两个元素，然后交换它们。
 * 返回使 nums 变成 半有序排列 所需的最小操作次数。
 * <p>
 * 排列 是一个长度为 n 的整数序列，其中包含从 1 到 n 的每个数字恰好一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4,3]
 * 输出：2
 * 解释：可以依次执行下述操作得到半有序排列：
 * 1 - 交换下标 0 和下标 1 对应元素。排列变为 [1,2,4,3] 。
 * 2 - 交换下标 2 和下标 3 对应元素。排列变为 [1,2,3,4] 。
 * 可以证明，要让 nums 成为半有序排列，不存在执行操作少于 2 次的方案。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,1,3]
 * 输出：3
 * 解释：
 * 可以依次执行下述操作得到半有序排列：
 * 1 - 交换下标 1 和下标 2 对应元素。排列变为 [2,1,4,3] 。
 * 2 - 交换下标 0 和下标 1 对应元素。排列变为 [1,2,4,3] 。
 * 3 - 交换下标 2 和下标 3 对应元素。排列变为 [1,2,3,4] 。
 * 可以证明，要让 nums 成为半有序排列，不存在执行操作少于 3 次的方案。
 * 示例 3：
 * <p>
 * 输入：nums = [1,3,4,2,5]
 * 输出：0
 * 解释：这个排列已经是一个半有序排列，无需执行任何操作。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length == n <= 50
 * 1 <= nums[i] <= 50
 * nums 是一个 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/semi-ordered-permutation/description/?envType=daily-question&envId=2024-12-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2717_SemiOrderedPermutation {
    public static void main(String[] args) {
        L2717_SemiOrderedPermutation l2717SemiOrderedPermutation = new L2717_SemiOrderedPermutation();
        System.out.println(l2717SemiOrderedPermutation.semiOrderedPermutation(new int[]{2,4,1,3}));
    }
    public int semiOrderedPermutation(int[] nums) {
        int firstZeroIndex = nums.length;
        int lastOneIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                firstZeroIndex = Math.min(firstZeroIndex, i);
            } else if (nums[i] == nums.length) {
                lastOneIndex = Math.max(lastOneIndex, i);
            }
        }
        if (firstZeroIndex == nums.length || lastOneIndex == -1) {
            return 0;
        }
        //判断是否交叉
        int ans = firstZeroIndex + nums.length - 1 - lastOneIndex;
        if (firstZeroIndex > lastOneIndex) {
            ans--;
        }
        return ans;
    }
}
