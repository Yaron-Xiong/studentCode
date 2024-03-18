package com.yaronxiong.algorithms.swordFingerOffer.bitOperation;

import java.util.Arrays;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S56_SingleNumbers {
    public static void main(String[] args) {
        S56_SingleNumbers s56SingleNumbers = new S56_SingleNumbers();
        int[] ints = s56SingleNumbers.singleNumbers(new int[]{1, 2, 5, 2});
        System.out.println(Arrays.toString(ints));
    }

    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        //找到x中值为1的位置
        int diffValue = 1;
        while ((diffValue & x) != diffValue) {
            diffValue <<= 1;
        }
        int x1 = 0;
        int x2 = 0;
        for (int num : nums) {
            if ((num & diffValue) == diffValue) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }
        return new int[]{x1, x2};
    }
}
