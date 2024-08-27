package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/***
 *
 *
 * 3152. 特殊数组 II
 * 算术评级: 4
 * 第 398 场周赛
 * Q2
 *  同步题目状态
 *
 * 1523
 * 相关标签
 * 相关企业
 * 提示
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 *
 * 周洋哥有一个整数数组 nums 和一个二维整数矩阵 queries，
 * 对于 queries[i] = [fromi, toi]，请你帮助周洋哥检查子数组 nums[fromi..toi] 是不是一个 特殊数组 。
 *
 * 返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,1,2,6], queries = [[0,4]]
 *
 * 输出：[false]
 *
 * 解释：
 *
 * 子数组是 [3,4,1,2,6]。2 和 6 都是偶数。
 *
 * 示例 2：
 *
 * 输入：nums = [4,3,1,6], queries = [[0,2],[2,3]]
 *
 * 输出：[false,true]
 *
 * 解释：
 *
 * 子数组是 [4,3,1]。3 和 1 都是奇数。因此这个查询的答案是 false。
 * 子数组是 [1,6]。只有一对：(1,6)，且包含了奇偶性不同的数字。因此这个查询的答案是 true。
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] <= nums.length - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/special-array-ii/description/?envType=daily-question&envId=2024-08-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3152_IsArraySpecial {
    public static void main(String[] args) {
        L3152_IsArraySpecial l3152IsArraySpecial = new L3152_IsArraySpecial();
        System.out.println(Arrays.toString(l3152IsArraySpecial.isArraySpecial(new int[]{1, 1}, new int[][]{{0, 1}})));
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] s = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            s[i] = s[i - 1] + (nums[i] % 2 == nums[i - 1] % 2 ? 1 : 0);
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            //检查这个区间有没有发生突变
            ans[i] = s[to] == s[from];
        }
        return ans;
    }
}
