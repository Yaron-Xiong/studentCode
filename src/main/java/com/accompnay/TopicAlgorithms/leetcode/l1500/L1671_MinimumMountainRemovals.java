package com.accompnay.TopicAlgorithms.leetcode.l1500;

/**
 * 1671. 得到山形数组的最少删除次数
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 我们定义 arr 是 山形数组 当且仅当它满足：
 * <p>
 * arr.length >= 3
 * 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给你整数数组 nums​ ，请你返回将 nums 变成 山形状数组 的​ 最少 删除次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1]
 * 输出：0
 * 解释：数组本身就是山形数组，所以我们不需要删除任何元素。
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,1,5,6,2,3,1]
 * 输出：3
 * 解释：一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * 1 <= nums[i] <= 109
 * 题目保证 nums 删除一些元素后一定能得到山形数组
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/description/?envType=daily-question&envId=2023-12-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1671_MinimumMountainRemovals {
    public static void main(String[] args) {
        L1671_MinimumMountainRemovals l1671MinimumMountainRemovals = new L1671_MinimumMountainRemovals();
        System.out.println(l1671MinimumMountainRemovals.minimumMountainRemovals(new int[]{100, 92, 89, 77, 74, 66, 64, 66, 64}));
    }

    public int minimumMountainRemovals(int[] nums) {
        int[] pre = new int[nums.length];
        //假设以i为山峰 (0~i) 的 最长的递增长度是多少
        for (int i = 0; i < nums.length; i++) {
            pre[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    pre[i] = Math.max(pre[i], pre[j] + 1);
                }
            }
        }
        int ans = 0;
        int[] suf = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            suf[i] = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    suf[i] = Math.max(suf[i], suf[j] + 1);
                }
            }
            if (i != 0 && i != nums.length - 1 && suf[i] > 1 && pre[i] > 1) {
                ans = Math.max(ans, suf[i] + pre[i] - 1);
            }
        }
        return nums.length - ans;

    }
}
