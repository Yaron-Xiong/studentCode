package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.HashSet;
import java.util.Set;

/**
 * 3158. 求出出现两次数字的 XOR 值
 * 算术评级: 2
 * 第 131 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1172
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个数组 nums ，数组中的数字 要么 出现一次，要么 出现两次。
 * <p>
 * 请你返回数组中所有出现两次数字的按位 XOR 值，如果没有数字出现过两次，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,3]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 中唯一出现过两次的数字是 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * nums 中没有数字出现两次。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,2,1]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 数字 1 和 2 出现过两次。1 XOR 2 == 3 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 * nums 中每个数字要么出现过一次，要么出现过两次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-xor-of-numbers-which-appear-twice/description/?envType=daily-question&envId=2024-10-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3158_DuplicateNumbersXOR {
    public static void main(String[] args) {
        System.out.println(1 ^ 2 ^ 3);
    }

    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            if (!set.add(num)) {
                ans ^= num;
            }
        }
        return ans;
    }
}
