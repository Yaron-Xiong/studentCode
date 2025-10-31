package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3370. 仅含置位位的最小整数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数 n。
 * <p>
 * 返回 大于等于 n 且二进制表示仅包含 置位 位的 最小 整数 x 。
 * <p>
 * 置位 位指的是二进制表示中值为 1 的位。
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 5
 * <p>
 * 输出： 7
 * <p>
 * 解释：
 * <p>
 * 7 的二进制表示是 "111"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 10
 * <p>
 * 输出： 15
 * <p>
 * 解释：
 * <p>
 * 15 的二进制表示是 "1111"。
 * <p>
 * 示例 3：
 * <p>
 * 输入： n = 3
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 3 的二进制表示是 "11"。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-number-with-all-set-bits/description/?envType=daily-question&envId=2025-10-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3370_SmallestNumber {
    public static void main(String[] args) {
        L3370_SmallestNumber l3370SmallestNumber = new L3370_SmallestNumber();
        System.out.println(l3370SmallestNumber.smallestNumber(10));
    }
    public int smallestNumber(int n) {
        String binaryString = Integer.toBinaryString(n);
        int ans = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            ans += Math.pow(2, i);
        }
        return ans;
    }
}
