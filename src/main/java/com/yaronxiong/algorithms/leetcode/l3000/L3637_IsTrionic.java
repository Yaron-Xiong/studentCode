package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3637. 三段式数组 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums。
 * <p>
 * 如果存在索引 0 < p < q < n − 1，使得数组满足以下条件，则称其为 三段式数组（trionic）：
 * <p>
 * nums[0...p] 严格 递增，
 * nums[p...q] 严格 递减，
 * nums[q...n − 1] 严格 递增。
 * 如果 nums 是三段式数组，返回 true；否则，返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,4,2,6]
 * <p>
 * 输出: true
 * <p>
 * 解释:
 * <p>
 * 选择 p = 2, q = 4：
 * <p>
 * nums[0...2] = [1, 3, 5] 严格递增 (1 < 3 < 5)。
 * nums[2...4] = [5, 4, 2] 严格递减 (5 > 4 > 2)。
 * nums[4...5] = [2, 6] 严格递增 (2 < 6)。
 * 示例 2:
 * <p>
 * 输入: nums = [2,1,3]
 * <p>
 * 输出: false
 * <p>
 * 解释:
 * <p>
 * 无法选出能使数组满足三段式要求的 p 和 q 。
 * <p>
 * 提示:
 * <p>
 * 3 <= n <= 100
 * -1000 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/trionic-array-i/description/?envType=daily-question&envId=2026-02-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3637_IsTrionic {
    public static void main(String[] args) {
        L3637_IsTrionic l3637IsTrionic = new L3637_IsTrionic();
        System.out.println(l3637IsTrionic.isTrionic(new int[]{1, 3, 5, 4, 2, 6}));
        System.out.println(l3637IsTrionic.isTrionic(new int[]{2, 1, 3}));
    }

    public boolean isTrionic(int[] nums) {
        boolean[] increment = new boolean[nums.length];
        increment[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0 && nums[i] < nums[i + 1]; i--) {
            if (nums[i] < nums[i + 1]) {
                increment[i] = true;
            }
        }
        //判断是否递增
        for (int p = 1; p < nums.length - 2 && nums[p] > nums[p - 1]; p++) {
            //递减
            for (int q = p + 1; q < nums.length - 1 && nums[q] < nums[q - 1]; q++) {
                //第三层
                if (increment[q]) {
                    return true;
                }
            }
        }
        return false;
    }
}
