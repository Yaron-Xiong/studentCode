package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1437. 是否所有 1 都至少相隔 k 个元素
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,0,0,1,0,0,1], k = 2
 * 输出：true
 * 解释：每个 1 都至少相隔 2 个元素。
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,0,1,0,1], k = 2
 * 输出：false
 * 解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= k <= nums.length
 * nums[i] 的值为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended/description/?envType=daily-question&envId=2025-07-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1437_KLengthApart {
    public boolean kLengthApart(int[] nums, int k) {
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (pre != -1) {
                if (i - pre - 1 < k) {
                    return false;
                }
            }
            pre = i;
        }
        return true;
    }
}
