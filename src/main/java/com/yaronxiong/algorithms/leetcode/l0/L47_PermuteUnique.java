package com.yaronxiong.algorithms.leetcode.l0;

import java.util.*;

/**
 * 47. 全排列 II
 * 已解答
 * 算术评级: 5
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/permutations-ii/description/?envType=daily-question&envId=2025-02-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L47_PermuteUnique {
    public static void main(String[] args) {
        List<List<Integer>> lists = new L47_PermuteUnique().permuteUnique(new int[]{1, 1, 1, 2});
        System.out.println(lists);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs2(nums, new boolean[nums.length], new ArrayDeque<>(), res);
        return res;
    }

    private void dfs2(int[] nums, boolean[] visit, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i] || (i < nums.length - 1 && nums[i] == nums[i + 1] && visit[i + 1])) {
                continue;
            }
            path.add(nums[i]);
            visit[i] = true;
            dfs2(nums, visit, path, res);
            visit[i] = false;
            path.removeLast();
        }
    }
}
