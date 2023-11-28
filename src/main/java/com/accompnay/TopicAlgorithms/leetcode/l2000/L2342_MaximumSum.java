package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2342. 数位和相等数对的最大和
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
 * <p>
 * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [18,43,36,13,7]
 * 输出：54
 * 解释：满足条件的数对 (i, j) 为：
 * - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
 * - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
 * 所以可以获得的最大和是 54 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,12,19,14]
 * 输出：-1
 * 解释：不存在满足条件的数对，返回 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/?envType=daily-question&envId=2023-11-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2342_MaximumSum {
    public static void main(String[] args) {
        L2342_MaximumSum l2342MaximumSum = new L2342_MaximumSum();
        System.out.println(l2342MaximumSum.maximumSum(new int[]{18, 43, 36, 13, 7}));
    }

    public int maximumSum(int[] nums) {
        int ans = -1;
        int[] mx = new int[82];
        for (int num : nums) {
            int x = getNum(num);
            if (mx[x] > 0) {
                ans = Math.max(ans, mx[x] + num);
            }
            mx[x] = Math.max(mx[x], num);
        }
        return ans;
    }

    public int getNum(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}
