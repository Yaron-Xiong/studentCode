package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.HashMap;
import java.util.Map;

/**
 * 3583. 统计特殊三元组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 特殊三元组 定义为满足以下条件的下标三元组 (i, j, k)：
 * <p>
 * 0 <= i < j < k < n，其中 n = nums.length
 * nums[i] == nums[j] * 2
 * nums[k] == nums[j] * 2
 * 返回数组中 特殊三元组 的总数。
 * <p>
 * 由于答案可能非常大，请返回结果对 109 + 7 取余数后的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [6,3,6]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 唯一的特殊三元组是 (i, j, k) = (0, 1, 2)，其中：
 * <p>
 * nums[0] = 6, nums[1] = 3, nums[2] = 6
 * nums[0] = nums[1] * 2 = 3 * 2 = 6
 * nums[2] = nums[1] * 2 = 3 * 2 = 6
 * 示例 2：
 * <p>
 * 输入： nums = [0,1,0,0]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 唯一的特殊三元组是 (i, j, k) = (0, 2, 3)，其中：
 * <p>
 * nums[0] = 0, nums[2] = 0, nums[3] = 0
 * nums[0] = nums[2] * 2 = 0 * 2 = 0
 * nums[3] = nums[2] * 2 = 0 * 2 = 0
 * 示例 3：
 * <p>
 * 输入： nums = [8,4,2,8,4]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 共有两个特殊三元组：
 * <p>
 * (i, j, k) = (0, 1, 3)
 * nums[0] = 8, nums[1] = 4, nums[3] = 8
 * nums[0] = nums[1] * 2 = 4 * 2 = 8
 * nums[3] = nums[1] * 2 = 4 * 2 = 8
 * (i, j, k) = (1, 2, 4)
 * nums[1] = 4, nums[2] = 2, nums[4] = 4
 * nums[1] = nums[2] * 2 = 2 * 2 = 4
 * nums[4] = nums[2] * 2 = 2 * 2 = 4
 * <p>
 * 提示：
 * <p>
 * 3 <= n == nums.length <= 105
 * 0 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-special-triplets/description/?envType=daily-question&envId=2025-12-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3583_SpecialTriplets {
    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] pre = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pre[i] = cnt.getOrDefault(nums[i] * 2, 0);
            cnt.merge(nums[i], 1, Integer::sum);
        }
        long mod = 1000000007;
        long ans = 0;
        cnt = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans += ((long) pre[i] * cnt.getOrDefault(nums[i] * 2, 0)) % mod;
            cnt.merge(nums[i], 1, Integer::sum);
        }
        return (int) (ans % mod);
    }
}
