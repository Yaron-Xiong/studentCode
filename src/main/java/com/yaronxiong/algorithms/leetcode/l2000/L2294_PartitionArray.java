package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2294. 划分数组使最大差为 K
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k 。你可以将 nums 划分成一个或多个 子序列 ，使 nums 中的每个元素都 恰好 出现在一个子序列中。
 * <p>
 * 在满足每个子序列中最大值和最小值之间的差值最多为 k 的前提下，返回需要划分的 最少 子序列数目。
 * <p>
 * 子序列 本质是一个序列，可以通过删除另一个序列中的某些元素（或者不删除）但不改变剩下元素的顺序得到。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,1,2,5], k = 2
 * 输出：2
 * 解释：
 * 可以将 nums 划分为两个子序列 [3,1,2] 和 [6,5] 。
 * 第一个子序列中最大值和最小值的差值是 3 - 1 = 2 。
 * 第二个子序列中最大值和最小值的差值是 6 - 5 = 1 。
 * 由于创建了两个子序列，返回 2 。可以证明需要划分的最少子序列数目就是 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 1
 * 输出：2
 * 解释：
 * 可以将 nums 划分为两个子序列 [1,2] 和 [3] 。
 * 第一个子序列中最大值和最小值的差值是 2 - 1 = 1 。
 * 第二个子序列中最大值和最小值的差值是 3 - 3 = 0 。
 * 由于创建了两个子序列，返回 2 。注意，另一种最优解法是将 nums 划分成子序列 [1] 和 [2,3] 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,2,4,5], k = 0
 * 输出：3
 * 解释：
 * 可以将 nums 划分为三个子序列 [2,2]、[4] 和 [5] 。
 * 第一个子序列中最大值和最小值的差值是 2 - 2 = 0 。
 * 第二个子序列中最大值和最小值的差值是 4 - 4 = 0 。
 * 第三个子序列中最大值和最小值的差值是 5 - 5 = 0 。
 * 由于创建了三个子序列，返回 3 。可以证明需要划分的最少子序列数目就是 3 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 * 0 <= k <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/partition-array-such-that-maximum-difference-is-k/description/?envType=daily-question&envId=2025-06-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2294_PartitionArray {
    public static void main(String[] args) {
        L2294_PartitionArray l2294PartitionArray = new L2294_PartitionArray();
        System.out.println(l2294PartitionArray.partitionArray(new int[]{2, 2, 4, 5}, 0));
    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int preNum = nums[0];
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - preNum > k) {
                preNum = nums[i];
                ans++;
            }
        }
        return ans;
    }
}
