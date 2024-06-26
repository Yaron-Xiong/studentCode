package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2670. 找出不同元素数目差数组
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的数组 nums ，数组长度为 n 。
 * <p>
 * nums 的 不同元素数目差 数组可以用一个长度为 n 的数组 diff 表示，
 * 其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目 减去 后缀 nums[i + 1, ..., n - 1] 中不同元素的数目。
 * <p>
 * 返回 nums 的 不同元素数目差 数组。
 * <p>
 * 注意 nums[i, ..., j] 表示 nums 的一个从下标 i 开始到下标 j 结束的子数组（包含下标 i 和 j 对应元素）。
 * 特别需要说明的是，如果 i > j ，则 nums[i, ..., j] 表示一个空子数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：[-3,-1,1,3,5]
 * 解释：
 * 对于 i = 0，前缀中有 1 个不同的元素，而在后缀中有 4 个不同的元素。因此，diff[0] = 1 - 4 = -3 。
 * 对于 i = 1，前缀中有 2 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[1] = 2 - 3 = -1 。
 * 对于 i = 2，前缀中有 3 个不同的元素，而在后缀中有 2 个不同的元素。因此，diff[2] = 3 - 2 = 1 。
 * 对于 i = 3，前缀中有 4 个不同的元素，而在后缀中有 1 个不同的元素。因此，diff[3] = 4 - 1 = 3 。
 * 对于 i = 4，前缀中有 5 个不同的元素，而在后缀中有 0 个不同的元素。因此，diff[4] = 5 - 0 = 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,3,4,2]
 * 输出：[-2,-1,0,2,3]
 * 解释：
 * 对于 i = 0，前缀中有 1 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[0] = 1 - 3 = -2 。
 * 对于 i = 1，前缀中有 2 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[1] = 2 - 3 = -1 。
 * 对于 i = 2，前缀中有 2 个不同的元素，而在后缀中有 2 个不同的元素。因此，diff[2] = 2 - 2 = 0 。
 * 对于 i = 3，前缀中有 3 个不同的元素，而在后缀中有 1 个不同的元素。因此，diff[3] = 3 - 1 = 2 。
 * 对于 i = 4，前缀中有 3 个不同的元素，而在后缀中有 0 个不同的元素。因此，diff[4] = 3 - 0 = 3 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 50
 * 1 <= nums[i] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-distinct-difference-array/description/?envType=daily-question&envId=2024-01-31">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2670_DistinctDifferenceArray {
    public static void main(String[] args) {
        L2670_DistinctDifferenceArray l2670DistinctDifferenceArray = new L2670_DistinctDifferenceArray();
        System.out.println(Arrays.toString(l2670DistinctDifferenceArray.distinctDifferenceArray(new int[]{3, 2, 3, 4, 2})));
    }

    public int[] distinctDifferenceArray(int[] nums) {
        int[] ans = new int[nums.length];
        int[] preSum = new int[nums.length];
        preSum[0] = 1;
        boolean[] visit = new boolean[50];
        visit[nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1];
            if (!visit[nums[i]]) {
                preSum[i]++;
            }
            visit[nums[i]] = true;
        }
        ans[nums.length - 1] = preSum[nums.length - 1];
        int[] subSum = new int[nums.length];
        subSum[nums.length - 1] = 1;
        visit = new boolean[50];
        visit[nums[nums.length - 1]] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            subSum[i] = subSum[i + 1];
            if (!visit[nums[i]]) {
                subSum[i]++;
            }
            ans[i] = preSum[i] - subSum[i + 1];
            visit[nums[i]] = true;
        }
        return ans;
    }
}
