package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2614. 对角线上的质数
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二维整数数组 nums 。
 * <p>
 * 返回位于 nums 至少一条 对角线 上的最大 质数 。如果任一对角线上均不存在质数，返回 0 。
 * <p>
 * 注意：
 * <p>
 * 如果某个整数大于 1 ，且不存在除 1 和自身之外的正整数因子，则认为该整数是一个质数。
 * 如果存在整数 i ，使得 nums[i][i] = val 或者 nums[i][nums.length - i - 1]= val ，则认为整数 val 位于 nums 的一条对角线上。
 * <p>
 * <p>
 * 在上图中，一条对角线是 [1,5,9] ，而另一条对角线是 [3,5,7] 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[1,2,3],[5,6,7],[9,10,11]]
 * 输出：11
 * 解释：数字 1、3、6、9 和 11 是所有 "位于至少一条对角线上" 的数字。由于 11 是最大的质数，故返回 11 。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,2,3],[5,17,7],[9,11,10]]
 * 输出：17
 * 解释：数字 1、3、9、10 和 17 是所有满足"位于至少一条对角线上"的数字。由于 17 是最大的质数，故返回 17 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 300
 * nums.length == numsi.length
 * 1 <= nums[i][j] <= 4*106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/prime-in-diagonal/description/?envType=daily-question&envId=2025-03-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2614_DiagonalPrime {
    public static void main(String[] args) {
        L2614_DiagonalPrime l2614DiagonalPrime = new L2614_DiagonalPrime();
        System.out.println(l2614DiagonalPrime.diagonalPrime(new int[][]{{341}}));
    }

    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        int a = 0;
        for (int i = 0; i < nums.length; i++, a++) {
            if (nums[i][a] > ans && isPrimeNumber(nums[i][a])) {
                ans = Math.max(ans, nums[i][a]);
            }
            if (nums[i][nums.length - a - 1] > ans && isPrimeNumber(nums[i][nums.length - a - 1])) {
                ans = Math.max(ans, nums[i][nums.length - a - 1]);
            }
        }
        return ans;
    }

    public boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
