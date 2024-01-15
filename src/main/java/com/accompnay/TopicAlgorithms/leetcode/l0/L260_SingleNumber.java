package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 260. 只出现一次的数字 III
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/single-number-iii/description/?envType=daily-question&envId=2023-10-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L260_SingleNumber {
    public static void main(String[] args) {
        L260_SingleNumber l260SingleNumber = new L260_SingleNumber();
        System.out.println(Arrays.toString(l260SingleNumber.singleNumber(new int[]{1,2,1,3,2,5})));
    }
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int i = Integer.numberOfTrailingZeros(xor);
        int xor1 = 0;
        int xor2 = 0;
        for (int num : nums) {
            if ((num >> i & 1) == 0) {
                xor1 ^= num;
            } else {
                xor2 ^= num;
            }
        }
        return new int[]{xor1, xor2};
    }
}
