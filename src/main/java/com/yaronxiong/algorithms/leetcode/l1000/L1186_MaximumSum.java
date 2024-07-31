package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1186. 删除一次得到子数组最大和
 * 提示
 * 中等
 * 181
 * 相关企业
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
 * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），
 * （删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
 * <p>
 * 注意，删除一个元素后，子数组 不能为空。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,-2,0,3]
 * 输出：4
 * 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
 * 示例 2：
 * <p>
 * 输入：arr = [1,-2,-2,3]
 * 输出：3
 * 解释：我们直接选出 [3]，这就是最大和。
 * 示例 3：
 * <p>
 * 输入：arr = [-1,-1,-1,-1]
 * 输出：-1
 * 解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
 * 我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 105
 * -104 <= arr[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1186_MaximumSum {
    public static void main(String[] args) {
        L1186_MaximumSum l1186MaximumSum = new L1186_MaximumSum();
        System.out.println(l1186MaximumSum.maximumSum(new int[]{8, -1, 6, -7, -4, 5, -4, 7, -6}));
    }

    public int maximumSum(int[] arr) {
        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
            ans = Math.max(ans, dp[i][1]);
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }
}
