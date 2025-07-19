package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3201. 找出有效子序列的最大长度 I
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列：
 * <p>
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2
 * 返回 nums 的 最长的有效子序列 的长度。
 * <p>
 * 一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3,4]
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 最长的有效子序列是 [1, 2, 3, 4]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,1,1,2,1,2]
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * 最长的有效子序列是 [1, 2, 1, 2, 1, 2]。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [1,3]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 最长的有效子序列是 [1, 3]。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2 * 105
 * 1 <= nums[i] <= 107
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-maximum-length-of-valid-subsequence-i/?envType=daily-question&envId=2025-07-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3201_MaximumLength {
    public static void main(String[] args) {
        L3201_MaximumLength l3201MaximumLength = new L3201_MaximumLength();
        System.out.println(l3201MaximumLength.maximumLength(new int[]{1, 2, 3, 4}));
    }
    public int maximumLength(int[] nums) {
        //1. 全部都是奇数
        //2. 全部都是偶数
        //3. 奇偶交替
        int odds = 0;
        int evens = 0;
        int oddEvens = 1;
        int pre = nums[0] % 2;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i] % 2;
            if (cur == 0) {
                evens++;
            } else {
                odds++;
            }
            if (pre != cur) {
                oddEvens++;
            }
            pre = cur;
        }
        return Math.max(odds, Math.max(evens, oddEvens));
    }
}
