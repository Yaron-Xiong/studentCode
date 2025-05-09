package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 2364. 统计坏数对的数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一个 坏数对 。
 * <p>
 * 请你返回 nums 中 坏数对 的总数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,3,3]
 * 输出：5
 * 解释：数对 (0, 1) 是坏数对，因为 1 - 0 != 1 - 4 。
 * 数对 (0, 2) 是坏数对，因为 2 - 0 != 3 - 4, 2 != -1 。
 * 数对 (0, 3) 是坏数对，因为 3 - 0 != 3 - 4, 3 != -1 。
 * 数对 (1, 2) 是坏数对，因为 2 - 1 != 3 - 1, 1 != 2 。
 * 数对 (2, 3) 是坏数对，因为 3 - 2 != 3 - 3, 1 != 0 。
 * 总共有 5 个坏数对，所以我们返回 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：0
 * 解释：没有坏数对。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-number-of-bad-pairs/description/?envType=daily-question&envId=2025-04-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2364_CountBadPairs {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0;
        long match = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = i - nums[i];
            if (map.containsKey(temp)) {
                match += map.get(temp);
            }
            map.merge(temp, 1, Integer::sum);
            cnt += i;
        }
        return cnt - match;
    }
}
