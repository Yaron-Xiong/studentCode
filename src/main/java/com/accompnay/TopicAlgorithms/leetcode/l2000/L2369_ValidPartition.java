package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2369. 检查数组是否存在有效划分
 * 第 305 场周赛
 * Q3
 * 1780
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
 * <p>
 * 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
 * <p>
 * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
 * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
 * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
 * 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,4,5,6]
 * 输出：true
 * 解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
 * 这是一种有效划分，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,2]
 * 输出：false
 * 解释：该数组不存在有效划分。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array/description/?envType=daily-question&envId=2024-03-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2369_ValidPartition {
    public static void main(String[] args) {
        L2369_ValidPartition l2369ValidPartition = new L2369_ValidPartition();
        boolean b = l2369ValidPartition.validPartition(new int[]{993335, 993336, 993337, 993338, 993339, 993340, 993341});
        System.out.println(b);
    }

    public boolean validPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && dp[i - 1]) {
                dp[i + 1] = dp[i - 1];
            }
            if (i > 1 && dp[i - 2] && nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                dp[i + 1] = dp[i - 2];
            }
            if (i > 1 && dp[i - 2] && nums[i] - nums[i - 1] == 1 && nums[i] - nums[i - 2] == 2) {
                dp[i + 1] = dp[i - 2] | dp[i + 1];
            }
        }
        return dp[nums.length];
    }

    private boolean dfs(int[] nums, int left) {
        if (left == nums.length) {
            return true;
        }
        //从left开始，尝试构建合法的子数组
        //1.由两个相同元素构成
        //2.由三个相同元素构成
        //3.由三个连续递增数字构成
        if (left + 1 <= nums.length - 1 && nums[left] == nums[left + 1]) {
            if (dfs(nums, left + 2)) {
                return true;
            }
        }
        if (left + 2 <= nums.length - 1 && nums[left] == nums[left + 1] && nums[left] == nums[left + 2]) {
            if (dfs(nums, left + 3)) {
                return true;
            }
        }
        if (left + 2 <= nums.length - 1 && nums[left + 2] - nums[left + 1] == 1 && nums[left + 1] - nums[left] == 1) {
            if (dfs(nums, left + 3)) {
                return true;
            }
        }
        return false;
    }
}
