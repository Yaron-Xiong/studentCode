package com.accompnay.TopicAlgorithms.leetcode.lcr;

/**
 * LCR 090. 打家劫舍 II
 * 中等
 * 47
 * 相关企业
 * 一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * 注意：本题与主站 213 题相同： <a href="https://leetcode-cn.com/problems/house-robber-ii/">...</a>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/PzWKhm/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L90_Rob {
    public static void main(String[] args) {
        L90_Rob l90Rob = new L90_Rob();
        System.out.println(l90Rob.rob(new int[]{1, 2}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];
        System.arraycopy(nums, 0, nums1, 0, nums1.length);
        System.arraycopy(nums, 1, nums2, 0, nums2.length);
        int v1 = getMaxRob(nums1);
        int v2 = getMaxRob(nums2);
        return Math.max(v1, v2);
    }

    private int getMaxRob(int[] nums) {
        int notRob = 0;
        int rob = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempNotRob = Math.max(notRob, rob);
            int TempRob = notRob + nums[i];
            notRob = tempNotRob;
            rob = TempRob;
        }
        return Math.max(notRob, rob);
    }
}
