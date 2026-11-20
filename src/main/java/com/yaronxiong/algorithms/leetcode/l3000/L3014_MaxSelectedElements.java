package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3041. 修改数组后最大化数组中的连续元素数目
 * 已解答
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始只包含 正 整数的数组 nums 。
 * <p>
 * 一开始，你可以将数组中 任意数量 元素增加 至多 1 。
 * <p>
 * 修改后，你可以从最终数组中选择 一个或者更多 元素，并确保这些元素升序排序后是 连续 的。
 * 比方说，[3, 4, 5] 是连续的，但是 [3, 4, 6] 和 [1, 1, 2, 3] 不是连续的。
 * <p>
 * 请你返回 最多 可以选出的元素数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,5,1,1]
 * 输出：3
 * 解释：我们将下标 0 和 3 处的元素增加 1 ，得到结果数组 nums = [3,1,5,2,1] 。
 * 我们选择元素 [3,1,5,2,1] 并将它们排序得到 [1,2,3] ，是连续元素。
 * 最多可以得到 3 个连续元素。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,7,10]
 * 输出：1
 * 解释：我们可以选择的最多元素数目是 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximize-consecutive-elements-in-an-array-after-modification/description/?envType=daily-question&envId=2026-11-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3014_MaxSelectedElements {
    public static void main(String[] args) {
        L3014_MaxSelectedElements l3014MaxSelectedElements = new L3014_MaxSelectedElements();
        System.out.println(l3014MaxSelectedElements.maxSelectedElements(new int[]{2,1,5,1,1}));
        System.out.println(l3014MaxSelectedElements.maxSelectedElements(new int[]{1, 4, 7, 10}));
    }
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int x : nums) {
            map.put(x + 1, Math.max(map.getOrDefault(x, 0) + 1, map.getOrDefault(x + 1, 0)));
            map.put(x, Math.max(map.getOrDefault(x - 1, 0) + 1, map.getOrDefault(x, 0)));
            ans = Math.max(ans, Math.max(map.get(x + 1), map.get(x)));
        }
        return ans;
    }
}
