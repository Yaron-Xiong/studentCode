package com.yaronxiong.algorithms.swordFingerOffer.math;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S39_MajorityElement {
    public static void main(String[] args) {
        S39_MajorityElement s39MajorityElement = new S39_MajorityElement();
        int i = s39MajorityElement.majorityElement(new int[]{3, 3, 2});
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        int item = nums[0];
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                item = num;
            }
            vote += item == num ? 1 : -1;
        }
        return item;
    }
}
