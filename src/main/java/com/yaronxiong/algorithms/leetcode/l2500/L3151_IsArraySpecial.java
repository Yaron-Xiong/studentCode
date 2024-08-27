package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3151. 特殊数组 I
 * 算术评级: 1
 * 第 398 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1153
 * 相关标签
 * 相关企业
 * 提示
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * <p>
 * Aging 有一个整数数组 nums。如果 nums 是一个 特殊数组 ，返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 只有一个元素，所以答案为 true。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,4]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 只有两对相邻元素： (2,1) 和 (1,4)，它们都包含了奇偶性不同的数字，因此答案为 true。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [4,3,1,6]
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * nums[1] 和 nums[2] 都是奇数。因此答案为 false。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/special-array-i/description/?envType=daily-question&envId=2024-08-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3151_IsArraySpecial {
    public static void main(String[] args) {
        L3151_IsArraySpecial l3151IsArraySpecial = new L3151_IsArraySpecial();
        System.out.println(l3151IsArraySpecial.isArraySpecial(new int[]{2,1,4}));
    }

    public boolean isArraySpecial(int[] nums) {
        boolean flag = nums[0] % 2 == 0;
        for (int i = 1; i < nums.length; i++) {
            boolean curFlag = nums[i] % 2 == 0;
            if (curFlag == flag) {
                return false;
            }
            flag = curFlag;
        }
        return true;
    }
}
