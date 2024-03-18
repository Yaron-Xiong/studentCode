package com.yaronxiong.algorithms.swordFingerOffer.sort;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * <p>
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 示例1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S61_IsStraight {
    public static void main(String[] args) {
        S61_IsStraight s61IsStraight = new S61_IsStraight();
        boolean straight = s61IsStraight.isStraight(new int[]{11, 0, 9, 0, 0});
        System.out.println(straight);
    }

    public boolean isStraight2(int[] nums) {
        //不能有重复
        boolean[] flag = new boolean[14];
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (flag[num]) {
                return false;
            }
            flag[num] = true;
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }
        return maxValue - minValue <= 4;
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        int index = 0;
        while (nums[index] == 0) {
            index++;
            joker++;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
            int diff = nums[i] - 1 - nums[i - 1];
            joker -= diff;
            if (joker < 0) {
                return false;
            }
        }
        return true;
    }
}
