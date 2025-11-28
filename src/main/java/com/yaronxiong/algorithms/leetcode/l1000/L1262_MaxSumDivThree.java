package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1262. 可被三整除的最大和
 * 提示
 * 中等
 * 248
 * 相关企业
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/greatest-sum-divisible-by-three/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1262_MaxSumDivThree {
    public static void main(String[] args) {
        L1262_MaxSumDivThree l1262MaxSumDivThree = new L1262_MaxSumDivThree();
        System.out.println(l1262MaxSumDivThree.maxSumDivThreeV2(new int[]{2, 6, 2, 2, 7}));
    }

    /**
     * dfs
     */
    public int maxSumDivThreeV2(int[] nums) {
        int[][] memo = new int[nums.length][3];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs2(nums.length - 1, 0, nums, memo);
    }

    private int dfs2(int i, int j, int[] nums, int[][] memo) {
        if (i < 0) {
            return j == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        //选
        int a = dfs2(i - 1, (j + nums[i]) % 3, nums, memo) + nums[i];
        //不选
        int b = dfs2(i - 1, j, nums, memo);
        return memo[i][j] = Math.max(a, b);
    }

    /**
     * 贪心版本
     */
    public int maxSumDivThree(int[] nums) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            if (num % 3 == 1) {
                a1.add(num);
            } else if (num % 3 == 2) {
                a2.add(num);
            }
            sum += num;
        }
        if (sum % 3 == 0) {
            return sum;
        }
        a1.sort(Comparator.comparingInt(a -> a));
        a2.sort(Comparator.comparingInt(a -> a));
        //当sum%3 == 1 时： 可以由 2个2 或者 1个1 构建
        //当sum%3 == 2 时： 可以由 2个1 或者 1个2 构建
        if (sum % 3 == 1) {
            List<Integer> tmp = a2;
            a2 = a1;
            a1 = tmp;
        }
        int ans = a2.isEmpty() ? 0 : sum - a2.get(0);
        if (a1.size() > 1) {
            ans = Math.max(ans, sum - a1.get(0) - a1.get(1));
        }
        return ans;
    }

}
