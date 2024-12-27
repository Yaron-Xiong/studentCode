package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3159. 查询数组中元素的出现位置
 * 算术评级: 2
 * 第 131 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1263
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，一个整数数组 queries 和一个整数 x 。
 * <p>
 * 对于每个查询 queries[i] ，你需要找到 nums 中第 queries[i] 个 x 的位置，并返回它的下标。
 * 如果数组中 x 的出现次数少于 queries[i] ，该查询的答案为 -1 。
 * <p>
 * 请你返回一个整数数组 answer ，包含所有查询的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1,7], queries = [1,3,2,4], x = 1
 * <p>
 * 输出：[0,-1,2,-1]
 * <p>
 * 解释：
 * <p>
 * 第 1 个查询，第一个 1 出现在下标 0 处。
 * 第 2 个查询，nums 中只有两个 1 ，所以答案为 -1 。
 * 第 3 个查询，第二个 1 出现在下标 2 处。
 * 第 4 个查询，nums 中只有两个 1 ，所以答案为 -1 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], queries = [10], x = 5
 * <p>
 * 输出：[-1]
 * <p>
 * 解释：
 * <p>
 * 第 1 个查询，nums 中没有 5 ，所以答案为 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, queries.length <= 105
 * 1 <= queries[i] <= 105
 * 1 <= nums[i], x <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-occurrences-of-an-element-in-an-array/description/?envType=daily-question&envId=2024-12-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3159_OccurrencesOfElement {
    public static void main(String[] args) {
        L3159_OccurrencesOfElement l3159OccurrencesOfElement = new L3159_OccurrencesOfElement();
        int[] a = l3159OccurrencesOfElement.occurrencesOfElement(new int[]{1, 3, 1, 7}, new int[]{1, 3, 2, 4}, 1);
        System.out.println(Arrays.toString(a));
    }

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> cnts = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                cnts.add(i);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] - 1 >= cnts.size()) {
                ans[i] = -1;
                continue;
            }
            ans[i] = cnts.get(queries[i] - 1);
        }
        return ans;
    }
}
