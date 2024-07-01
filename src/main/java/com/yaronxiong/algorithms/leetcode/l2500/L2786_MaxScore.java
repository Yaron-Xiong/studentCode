package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2786. 访问数组中的位置使分数最大
 * 算术评级: 5
 * 第 109 场双周赛
 * Q3
 * 1733
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。
 * <p>
 * 你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置：
 * <p>
 * 如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。
 * 对于你访问的位置 i ，你可以获得分数 nums[i] 。
 * 如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。
 * 请你返回你能得到的 最大 得分之和。
 * <p>
 * 注意 ，你一开始的分数为 nums[0] 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,6,1,9,2], x = 5
 * 输出：13
 * 解释：我们可以按顺序访问数组中的位置：0 -> 2 -> 3 -> 4 。
 * 对应位置的值为 2 ，6 ，1 和 9 。因为 6 和 1 的奇偶性不同，所以下标从 2 -> 3 让你失去 x = 5 分。
 * 总得分为：2 + 6 + 1 + 9 - 5 = 13 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6,8], x = 3
 * 输出：20
 * 解释：数组中的所有元素奇偶性都一样，所以我们可以将每个元素都访问一次，而且不会失去任何分数。
 * 总得分为：2 + 4 + 6 + 8 = 20 。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i], x <= 106
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/visit-array-positions-to-maximize-score/description/?envType=daily-question&envId=2024-06-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2786_MaxScore {
    public static void main(String[] args) {
        L2786_MaxScore l2786MaxScore = new L2786_MaxScore();
        System.out.println(l2786MaxScore.maxScore(new int[]{8, 50, 65, 85, 8, 73, 55, 50, 29, 95, 5, 68, 52, 79}, 74));
    }

    public long maxScore(int[] nums, int x) {
        long oddSum = nums[0] % 2 == 0 ? -x : nums[0];
        long evenSum = nums[0] % 2 == 0 ? nums[0] : -x;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                //奇数会像偶数跃迁
                evenSum = Math.max(evenSum, oddSum - x) + nums[i];
            } else {
                //偶数会像奇数跃迁
                oddSum = Math.max(oddSum, evenSum - x) + nums[i];
            }
        }
        return Math.max(evenSum, oddSum);
    }
}
