package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3171. 找到按位或最接近 K 的子数组
 * 算术评级: 8
 * 第 400 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2163
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个数组 nums 和一个整数 k 。你需要找到 nums 的一个
 * 子数组
 * ，满足子数组中所有元素按位或运算 OR 的值与 k 的 绝对差 尽可能 小 。
 * 换言之，你需要选择一个子数组 nums[l..r] 满足 |k - (nums[l] OR nums[l + 1] ... OR nums[r])| 最小。
 * <p>
 * 请你返回 最小 的绝对差值。
 * <p>
 * 子数组 是数组中连续的 非空 元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,4,5], k = 3
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 子数组 nums[0..1] 的按位 OR 运算值为 3 ，得到最小差值 |3 - 3| = 0 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,1,3], k = 2
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 子数组 nums[1..1] 的按位 OR 运算值为 3 ，得到最小差值 |3 - 2| = 1 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1], k = 10
 * <p>
 * 输出：9
 * <p>
 * 解释：
 * <p>
 * 只有一个子数组，按位 OR 运算值为 1 ，得到最小差值 |10 - 1| = 9 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-time-to-complete-trips/description/?envType=daily-question&envId=2024-10-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3171_MinimumDifference {
    public static void main(String[] args) {
        L3171_MinimumDifference l3171MinimumDifference = new L3171_MinimumDifference();
        System.out.println(l3171MinimumDifference.minimumDifference(new int[]{1, 2, 4, 5}, 3));
    }

    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int bottom = 0;
        int rightOr = 0;
        for (int right = 0; right < nums.length; right++) {
            rightOr |= nums[right];
            while (left <= right && (nums[left] | rightOr) > k) {
                ans = Math.min(ans, (nums[left] | rightOr) - k);
                if (bottom <= left) {
                    // 重新构建一个栈
                    // 由于 left 即将移出窗口，只需计算到 left+1
                    for (int i = right - 1; i > left; i--) {
                        nums[i] |= nums[i + 1];
                    }
                    bottom = right;
                    rightOr = 0;
                }
                left++;
            }
            if (left <= right) {
                ans = Math.min(ans, k - (nums[left] | rightOr));
            }
        }
        return ans;
    }
}
