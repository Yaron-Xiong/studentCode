package com.yaronxiong.algorithms.leetcode.l0;

import java.util.*;

/**
 * 90. 子集 II
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集不能包含重复的子集。返回的解集中，子集可以按任意顺序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/subsets-ii/description/?envType=daily-question&envId=2025-02-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L90_SubsetsWithDup {
    public static void main(String[] args) {
        L90_SubsetsWithDup l90SubsetsWithDup = new L90_SubsetsWithDup();
        System.out.println(l90SubsetsWithDup.subsetsWithDup(new int[]{0}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        dfs2(0, nums, ans, new LinkedList<>());
        return ans;
    }

    private void dfs2(int i, int[] nums, List<List<Integer>> ans, Deque<Integer> path) {
        for (int j = i; j < nums.length; j++) {
            if (j != i && nums[j] == nums[j - 1]) {
                continue;
            }
            path.addLast(nums[j]);
            ans.add(new ArrayList<>(path));
            dfs2(j + 1, nums, ans, path);
            path.removeLast();
        }
    }
}
