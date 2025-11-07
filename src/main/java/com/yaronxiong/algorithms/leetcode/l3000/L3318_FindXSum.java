package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.*;

/**
 * 3318. 计算子数组的 x-sum I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。
 * <p>
 * 数组的 x-sum 计算按照以下步骤进行：
 * <p>
 * 统计数组中所有元素的出现次数。
 * 仅保留出现次数最多的前 x 个元素的每次出现。如果两个元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。
 * 计算结果数组的和。
 * 注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。
 * <p>
 * 返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是 子数组 nums[i..i + k - 1] 的 x-sum。
 * <p>
 * 子数组 是数组内的一个连续 非空 的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
 * <p>
 * 输出：[6,10,12]
 * <p>
 * 解释：
 * <p>
 * 对于子数组 [1, 1, 2, 2, 3, 4]，只保留元素 1 和 2。因此，answer[0] = 1 + 1 + 2 + 2。
 * 对于子数组 [1, 2, 2, 3, 4, 2]，只保留元素 2 和 4。因此，answer[1] = 2 + 2 + 2 + 4。注意 4 被保留是因为其数值大于出现其他出现次数相同的元素（3 和 1）。
 * 对于子数组 [2, 2, 3, 4, 2, 3]，只保留元素 2 和 3。因此，answer[2] = 2 + 2 + 2 + 3 + 3。
 * 示例 2：
 * <p>
 * 输入：nums = [3,8,7,8,7,5], k = 2, x = 2
 * <p>
 * 输出：[11,15,15,15,12]
 * <p>
 * 解释：
 * <p>
 * 由于 k == x，answer[i] 等于子数组 nums[i..i + k - 1] 的总和。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 50
 * 1 <= nums[i] <= 50
 * 1 <= x <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-x-sum-of-all-k-long-subarrays-i/description/?envType=daily-question&envId=2025-11-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3318_FindXSum {
    public static void main(String[] args) {
        L3318_FindXSum l3318FindXSum = new L3318_FindXSum();
        System.out.println(Arrays.toString(l3318FindXSum.findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)));
    }

    public void updateNum(Map<Integer, Integer> cntMap, TreeMap<Integer, TreeSet<Integer>> treeMap, int num, int operation) {
        Integer oldValue = cntMap.get(num);
        if (oldValue != null) {
            TreeSet<Integer> treeSet = treeMap.get(oldValue);
            treeSet.remove(num);
            if (treeSet.isEmpty()) {
                treeMap.remove(oldValue);
            }
        }
        Integer newValue = cntMap.merge(num, operation, Integer::sum);
        treeMap.computeIfAbsent(newValue, k1 -> new TreeSet<>((a, b) -> b - a)).add(num);
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];
        Map<Integer, Integer> cntMap = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> treeMap = new TreeMap<>((a, b) -> b - a);
        for (int i = 0, j = 0; i < nums.length; i++) {
            //移除左边的值
            if (i >= k) {
                updateNum(cntMap, treeMap, nums[i - k], -1);
            }
            //添加当前节点
            updateNum(cntMap, treeMap, nums[i], 1);
            if (i < k - 1) {
                continue;
            }
            int cutX = 0;
            int tempAns = 0;
            for (Map.Entry<Integer, TreeSet<Integer>> entry : treeMap.entrySet()) {
                for (Integer num : entry.getValue()) {
                    if (cutX == x) {
                        break;
                    }
                    tempAns += entry.getKey() * num;
                    cutX++;
                }
            }
            ans[j++] = tempAns;
        }
        return ans;
    }
}
