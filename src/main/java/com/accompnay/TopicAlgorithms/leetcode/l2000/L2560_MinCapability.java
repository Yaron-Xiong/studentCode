package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2560. 打家劫舍 IV
 * 提示
 * 中等
 * 42
 * 相关企业
 * 沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 * <p>
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 * <p>
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 * <p>
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 * <p>
 * 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 * <p>
 * 返回小偷的 最小 窃取能力。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,5,9], k = 2
 * 输出：5
 * 解释：
 * 小偷窃取至少 2 间房屋，共有 3 种方式：
 * - 窃取下标 0 和 2 处的房屋，窃取能力为 max(nums[0], nums[2]) = 5 。
 * - 窃取下标 0 和 3 处的房屋，窃取能力为 max(nums[0], nums[3]) = 9 。
 * - 窃取下标 1 和 3 处的房屋，窃取能力为 max(nums[1], nums[3]) = 9 。
 * 因此，返回 min(5, 9, 9) = 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,7,9,3,1], k = 2
 * 输出：2
 * 解释：共有 7 种窃取方式。窃取能力最小的情况所对应的方式是窃取下标 0 和 4 处的房屋。返回 max(nums[0], nums[4]) = 2 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= (nums.length + 1)/2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/house-robber-iv/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2560_MinCapability {
    public static void main(String[] args) {
        L2560_MinCapability l2560MinCapability = new L2560_MinCapability();
        System.out.println(l2560MinCapability.minCapability(new int[]{2, 7, 9, 3, 1}, 2));
    }

    public int minCapability(int[] nums, int k) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int count = check(nums, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int check(int[] nums, int singleRootAmount) {
        int f0 = 0;
        int f1 = nums[0] > singleRootAmount ? 0 : 1;
        for (int i = 1; i < nums.length; i++) {
            int tempF0 = Math.max(f0, f1);
            int tempF1 = nums[i] <= singleRootAmount ? f0 + 1 : tempF0;
            f0 = tempF0;
            f1 = tempF1;
        }
        return Math.max(f0, f1);
    }
}
