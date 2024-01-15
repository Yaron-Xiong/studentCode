package com.accompnay.TopicAlgorithms.leetcode.l0;

/**
 * 137. 只出现一次的数字 II
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/single-number-ii/description/?envType=daily-question&envId=2023-10-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L137_SingleNumber {
    public static void main(String[] args) {
        L137_SingleNumber l137SingleNumber = new L137_SingleNumber();
        System.out.println(l137SingleNumber.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += num >> i & 1;
            }
            ans |= (total % 3) << i;
        }
        return ans;
    }
}
