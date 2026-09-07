package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3875. 构造奇偶一致的数组 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的数组 nums1，其中包含 互不相同 的整数。
 * <p>
 * 你需要构造另一个长度为 n 的数组 nums2，使得 nums2 中的元素要么全部为 奇数，要么全部为 偶数。
 * <p>
 * 对于每个下标 i，你必须从以下两种选择中 任选其一（顺序不限）：
 * <p>
 * nums2[i] = nums1[i]
 * nums2[i] = nums1[i] - nums1[j]，其中 j != i
 * 如果能够构造出满足条件的数组，则返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums1 = [2,3]
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 选择 nums2[0] = nums1[0] - nums1[1] = 2 - 3 = -1。
 * 选择 nums2[1] = nums1[1] = 3。
 * nums2 = [-1, 3]，两个元素均为奇数。因此答案为 true。
 * 示例 2：
 * <p>
 * 输入： nums1 = [4,6]
 * <p>
 * 输出： true
 * <p>
 * 解释：​​​​​​​
 * <p>
 * 选择 nums2[0] = nums1[0] = 4。
 * 选择 nums2[1] = nums1[1] = 6。
 * nums2 = [4, 6]，两个元素均为偶数。因此答案为 true。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums1.length <= 100
 * 1 <= nums1[i] <= 100
 * nums1 中的所有整数互不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/construct-uniform-parity-array-i/description/?envType=daily-question&envId=2026-09-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3875_UniformArray {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}
