package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.*;

/**
 * 3488. 距离最小相等元素查询
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 环形 数组 nums 和一个数组 queries 。
 * <p>
 * 对于每个查询 i ，你需要找到以下内容：
 * <p>
 * 数组 nums 中下标 queries[i] 处的元素与 任意 其他下标 j（满足 nums[j] == nums[queries[i]]）之间的 最小 距离。
 * 如果不存在这样的下标 j，则该查询的结果为 -1 。
 * 返回一个数组 answer，其大小与 queries 相同，其中 answer[i] 表示查询i的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,3,1,4,1,3,2], queries = [0,3,5]
 * <p>
 * 输出： [2,-1,3]
 * <p>
 * 解释：
 * <p>
 * 查询 0：下标 queries[0] = 0 处的元素为 nums[0] = 1 。最近的相同值下标为 2，距离为 2。
 * 查询 1：下标 queries[1] = 3 处的元素为 nums[3] = 4 。不存在其他包含值 4 的下标，因此结果为 -1。
 * 查询 2：下标 queries[2] = 5 处的元素为 nums[5] = 3 。最近的相同值下标为 1，距离为 3（沿着循环路径：5 -> 6 -> 0 -> 1）。
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,3,4], queries = [0,1,2,3]
 * <p>
 * 输出： [-1,-1,-1,-1]
 * <p>
 * 解释：
 * <p>
 * 数组 nums 中的每个值都是唯一的，因此没有下标与查询的元素值相同。所有查询的结果均为 -1。
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 0 <= queries[i] < nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/closest-equal-element-queries/description/?envType=daily-question&envId=2026-04-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3488_SolveQueries {
    public static void main(String[] args) {
        L3488_SolveQueries l3488SolveQueries = new L3488_SolveQueries();
        System.out.println(l3488SolveQueries.solveQueries(new int[]{1, 3, 1, 4, 1, 3, 2}, new int[]{0, 3, 5}));
        System.out.println(l3488SolveQueries.solveQueries(new int[]{1, 2, 3, 4}, new int[]{0, 1, 2, 3}));
    }
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int query : queries) {
            int value = nums[query];
            List<Integer> indexList = map.get(value);
            if (indexList == null || indexList.size() == 1) {
                ans.add(-1);
                continue;
            }
            int index = Collections.binarySearch(indexList, query);
            if (index == 0) {
                //左边
                int leftValue = indexList.get(index) + (nums.length - indexList.get(indexList.size() - 1));
                //右边
                int rightValue = indexList.get(index + 1) - indexList.get(index);
                ans.add(Math.min(leftValue, rightValue));
            }else if (index == indexList.size() - 1) {
                //左边
                int leftValue = indexList.get(index) - indexList.get(index - 1);
                //右边
                int rightValue = nums.length - indexList.get(index) + indexList.get(0);
                ans.add(Math.min(leftValue, rightValue));
            }else {
                //左边
                int leftValue = indexList.get(index) - indexList.get(index - 1);
                //右边
                int rightValue = indexList.get(index + 1) - indexList.get(index);
                ans.add(Math.min(leftValue, rightValue));
            }
        }
        return ans;
    }
}
