package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3038. 相同分数的最大操作数目 I
 * 算术评级: 2
 * 第 124 场双周赛
 * Q1
 * 1202
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作：
 * <p>
 * 选择 nums 中的前两个元素并将它们删除。
 * 一次操作的 分数 是被删除元素的和。
 * <p>
 * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
 * <p>
 * 请你返回按照上述要求 最多 可以进行的操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,1,4,5]
 * 输出：2
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,4,5] 。
 * - 删除前两个元素，分数为 1 + 4 = 5 ，nums = [5] 。
 * 由于只剩下 1 个元素，我们无法继续进行任何操作。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,6,1,4]
 * 输出：1
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
 * 由于下一次操作的分数与前一次不相等，我们无法继续进行任何操作。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/description/?envType=daily-question&envId=2024-06-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3038_MaxOperations {
    public static void main(String[] args) {
        L3038_MaxOperations l3038MaxOperations = new L3038_MaxOperations();
        System.out.println(l3038MaxOperations.maxOperations(new int[]{1,1,1,1,1,1}));
    }
    public int maxOperations(int[] nums) {
        int i1 = 2;
        int i2 = 3;
        int score = nums[0] + nums[1];
        int maxOperations = 1;
        while (i2 < nums.length) {
            if (nums[i1] + nums[i2] != score) {
                break;
            }
            i1 += 2;
            i2+=2;
            maxOperations++;
        }
        return maxOperations;
    }
}
