package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1524. 和为奇数的子数组数目
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
 * <p>
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,3,5]
 * 输出：4
 * 解释：所有的子数组为 [[1],[1,3],[1,3,5],[3],[3,5],[5]] 。
 * 所有子数组的和为 [1,4,9,3,8,5].
 * 奇数和包括 [1,9,3,5] ，所以答案为 4 。
 * 示例 2 ：
 * <p>
 * 输入：arr = [2,4,6]
 * 输出：0
 * 解释：所有子数组为 [[2],[2,4],[2,4,6],[4],[4,6],[6]] 。
 * 所有子数组和为 [2,6,12,4,10,6] 。
 * 所有子数组和都是偶数，所以答案为 0 。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3,4,5,6,7]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：arr = [100,100,99,99]
 * 输出：4
 * 示例 5：
 * <p>
 * 输入：arr = [7]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-sub-arrays-with-odd-sum/description/?envType=daily-question&envId=2026-11-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1524_NumOfSubarrays {
    public static void main(String[] args) {
        L1524_NumOfSubarrays l1524NumOfSubarrays = new L1524_NumOfSubarrays();
        System.out.println(l1524NumOfSubarrays.numOfSubarrays(new int[]{1, 3, 5}));
    }

    public int numOfSubarrays(int[] arr) {
        //记录前缀和 [0,i-1] 的奇偶总数
        int[] preSum = new int[2];
        int mod = (int) (1e9 + 7);
        preSum[0] = 1;
        int val = 0;
        long ans = 0;
        for (int j : arr) {
            val += j;
            if (val % 2 == 0) {
                //当前前缀和是偶数，看前面有多少个奇数的前缀和
                ans += preSum[1];
                preSum[0]++;
            } else {
                //当前前缀和是奇数、看前面有多少个偶数的前缀和
                ans += preSum[0];
                preSum[1]++;
            }
            ans %= mod;
        }
        return (int) ans;
    }


}
